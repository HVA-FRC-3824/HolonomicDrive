package org.usfirst.frc3824.HolonomicDrive;

public class Constants
{
    //***************************************************************************************
	// gyro center value
	public final static int GYRO_CENTER                                      = 1975175;
	
    //***************************************************************************************
    // forklift positions for each tote height
	                                                                                 //  Competition Robot settings
    public final static double FORKLIFT_TOTEPICKUP_POSITION                  =  0.0; //  0.0;
    public final static double FORKLIFT_TOTE0_POSITION                       =  4.0; //  5.0;  //going to be well over the height of one tote
    public final static double FORKLIFT_TOTE1_POSITION                       = 12.0; // 18.5;
    public final static double FORKLIFT_TOTE2_POSITION                       = 22.0; // 30.0;
    public final static double FORKLIFT_TOTE3_POSITION                       = 28.75; // 40.0;
    public final static double FORKLIFT_TOTE4_POSITION                       = 35.0; // 49.0;
    public final static double FORKLIFT_TOTE5_POSITION                       = 55.5; // 55.5;
    
    public final static double FORKLIFT_STEP                                 = 10.5; // 10.5;
    public final static double FORKLIFT_CONTAINER_PICKUP                     =  6.6; //  6.6;
    public final static double FORKLIFT_CONTAINER_LIFT                       = 21.0; // 21.0;
    
    public final static double FORKLIFT_TOTE_LOAD_HEIGHT                     = 18.5; // 25.0;
    	
    //***************************************************************************************
    // Drive train turn constants
    public final static double DRIVETRAIN_DRIVE_STRAIGHT_P                   = 0.040;
    public final static double DRIVETRAIN_DRIVE_STRAIGHT_I                   = 0.004;
    public final static double DRIVETRAIN_DRIVE_STRAIGHT_D                   = 0.040;

    public final static double DRIVETRAIN_TURN_ANGLE_P                       = 0.005;   // 0.005
    public final static double DRIVETRAIN_TURN_ANGLE_I                       = 0.0001;  // 0.0005
    public final static double DRIVETRAIN_TURN_ANGLE_D                       = 0.005;
    
    public final static double DRIVETRAIN_DRIVE_AND_TURN_P                   = 0.005;
    public final static double DRIVETRAIN_DRIVE_AND_TURN_I                   = 0.00001;
    public final static double DRIVETRAIN_DRIVE_AND_TURN_D                   = 0.005;

    public final static double TURN_THRESHOLD                                = 3.0; // works with 1, but is a bit slow

    //**************************************************************************************
    // TELEOP: Bring totes in and out
    public final static double ROLLER_MOTOR_POWER                               =  1.0;

    //***************************************************************************************
    // forklift velocity and position PID parameters
    public final static int    FORKLIFT_POSITION_MODE                        = 0;
    public final static int    FORKLIFT_VELOCITY_MODE                        = 1;
    
    public final static double FORKLIFT_MAXIMUM_POSITION                     = 50.0;
    
    public final static double FORKLIFT_AT_POSITION_DISTANCE                 = 0.5;
        
    public final static double FORKLIFT_SWITCH_TO_POSITION_DISTANCE          = 1.0;
    
    public final static double FORKLIFT_JOG_STEP                             = 2.5;
    
    public final static double FORKLIFT_VELOCITY_SETPOINT_LOW                = 12.5;                         
    public final static double FORKLIFT_VELOCITY_SETPOINT_HIGH               = 28.0;                       
    
    public final static double FORKLIFT_VELOCITY_P                           = 0.01;
    public final static double FORKLIFT_VELOCITY_I                           = 0.01;
    public final static double FORKLIFT_VELOCITY_D                           = 0.00;
    
    public final static double FORKLIFT_POSITION_P                           = 0.20;
    public final static double FORKLIFT_POSITION_I                           = 0.01;
    public final static double FORKLIFT_POSITION_D                           = 0.15;
    
    //***************************************************************************************
    // AUTONOMOUS: Drive to Autozone
    public final static double AUTONOMOUS_AUTOZONE_DRIVE_TIME                =  1.5;
    public final static double AUTONOMOUS_AUTOZONE_DRIVER_POWER              =  0.5;
    public final static double AUTONOMOUS_AUTOZONE_DRIVE_ANGLE               =  0.0;
    
    //***************************************************************************************
    // AUTONOMOUS: Tote
    public final static double AUTONOMOUS_TOTE_DRIVE_TIME                    =  3.0;
    public final static double AUTONOMOUS_TOTE_DRIVE_POWER                   =  0.75;
    public final static double AUTONOMOUS_TOTE_DRIVE_ANGLE                   =  90.0;
    
    //***************************************************************************************
    // AUTONOMOUS: Tote and Container
    public final static double AUTONOMOUS_TOTE_AND_CONTAINER_DRIVE_TIME      =  0.7;
    public final static double AUTONOMOUS_TOTE_AND_CONTAINER_DRIVE_POWER     =  0.6;
    public final static double AUTONOMOUS_TOTE_AND_CONTAINER_DRIVE_ANGLE     =  0.0;
    
  //***************************************************************************************
    // AUTONOMOUS: Get Container in Autozone
    public final static double AUTONOMOUS_CONTAINER_DRIVE_TIME                =  1.9;
    public final static double AUTONOMOUS_CONTAINER_STEP_DRIVE_TIME           =  2.4;
    public final static double AUTONOMOUS_CONTAINER_DRIVE_POWER               =  0.5;
    public final static double AUTONOMOUS_CONTAINER_DRIVE_ANGLE               =  0.0;

    //***************************************************************************************
    // AUTONOMOUS: Get Container in Autozone
    public final static double AUTONOMOUS_REMOVE_CONTAINER_DRIVE_TIME         =  2.2;
    public final static double AUTONOMOUS_REMOVE_CONTAINER_DRIVE_POWER        =  0.5;
    public final static double AUTONOMOUS_REMOVE_CONTAINER_DRIVE_ANGLE        =  0.0;

    //***************************************************************************************
    // AUTONOMOUS: Move Container to store area and align with loading station
    public final static double AUTONOMOUS_CONTAINER_STORE_TIME                =  1.0;
    public final static double AUTONOMOUS_CONTAINER_STORE_POWER               =  0.5;
    public final static double AUTONOMOUS_CONTAINER_STORE_ANGLE               =  0.0;
}
