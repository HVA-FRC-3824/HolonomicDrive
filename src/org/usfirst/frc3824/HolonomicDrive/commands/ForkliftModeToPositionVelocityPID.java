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

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc3824.HolonomicDrive.Robot;
import org.usfirst.frc3824.HolonomicDrive.Constants;
import org.usfirst.frc3824.HolonomicDrive.RobotMap;

/*
 * Class to move the forklift to a specified position using a velocity PID followed by
 * a position PID.
 */
public class ForkliftModeToPositionVelocityPID extends Command
{
	double position = 0.0;
	boolean positionSpecified = false;

	public ForkliftModeToPositionVelocityPID()
	{
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.forklift);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        
    	positionSpecified = false;
	}

	public ForkliftModeToPositionVelocityPID(double position) 
	{
		// call the default constructor
		this();
		
		// remember the desired position
		this.position = position;
		positionSpecified = true;
	}
	
	// Called just before this Command runs the first time
	protected void initialize()
	{
		// Determine which button was pressed
		if (Robot.oi.totePickUp.get() == true)
			position = Constants.FORKLIFT_TOTEPICKUP_POSITION;
		else if (Robot.oi.tote1.get() == true)
			position = Constants.FORKLIFT_TOTE1_POSITION;
		else if (Robot.oi.tote2.get() == true)
			position = Constants.FORKLIFT_TOTE2_POSITION;
		else if (Robot.oi.tote3.get() == true)
			position = Constants.FORKLIFT_TOTE3_POSITION;
		else if (Robot.oi.tote4.get() == true)
			position = Constants.FORKLIFT_TOTE4_POSITION;
		else if (Robot.oi.tote5.get() == true)
			position = Constants.FORKLIFT_TOTE5_POSITION;
		else if (Robot.oi.tote6.get() == true)
			position = Constants.FORKLIFT_TOTE6_POSITION;
		else if (positionSpecified == false) {
			position = Robot.forklift.getPosition();
		}
		
		// ensure the range of the position
		if (position < 0.0)
			position = 0.0;
		
		if (position >= Constants.FORKLIFT_MAXIMUM_POSITION)
			position = Constants.FORKLIFT_MAXIMUM_POSITION;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		// determine if the distance from set point is close enough to use the position PID
		if (Math.abs(Robot.forklift.getPosition() - position) < Constants.FORKLIFT_SWITCH_TO_POSITION_DISTANCE)
		{
			SmartDashboard.putString("PID Mode", "Position");
			
			// set the forklift PID to position control
			// Note: the method enables the position encoder
			Robot.forklift.setPIDmodeAndSetpoint(Constants.FORKLIFT_POSITION_MODE, position);
		}
		else
		{
			SmartDashboard.putString("PID Mode", "Velocity");
			
			// determine if above or below the desired set point
			if (Robot.forklift.getPosition() < position)
			{
		        // set the fork-lift mode to position and set the position
		        Robot.forklift.setPIDmodeAndSetpoint(Constants.FORKLIFT_VELOCITY_MODE, Constants.FORKLIFT_VELOCITY_SETPOINT);				
			}
			else
			{
		        // set the fork-lift mode to position and set the position
		        Robot.forklift.setPIDmodeAndSetpoint(Constants.FORKLIFT_VELOCITY_MODE, -Constants.FORKLIFT_VELOCITY_SETPOINT);				
			}
		}
			
		SmartDashboard.putNumber("Error", Robot.forklift.getError());		
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		// determine if the forklift is in the desire position
		if (Math.abs(Robot.forklift.getPosition() - position) < Constants.FORKLIFT_AT_POSITION_DISTANCE)
			return(true);
			
		return(false);
	}

	// Called once after isFinished returns true
	protected void end()
	{
		
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		
	}
}
