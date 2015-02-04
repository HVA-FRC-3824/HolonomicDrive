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

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc3824.HolonomicDrive.commands.*;
import org.usfirst.frc3824.HolonomicDrive.subsystems.*;

/*
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot
{
	Command autonomousCommand;
	Command joystickCommand;
	
	public static OI oi;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static DriveTrain driveTrain;
    public static Forklift forklift;
    public static ToteCapture toteCapture;
    public static ContainerCapture containerCapture;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
	public static SendableChooser chooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit()
	{
		RobotMap.init();
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrain = new DriveTrain();
        forklift = new Forklift();
        toteCapture = new ToteCapture();
        containerCapture = new ContainerCapture();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		// OI must be constructed after subsystems. If the OI creates Commands
		// (which it very likely will), subsystems are not guaranteed to be
		// constructed yet. Thus, their requires() statements may grab null
		// pointers. Bad news. Don't move it.
		oi = new OI();

		// create command for joystick control override
		joystickCommand = new ForkliftWithJoystick();
		
		
		// instantiate the command used for the autonomous period
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        autonomousCommand = new AutonomousDoNothing();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

		chooser = new SendableChooser();
		chooser.addDefault("1) Do Nothing", new AutonomousDoNothing());
		chooser.addObject("2) Drive to Auto Zone", new AutonomousDriveToAutoZone());
		chooser.addObject("3) Stack One Tote", new AutonomousStackOneTote());
		chooser.addObject("4) Stack Two Totes", new AutonomousStackTwoTotes());
		chooser.addObject("5) Stack Three Totes", new AutonomousStackThreeTotes());
		chooser.addObject("6) Get Right Container from Step", new AutonomousGetRightContainerFromStep());

		// show the autonomous modes
		SmartDashboard.putData("AutonomousModes", chooser);
	}

	/*
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit()
	{

	}

	public void disabledPeriodic()
	{
		Scheduler.getInstance().run();

		// add current gyro angle to smart dashboard
		SmartDashboard.putNumber("Gyro Angle", RobotMap.driveTrainGyro.getAngle());
	}

	public void autonomousInit()
	{
		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/*
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic()
	{
		Scheduler.getInstance().run();

		// add current gyro angle to smart dashboard
		SmartDashboard.putNumber("Gyro Angle", RobotMap.driveTrainGyro.getAngle());
	}

	public void teleopInit()
	{
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/*
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic()
	{

		Scheduler.getInstance().run();

		// add current gyro angle to smart dashboard
		SmartDashboard.putNumber("Gyro Angle", RobotMap.driveTrainGyro.getAngle());

		SmartDashboard.putNumber("Current 1", RobotMap.powerDistributionPanel.getCurrent(14));
		SmartDashboard.putNumber("Current 2", RobotMap.powerDistributionPanel.getCurrent(15));
				
		// Check to see if Joystick has moved
    	if (Math.abs(oi.forkliftJoystick.getY()) > Constants.FORKLIFT_JOYSTICK_THRESHOLD) {
    		if (!joystickCommand.isRunning()) {
    			Scheduler.getInstance().add(joystickCommand);
    		}
    	}
	}
	
	/*
	 * This function is called periodically during test mode
	 */
	public void testPeriodic()
	{
		LiveWindow.run();
	}
}
