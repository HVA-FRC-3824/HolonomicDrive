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

/*
 *
 */
public class AutonomousMoveContainerAndAlignToLoad extends CommandGroup
{
	public AutonomousMoveContainerAndAlignToLoad()
	{
		ChassisTurnAngle chassisTurn90Right = new ChassisTurnAngle(-90.0, 0.0);

		// reset the gyro
		addSequential(new ResetGyro());
		
		addSequential(new ForkliftMoveToPosition(Constants.FORKLIFT_TOTE2_POSITION, Constants.FORKLIFT_VELOCITY_SETPOINT_HIGH));
		addSequential(new ForkliftMoveToPosition(Constants.FORKLIFT_TOTE2_POSITION, Constants.FORKLIFT_VELOCITY_SETPOINT_HIGH));

		// drive forward at half power for one second
		addSequential(new ChassisDriveStraight( Constants.AUTONOMOUS_CONTAINER_STORE_TIME, 
		                                       -Constants.AUTONOMOUS_CONTAINER_STORE_POWER,
		                                        Constants.AUTONOMOUS_CONTAINER_STORE_ANGLE));

		// turn 90 degrees to face wall
		addSequential(chassisTurn90Right);

		addSequential(new ForkliftMoveToPosition(Constants.FORKLIFT_TOTEPICKUP_POSITION, Constants.FORKLIFT_VELOCITY_SETPOINT_HIGH));
	}
}
