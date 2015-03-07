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

/*
 * Class to move the forklift to a specified position using a velocity PID followed by
 * a position PID.
 * 
 * The static variables positionSetpoint and velocitySetpoint were added so that a command
 * could modify the setpoint without having to know which instance of this command is
 * currently active.  
 * 
 * Example: The speed button, press for high speed move, release for low speed move
 * it doesn't matter which button was pressed, the speed button should change the speed
 * during the move.  
 * 
 * FIX for CLARITY 
 * The button should not be calling into this class, it should be calling directly
 * into the Forklift class. 
 */
public class ForkliftMoveToPosition extends Command
{
	double mVelocitySetpoint;
	double mPositionSetpoint;

	public ForkliftMoveToPosition()
	{
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.forklift);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        
        // Initialize the members
        mVelocitySetpoint = Constants.FORKLIFT_VELOCITY_SETPOINT_LOW;
        mPositionSetpoint = 0.0;
	}

	public ForkliftMoveToPosition(double position, double velocity)
	{
		// call the default constructor
		this();

		// Store the desired position and velocity
		mPositionSetpoint = position;
		mVelocitySetpoint = velocity;
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		// Determine which button was pressed
		if (Robot.oi.totePickUp.get() == true)
			mPositionSetpoint = Constants.FORKLIFT_TOTEPICKUP_POSITION;
		else if (Robot.oi.tote0.get() == true)
			mPositionSetpoint = Constants.FORKLIFT_TOTE0_POSITION;
		else if (Robot.oi.tote1.get() == true)
			mPositionSetpoint = Constants.FORKLIFT_TOTE1_POSITION;
		else if (Robot.oi.tote2.get() == true)
			mPositionSetpoint = Constants.FORKLIFT_TOTE2_POSITION;
		else if (Robot.oi.tote3.get() == true)
			mPositionSetpoint = Constants.FORKLIFT_TOTE3_POSITION;
		else if (Robot.oi.tote4.get() == true)
			mPositionSetpoint = Constants.FORKLIFT_TOTE4_POSITION;
		else if (Robot.oi.tote5.get() == true)
			mPositionSetpoint = Constants.FORKLIFT_TOTE5_POSITION;
		else if (Robot.oi.step.get() == true)
			mPositionSetpoint = Constants.FORKLIFT_STEP;
		else if (Robot.oi.containerPickup.get() == true)
			mPositionSetpoint = Constants.FORKLIFT_CONTAINER_PICKUP;
		else if (Robot.oi.containerLift.get() == true)
			mPositionSetpoint = Constants.FORKLIFT_CONTAINER_LIFT;
		else if (Robot.oi.forkliftJogUp.get() == true)
			mPositionSetpoint = Robot.forklift.getPositionSetpoint() + Constants.FORKLIFT_JOG_STEP;
		else if (Robot.oi.forkliftJogDown.get() == true)
			mPositionSetpoint = Robot.forklift.getPositionSetpoint() - Constants.FORKLIFT_JOG_STEP;
		
		// ensure the range of the position
		// if (position < 0.0)
		// position = 0.0;
		//
		// if (position >= Constants.FORKLIFT_MAXIMUM_POSITION)
		// position = Constants.FORKLIFT_MAXIMUM_POSITION;

//		 SmartDashboard.putNumber("Local Position Setpoint", mPositionSetpoint);
//		 SmartDashboard.putNumber("Static Position Setpoint", positionSetpoint);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{		
		// determine if the distance from set point is close enough to use the
		// position PID
		if (Math.abs(Robot.forklift.getPosition() - mPositionSetpoint) < Constants.FORKLIFT_SWITCH_TO_POSITION_DISTANCE)
		{
			// set the forklift PID to position control
			// Note: the method enables the position encoder
			Robot.forklift.setPIDmodeAndSetpoint(Constants.FORKLIFT_POSITION_MODE, mPositionSetpoint);
		}
		else
		{
			// determine if above or below the desired set point
			if (Robot.forklift.getPosition() < mPositionSetpoint)
			{
				// set the fork-lift mode to position and set the position
				Robot.forklift.setPIDmodeAndSetpoint(Constants.FORKLIFT_VELOCITY_MODE, mVelocitySetpoint);
			}
			else
			{
				// set the fork-lift mode to position and set the position
				Robot.forklift.setPIDmodeAndSetpoint(Constants.FORKLIFT_VELOCITY_MODE, -mVelocitySetpoint);
			}
		}

//		 SmartDashboard.putNumber("Velocity Setpoint", velocitySetpoint);
		 SmartDashboard.putNumber("Forklift Position", Robot.forklift.getPosition());
//		 SmartDashboard.putNumber("Error", Robot.forklift.getError());
//		 SmartDashboard.putNumber("Forklift Mode", Robot.forklift.getPIDMode());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		// Determine if the forklift is in the desire position - 
		// we're assuming that if the mode is POSITION_MODE, then we're
		// close enough to the desired position. In POSITION_MODE, the
		// forklift is being held in it's specified position.
		if (Robot.forklift.getPIDMode() == Constants.FORKLIFT_POSITION_MODE)
		{
			return (true);
		}

		return (false);
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
