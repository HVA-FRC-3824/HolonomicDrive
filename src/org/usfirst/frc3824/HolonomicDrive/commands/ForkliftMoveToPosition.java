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

import org.usfirst.frc3824.HolonomicDrive.Constants;
import org.usfirst.frc3824.HolonomicDrive.Robot;

public class ForkliftMoveToPosition extends Command
{
    // the desired forklift position
	double position = 0.0;
	
	public ForkliftMoveToPosition()
	{
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.forkliftPID);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	}
	
	// constructor given a position
	public ForkliftMoveToPosition(double position) 
	{
		// call the default constructor
		this();
		
		// remember the desired position
		this.position = position;
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

		// set the forklift desired position
		Robot.forkliftPID.SetSetpoint(position);
		Robot.forkliftPID.StartPID();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return true;
	}

	// Called once after isFinished returns true
	protected void end()
	{

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		// Note: When a command is interrupted, the command class is terminated
		//       and the default command is renewed.
	}
}