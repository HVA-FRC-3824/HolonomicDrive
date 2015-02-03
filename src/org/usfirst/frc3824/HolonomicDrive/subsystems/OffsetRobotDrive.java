package org.usfirst.frc3824.HolonomicDrive.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.communication.UsageReporting;
import edu.wpi.first.wpilibj.communication.FRCNetworkCommunicationsLibrary.tInstances;
import edu.wpi.first.wpilibj.communication.FRCNetworkCommunicationsLibrary.tResourceType;

public class OffsetRobotDrive extends RobotDrive {

    private Boolean offsetCenter = false;

    static final int kFrontLeft_val = 0;
    static final int kFrontRight_val = 1;
    static final int kRearLeft_val = 2;
    static final int kRearRight_val = 3;
    
    boolean wheelbaseSet = false;
    double xWheelbase = 0.0;
    double yWheelbase = 0.0;
    double xOffset = 0.0;
    double yOffset = 0.0;
    double xDistFromCenter[] = new double[kMaxNumberOfMotors];
    double yDistFromCenter[] = new double[kMaxNumberOfMotors];

    public OffsetRobotDrive(int leftMotorChannel, int rightMotorChannel) {
		super(leftMotorChannel, rightMotorChannel);
		// TODO Auto-generated constructor stub
	}

	public OffsetRobotDrive(SpeedController leftMotor,
			SpeedController rightMotor) {
		super(leftMotor, rightMotor);
		// TODO Auto-generated constructor stub
	}

	public OffsetRobotDrive(int frontLeftMotor, int rearLeftMotor,
			int frontRightMotor, int rearRightMotor) {
		super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
		// TODO Auto-generated constructor stub
	}

	public OffsetRobotDrive(SpeedController frontLeftMotor,
			SpeedController rearLeftMotor, SpeedController frontRightMotor,
			SpeedController rearRightMotor) {
		super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * specify the wheelbase measurements of the robot
	 * 
	 * @param xdist distance between right and left wheels
	 * @param ydist distance between front and back wheels
	 * 
	 */
	public void setWheelbase(double xdist, double ydist)
	{
		if(xdist != 0.0 && ydist != 0.0)
		{
			xWheelbase = xdist;
			yWheelbase = ydist;
			wheelbaseSet = true;
		}		
	}

	/**
	 * specify the offset rotation point relative to the physical center point
	 * 
	 * @param xdist distance between physical center and center of rotation
	 * @param ydist distance between physical center and center of rotation
	 */
	public void setRotationOffset(double xdist, double ydist)
	{		
		xOffset = xdist;
		yOffset = ydist;
	}

	/**
	 * Choose whether twist should be about the center of off-center point of the robot
	 * 
	 * If offset center is FALSE, the robot will twist about the center of the rectangle created by the wheels.
	 * If offset center is TRUE, the robot will twist about the center of the tote carrying mechanism
	 * 
	 * @param state enable or disable offset twisting of the robot.
	 */
	public void useOffsetCenter(Boolean state)
	{
		if(wheelbaseSet == true)
		{
			offsetCenter = state;
		}
	}
	
    /**
     * Drive method for Mecanum wheeled robots.
     *
     * A method for driving with Mecanum wheeled robots. There are 4 wheels
     * on the robot, arranged so that the front and back wheels are toed in 45 degrees.
     * When looking at the wheels from the top, the roller axles should form an X across the robot.
     *
     * @param magnitude The speed that the robot should drive in a given direction.
     * @param direction The direction the robot should drive in degrees. The direction and maginitute are
     * independent of the rotation rate.
     * @param rotation The rate of rotation for the robot that is completely independent of
     * the magnitute or direction. [-1.0..1.0]
     */
    public void mecanumDrive_Polar(double magnitude, double direction, double rotation) {
        if(!kMecanumPolar_Reported) {
            UsageReporting.report(tResourceType.kResourceType_RobotDrive, getNumMotors(), tInstances.kRobotDrive_MecanumPolar);
            kMecanumPolar_Reported = true;
        }

        // Normalized for full power along the Cartesian axes.
        magnitude = limit(magnitude) * Math.sqrt(2.0);
        // The rollers are at 45 degree angles.
        double dirInRad = (direction + 45.0) * 3.14159 / 180.0;
        double cosD = Math.cos(dirInRad);
        double sinD = Math.sin(dirInRad);
        double offsetRotation[] = new double[kMaxNumberOfMotors];

		xDistFromCenter[kFrontLeft_val] = (xWheelbase / 2.0) + xOffset;
		yDistFromCenter[kFrontLeft_val] = (yWheelbase / 2.0) - yOffset;
		
		xDistFromCenter[kFrontRight_val] = (xWheelbase / 2.0) - xOffset;
		yDistFromCenter[kFrontRight_val] = (yWheelbase / 2.0) - yOffset;
		
		xDistFromCenter[kRearLeft_val] = (xWheelbase / 2.0) + xOffset;
		yDistFromCenter[kRearLeft_val] = (yWheelbase / 2.0) + yOffset;
		
		xDistFromCenter[kRearRight_val] = (xWheelbase / 2.0) - xOffset;
		yDistFromCenter[kRearRight_val] = (yWheelbase / 2.0) + yOffset;		

		if(offsetCenter == true)
        {
        	offsetRotation[kFrontLeft_val] = rotation *
        			((xDistFromCenter[kFrontLeft_val] + yDistFromCenter[kFrontLeft_val]) / ((xWheelbase + yWheelbase) / 2.0));
	    	offsetRotation[kFrontRight_val] = rotation *
	    			((xDistFromCenter[kFrontRight_val] + yDistFromCenter[kFrontRight_val]) / ((xWheelbase + yWheelbase) / 2.0));
        	offsetRotation[kRearLeft_val] = rotation *
        			((xDistFromCenter[kRearLeft_val] + yDistFromCenter[kRearLeft_val]) / ((xWheelbase + yWheelbase) / 2.0));
        	offsetRotation[kRearRight_val] = rotation *
        			((xDistFromCenter[kRearRight_val] + yDistFromCenter[kRearRight_val]) / ((xWheelbase + yWheelbase) / 2.0));
        }
        else
        {
        	offsetRotation[kFrontLeft_val] = rotation;
        	offsetRotation[kFrontRight_val] = rotation;
        	offsetRotation[kRearLeft_val] = rotation;
        	offsetRotation[kRearRight_val] = rotation;
        }
        
        double wheelSpeeds[] = new double[kMaxNumberOfMotors];
        wheelSpeeds[kFrontLeft_val] = (sinD * magnitude + offsetRotation[kFrontLeft_val]);
        wheelSpeeds[kFrontRight_val] = (cosD * magnitude - offsetRotation[kFrontRight_val]);
        wheelSpeeds[kRearLeft_val] = (cosD * magnitude + offsetRotation[kRearLeft_val]);
        wheelSpeeds[kRearRight_val] = (sinD * magnitude - offsetRotation[kRearRight_val]);

        normalize(wheelSpeeds);

        m_frontLeftMotor.set(wheelSpeeds[kFrontLeft_val] * m_invertedMotors[kFrontLeft_val] * m_maxOutput, m_syncGroup);
        m_frontRightMotor.set(wheelSpeeds[kFrontRight_val] * m_invertedMotors[kFrontRight_val] * m_maxOutput, m_syncGroup);
        m_rearLeftMotor.set(wheelSpeeds[kRearLeft_val] * m_invertedMotors[kRearLeft_val] * m_maxOutput, m_syncGroup);
        m_rearRightMotor.set(wheelSpeeds[kRearRight_val] * m_invertedMotors[kRearRight_val] * m_maxOutput, m_syncGroup);

        if (this.m_syncGroup != 0) {
            CANJaguar.updateSyncGroup(m_syncGroup);
        }

        if (m_safetyHelper != null) m_safetyHelper.feed();
    }

}
