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
public class AutonomousStackContainerandTote extends CommandGroup
{
	public AutonomousStackContainerandTote()
	{
		addSequential(new ForkliftMoveToPosition(Constants.FORKLIFT_TOTE2_POSITION));
		addSequential(new ChassisDriveStraight(0.5, 0.5, 0));
		addSequential(new ForkliftMoveToPosition(Constants.FORKLIFT_TOTEPICKUP_POSITION));
		addSequential(new ForkliftMoveToPosition(Constants.FORKLIFT_TOTE0_POSITION));
		addSequential(new ChassisDriveStraight(2.5, 0.5, -90));
		addSequential(new ForkliftMoveToPosition(Constants.FORKLIFT_TOTEPICKUP_POSITION));
		addSequential(new ChassisDriveStraight(1.0, 0.5, 180));
	}
}
