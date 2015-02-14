package org.usfirst.frc3824.HolonomicDrive.commands;
import org.usfirst.frc3824.HolonomicDrive.Constants;
import edu.wpi.first.wpilibj.command.CommandGroup;
public class AutonomousStackThreeToteContainer extends CommandGroup
{
	public AutonomousStackThreeToteContainer(){
		ChassisTurnAngle chassisTurn45 = new ChassisTurnAngle(-45.0, 0.0);
		ChassisTurnAngle chassisTurn0 = new ChassisTurnAngle(0.0, 0.0);

		//goes for first tote
		addParallel(new ForkliftMoveToPosition(Constants.FORKLIFT_TOTE0_POSITION));
		addSequential(chassisTurn45);

		//goes for second tote
		addSequential(new ChassisDriveStraight(1.0, 0.5, 45));
		addSequential(chassisTurn0);
		addSequential(new ChassisDriveStraight(1.0, 0.5, 0));
		addSequential(new ForkliftMoveToPosition(Constants.FORKLIFT_TOTEPICKUP_POSITION));
		addSequential(new ForkliftMoveToPosition(Constants.FORKLIFT_TOTE0_POSITION));
		
		//goes for third tote
		addSequential(new ChassisDriveStraight(1.0, 0.5, 0));
		addSequential(new ForkliftMoveToPosition(Constants.FORKLIFT_TOTEPICKUP_POSITION));
		addSequential(new ForkliftMoveToPosition(Constants.FORKLIFT_TOTE0_POSITION));
				
		// takes robot and totes to autozone
		addSequential(new ChassisDriveStraight(2.0, 0.7, 90));
		addSequential(new ForkliftMoveToPosition(Constants.FORKLIFT_TOTEPICKUP_POSITION));
		addSequential(new ChassisDriveStraight(1.0, 0.5, 180));
	}
}
