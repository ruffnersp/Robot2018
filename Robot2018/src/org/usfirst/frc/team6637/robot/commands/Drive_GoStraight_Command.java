package org.usfirst.frc.team6637.robot.commands;

import org.usfirst.frc.team6637.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Drive_GoStraight_Command extends Command {
	
	public double Kp = -0.035;
	public double inches,angle,rampDown,power; 
	public double brakePower = 0.4;
	
	// encoders aren't resetting. store the initial distance, subtract from ongoing average distance to get distanceSoFar
	public double initialAverageEncoderValue,distanceSoFar;
	
	public Drive_GoStraight_Command(double inches, double power, double rampDown) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveSubsystem);
    	this.inches = inches;
    	this.power = power;
		this.rampDown = rampDown;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		// initiate encoders
    	Timer.delay(.1);
    	Robot.driveSubsystem.resetEncoders();
    	Robot.driveSubsystem.resetAngle();
    	System.out.println(Robot.driveSubsystem.getLeftPosition());
    	System.out.println(Robot.driveSubsystem.getRightPosition());
    	initialAverageEncoderValue = Robot.driveSubsystem.getAverageDistance();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	angle = Robot.driveSubsystem.getAngle(); 
    	
    	distanceSoFar = Robot.driveSubsystem.getAverageDistance() - initialAverageEncoderValue;

    	if(distanceSoFar < inches - rampDown) {
    		Robot.driveSubsystem.autonDrive(-power, angle*Kp, false);
    	} else if(distanceSoFar > (inches - rampDown) && Robot.driveSubsystem.getAverageDistance() < inches) {
    		Robot.driveSubsystem.autonDrive(-brakePower, angle*Kp, false);
    	} else if(distanceSoFar > inches) {
    		Robot.driveSubsystem.autonDrive(brakePower, -angle*Kp, false);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(distanceSoFar > inches) {
    		return true;
    	}
    	
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Robot.driveSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
