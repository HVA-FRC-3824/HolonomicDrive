package org.usfirst.frc3824.HolonomicDrive;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Constants
{
	static final boolean IS_COMP_ROBOT = false;
	
	public static void InitConstants()
	{
		if (IS_COMP_ROBOT)
		{
			SmartDashboard.putString("Active Robot Values", "COMPETITION");
		    FORKLIFT_TOTEPICKUP_POSITION                  = COMP_FORKLIFT_TOTEPICKUP_POSITION;
		    FORKLIFT_TOTE0_POSITION                       = COMP_FORKLIFT_TOTE0_POSITION;
		    FORKLIFT_TOTE1_POSITION                       = COMP_FORKLIFT_TOTE1_POSITION;
		    FORKLIFT_TOTE2_POSITION                       = COMP_FORKLIFT_TOTE2_POSITION;
		    FORKLIFT_TOTE3_POSITION                       = COMP_FORKLIFT_TOTE3_POSITION;
		    FORKLIFT_TOTE4_POSITION                       = COMP_FORKLIFT_TOTE4_POSITION;
		    FORKLIFT_TOTE5_POSITION                       = COMP_FORKLIFT_TOTE5_POSITION;
		    
		    FORKLIFT_STEP                                 = COMP_FORKLIFT_STEP;
		    FORKLIFT_CONTAINER_PICKUP                     = COMP_FORKLIFT_CONTAINER_PICKUP;
		    FORKLIFT_CONTAINER_LIFT                       = COMP_FORKLIFT_CONTAINER_LIFT;
		    
		    FORKLIFT_TOTE_LOAD_HEIGHT                     = COMP_FORKLIFT_TOTE_LOAD_HEIGHT;
		    	
		    //***************************************************************************************
		    // Drive train turn constants
		    DRIVETRAIN_DRIVE_STRAIGHT_P                   = COMP_DRIVETRAIN_DRIVE_STRAIGHT_P;
		    DRIVETRAIN_DRIVE_STRAIGHT_I                   = COMP_DRIVETRAIN_DRIVE_STRAIGHT_I;
		    DRIVETRAIN_DRIVE_STRAIGHT_D                   = COMP_DRIVETRAIN_DRIVE_STRAIGHT_D;
	
		    DRIVETRAIN_TURN_ANGLE_P                       = COMP_DRIVETRAIN_TURN_ANGLE_P;
		    DRIVETRAIN_TURN_ANGLE_I                       = COMP_DRIVETRAIN_TURN_ANGLE_I;
		    DRIVETRAIN_TURN_ANGLE_D                       = COMP_DRIVETRAIN_TURN_ANGLE_D;
		    
		    DRIVETRAIN_DRIVE_AND_TURN_P                   = COMP_DRIVETRAIN_DRIVE_AND_TURN_P;
		    DRIVETRAIN_DRIVE_AND_TURN_I                   = COMP_DRIVETRAIN_DRIVE_AND_TURN_I;
		    DRIVETRAIN_DRIVE_AND_TURN_D                   = COMP_DRIVETRAIN_DRIVE_AND_TURN_D;
		}
		else // ---------- PRACTICE ROBOT ----------
		{
			SmartDashboard.putString("Active Robot Values", "PRACTICE");
		    FORKLIFT_TOTEPICKUP_POSITION                  = PRACTICE_FORKLIFT_TOTEPICKUP_POSITION;
		    FORKLIFT_TOTE0_POSITION                       = PRACTICE_FORKLIFT_TOTE0_POSITION;
		    FORKLIFT_TOTE1_POSITION                       = PRACTICE_FORKLIFT_TOTE1_POSITION;
		    FORKLIFT_TOTE2_POSITION                       = PRACTICE_FORKLIFT_TOTE2_POSITION;
		    FORKLIFT_TOTE3_POSITION                       = PRACTICE_FORKLIFT_TOTE3_POSITION;
		    FORKLIFT_TOTE4_POSITION                       = PRACTICE_FORKLIFT_TOTE4_POSITION;
		    FORKLIFT_TOTE5_POSITION                       = PRACTICE_FORKLIFT_TOTE5_POSITION;
		    
		    FORKLIFT_STEP                                 = PRACTICE_FORKLIFT_STEP;
		    FORKLIFT_CONTAINER_PICKUP                     = PRACTICE_FORKLIFT_CONTAINER_PICKUP;
		    FORKLIFT_CONTAINER_LIFT                       = PRACTICE_FORKLIFT_CONTAINER_LIFT;
		    
		    FORKLIFT_TOTE_LOAD_HEIGHT                     = PRACTICE_FORKLIFT_TOTE_LOAD_HEIGHT;
		    	
		    //***************************************************************************************
		    // Drive train turn constants
		    DRIVETRAIN_DRIVE_STRAIGHT_P                   = PRACTICE_DRIVETRAIN_DRIVE_STRAIGHT_P;
		    DRIVETRAIN_DRIVE_STRAIGHT_I                   = PRACTICE_DRIVETRAIN_DRIVE_STRAIGHT_I;
		    DRIVETRAIN_DRIVE_STRAIGHT_D                   = PRACTICE_DRIVETRAIN_DRIVE_STRAIGHT_D;
	
		    DRIVETRAIN_TURN_ANGLE_P                       = PRACTICE_DRIVETRAIN_TURN_ANGLE_P;
		    DRIVETRAIN_TURN_ANGLE_I                       = PRACTICE_DRIVETRAIN_TURN_ANGLE_I;
		    DRIVETRAIN_TURN_ANGLE_D                       = PRACTICE_DRIVETRAIN_TURN_ANGLE_D;
		    
		    DRIVETRAIN_DRIVE_AND_TURN_P                   = PRACTICE_DRIVETRAIN_DRIVE_AND_TURN_P;
		    DRIVETRAIN_DRIVE_AND_TURN_I                   = PRACTICE_DRIVETRAIN_DRIVE_AND_TURN_I;
		    DRIVETRAIN_DRIVE_AND_TURN_D                   = PRACTICE_DRIVETRAIN_DRIVE_AND_TURN_D;			
		}

	}
    //***************************************************************************************
	// gyro center value
	public final static int GYRO_CENTER                                      = 1975175;
	
    //***************************************************************************************
    //**************** Values that differ between practice and competition ******************
    //***************************************************************************************
   
    public static double FORKLIFT_TOTEPICKUP_POSITION;
    public static double FORKLIFT_TOTE0_POSITION;  //going to be well over the height of one tote
    public static double FORKLIFT_TOTE1_POSITION;
    public static double FORKLIFT_TOTE2_POSITION;
    public static double FORKLIFT_TOTE3_POSITION;
    public static double FORKLIFT_TOTE4_POSITION;
    public static double FORKLIFT_TOTE5_POSITION;
    
    public static double FORKLIFT_STEP;
    public static double FORKLIFT_CONTAINER_PICKUP;
    public static double FORKLIFT_CONTAINER_LIFT;
    
    public static double FORKLIFT_TOTE_LOAD_HEIGHT;
    	
    //***************************************************************************************
    // Drive train turn constants
    public static double DRIVETRAIN_DRIVE_STRAIGHT_P;
    public static double DRIVETRAIN_DRIVE_STRAIGHT_I;
    public static double DRIVETRAIN_DRIVE_STRAIGHT_D;

    public static double DRIVETRAIN_TURN_ANGLE_P;
    public static double DRIVETRAIN_TURN_ANGLE_I;
    public static double DRIVETRAIN_TURN_ANGLE_D;
    
    public static double DRIVETRAIN_DRIVE_AND_TURN_P;
    public static double DRIVETRAIN_DRIVE_AND_TURN_I;
    public static double DRIVETRAIN_DRIVE_AND_TURN_D;

    
    //***************************************************************************************
    //			                            ------- PRACTICE ROBOT SETTINGS ------
    // forklift positions for each tote height
	                                                                                 
    public final static double PRACTICE_FORKLIFT_TOTEPICKUP_POSITION              =  0.0;
    public final static double PRACTICE_FORKLIFT_TOTE0_POSITION                   =  4.0;
    public final static double PRACTICE_FORKLIFT_TOTE1_POSITION                   = 12.0;
    public final static double PRACTICE_FORKLIFT_TOTE2_POSITION                   = 22.0;
    public final static double PRACTICE_FORKLIFT_TOTE3_POSITION                   = 28.75;
    public final static double PRACTICE_FORKLIFT_TOTE4_POSITION                   = 38.0;
    public final static double PRACTICE_FORKLIFT_TOTE5_POSITION                   = 55.5;
    
    public final static double PRACTICE_FORKLIFT_STEP                             = 10.5;
    public final static double PRACTICE_FORKLIFT_CONTAINER_PICKUP                 =  6.6;
    public final static double PRACTICE_FORKLIFT_CONTAINER_LIFT                   = 21.0;
    
    public final static double PRACTICE_FORKLIFT_TOTE_LOAD_HEIGHT                 = 18.5;
    	
    //***************************************************************************************
    // Drive train turn constants
    public final static double PRACTICE_DRIVETRAIN_DRIVE_STRAIGHT_P               = 0.040;
    public final static double PRACTICE_DRIVETRAIN_DRIVE_STRAIGHT_I               = 0.004;
    public final static double PRACTICE_DRIVETRAIN_DRIVE_STRAIGHT_D               = 0.040;

    public final static double PRACTICE_DRIVETRAIN_TURN_ANGLE_P                   = 0.005;
    public final static double PRACTICE_DRIVETRAIN_TURN_ANGLE_I                   = 0.0001;
    public final static double PRACTICE_DRIVETRAIN_TURN_ANGLE_D                   = 0.005;
    
    public final static double PRACTICE_DRIVETRAIN_DRIVE_AND_TURN_P               = 0.005;
    public final static double PRACTICE_DRIVETRAIN_DRIVE_AND_TURN_I               = 0.00001;
    public final static double PRACTICE_DRIVETRAIN_DRIVE_AND_TURN_D               = 0.005;

    //***************************************************************************************
    //			                            ------- COMPETITION ROBOT SETTINGS ------
    // forklift positions for each tote height
	                                                                                 
    public final static double COMP_FORKLIFT_TOTEPICKUP_POSITION             =  0.0;
    public final static double COMP_FORKLIFT_TOTE0_POSITION                  =  5.0;  //going to be well over the height of one tote
    public final static double COMP_FORKLIFT_TOTE1_POSITION                  = 18.5;
    public final static double COMP_FORKLIFT_TOTE2_POSITION                  = 30.0;
    public final static double COMP_FORKLIFT_TOTE3_POSITION                  = 40.0;
    public final static double COMP_FORKLIFT_TOTE4_POSITION                  = 49.0;
    public final static double COMP_FORKLIFT_TOTE5_POSITION                  = 55.5;
    
    public final static double COMP_FORKLIFT_STEP                            = 10.5;
    public final static double COMP_FORKLIFT_CONTAINER_PICKUP                =  6.6;
    public final static double COMP_FORKLIFT_CONTAINER_LIFT                  = 21.0;
    
    public final static double COMP_FORKLIFT_TOTE_LOAD_HEIGHT                = 25.0;
    	
    //***************************************************************************************
    // Drive train turn constants
    public final static double COMP_DRIVETRAIN_DRIVE_STRAIGHT_P              = 0.040;
    public final static double COMP_DRIVETRAIN_DRIVE_STRAIGHT_I              = 0.004;
    public final static double COMP_DRIVETRAIN_DRIVE_STRAIGHT_D              = 0.040;

    public final static double COMP_DRIVETRAIN_TURN_ANGLE_P                  = 0.005;
    public final static double COMP_DRIVETRAIN_TURN_ANGLE_I                  = 0.0005;
    public final static double COMP_DRIVETRAIN_TURN_ANGLE_D                  = 0.005;
    
    public final static double COMP_DRIVETRAIN_DRIVE_AND_TURN_P              = 0.005;
    public final static double COMP_DRIVETRAIN_DRIVE_AND_TURN_I              = 0.00001;
    public final static double COMP_DRIVETRAIN_DRIVE_AND_TURN_D              = 0.005;

    //***************************************************************************************
    //***************************************************************************************
    //***************************************************************************************
   
    public final static double TURN_THRESHOLD                                = 3.0; // works with 1, but is a bit slow

    //**************************************************************************************
    // TELEOP: Bring totes in and out
    public final static double ROLLER_MOTOR_POWER                            =  1.0;

    //***************************************************************************************
    // forklift velocity and position PID parameters
    public final static int    FORKLIFT_POSITION_MODE                        = 0;
    public final static int    FORKLIFT_VELOCITY_MODE                        = 1;
    
    public final static double FORKLIFT_MAXIMUM_POSITION                     = 50.0;
    
    public final static double FORKLIFT_AT_POSITION_DISTANCE                 = 0.5;
        
    public final static double FORKLIFT_SWITCH_TO_POSITION_DISTANCE          = 1.0;
    
    public final static double FORKLIFT_JOG_STEP                             = 2.5;
    
    public final static double FORKLIFT_VELOCITY_SETPOINT_NORMAL             = 28.0;                        
    public final static double FORKLIFT_VELOCITY_SETPOINT_OVERRIDE           = 12.0;                       
    
    public final static double FORKLIFT_VELOCITY_P                           = 0.01;
    public final static double FORKLIFT_VELOCITY_I                           = 0.01;
    public final static double FORKLIFT_VELOCITY_D                           = 0.00;
    
    public final static double FORKLIFT_POSITION_P                           = 0.20;
    public final static double FORKLIFT_POSITION_I                           = 0.01;
    public final static double FORKLIFT_POSITION_D                           = 0.15;
    
    public final static double FORKLIFT_SWITCH_TO_DECELERATE_DISTANCE        =  8.0;
    public final static double FORKLIFT_ACCEL_VALUE                          =  2.0; // 0 -> 12.5 in about 1/2 sec (may be too fast)
    public final static double FORKLIFT_DECEL_VALUE                          =  2.0; // 12.5 -> 0 in about 1/2 sec
    public final static double FORKLIFT_DECEL_VELOCITY_MIN_VALUE             = 10.0; // min value so the forklift keeps moving until switching to POS mode
    public final static double FORKLIFT_DECEL_JOG_VELOCITY_MIN_VALUE         = 10.0;
    
    //***************************************************************************************
    // AUTONOMOUS: Drive to Autozone
    public final static double AUTONOMOUS_AUTOZONE_DRIVE_TIME                =  1.5;
    public final static double AUTONOMOUS_AUTOZONE_DRIVER_POWER              =  0.5;
    public final static double AUTONOMOUS_AUTOZONE_DRIVE_ANGLE               =  0.0;
    
    //***************************************************************************************
    // AUTONOMOUS: Tote
    public final static double AUTONOMOUS_TOTE_DRIVE_TIME                    =  2.70;
    public final static double AUTONOMOUS_TOTE_DRIVE_POWER                   =  0.75;
    public final static double AUTONOMOUS_TOTE_DRIVE_ANGLE                   =  90.0;
    
    //***************************************************************************************
    // AUTONOMOUS: Tote and Container
    public final static double AUTONOMOUS_TOTE_AND_CONTAINER_DRIVE_TIME      =  0.6;
    public final static double AUTONOMOUS_TOTE_AND_CONTAINER_DRIVE_POWER     =  0.6;
    public final static double AUTONOMOUS_TOTE_AND_CONTAINER_DRIVE_ANGLE     =  0.0;
    
  //***************************************************************************************
    // AUTONOMOUS: Get Container in Autozone
    public final static double AUTONOMOUS_CONTAINER_DRIVE_TIME               =  1.7;
    public final static double AUTONOMOUS_CONTAINER_STEP_DRIVE_TIME          =  1.9;
    public final static double AUTONOMOUS_CONTAINER_DRIVE_POWER              =  0.5;
    public final static double AUTONOMOUS_CONTAINER_DRIVE_ANGLE              =  0.0;

    //***************************************************************************************
    // AUTONOMOUS: Get Container in Autozone
    public final static double AUTONOMOUS_REMOVE_CONTAINER_DRIVE_TIME        =  2.2;
    public final static double AUTONOMOUS_REMOVE_CONTAINER_DRIVE_POWER       =  0.5;
    public final static double AUTONOMOUS_REMOVE_CONTAINER_DRIVE_ANGLE       =  0.0;

    //***************************************************************************************
    // AUTONOMOUS: Move Container to store area and align with loading station
    public final static double AUTONOMOUS_CONTAINER_STORE_TIME               =  1.6; //adjust for battery level
    public final static double AUTONOMOUS_CONTAINER_STORE_POWER              =  0.5;
    public final static double AUTONOMOUS_CONTAINER_STORE_ANGLE              =  0.0;
  
    public final static double AUTONOMOUS_CONTAINER_BACKUP_TIME              =  0.95; //adjust for battery level
    public final static double AUTONOMOUS_CONTAINER_BACKUP_POWER             =  0.5;
    public final static double AUTONOMOUS_CONTAINER_BACKUP_ANGLE             = 180.0;
    
    public final static double AUTONOMOUS_CONTAINER_STATION_TIME             =  0.4; //adjust for battery level
    public final static double AUTONOMOUS_CONTAINER_STATION_POWER            = -0.5;
    public final static double AUTONOMOUS_CONTAINER_STATION_ANGLE            =  0.0; 
}
