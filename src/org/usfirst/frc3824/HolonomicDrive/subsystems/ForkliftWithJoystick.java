// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc3824.HolonomicDrive.subsystems;

import org.usfirst.frc3824.HolonomicDrive.RobotMap;
import org.usfirst.frc3824.HolonomicDrive.commands.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ForkliftWithJoystick extends Subsystem
{
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController motor = RobotMap.forkliftWithJoystickMotor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	/*
	 * Method which is used to set the default command for the subsystem
	 */
	public void initDefaultCommand()
	{
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new LiftWithJoystick());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	}

	public void forkliftWithJoystick(Joystick joy)
	{
		// invert the joystick direction
		motor.set(-joy.getY());
	}
}