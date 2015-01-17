package org.usfirst.frc3824.HolonomicDrive;

/**
 * Put any important constants here.
 */
public class Constants
{
    /* Contants which might require tuning */
    public final static double DrivetrainAngleGyroControllerP     = 0.04;
    public final static double DrivetrainAngleGyroControllerI     = 0.004;
    public final static double DrivetrainAngleGyroControllerD     = 0.04;

    public final static double DrivetrainAngleGyroControllerTurnP = 0.005;
    public final static double DrivetrainAngleGyroControllerTurnI = 0.00005;
    public final static double DrivetrainAngleGyroControllerTurnD = 0.0004;

    public final static double TURN_THRESHOLD    = 1.5; //works with 1 but is a bit slow    
    
    public final static double AUTONOMOUS_STRAIGHT_DRIVE_TIME                       = 2.0;
    public final static double AUTONOMOUS_STRAIGHT_DRIVER_POWER                     = 1.0;
    public final static double AUTONOMOUS_STRAIGHT_DRIVE_ANGLE                      = 0.0;
}
