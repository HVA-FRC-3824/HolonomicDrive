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
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem
{
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController leftFront = RobotMap.driveTrainLeftFront;
    SpeedController leftRear = RobotMap.driveTrainLeftRear;
    SpeedController rightFront = RobotMap.driveTrainRightFront;
    SpeedController rightRear = RobotMap.driveTrainRightRear;
    RobotDrive holonomicDrive = RobotMap.driveTrainHolonomicDrive;
    Gyro gyro = RobotMap.driveTrainGyro;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	private AnglePIDOutput angleOutput = new AnglePIDOutput();

	private PIDController angleGyroController = new PIDController(
			Constants.DrivetrainAngleGyroControllerP,
			Constants.DrivetrainAngleGyroControllerI,
			Constants.DrivetrainAngleGyroControllerD, gyro, angleOutput);

	// used as the value for drive while running under PIDControl. Those values
	// not set by the controller can be set by a command directly
	private double magnitude;
	private double direction;
	private double angle;

	public void initDefaultCommand()
	{
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	}

	public void holonomicDrive(Joystick joy)
	{
		SmartDashboard.putNumber("magnitude", joy.getMagnitude());
		SmartDashboard.putNumber("direction", joy.getDirectionDegrees());
		SmartDashboard.putNumber("angle",     joy.getTwist() * 0.5);
		
		holonomicDrive.mecanumDrive_Polar(joy.getMagnitude(),
				                          joy.getDirectionDegrees(),  
				                          joy.getTwist() * 0.5);
	}

	public void holonomicDrive(double magnitude, double direction, double angle)
	{
		holonomicDrive.mecanumDrive_Polar(magnitude, direction, angle);
	}

	public void straightHolonomicDrive(double x, double y, double rotation)
	{
		holonomicDrive.mecanumDrive_Cartesian(x, y, rotation, gyro.getAngle());
	}

	public Gyro getGyro()
	{
		return (gyro);
	}

	public double getGyroValue()
	{
		return (gyro.getAngle());
	}

	public void resetGyro()
	{
		gyro.reset();
	}

	/**
	 * Only to be used while controlled by PID controller
	 */
	public void setMagnitude(double magnitude)
	{
		this.magnitude = magnitude;
	}

	/**
	 * Only to be used while controlled by PID controller
	 */
	public void setDirection(double direction)
	{
		this.direction = direction;
	}

	/**
	 * Only to be used while controlled by PID controller
	 */
	public void setAngle(double angle)
	{
		this.angle = angle;
	}

	/**
	 * Needs to be enabled. Make sure to disable when done. Set magnitude and
	 * direction with setMagnitude and setDirection.
	 */
	public PIDController getAngleGyroController()
	{
		return (angleGyroController);
	}

	public class AnglePIDOutput implements PIDOutput
	{
		public void pidWrite(double d)
		{
			SmartDashboard.putNumber("magnitude", magnitude);
			SmartDashboard.putNumber("direction", direction);
			SmartDashboard.putNumber("angle", angle);
			
			// set the local angle value
			setAngle(d);
			
			// drive the robot with mecanum drive and polar coordinates
			holonomicDrive.mecanumDrive_Polar(magnitude, direction, angle);
		}
	}
}
