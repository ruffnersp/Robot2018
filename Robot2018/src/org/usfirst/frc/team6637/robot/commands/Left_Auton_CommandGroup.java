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
		
		// SWITCH IS OURS
		if(gameData.charAt(0) == 'L'){ 
						
			// raise elevator
			addSequential(new Elevator_Auton_Raise_Command(26000));
			
			// drive forward 14 feet - 168 inches
			addSequential(new Drive_GoStraight_Command(160.0, 0.5, 24.0));
	
			// turn right
			addSequential(new Drive_TurnToAngle_Command(90.0));
			
			// drive forward 1 foot
			addSequential(new Drive_GoStraight_Command(12.0, 0.4, 5.0));
		
			// drop cube
			addSequential(new Gripper_Auton_Open_Command());
			
		// SCALE IS OURS
		} else if (gameData.charAt(1) == 'L') {
			
			// raise elevator
			addSequential(new Elevator_Auton_Raise_Command(26000));
			
			// drive forward 27 feet - 324 inches
			addSequential(new Drive_GoStraight_Command(320.0, 0.5, 24.0));
			
			// turn right
			addSequential(new Drive_TurnToAngle_Command(90.0));
			
			// drive forward 1 foot
			addSequential(new Drive_GoStraight_Command(12.0, 0.35, 5.0));
		
			// drop cube
			addSequential(new Gripper_Auton_Open_Command());

		// NEITHER IS OURS - Go through the alley
		} else {
						
			// raise elevator
			addSequential(new Elevator_Auton_Raise_Command(26000));
			
			// drive forward 20.5 feet - 246 inches
			addSequential(new Drive_GoStraight_Command(246.0, 0.5, 24.0));
			
			// turn right
			addSequential(new Drive_TurnToAngle_Command(90.0));
			
			// drive forward feet x inches
			addSequential(new Drive_GoStraight_Command(100.0, 0.4, 24.0));
			
		}
    }
}