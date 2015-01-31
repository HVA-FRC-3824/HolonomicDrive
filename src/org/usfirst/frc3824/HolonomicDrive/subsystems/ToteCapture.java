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

import org.usfirst.frc3824.HolonomicDrive.Constants;
import org.usfirst.frc3824.HolonomicDrive.Robot;
import org.usfirst.frc3824.HolonomicDrive.RobotMap;
import org.usfirst.frc3824.HolonomicDrive.commands.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ToteCapture extends Subsystem
{
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    AnalogPotentiometer leftPosition = RobotMap.toteCaptureLeftPosition;
    SpeedController leftMotor = RobotMap.toteCaptureLeftMotor;
    PIDController leftArm = RobotMap.toteCaptureLeftArm;
    AnalogPotentiometer rightPosition = RobotMap.toteCaptureRightPosition;
    SpeedController rightMotor = RobotMap.toteCaptureRightMotor;
    PIDController rightArm = RobotMap.toteCaptureRightArm;
    SpeedController leftWheel = RobotMap.toteCaptureLeftWheel;
    SpeedController rightWheel = RobotMap.toteCaptureRightWheel;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // need to remember the present tote capture arm positions
    double rightArmPosition = 0;
    double leftArmPosition = 0;

	public void initDefaultCommand()
	{
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new TeleoperatedToteCapture());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	// method to set the right tote capture arm position
	public void setRightArmPosition(double position)
	{
		// remember the right arm position
		rightArmPosition = position;
		
		// set the right arm PID position
		rightArm.setSetpoint(rightArmPosition);
	}
	
	// method to set the left tote capture arm position
	public void setLeftArmPosition(double position)
	{
		// remember the left arm position
		leftArmPosition = position;
		
		// set the left arm PID position
		leftArm.setSetpoint(position);
	}
	
	public void driveToteCaptureAngle(Joystick joystick)
	{
		double joystickPosition;
		
		// get the present joystick position
		// Note: negative joystick indicates left
		joystickPosition = Robot.oi.forkliftJoystick.getX();
		
        // set the tote arm positions based on the joystick position
		setRightArmPosition(joystickPosition + Constants.TOTE_CAPTURE_RIGHT_ARM_ZERO_POSITION);
		setLeftArmPosition(joystickPosition + Constants.TOTE_CAPTURE_LEFT_ARM_ZERO_POSITION);
	}
}
