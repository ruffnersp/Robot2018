package org.usfirst.frc.team6637.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Right_Auton_CommandGroup extends CommandGroup {

    public Right_Auton_CommandGroup() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(gameData.charAt(0) == 'R'){ 
			//drive forward x feet
			addSequential(new Drive_GoStraight_Command(168.0, 1.0, 18.0));
	
			// turn left
			addSequential(new Drive_TurnToAngle_Command(-90.0));
			
			// drive forward 3 foot
			addSequential(new Drive_GoStraight_Command(36.0, 0.5, 9.0));
		
			// drop cube
		}else if(gameData.charAt(1) == 'R') {
		//Scale is ours
		}
    }
}