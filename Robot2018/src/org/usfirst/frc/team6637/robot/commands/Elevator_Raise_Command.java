package org.usfirst.frc.team6637.robot.commands;

import org.usfirst.frc.team6637.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Elevator_Raise_Command extends Command {

    public Elevator_Raise_Command() {
    	requires(Robot.elevatorSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevatorSubsystem.raise();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevatorSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
