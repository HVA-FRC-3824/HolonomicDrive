package org.usfirst.frc3824.HolonomicDrive;

public class Constants
{
    //***************************************************************************************
    // tote capture arm constants
	public final static double TOTE_CAPTURE_RIGHT_ARM_ZERO_POSITION          = 0.5;
	public final static double TOTE_CAPTURE_LEFT_ARM_ZERO_POSITION           = 0.5;
	
    //***************************************************************************************
    /* Contants which might require tuning */
    public final static double DrivetrainAngleGyroControllerP                = 0.040;  // 0.04;	John Young's nums
    public final static double DrivetrainAngleGyroControllerI                = 0.004;  // 0.004;
    public final static double DrivetrainAngleGyroControllerD                = 0.040;  // 0.04;

    public final static double DrivetrainAngleGyroControllerTurnP            = 0.005;
    public final static double DrivetrainAngleGyroControllerTurnI            = 0.00005;
    public final static double DrivetrainAngleGyroControllerTurnD            = 0.0004;

    public final static double TURN_THRESHOLD                                = 10.0; //works with 1 but is a bit slow;    was 1.5
    
    //***************************************************************************************
    // forklift positions for each tote height
    public final static double FORKLIFT_TOTEPICKUP_POSITION                  = 0.0;
    public final static double FORKLIFT_TOTE1_POSITION                       = 5.0; //going to be well over the height of one tote
    public final static double FORKLIFT_TOTE2_POSITION                       = 17.0;
    public final static double FORKLIFT_TOTE3_POSITION                       = 28.0;
    public final static double FORKLIFT_TOTE4_POSITION                       = 38.0;
    public final static double FORKLIFT_TOTE5_POSITION                       = 47.0;
    public final static double FORKLIFT_TOTE6_POSITION                       = 54.50;
    
    //***************************************************************************************
    // autonomous command constants
    public final static double AUTONOMOUS_AUTOZONE_DRIVE_TIME                = 1.0;
    public final static double AUTONOMOUS_AUTOZONE_DRIVER_POWER              = 0.5;
    public final static double AUTONOMOUS_AUTOZONE_DRIVE_ANGLE               = 0.0;
    
    public final static double AUTONOMOUS_CONTAINER_DRIVE_TIME               = 1.25;
    public final static double AUTONOMOUS_CONTAINER_DRIVER_POWER             = 0.5;
    public final static double AUTONOMOUS_CONTAINER_DRIVE_REVERSE_DIRECTION  = 180.0;
    public final static double AUTONOMOUS_CONTAINER_DRIVE_FORWARD_DIRECTION  = 0;
    
    //***************************************************************************************
    // robot motor controller power  
    public final static int    FORKLIFT_MOTOR1_PDP_CHANNEL                   = 14;
    public final static int    FORKLIFT_MOTOR2_PDP_CHANNEL                   = 15;   
    
    //***************************************************************************************
    // forklift velocity and position PID parameters
    public final static int    FORKLIFT_POSITION_MODE                        = 0;
    public final static int    FORKLIFT_VELOCITY_MODE                        = 1;
    
    public final static double FORKLIFT_MAXIMUM_POSITION                     = 50.0;
    
    public final static double FORKLIFT_AT_POSITION_DISTANCE                 = 0.5;
        
    public final static double FORKLIFT_SWITCH_TO_POSITION_DISTANCE          = 1.0;
    
    public final static double FORKLIFT_JOG_STEP                             = 2.5;
    
    public final static double FORKLIFT_VELOCITY_SETPOINT                    = 20.0;                         
    
    public final static double FORKLIFT_VELOCITY_P                           = 0.01;
    public final static double FORKLIFT_VELOCITY_I                           = 0.01;
    public final static double FORKLIFT_VELOCITY_D                           = 0.00;
    
    public final static double FORKLIFT_POSITION_P                           = 0.20;
    public final static double FORKLIFT_POSITION_I                           = 0.01;
    public final static double FORKLIFT_POSITION_D                           = 0.15;
    
}
