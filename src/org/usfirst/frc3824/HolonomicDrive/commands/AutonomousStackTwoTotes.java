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

public class AutonomousStackTwoTotes extends CommandGroup
{
	public AutonomousStackTwoTotes()
	{
		ChassisTurnAngle chassisTurn45 = new ChassisTurnAngle(-45.0, 0.0);
		ChassisTurnAngle chassisTurn0  = new ChassisTurnAngle(0.0, 0.0);

		// reset the gyro
		addSequential(new ResetGyro());
		
		// goes for first tote
		addSequential(new ForkliftMoveToPosition(Constants.FORKLIFT_TOTE0_POSITION, Constants.FORKLIFT_VELOCITY_SETPOINT_OVERRIDE));
		addParallel(new ForkliftMoveToPosition(Constants.FORKLIFT_TOTE0_POSITION, Constants.FORKLIFT_VELOCITY_SETPOINT_OVERRIDE));
		addSequential(chassisTurn45);

		// goes for second tote
		addSequential(new ChassisDriveStraight(1.0, 0.5, 45));
		addSequential(chassisTurn0);
		
		// goes for first tote
		addSequential(new ForkliftMoveToPosition(Constants.FORKLIFT_TOTE0_POSITION, Constants.FORKLIFT_VELOCITY_SETPOINT_OVERRIDE));

		// goes for second tote
		addSequential(new ChassisDriveStraight(1.0, 0.5, 0));
		addSequential(new ForkliftMoveToPosition(Constants.FORKLIFT_TOTEPICKUP_POSITION, Constants.FORKLIFT_VELOCITY_SETPOINT_OVERRIDE));
		addSequential(new ForkliftMoveToPosition(Constants.FORKLIFT_TOTE0_POSITION, Constants.FORKLIFT_VELOCITY_SETPOINT_OVERRIDE));

		// takes robot and totes to autozone
		addSequential(new ChassisDriveStraight(2.0, 0.7, 90));
		addSequential(new ForkliftMoveToPosition(Constants.FORKLIFT_TOTEPICKUP_POSITION, Constants.FORKLIFT_VELOCITY_SETPOINT_OVERRIDE));
		addSequential(new ChassisDriveStraight(1.0, 0.5, 180));
	}
}
