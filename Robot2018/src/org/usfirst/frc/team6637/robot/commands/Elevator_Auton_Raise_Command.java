package org.usfirst.frc.team6637.robot.commands;

import org.usfirst.frc.team6637.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Elevator_Auton_Raise_Command extends Command {
	
	public int targetPosition, pos;

    public Elevator_Auton_Raise_Command(int targetPosition) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.elevatorSubsystem);
        requires(Robot.brakeSubsystem);
        this.targetPosition = targetPosition;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.brakeSubsystem.open();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	pos = Robot.elevatorSubsystem.getEncoderPosition();
    	Robot.elevatorSubsystem.raise(-1.0);
    	Timer.delay(0.1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(pos > targetPosition) {
    		return true;
    	}
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
