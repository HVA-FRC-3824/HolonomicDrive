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

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc3824.HolonomicDrive.Constants;
import org.usfirst.frc3824.HolonomicDrive.Robot;
import org.usfirst.frc3824.HolonomicDrive.RobotMap;

/**
 *
 */
public class  ForkliftMoveToPosition extends PIDCommand {

	double position = -1.0;

	// NOTE: if position is <0 position is set to current position
    public ForkliftMoveToPosition(double position) 
	{
		this();
		this.position = position;
	}

    public ForkliftMoveToPosition() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
        super("ForkliftMoveToPosition", 0.2, 0.01, 0.15, 0.02);
        getPIDController().setContinuous(true);
        getPIDController().setAbsoluteTolerance(0.1);
        getPIDController().setOutputRange(-0.4, 1.0);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID

        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.forklift);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }    

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
        return RobotMap.forkliftEncoder.pidGet();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
        RobotMap.forkliftMotor.pidWrite(output);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		// Determine which button was pressed
		if (Robot.oi.totePickUp.get() == true)
			position = Constants.FORKLIFT_TOTEPICKUP_POSITION;
		else if (Robot.oi.tote1.get() == true)
			position = Constants.FORKLIFT_TOTE1_POSITION;
		else if (Robot.oi.tote2.get() == true)
			position = Constants.FORKLIFT_TOTE2_POSITION;
		else if (Robot.oi.tote3.get() == true)
			position = Constants.FORKLIFT_TOTE3_POSITION;
		else if (Robot.oi.tote4.get() == true)
			position = Constants.FORKLIFT_TOTE4_POSITION;
		else if (Robot.oi.tote5.get() == true)
			position = Constants.FORKLIFT_TOTE5_POSITION;
		else if (Robot.oi.tote6.get() == true)
			position = Constants.FORKLIFT_TOTE6_POSITION;
		else {
			// no buton was pressed, check to see if position was passed
			if (position < 0) {
				position = RobotMap.forkliftEncoder.pidGet();
			}
		}

		getPIDController().setSetpoint(position);
		getPIDController().enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		SmartDashboard.putNumber("Error", this.getPIDController().getError());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
		getPIDController().disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
		getPIDController().disable();
    }
}
