package org.usfirst.frc.team6637.robot.commands;

import org.usfirst.frc.team6637.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Drive_GoStraight_Command extends Command {
	
	public double Kp = -0.035;
	public double inches,angle,rampDown,power; 
	public double brakePower = 0.4;
	public int toleranceCount = 0;
	
	// encoders aren't resetting. store the initial distance, subtract from ongoing average distance to get distanceSoFar
	public double initialAverageEncoderValue,distanceSoFar;
	
	public Drive_GoStraight_Command(double inches, double power, double rampDown) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveSubsystem);
        requires(Robot.driveEncoderSubsystem);
    		this.inches = inches;
    		this.power = power;
		this.rampDown = rampDown;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		// initiate gyro and encoders
    		Robot.driveSubsystem.resetAngle();
    		Robot.driveEncoderSubsystem.resetEncoders();    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		angle = Robot.driveSubsystem.getAngle();
    	System.out.println(Robot.driveEncoderSubsystem.getLeftDistance());
    	System.out.println(Robot.driveEncoderSubsystem.getRightDistance());
    		
    		//drive normal, drive braked, drive in reverse breaked
    		Timer.delay(0.004);
    		if(Robot.driveEncoderSubsystem.getAverageDistance() < inches - rampDown) {
    			Robot.driveSubsystem.autonDrive(-power, angle*Kp, false);
    		} else if(Robot.driveEncoderSubsystem.getAverageDistance() > (inches - rampDown) && Robot.driveEncoderSubsystem.getAverageDistance() < inches) {
    			Robot.driveSubsystem.autonDrive(-brakePower, angle*Kp, false);
    		} else if(Robot.driveEncoderSubsystem.getAverageDistance() > inches) {
    			Robot.driveSubsystem.autonDrive(brakePower, -angle*Kp, false);
    		}        	
        	
    		// if the robot is within 2 inches of goal, start tolerance counter, determines isFinished result
        	if((Robot.driveEncoderSubsystem.getAverageDistance() + inches) / 2 - inches < 2 && Robot.driveEncoderSubsystem.getAverageDistance() > inches / 2) {
        		toleranceCount++;
        	} else {
        		toleranceCount = 0;
        	}
        	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(toleranceCount == 50) {
        	return true;
        }
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.driveSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    		end();
    }
}
