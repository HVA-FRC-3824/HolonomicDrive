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

import org.usfirst.frc3824.HolonomicDrive.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousContainerAndTote extends CommandGroup
{
	public AutonomousContainerAndTote()
	{
		// Pickup container
		addSequential(new ForkliftMoveToPosition(Constants.FORKLIFT_TOTE2_POSITION, Constants.FORKLIFT_VELOCITY_SETPOINT_HIGH));
		addSequential(new ForkliftMoveToPosition(Constants.FORKLIFT_TOTE2_POSITION, Constants.FORKLIFT_VELOCITY_SETPOINT_HIGH));

		// drive forward to get the tote
		addSequential(new ChassisDriveStraight(Constants.AUTONOMOUS_TOTE_AND_CONTAINER_DRIVE_TIME,
		                                       Constants.AUTONOMOUS_TOTE_AND_CONTAINER_DRIVE_POWER,
		                                       Constants.AUTONOMOUS_TOTE_AND_CONTAINER_DRIVE_ANGLE));

		// pickup tote
//		addSequential(new ForkliftMoveToPosition(Constants.FORKLIFT_TOTE0_POSITION, Constants.FORKLIFT_VELOCITY_SETPOINT_LOW));
		
		// Move sideways (left) to autozone
		addSequential(new ChassisDriveStraight(3.0, 
		                                       Constants.AUTONOMOUS_TOTE_DRIVE_POWER,
		                                       -Constants.AUTONOMOUS_TOTE_DRIVE_ANGLE));

		addSequential(new ForkliftMoveToPosition(Constants.FORKLIFT_TOTE0_POSITION, Constants.FORKLIFT_VELOCITY_SETPOINT_LOW));
	}
}
