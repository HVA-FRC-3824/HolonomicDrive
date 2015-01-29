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

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousGetLeftContainerFromStep extends CommandGroup
{
	public AutonomousGetLeftContainerFromStep()
	{
		//collect from step; mechanism pending
		
		//backing up
		addSequential(new ChassisDriveStraight(1.0, 0.5, 180));
				
		//deposit and get clear from container
	}
}
