package org.usfirst.frc3824.HolonomicDrive;

import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 */
public class JoystickMovementTrigger extends Trigger {

	public boolean get() {
		// Check to see if Joystick has moved
		return (Math.abs(Robot.oi.forkliftJoystick.getY()) > Constants.FORKLIFT_JOYSTICK_THRESHOLD);
	}
}
