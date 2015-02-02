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
	// // CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	// // TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public Joystick joystick;
    public JoystickButton totePickUp;
    public JoystickButton tote1;
    public JoystickButton tote2;
    public JoystickButton tote3;
    public JoystickButton tote4;
    public JoystickButton tote5;
    public JoystickButton tote6;
    public JoystickButton unlockJoystick;
    public Joystick forkliftJoystick;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	public OI()
	{
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        forkliftJoystick = new Joystick(1);
        
        unlockJoystick = new JoystickButton(forkliftJoystick, 2);
        unlockJoystick.whileHeld(new ForkliftWithJoystick());
        tote6 = new JoystickButton(forkliftJoystick, 7);
        tote6.whenPressed(new ForkliftMoveToPosition());
        tote5 = new JoystickButton(forkliftJoystick, 8);
        tote5.whenPressed(new ForkliftMoveToPosition());
        tote4 = new JoystickButton(forkliftJoystick, 9);
        tote4.whenPressed(new ForkliftMoveToPosition());
        tote3 = new JoystickButton(forkliftJoystick, 10);
        tote3.whenPressed(new ForkliftMoveToPosition());
        tote2 = new JoystickButton(forkliftJoystick, 11);
        tote2.whenPressed(new ForkliftMoveToPosition());
        tote1 = new JoystickButton(forkliftJoystick, 12);
        tote1.whenPressed(new ForkliftMoveToPosition());
        totePickUp = new JoystickButton(forkliftJoystick, 1);
        totePickUp.whenPressed(new ForkliftMoveToPosition());
        joystick = new Joystick(0);
        

	    
        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Do Nothing", new AutonomousDoNothing());

        SmartDashboard.putData("Autonomous Drive To Auto Zone", new AutonomousDriveToAutoZone());

        SmartDashboard.putData("Autonomous Stack One Tote", new AutonomousStackOneTote());

        SmartDashboard.putData("Autonomous Stack Two Totes", new AutonomousStackTwoTotes());

        SmartDashboard.putData("Autonomous Stack Three Totes", new AutonomousStackThreeTotes());

        SmartDashboard.putData("Autonomous Get Left Container From Step", new AutonomousGetLeftContainerFromStep());

        SmartDashboard.putData("Autonomous Get Right Container From Step", new AutonomousGetRightContainerFromStep());

        SmartDashboard.putData("Autonomous Get Two Containers From Step", new AutonomousGetTwoContainersFromStep());

        SmartDashboard.putData("Autonomous Get Four Containers From Step", new AutonomousGetFourContainersFromStep());

        SmartDashboard.putData("Chassis Drive And Turn Test", new ChassisDriveAndTurnTest());

        SmartDashboard.putData("Chassis Drive Straight", new ChassisDriveStraight());

        SmartDashboard.putData("Chassis Turn Angle", new ChassisTurnAngle());

        SmartDashboard.putData("Teleoperated Tote Capture", new TeleoperatedToteCapture());

        SmartDashboard.putData("Forklift Move To Position", new ForkliftMoveToPosition());

        SmartDashboard.putData("Forklift With Joystick", new ForkliftWithJoystick());


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
