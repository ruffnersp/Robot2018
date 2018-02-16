package org.usfirst.frc.team6637.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Raise_Elevator_Manual extends CommandGroup {

    public Raise_Elevator_Manual() {
    	
    	System.out.println("brake starting");
    	addSequential(new Brake_Open_Command());
    	System.out.println("brake done");
    	addSequential(new Elevator_Raise_Command());
    	addSequential(new Brake_Close_Command());
    }
}
