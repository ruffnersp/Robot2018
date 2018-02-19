package org.usfirst.frc.team6637.robot.commands;

import org.usfirst.frc.team6637.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Drive_Arcade_Command extends Command {

    public Drive_Arcade_Command() {
        requires(Robot.driveSubsystem);
        
        // test encoder and mm
       // Robot.driveSubsystem.initMotionMagic();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() { 
    		double move = Robot.oi.driveStick.getY();
    		double turn = Robot.oi.driveStick.getX();
    		if(Robot.oi.joystick.getRawAxis(3) > 0) {
    			move = -move;
    			turn = -turn;
    		}
    		Robot.driveSubsystem.teleopDrive(move, turn);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
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
