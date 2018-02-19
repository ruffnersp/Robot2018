package org.usfirst.frc.team6637.robot.commands;

import org.usfirst.frc.team6637.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Elevator_Lower_Command extends Command {
	
	double pos;

    public Elevator_Lower_Command() {
    	requires(Robot.elevatorSubsystem);
    	requires(Robot.brakeSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.brakeSubsystem.open();
    	Timer.delay(0.1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	pos = Robot.elevatorSubsystem.getEncoderPosition();   	
    	
    	// full speed
    	if(pos > 500) {
    		Robot.elevatorSubsystem.lower(0.05);
    	// slower speed	
    	} else if(pos > 40) {
    		Robot.elevatorSubsystem.lower(-0.05);
    	// stop
    	} else {
        	Robot.elevatorSubsystem.stop();
        	Timer.delay(0.1);
        	Robot.brakeSubsystem.close();    		
    	}	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevatorSubsystem.stop();
    	Timer.delay(0.1);
    	Robot.brakeSubsystem.close();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}