package org.usfirst.frc3824.HolonomicDrive;

public class Constants
{
    /* Contants which might require tuning */
    public final static double DrivetrainAngleGyroControllerP     = 0.04;	//.04;	John Young's nums
    public final static double DrivetrainAngleGyroControllerI     = 0.004;  // 0.004;
    public final static double DrivetrainAngleGyroControllerD     = 0.04;  //0.04;

    public final static double DrivetrainAngleGyroControllerTurnP = 0.005;
    public final static double DrivetrainAngleGyroControllerTurnI = 0.00005;
    public final static double DrivetrainAngleGyroControllerTurnD = 0.0004;

    public final static double TURN_THRESHOLD                     = 10.0; //works with 1 but is a bit slow;    was 1.5
    
    public final static double AUTONOMOUS_STRAIGHT_DRIVE_TIME     = 1.0;
    public final static double AUTONOMOUS_STRAIGHT_DRIVER_POWER   = 0.5;
    public final static double AUTONOMOUS_STRAIGHT_DRIVE_ANGLE    = 0.0;
    
    public final static double FORKLIFT_TOTE0_POSITION            = 0.1;
    public final static double FORKLIFT_TOTE1_POSITION            = 0.2;
}
