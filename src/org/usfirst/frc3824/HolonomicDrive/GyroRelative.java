package org.usfirst.frc3824.HolonomicDrive;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Gyro;

public class GyroRelative extends Gyro {

	public GyroRelative(int channel) {
		super(channel);
		// TODO Auto-generated constructor stub
	}

	public GyroRelative(AnalogInput channel) {
		super(channel);
		// TODO Auto-generated constructor stub
	}

	
	public double getRelative() {
		double absAngle = this.getAngle();
		
		if (absAngle < 0.0) {
			while (absAngle < 0.0) {
				absAngle += 360.0;
			}
		} else if (absAngle >= 360.0) {
			while (absAngle >= 360.0) {
				absAngle -= 360.0;
			}
		}
		
		return absAngle;
	}
}
