package org.usfirst.frc.team6637.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Center_Auton_CommandGroup extends CommandGroup {

    public Center_Auton_CommandGroup() {
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
		if(gameData.charAt(0) == 'L'){
			
			addSequential(new Drive_GoStraight_Command(15.0)); 
		
		} else if(gameData.charAt(1) == 'L') {
			
			//Scale is ours
			
		}
		
    }
}