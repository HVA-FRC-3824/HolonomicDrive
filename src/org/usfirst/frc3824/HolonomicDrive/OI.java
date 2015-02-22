// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc3824.HolonomicDrive;

import org.usfirst.frc3824.HolonomicDrive.commands.*;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;

/*
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI
{
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public Joystick joystick;
    public JoystickButton totePickUp;
    public JoystickButton tote0;
    public JoystickButton tote1;
    public JoystickButton tote2;
    public JoystickButton tote3;
    public JoystickButton tote4;
    public JoystickButton tote5;
    public JoystickButton forkliftJogUp;
    public JoystickButton forkliftJogDown;
    public JoystickButton resetSpeed;
    public JoystickButton setSpeed;
    public Joystick forkliftJoystick;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	public OI()
	{
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        forkliftJoystick = new Joystick(1);
        
        setSpeed = new JoystickButton(forkliftJoystick, 2);
        setSpeed.whenPressed(new ForkliftSetSpeed());
        resetSpeed = new JoystickButton(forkliftJoystick, 2);
        resetSpeed.whenReleased(new ForkliftSetSpeed());
        forkliftJogDown = new JoystickButton(forkliftJoystick, 3);
        forkliftJogDown.whenPressed(new ForkliftMoveToPosition());
        forkliftJogUp = new JoystickButton(forkliftJoystick, 5);
        forkliftJogUp.whenPressed(new ForkliftMoveToPosition());
        tote5 = new JoystickButton(forkliftJoystick, 7);
        tote5.whenPressed(new ForkliftMoveToPosition());
        tote4 = new JoystickButton(forkliftJoystick, 8);
        tote4.whenPressed(new ForkliftMoveToPosition());
        tote3 = new JoystickButton(forkliftJoystick, 9);
        tote3.whenPressed(new ForkliftMoveToPosition());
        tote2 = new JoystickButton(forkliftJoystick, 10);
        tote2.whenPressed(new ForkliftMoveToPosition());
        tote1 = new JoystickButton(forkliftJoystick, 11);
        tote1.whenPressed(new ForkliftMoveToPosition());
        tote0 = new JoystickButton(forkliftJoystick, 12);
        tote0.whenPressed(new ForkliftMoveToPosition());
        totePickUp = new JoystickButton(forkliftJoystick, 1);
        totePickUp.whenPressed(new ForkliftMoveToPosition());
        joystick = new Joystick(0);
        

	    
        // SmartDashboard Buttons
        SmartDashboard.putData("Chassis Drive Straight", new ChassisDriveStraight());

        SmartDashboard.putData("Chassis Turn Angle", new ChassisTurnAngle());

        SmartDashboard.putData("Chassis Drive And Turn", new ChassisDriveAndTurn());

        SmartDashboard.putData("Chassis Drive And Turn Test", new ChassisDriveAndTurnTest());


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
	}

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getJoystick() {
        return joystick;
    }

    public Joystick getForkliftJoystick() {
        return forkliftJoystick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}
