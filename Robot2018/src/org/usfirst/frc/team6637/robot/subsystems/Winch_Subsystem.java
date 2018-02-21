package org.usfirst.frc.team6637.robot.subsystems;

import org.usfirst.frc.team6637.robot.RobotMap;
import org.usfirst.frc.team6637.robot.commands.Winch_Control_Command;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Winch_Subsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	  public Spark Winch = new Spark(RobotMap.Winch);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Winch_Control_Command());
    }


public void setPower(double power) {
	if (Math.abs(power) < 0.10) {				
		power = 0;
	}
		Winch.set(power);
}

public void stop() {
		Winch.set(0.0);
	}
}

