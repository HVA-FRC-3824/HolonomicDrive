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

import org.usfirst.frc3824.HolonomicDrive.subsystems.OffsetRobotDrive;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/*
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController driveTrainLeftFront;
    public static SpeedController driveTrainLeftRear;
    public static SpeedController driveTrainRightFront;
    public static SpeedController driveTrainRightRear;
    public static RobotDrive driveTrainHolonomicDrivePlaceHolder;
    public static Gyro driveTrainGyro;
    public static SpeedController forkliftPIDMotor;
    public static Encoder forkliftPIDEncoder;
    public static SpeedController forkliftWithJoystickMotor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static OffsetRobotDrive driveTrainHolonomicDrive;
    public static PowerDistributionPanel powerDistributionPanel;
    
	public static void init()
	{
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainLeftFront = new Talon(0);
        LiveWindow.addActuator("DriveTrain", "Left Front", (Talon) driveTrainLeftFront);
        
        driveTrainLeftRear = new Talon(1);
        LiveWindow.addActuator("DriveTrain", "Left Rear", (Talon) driveTrainLeftRear);
        
        driveTrainRightFront = new Talon(2);
        LiveWindow.addActuator("DriveTrain", "Right Front", (Talon) driveTrainRightFront);
        
        driveTrainRightRear = new Talon(3);
        LiveWindow.addActuator("DriveTrain", "Right Rear", (Talon) driveTrainRightRear);
        
        driveTrainHolonomicDrivePlaceHolder = new RobotDrive(driveTrainLeftFront, driveTrainLeftRear,
              driveTrainRightFront, driveTrainRightRear);
        
        driveTrainHolonomicDrivePlaceHolder.setSafetyEnabled(false);
        driveTrainHolonomicDrivePlaceHolder.setExpiration(0.1);
        driveTrainHolonomicDrivePlaceHolder.setSensitivity(0.5);
        driveTrainHolonomicDrivePlaceHolder.setMaxOutput(1.0);

        driveTrainHolonomicDrivePlaceHolder.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        driveTrainHolonomicDrivePlaceHolder.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        driveTrainGyro = new Gyro(0);
        LiveWindow.addSensor("DriveTrain", "Gyro", driveTrainGyro);
        driveTrainGyro.setSensitivity(0.007);
        forkliftPIDMotor = new Talon(4);
        LiveWindow.addActuator("Forklift PID", "Motor", (Talon) forkliftPIDMotor);
        
        forkliftPIDEncoder = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("Forklift PID", "Encoder", forkliftPIDEncoder);
        forkliftPIDEncoder.setDistancePerPulse(0.012);
        forkliftPIDEncoder.setPIDSourceParameter(PIDSourceParameter.kDistance);
        forkliftWithJoystickMotor = new Talon(5);
        LiveWindow.addActuator("Forklift With Joystick", "Motor", (Talon) forkliftWithJoystickMotor);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainHolonomicDrive = new OffsetRobotDrive(driveTrainLeftFront, driveTrainLeftRear,
                driveTrainRightFront, driveTrainRightRear);

        driveTrainHolonomicDrive.setSafetyEnabled(false);
        driveTrainHolonomicDrive.setExpiration(0.1);
        driveTrainHolonomicDrive.setSensitivity(0.5);
        driveTrainHolonomicDrive.setMaxOutput(1.0);

        driveTrainHolonomicDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        driveTrainHolonomicDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);

        driveTrainHolonomicDrive.setWheelbase(38, 22);
        driveTrainHolonomicDrive.setRotationOffset(0, 60);
        driveTrainHolonomicDrive.useOffsetCenter(true);
	}
}
