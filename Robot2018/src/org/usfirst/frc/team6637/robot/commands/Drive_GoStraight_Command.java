package org.usfirst.frc.team6637.robot.commands;

import org.usfirst.frc.team6637.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class Drive_GoStraight_Command extends Command {
	
	public double Kp = -0.035;
	public double inches, angle;
	public double targetPos;
	
    public Drive_GoStraight_Command(double inches) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveSubsystem);
        //requires(Robot.driveTrainEncoders);
    	this.inches = inches;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		// initiate encoders
    	Robot.driveSubsystem.resetEncoders();
    	
    	// calculate target position
    	targetPos = Robot.driveSubsystem.inchesToRotations(inches) * 1440;
    	System.out.println(targetPos);
    	
    	//utilize motion magic
    	Robot.driveSubsystem.initMotionMagic();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveSubsystem.runMotionMagic(targetPos);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double error = inches - Robot.driveSubsystem.getLeftPositionInches();
    	if(Math.abs(error) < 2) {
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
