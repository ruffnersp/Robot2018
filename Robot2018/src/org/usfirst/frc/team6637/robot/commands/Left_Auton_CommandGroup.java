package org.usfirst.frc.team6637.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Left_Auton_CommandGroup extends CommandGroup {

    public Left_Auton_CommandGroup() {
    	
    	String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(gameData.charAt(0) == 'L'){ 
			// lift cube
			//addSequential(new Elevator_Auton_Raise_Command(26000));
			
			//drive forward x feet
			addSequential(new Drive_GoStraight_Command(168.0, 0.6, 10.0));
			
			// turn right
			addSequential(new Drive_TurnToAngle_Command(90.0));
			
			// drive forward 3 foot
			addSequential(new Drive_GoStraight_Command(48.0, 0.5, 9.0));
		
			// drop cube
			//addSequential(new Gripper_Auton_Open_Command());
			
		}else if(gameData.charAt(1) == 'L') {
			
			// lift cube
			//addSequential(new Elevator_Auton_Raise_Command(26000));
			
			//drive forward x feet
			addSequential(new Drive_GoStraight_Command(250.0, 0.6, 10.0));
			
			// turn right
			addSequential(new Drive_TurnToAngle_Command(90.0));
			
			// drive forward 3 foot
			addSequential(new Drive_GoStraight_Command(48.0, 0.5, 9.0));
		
			// drop cube
			//addSequential(new Gripper_Auton_Open_Command());
			
		//Scale is ours
		}
    }
}