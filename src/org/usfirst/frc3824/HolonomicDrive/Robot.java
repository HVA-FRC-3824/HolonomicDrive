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

	public static OI oi;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static DriveTrain driveTrain;
    public static Forklift forklift;
    public static Roller roller;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	public static SendableChooser chooser;

	/*
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit()
	{
		Constants.InitConstants();
		RobotMap.init();
		
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrain = new DriveTrain();
        forklift = new Forklift();
        roller = new Roller();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		// OI must be constructed after subsystems. If the OI creates Commands
		// (which it very likely will), subsystems are not guaranteed to be
		// constructed yet. Thus, their requires() statements may grab null
		// pointers. Bad news. Don't move it.
		oi = new OI();

		// instantiate the command used for the autonomous period
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        autonomousCommand = new AutonomousDoNothing();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        
		chooser = new SendableChooser();
		chooser.addDefault("1) Do Nothing",                                   new AutonomousDoNothing());
		chooser.addObject("2) Drive to Auto Zone",                            new AutonomousDriveToAutoZone());
		chooser.addObject("3) Tote",                                          new AutonomousTote());
		chooser.addObject("4) Tote And Container",                            new AutonomousToteAndContainer());
		chooser.addObject("5) Drive with Container And Turn Right",           new AutonomousDriveBackwardsWithContainerTurnRight());
		chooser.addObject("6) Drive with Container And Turn Left",            new AutonomousDriveBackwardsWithContainerTurnLeft());
		chooser.addObject("7) Drive with Container And Turn Right Over Step", new AutonomousDriveBackwardsWithContainerOverStep());
        chooser.addObject("8) Move Container and Ready to Load",              new AutonomousMoveContainerAndAlignToLoad());
		chooser.addObject("9) Remove Container For 3 Stack",                  new AutonomousRemoveContainer());
        //chooser.addObject("9) Stack Two Totes Container",                     new AutonomousStackTwoTotesContainer());
		//chooser.addObject("6) Stake Three Totes",                             new AutonomousStackThreeTotes());
		//chooser.addObject("8) Stack Three Totes Container",                   new AutonomousStackThreeTotesContainer());
		//chooser.addObject("7) Container And Totes",                           new AutonomousContainerAndTote());
		
		// show the autonomous modes
		SmartDashboard.putData("AutonomousModes", chooser);
	}

	/*
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit()
	{
		// Reset Position to 0.0 when disabled
		forklift.setPIDmodeAndSetpoint(Constants.FORKLIFT_POSITION_MODE, 0.0);
	}

	public void disabledPeriodic()
	{
		Scheduler.getInstance().run();

		// This is in disablePeriodic because we know that when disabled, the forklift
		// will slowly fall to it's rest position, this will keep reseting while disabled
		// One might think to put the reset in autonomousInit() or in teleopInit() the problem
		// with this approach is, if you put it in autonomousInit(), it won't initialize during
		// testing when you go straight to teleop.  If you put the reset in teleop, then during
		// a game, it will reset when it transitions from auto to teleop.  This would be bad
		// if autonomous had moved the forklift.  By putting it in disabled, we can be sure
		// that it will be reset RIGHT BEFORE either init is called and will not get
		// reset in between.
		forklift.resetEncoder();
		
		// add current gyro angle to smart dashboard
		SmartDashboard.putNumber("Gyro Angle", RobotMap.driveTrainGyro.getAngle());
	}

	public void autonomousInit()
	{
		// schedule the autonomous command (example)
		if (chooser.getSelected() != null)
		{
			Robot.driveTrain.resetGyro();
			Command autonomousCommand = (edu.wpi.first.wpilibj.command.Command) chooser.getSelected();
			autonomousCommand.start();
		}
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
		
		Robot.roller.setRollerSpeed(Constants.ROLLER_MOTOR_POWER);
	}

	/*
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic()
	{
		Scheduler.getInstance().run();

		// add current gyro angle to smart dashboard
		SmartDashboard.putNumber("Gyro Angle", RobotMap.driveTrainGyro.getAngle());

		// SmartDashboard.putNumber("Current 0",
		// RobotMap.powerDistributionPanel.getCurrent(0));
		// SmartDashboard.putNumber("Current 1",
		// RobotMap.powerDistributionPanel.getCurrent(1));
		// SmartDashboard.putNumber("Current 2",
		// RobotMap.powerDistributionPanel.getCurrent(2));
		// SmartDashboard.putNumber("Current 3",
		// RobotMap.powerDistributionPanel.getCurrent(3));
		// SmartDashboard.putNumber("Current 4",
		// RobotMap.powerDistributionPanel.getCurrent(4));
		// SmartDashboard.putNumber("Current 5",
		// RobotMap.powerDistributionPanel.getCurrent(5));
		// SmartDashboard.putNumber("Current 6",
		// RobotMap.powerDistributionPanel.getCurrent(6));
		// SmartDashboard.putNumber("Current 7",
		// RobotMap.powerDistributionPanel.getCurrent(7));
		// SmartDashboard.putNumber("Current 8",
		// RobotMap.powerDistributionPanel.getCurrent(8));
		// SmartDashboard.putNumber("Current 9",
		// RobotMap.powerDistributionPanel.getCurrent(9));
		// SmartDashboard.putNumber("Current 10",
		// RobotMap.powerDistributionPanel.getCurrent(10));
		// SmartDashboard.putNumber("Current 11",
		// RobotMap.powerDistributionPanel.getCurrent(11));
		// SmartDashboard.putNumber("Current 12",
		// RobotMap.powerDistributionPanel.getCurrent(12));
		// SmartDashboard.putNumber("Current 13",
		// RobotMap.powerDistributionPanel.getCurrent(13));
		// SmartDashboard.putNumber("Current 14",
		// RobotMap.powerDistributionPanel.getCurrent(14));
		// SmartDashboard.putNumber("Current 15",
		// RobotMap.powerDistributionPanel.getCurrent(15));
	}

	/*
	 * This function is called periodically during test mode
	 */
	public void testPeriodic()
	{
		LiveWindow.run();
	}
}
