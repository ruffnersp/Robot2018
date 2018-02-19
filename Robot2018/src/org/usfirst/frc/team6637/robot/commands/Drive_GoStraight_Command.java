package org.usfirst.frc.team6637.robot.commands;

import org.usfirst.frc.team6637.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class Drive_GoStraight_Command extends Command {
	
	public double Kp = -0.035;
	public double inches,angle,brakePower,rampDown,power;
	public double targetPos;
	public int toleranceCount; 
	
	public Drive_GoStraight_Command(double inchesVar, double powerVar, double rampDownVar) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveSubsystem);
    	inches = inchesVar;
    	power = powerVar;
		brakePower = 0.2;
		toleranceCount = 0;
		rampDown = rampDownVar;
		
    //public Drive_GoStraight_Command(double inches) {
        // Use requires() here to declare subsystem dependencies
        //requires(Robot.driveSubsystem);
        //requires(Robot.driveTrainEncoders);
    	//this.inches = inches;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		// initiate encoders
    	Robot.driveSubsystem.resetEncoders();
    	//Robot.driveSubsystem.resetAngle();
    	
    	
    	// calculate target position
    	//targetPos = Robot.driveSubsystem.inchesToRotations(inches) * 1440;
    	//System.out.println(targetPos);
    	
    	//utilize motion magic
    	//Robot.driveSubsystem.initMotionMagic();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.driveSubsystem.runMotionMagic(targetPos);
    	angle = Robot.driveSubsystem.getAngle(); 
    	System.out.println(angle);
    	
    	System.out.println(Robot.driveSubsystem.getAverageDistance());
    	System.out.println(Robot.driveSubsystem.getLeftPositionInches());
    	System.out.println(Robot.driveSubsystem.getRightPositionInches());
    	if(Robot.driveSubsystem.getAverageDistance() < inches - rampDown) {
    		Robot.driveSubsystem.autonDrive(-power, angle*Kp, false);
    	} else if(Robot.driveSubsystem.getAverageDistance() > (inches - rampDown) && Robot.driveSubsystem.getAverageDistance() < inches) {
    		Robot.driveSubsystem.autonDrive(-brakePower, angle*Kp, false);
    	} else if(Robot.driveSubsystem.getAverageDistance() > inches) {
    		Robot.driveSubsystem.autonDrive(brakePower, -angle*Kp, false);
    	}
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
