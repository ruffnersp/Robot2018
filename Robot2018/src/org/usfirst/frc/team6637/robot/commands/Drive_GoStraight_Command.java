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
    	Robot.driveSubsystem.resetEncoders();
    	Timer.delay(0.1);
    	Robot.driveSubsystem.resetAngle();
    	Timer.delay(0.1);
    	//initialAverageEncoderValue = Robot.driveSubsystem.getAverageDistance();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	angle = Robot.driveSubsystem.getAngle(); 
    	
    	//distanceSoFar = Math.abs(Robot.driveSubsystem.getAverageDistance() - initialAverageEncoderValue);
    	System.out.println("average, encoderaverage");
    	System.out.println(Robot.driveSubsystem.getAverageDistance());
    	//System.out.println(initialAverageEncoderValue);
    	if(Robot.driveSubsystem.getAverageDistance() < inches - rampDown) {
    		Robot.driveSubsystem.autonDrive(-power, angle*Kp, false);
    	} else if(Robot.driveSubsystem.getAverageDistance() > (inches - rampDown) && Robot.driveSubsystem.getAverageDistance() < inches) {
    		Robot.driveSubsystem.autonDrive(-brakePower, angle*Kp, false);
    	} else if(Robot.driveSubsystem.getAverageDistance() > inches) {
    		Robot.driveSubsystem.autonDrive(brakePower, -angle*Kp, false);
    	}
    	//System.out.println(distanceSoFar);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.driveSubsystem.getAverageDistance() > inches) {
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
