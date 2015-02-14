package org.usfirst.frc3824.HolonomicDrive.commands;
import org.usfirst.frc3824.HolonomicDrive.Constants;
import edu.wpi.first.wpilibj.command.CommandGroup;
public class AutonomousDragToteRight.java extends CommandGroup
{
	public AutonomousDragToteRight(){
    	addParallel(new ForkliftMoveToPosition(Constants.FORKLIFT_TOTE1_POSITION));
	addSequential(new ChassisDriveStraight(2.5, 0.5, -90));
	addSequential(new ForkliftMoveToPosition(Constants.FORKLIFT_TOTEPICKUP_POSITION));
	addSequential(new ChassisDriveStraight(1.0, 0.5, 180));
	}
}
