package org.usfirst.frc.team6637.robot.commands;

import org.usfirst.frc.team6637.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drive_TurnToAngle_Command extends Command {
	
	double targetAngle, error;
	double kP = .1;

    public Drive_TurnToAngle_Command(double targetAngle) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveSubsystem);
        this.targetAngle = targetAngle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double currentAngle = Robot.driveSubsystem.getAngle();
    	error = Math.IEEEremainder(targetAngle-currentAngle,360.0);
    	//double speed = Math.IEEEremainder(kP*error, 1);
    	double speed = 0.5;
    	Timer.delay(.1);
    	
    	if(error > 0 ) {
    		Robot.driveSubsystem.setPower(-speed, speed);
    	} else {
    		Robot.driveSubsystem.setPower(speed, -speed);
    	}
    	

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Math.abs(error) < 2) {
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
