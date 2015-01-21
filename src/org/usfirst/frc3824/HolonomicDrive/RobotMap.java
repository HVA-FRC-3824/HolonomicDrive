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

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;

/**
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
    public static RobotDrive driveTrainHolonomicDrive;
    public static Gyro driveTrainGyro;
    public static Encoder forkliftQuadratureEncoder;
    public static SpeedController forkliftMotor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

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
        
        driveTrainHolonomicDrive = new RobotDrive(driveTrainLeftFront, driveTrainLeftRear,
              driveTrainRightFront, driveTrainRightRear);
        
        driveTrainHolonomicDrive.setSafetyEnabled(false);
        driveTrainHolonomicDrive.setExpiration(0.1);
        driveTrainHolonomicDrive.setSensitivity(0.5);
        driveTrainHolonomicDrive.setMaxOutput(1.0);

        driveTrainHolonomicDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        driveTrainHolonomicDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        driveTrainGyro = new Gyro(0);
        LiveWindow.addSensor("DriveTrain", "Gyro", driveTrainGyro);
        driveTrainGyro.setSensitivity(0.007);
        forkliftQuadratureEncoder = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("Forklift", "Quadrature Encoder", forkliftQuadratureEncoder);
        forkliftQuadratureEncoder.setDistancePerPulse(0.001);
        forkliftQuadratureEncoder.setPIDSourceParameter(PIDSourceParameter.kDistance);
        forkliftMotor = new Talon(4);
        LiveWindow.addActuator("Forklift", "Motor", (Talon) forkliftMotor);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

	}
}
