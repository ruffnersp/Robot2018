package org.usfirst.frc.team6637.robot.commands;

import org.usfirst.frc.team6637.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Elevator_Raise_Command extends Command {
	
	double pos, trigger;

    public Elevator_Raise_Command() {
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
    	//trigger = Robot.oi.rightTrigger.get();
    	
    	// full speed
    	if(pos < 40000 ) {
    		Robot.elevatorSubsystem.raise(-1.0);
    	// slower speed	
    	} else if(pos < 56400) {
    		Robot.elevatorSubsystem.raise(-0.8);
    	// stop
    	} else {
        	Robot.brakeSubsystem.close();
        	Timer.delay(0.1);
        	Robot.elevatorSubsystem.stop();
        	   		
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
