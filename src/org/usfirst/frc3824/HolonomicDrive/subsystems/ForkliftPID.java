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

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class ForkliftPID extends PIDSubsystem
{
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController motor = RobotMap.forkliftPIDMotor;
    Encoder encoder = RobotMap.forkliftPIDEncoder;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	// Initialize your subsystem here
	public ForkliftPID()
	{
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
        super("ForkliftPID", 0.2, 0.01, 0.15);
        setAbsoluteTolerance(0.01);
        getPIDController().setContinuous(true);
        LiveWindow.addActuator("Forklift PID", "PIDSubsystem Controller", getPIDController());
        getPIDController().setOutputRange(-0.4, 1.0);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID

		// Use these to get going:
		// setSetpoint() - Sets where the PID controller should move the system
		// to
		// enable() - Enables the PID controller.
	}

	public void initDefaultCommand()
	{
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new ForkliftMoveToPosition());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	protected double returnPIDInput()
	{
		// Return your input value for the PID loop
		// e.g. a sensor, like a potentiometer:
		// yourPot.getAverageVoltage() / kYourMaxVoltage;

		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
        return encoder.pidGet();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
	}

	protected void usePIDOutput(double output)
	{
		// Use output to drive your system, like a motor
		// e.g. yourMotor.set(output);

		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
        motor.pidWrite(output);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
	}

	public void StartPID()
	{
		getPIDController().enable();
	}

	public void StopPID()
	{
		getPIDController().disable();
	}

	public void SetSetpoint(double setpoint)
	{
		getPIDController().setSetpoint(setpoint);
	}

	public double GetError()
	{
		return (getPIDController().getError());
	}
}
