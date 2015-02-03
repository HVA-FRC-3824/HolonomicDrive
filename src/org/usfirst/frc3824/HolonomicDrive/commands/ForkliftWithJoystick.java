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

/**
 *
 */
public class  ForkliftWithJoystick extends Command {

    public ForkliftWithJoystick() {

        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.forklift);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.forklift.setPIDmodeAndSetpoint(Constants.FORKLIFT_VELOCITY_MODE,-Robot.oi.forkliftJoystick.getY()*Constants.FORKLIFT_JOYSTICK_MULTIPLIER);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (Math.abs(Robot.oi.forkliftJoystick.getY()) < Constants.FORKLIFT_JOYSTICK_THRESHOLD) {
    		return true;
    	} else {
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.forklift.setPIDmodeAndSetpoint(Constants.FORKLIFT_VELOCITY_MODE, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
