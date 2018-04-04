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
		// addSequential(new Command2());
		// these will run in order.

		// To run multiple commands at the same time,
		// use addParallel()
		// e.g. addParallel(new Command1());
		// addSequential(new Command2());
		// Command1 and Command2 will run in parallel.

		// A command group will require all of the subsystems that each member
		// would require.
		// e.g. if Command1 requires chassis, and Command2 requires arm,
		// a CommandGroup containing them would require both the chassis and the
		// arm.
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();

		if (gameData.length() > 0) {

			// RIGHT SWITCH IS OURS
			if (gameData.charAt(0) == 'R') {

				// raise elevator
				addSequential(new Elevator_Auton_Raise_Command(24000));

				// drive forward 12 feet minus length of bot and bumpers
				addSequential(new Drive_GoStraight_Command(94.0, 0.75, 36.0));
				// drop cube
				addSequential(new Gripper_Auton_Open_Command());

				// LEFT SWITCH IS OURS
			} else if (gameData.charAt(0) == 'L') {

				// raise elevator
				addSequential(new Elevator_Auton_Raise_Command(24000));

				// drive forward 2 feet
				addSequential(new Drive_GoStraight_Command(24.0, 0.5, 9.0));

				// turn left
				addSequential(new Drive_TurnToAngle_Command(-90.0));

				// drive forward
				addSequential(new Drive_GoStraight_Command(96.0, 0.7, 40.0));

				// turn right
				addSequential(new Drive_TurnToAngle_Command(90.0));

				// drive forward
				addSequential(new Drive_GoStraight_Command(88.0, 0.7, 42.0));

				// drop cube
				addSequential(new Gripper_Auton_Open_Command());

			}
		}
	}
}