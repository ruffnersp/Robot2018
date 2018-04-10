package org.usfirst.frc.team6637.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Left_Scale_CommandGroup extends CommandGroup {

	public Left_Scale_CommandGroup() {

		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();

		if (gameData.length() > 0) {

			// SCALE IS OURS
		if (gameData.charAt(1) == 'L') {
				
				System.out.println("running scale");

				// drive forward 27 feet - 324 inches
				addSequential(new Drive_GoStraight_Command(204.0, 0.75, 24.0));

				// raise elevator
				addSequential(new Elevator_Auton_Raise_Command(55300));

				// turn right
				addSequential(new Drive_TurnToAngle_Command(90.0));

				// drive forward 1 foot
				addSequential(new Drive_GoStraight_Command(18.0, 0.35, 11.0));

				// drop cube
				addSequential(new Gripper_Auton_Open_Command());

				// SWITCH IS OURS
			} else if (gameData.charAt(0) == 'L') {

				// raise elevator
				addParallel(new Elevator_Auton_Raise_Command(25000));

				// drive forward 14 feet - 168 inches
				addSequential(new Drive_GoStraight_Command(130.0, 0.75, 24.0));

				// turn right
				addSequential(new Drive_TurnToAngle_Command(90.0));

				// drive forward 2 foot
				addSequential(new Drive_GoStraight_Command(32.0, 0.6, 11.0));

				// drop cube
				addSequential(new Gripper_Auton_Open_Command());

				// NEITHER IS OURS - Go through the alley
			} else {

				// raise elevator
				addSequential(new Elevator_Auton_Raise_Command(10000));

				// drive forward 20.5 feet - 246 inches
				addSequential(new Drive_GoStraight_Command(228.0, 0.6, 24.0));

				// turn right
				addSequential(new Drive_TurnToAngle_Command(90.0));

			}
		}

	}
}
