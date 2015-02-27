// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc3824.HolonomicDrive.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc3824.HolonomicDrive.Constants;
import org.usfirst.frc3824.HolonomicDrive.Robot;

/*
 *
 */
public class ChassisDriveAndTurn extends Command
{
	private Timer  timer;
	private double driveDuration  =  2.5;
	private double drivePower     =  0.7;
	private double driveDirection =  0.0;
	private double degreesToTurn  = 90.0;

	public ChassisDriveAndTurn()
	{
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

		// instantiate a timer
		timer = new Timer();
	}

	public ChassisDriveAndTurn(double duration, double power, double direction, double angle)
	{
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

		// instantiate a timer
		timer = new Timer();

		// copy the parameters to the class variables
		driveDuration  = duration;
		drivePower     = power;
		driveDirection = direction;
		degreesToTurn  = angle;
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		double goToGyro = Robot.driveTrain.getGyro().getAngle() + degreesToTurn;
		
//		SmartDashboard.putNumber("gyroAngle",     Robot.driveTrain.getGyroValue());		
//		SmartDashboard.putNumber("degreesToTurn", degreesToTurn);
//		SmartDashboard.putNumber("goToGyro",      goToGyro);

		// Set the PID up for driving straight
		Robot.driveTrain.getAngleGyroController().setPID(Constants.DRIVETRAIN_DRIVE_AND_TURN_P, 
		                                                 Constants.DRIVETRAIN_DRIVE_AND_TURN_I, 
		                                                 Constants.DRIVETRAIN_DRIVE_AND_TURN_D);
		Robot.driveTrain.setMagnitude(drivePower);
		Robot.driveTrain.setDirection(driveDirection);
		Robot.driveTrain.setAngle(goToGyro);
		
		Robot.driveTrain.getAngleGyroController().reset();
		Robot.driveTrain.getAngleGyroController().setSetpoint(goToGyro);
		Robot.driveTrain.getAngleGyroController().enable();
		
		// reset and start the timer
		timer.reset();
		timer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return (timer.get() > driveDuration);
	}

	// Called once after isFinished returns true
	protected void end()
	{
		// disable the PID and stop the robot
		Robot.driveTrain.getAngleGyroController().disable();
		Robot.driveTrain.holonomicDrive(0, 0, 0);
		timer.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		// call the end method
		this.end();
	}
}
