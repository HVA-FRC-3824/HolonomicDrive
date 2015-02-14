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

import org.usfirst.frc3824.HolonomicDrive.commands.ChassisDriveStraight;
import org.usfirst.frc3824.HolonomicDrive.commands.ChassisTurnAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ChassisDriveAndTurnTest extends CommandGroup
{
	public ChassisDriveAndTurnTest()
	{
		ChassisTurnAngle chassisTurn90 = new ChassisTurnAngle(90.0, 0.0);

		// Drive forward
		addSequential(new ChassisDriveStraight(1.0, 0.5, 0.0));

		// Turn around
		addSequential(chassisTurn90);

		// Drive forward in opposite directions
		addSequential(new ChassisDriveStraight(1.0, 0.5, 0.0));
	}
}
