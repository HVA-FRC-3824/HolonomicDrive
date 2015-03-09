/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008-2012. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc3824.HolonomicDrive;

import edu.wpi.first.wpilibj.AccumulatorResult;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SensorBase;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.communication.FRCNetworkCommunicationsLibrary.tResourceType;
import edu.wpi.first.wpilibj.communication.UsageReporting;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.util.BoundaryException;

/**
 * Use a rate gyro to return the robots heading relative to a starting position.
 * The Gyro class tracks the robots heading based on the starting position. As
 * the robot rotates the new heading is computed by integrating the rate of
 * rotation returned by the sensor. When the class is instantiated, it does a
 * short calibration routine where it samples the gyro while at rest to
 * determine the default offset. This is subtracted from each sample to
 * determine the heading.
 */
public class HVAGyro extends SensorBase implements PIDSource, LiveWindowSendable
{
	static final int    kOversampleBits                 = 10;
	static final int    kAverageBits                    =  0;
	static final double kSamplesPerSecond               = 50.0;
	static final double kCalibrationSampleTime          =  5.0;
	static final double kDefaultVoltsPerDegreePerSecond =  0.007;
	
	private   PIDSourceParameter m_pidSource;
	protected AnalogInput        m_analog;
	boolean m_channelAllocated = false;
	double  m_voltsPerDegreePerSecond;
	double  m_offset;
	int     m_center;
	
	AccumulatorResult result;

	/**
	 * Initialize the gyro. Calibrate the gyro by running for a number of
	 * samples and computing the center value. Then use the center value as the
	 * Accumulator center value for subsequent measurements. It's important to
	 * make sure that the robot is not moving while the centering calculations
	 * are in progress, this is typically done when the robot is first turned on
	 * while it's sitting at rest before the competition starts.
	 */
	public void initGyro()
	{
		result = new AccumulatorResult();
		
		if (m_analog == null)
		{
			System.out.println("Null m_analog");
		}
		
		m_voltsPerDegreePerSecond = kDefaultVoltsPerDegreePerSecond;
		m_analog.setAverageBits(kAverageBits);
		m_analog.setOversampleBits(kOversampleBits);
		
		double sampleRate = kSamplesPerSecond * (1 << (kAverageBits + kOversampleBits));
		
		AnalogInput.setGlobalSampleRate(sampleRate);
		Timer.delay(1.0);

		m_analog.initAccumulator();
		m_analog.resetAccumulator();

		// allow time for the Gyro run through the calibration
		Timer.delay(kCalibrationSampleTime);

		// read the accumulated value and the number of samples
		m_analog.getAccumulatorOutput(result);

		// the gyro center is the average of the accumulated counts, while if offset
		// is the fraction from the center (decimal)
		m_center = (int) ((double) result.value / (double) result.count + 0.5);
		m_offset =       ((double) result.value / (double) result.count) - m_center;

//		m_center = 1974250;
//		m_offset = 0.0;
			
		// set the gyro center (integer) for the integration
		m_analog.setAccumulatorCenter(m_center);
		m_analog.resetAccumulator();

		// dead band will decrease drift at the cost of decreasing accuracy
		setDeadband(0.0);

		// set the PID source
		setPIDSourceParameter(PIDSourceParameter.kAngle);

		UsageReporting.report(tResourceType.kResourceType_Gyro, m_analog.getChannel());
		
		LiveWindow.addSensor("HVAGyro", m_analog.getChannel(), this);
		SmartDashboard.putNumber("m_center", m_center);
	}

	/**
	 * Gyro constructor using the channel number
	 *
	 * @param channel
	 *            The analog channel the gyro is connected to. Gyros can only be
	 *            used on on-board channels 0-1.
	 */
	public HVAGyro(int channel)
	{
		this(new AnalogInput(channel));
		
		m_channelAllocated = true;
	}

	/**
	 * Gyro constructor with a pre-created analog channel object. Use this
	 * constructor when the analog channel needs to be shared.
	 *
	 * @param channel
	 *            The AnalogInput object that the gyro is connected to. Gyros
	 *            can only be used on on-board channels 0-1.
	 */
	public HVAGyro(AnalogInput channel)
	{
		m_analog = channel;
		
		if (m_analog == null)
		{
			throw new NullPointerException("AnalogInput supplied to Gyro constructor is null");
		}
		
		initGyro();
	}

	/**
	 * Reset the gyro. Resets the gyro to a heading of zero. This can be used if
	 * there is significant drift in the gyro and it needs to be re-calibrated
	 * after it has been running.
	 */
	public void reset()
	{
		if (m_analog != null)
		{
			m_analog.resetAccumulator();
		}
	}

	public void setGyroCenter(int center)
	{
		m_center = center;
		
		// set the gyro center (integer) for the integration
		m_analog.setAccumulatorCenter(m_center);
		m_analog.resetAccumulator();
	}
	   
	/**
	 * Delete (free) the accumulator and the analog components used for the
	 * gyro.
	 */
	@Override
	public void free()
	{
		if (m_analog != null && m_channelAllocated)
		{
			m_analog.free();
		}
		
		m_analog = null;
	}

	/**
	 * Return the actual angle in degrees that the robot is currently facing.
	 *
	 * The angle is based on the current accumulator value corrected by the
	 * over-sampling rate, the gyro type and the A/D calibration values. The
	 * angle is continuous, that is it will continue from 360 to 361 degrees.
	 * This allows algorithms that wouldn't want to see a discontinuity in the
	 * gyro output as it sweeps past from 360 to 0 on the second time around.
	 *
	 * @return the current heading of the robot in degrees. This heading is
	 *         based on integration of the returned rate from the gyro.
	 */
	public double getAngle()
	{
		if (m_analog == null)
		{
			return 0.0;
		}
		else
		{
			m_analog.getAccumulatorOutput(result);

			// correct the accumulated value by subtracting the offset
			// Note: The result.count is after the center subtraction
			long value = result.value - (long) (result.count * m_offset);

			// compute the angle
			double scaledValue = value * 1e-9 * m_analog.getLSBWeight() * 
					            (1 << m_analog.getAverageBits()) / (AnalogInput.getGlobalSampleRate() * 
					            m_voltsPerDegreePerSecond);

			// return the angle
			return scaledValue;
		}
	}

	/**
	 * Return the rate of rotation of the gyro
	 *
	 * The rate is based on the most recent reading of the gyro analog value
	 *
	 * @return the current rate in degrees per second
	 */
	public double getRate()
	{
		if (m_analog == null)
		{
			return 0.0;
		}
		else
		{
			return (m_analog.getAverageValue() - (m_center + m_offset)) * 1e-9 * 
					m_analog.getLSBWeight() / ((1 << m_analog.getOversampleBits()) * 
					m_voltsPerDegreePerSecond);
		}
	}

	/**
	 * Set the gyro sensitivity. This takes the number of volts/degree/second
	 * sensitivity of the gyro and uses it in subsequent calculations to allow
	 * the code to work with multiple gyros. This value is typically found in
	 * the gyro data sheet.
	 *
	 * @param voltsPerDegreePerSecond
	 *            The sensitivity in Volts/degree/second.
	 */
	public void setSensitivity(double voltsPerDegreePerSecond)
	{
		m_voltsPerDegreePerSecond = voltsPerDegreePerSecond;
	}

	/**
	 * Set the size of the neutral zone. Any voltage from the gyro less than
	 * this amount from the center is considered stationary. Setting a dead-band
	 * will decrease the amount of drift when the gyro isn't rotating, but will
	 * make it less accurate.
	 *
	 * @param volts
	 *            The size of the deadband in volts
	 */
	void setDeadband(double volts)
	{
		int deadband = (int) (volts * 1e9 / m_analog.getLSBWeight() * (1 << m_analog.getOversampleBits()));
		m_analog.setAccumulatorDeadband(deadband);
	}

	/**
	 * Set which parameter of the gyro you are using as a process control
	 * variable. The Gyro class supports the rate and angle parameters
	 *
	 * @param pidSource
	 *            An enum to select the parameter.
	 */
	public void setPIDSourceParameter(PIDSourceParameter pidSource)
	{
		BoundaryException.assertWithinBounds(pidSource.value, 1, 2);
		m_pidSource = pidSource;
	}

	/**
	 * Get the output of the gyro for use with PIDControllers. May be the angle
	 * or rate depending on the set PIDSourceParameter
	 *
	 * @return the output according to the gyro
	 */
	@Override
	public double pidGet()
	{
		switch (m_pidSource.value)
		{
		case 1: /* PIDSourceParameter.kRate_val */
			return getRate();
		case 2: /* PIDSourceParameter.kAngle_val */
			return getAngle();
		default:
			return 0.0;
		}
	}

	/*
	 * Live Window code, only does anything if live window is activated.
	 */
	@Override
	public String getSmartDashboardType()
	{
		return "Gyro";
	}

	private ITable m_table;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initTable(ITable subtable)
	{
		m_table = subtable;
		updateTable();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ITable getTable()
	{
		return m_table;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateTable()
	{
		if (m_table != null)
		{
			m_table.putNumber("Value", getAngle());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void startLiveWindowMode()
	{
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stopLiveWindowMode()
	{
		
	}
}
