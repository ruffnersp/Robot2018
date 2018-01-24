	package org.usfirst.frc.team6637.robot.commands;

import org.usfirst.frc.team6637.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Drive_GoStraight_Command extends Command {
	
	public double Kp = -0.035;
	public double inches,power;
	public int toleranceCount;
	
    public Drive_GoStraight_Command(double inchesVar, double powerVar) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveSubsystem);
        requires(Robot.driveTrainEncoders);
    		inches = inchesVar;
    		power = powerVar;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		Robot.gyro.reset();
		Robot.driveTrainEncoders.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		double angle = Robot.gyro.getAngle();
    	
    		//drive forward
    		Robot.driveSubsystem.autonDrive(power, angle*Kp);
    		Timer.delay(0.004);

    		System.out.println(Robot.driveTrainEncoders.getAverageDistance());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(Robot.driveTrainEncoders.getAverageDistance() >= inches) {
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
