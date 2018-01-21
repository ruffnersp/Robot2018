	package org.usfirst.frc.team6637.robot.commands;

import org.usfirst.frc.team6637.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Drive_GoStraight_Command extends Command {
	
	public double Kp = -0.035;
	public double inches,power,brakePower;
	public int toleranceCount;
	
    public Drive_GoStraight_Command(double inchesVar, double powerVar) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveSubsystem);
        requires(Robot.driveTrainEncoders);
    	inches = inchesVar;
    	power = powerVar;
		brakePower = 0.2;
		toleranceCount = 0;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		Robot.gyro.reset();
		Robot.driveTrainEncoders.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double angle = Robot.gyro.getAngle();
    	
    	//drive normal, drive braked, drive in reverse breaked
    	if(Robot.driveTrainEncoders.getAverageDistance() < inches - 18) {
    		Robot.driveSubsystem.autonDrive(-power, -angle*Kp);
    	} else if(Robot.driveTrainEncoders.getAverageDistance() > (inches - 18) && Robot.driveTrainEncoders.getAverageDistance() < inches) {
    		Robot.driveSubsystem.autonDrive(-brakePower, -angle*Kp);
    	} else if(Robot.driveTrainEncoders.getAverageDistance() > inches) {
    		Robot.driveSubsystem.autonDrive(brakePower, angle*Kp);
    	}
    	
    	// if the robot is within 2 inches of goal, start tolerance counter, determines isFinished result
    	if((Robot.driveTrainEncoders.getAverageDistance() + inches) / 2 - inches < 2 && Robot.driveTrainEncoders.getAverageDistance() > inches / 2) {
    		toleranceCount++;
    	} else {
    		toleranceCount = 0;
    	}
    	
		Timer.delay(0.004);
		//System.out.println(Robot.driveTrainEncoders.getAverageDistance());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(toleranceCount == 100) {
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
