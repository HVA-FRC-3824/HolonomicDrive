// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc3824.HolonomicDrive.subsystems;

import org.usfirst.frc3824.HolonomicDrive.Constants;
import org.usfirst.frc3824.HolonomicDrive.RobotMap;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.command.Subsystem;

/*
 * Forklift subsystem which uses a velocity PID followed by a position PID to move
 * the totes to the location in a smooth controlled manner.
 */
public class Forklift extends Subsystem
{
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController motor = RobotMap.forkliftMotor;
    Encoder encoder = RobotMap.forkliftEncoder;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    boolean override;
    double overrideVelocity;
    double originalVelocity;
    
	// set the present PID mode to invalid to ensure the mode is set properly
	// in the initialization
	static int presentPIDmode = -1;

	PIDController velocityPID = new PIDController(Constants.FORKLIFT_VELOCITY_P, 
	                                              Constants.FORKLIFT_VELOCITY_I,
	                                              Constants.FORKLIFT_VELOCITY_D, encoder, motor);
	PIDController positionPID = new PIDController(Constants.FORKLIFT_POSITION_P, 
	                                              Constants.FORKLIFT_POSITION_I,
	                                              Constants.FORKLIFT_POSITION_D, encoder, motor);

	
	/*
	 * Method which is used to set the default command for the subsystem
	 */
	public void initDefaultCommand()
	{
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

	}

	public void resetEncoder()
	{
		encoder.reset();
	}
	
	/*
	 * Method to activate the specified PID and set it's setpoint.
	 * If the specified PID  is already the active one, this just updates
	 * the setpoint and makes sure the PID is enabled.
	 * If the specified PID is not the active one, the specified PID
	 * will be made the active one, it's setpoint configured and the PID
	 * will be enabled.
	 */
	public void setPIDmodeAndSetpoint(int mode, double setPoint)
	{
//		SmartDashboard.putNumber("PID Mode", mode);
//		SmartDashboard.putNumber("PID Setpoint", setPoint);

		// determine the PID mode
		if (mode == Constants.FORKLIFT_POSITION_MODE)
		{
			// determine if the PID mode is changing
			if (mode == presentPIDmode)
			{
				// update the position set point
				positionPID.setSetpoint(setPoint);
				positionPID.enable();
			}
			else
			// changing from velocity PID to position PID
			{
				// disable the velocity PID
				velocityPID.disable();

				// change the mode of the encoder
				encoder.setPIDSourceParameter(PIDSourceParameter.kDistance);

				// update the position set point
				positionPID.setSetpoint(setPoint);

				// reset the PID error
				positionPID.reset();

				// enable the PID controller
				positionPID.enable();
			}
		}
		else
		// velocity PID
		{
			// determine if the PID mode is changing
			if (mode == presentPIDmode)
			{
				// update the position set point
				velocityPID.setSetpoint(setPoint);
				velocityPID.enable();
			}
			else  // changing from position to velocity PID
			{
				// disable the position PID
				positionPID.disable();

				// change the mode of the encoder
				encoder.setPIDSourceParameter(PIDSourceParameter.kRate);

				// update the position set point
				velocityPID.setSetpoint(setPoint);

				// reset the PID error
				velocityPID.reset();

				// enable the PID controller
				velocityPID.enable();
			}
		}

		// remember the mode
		presentPIDmode = mode;
	}

	/* ******************************************************
	 * Configuration for the POSITION PID
	 */
	public boolean isPositionPIDEnabled(int mode)
	{
		return positionPID.isEnable();
	}

	public void setPositionPIDvalues(int PID, double P, double I, double D)
	{
		positionPID.setPID(P, I, D);
	}

	public void setPositionSetpoint(int PID, double setpoint)
	{
		positionPID.setSetpoint(setpoint);
	}

	public double getPositionSetpoint()
	{
		return positionPID.getSetpoint();
	}

	/* ******************************************************
	 * Configuration for the VELOCITY PID
	 */
	public boolean isVelocityPIDEnabled(int mode)
	{
		return velocityPID.isEnable();
	}
	
	public void setVelocityPIDvalues(double P, double I, double D)
	{
		velocityPID.setPID(P, I, D);
	}
	
	public void setVelocitySetpoint(double setpoint)
	{
		velocityPID.setSetpoint(setpoint);
	}

	public double getVelocitySetpoint()
	{
		return velocityPID.getSetpoint();
	}

	/* ******************************************************
	 * VELOCITY PID override control
	 */	
	public void enableVelocityOverrideWithVelocity(double velocity)
	{
		if(override == false)
		{
			override = true;
			overrideVelocity = velocity;
			originalVelocity = velocityPID.getSetpoint();
			velocityPID.setSetpoint(overrideVelocity);
		}
		else
		{
			overrideVelocity = velocity;
			velocityPID.setSetpoint(overrideVelocity);
		}
	}
	
	public void disableVelocityOverride()
	{
		if(override == true)
		{
			override = false;
			velocityPID.setSetpoint(originalVelocity);
		}
	}
	
	/*
	 * Method to return the forklift position
	 */
	public double getPosition()
	{
		return (encoder.getDistance());
	}

	/*
	 * Method to return the forklift velocity
	 */
	public double getVelocity()
	{
		return (encoder.getRate());
	}

	/*
	 * Method to return the PID error value for the specified PID controller
	 */
	public double getError()
	{
		double error = -1.0;

		// determine the PID parameters to set
		if (presentPIDmode == Constants.FORKLIFT_POSITION_MODE)
		{
			error = positionPID.getError();
		}
		else
		{
			error = velocityPID.getError();
		}

		// return the PID error value
		return (error);
	}

	public int getPIDMode()
	{
		return (presentPIDmode);
	}
}
