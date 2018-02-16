package org.usfirst.frc.team6637.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Lower_Elevator_Manual extends CommandGroup {

    public Lower_Elevator_Manual() {
    	addSequential(new Brake_Open_Command());
    	addSequential(new Elevator_Lower_Command());
    	addSequential(new Brake_Close_Command());
    }
}
