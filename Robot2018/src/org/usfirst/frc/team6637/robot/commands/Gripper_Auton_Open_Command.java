package org.usfirst.frc.team6637.robot.commands;

import org.usfirst.frc.team6637.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Gripper_Auton_Open_Command extends Command {

    public Gripper_Auton_Open_Command() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.gripperSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gripperSubsystem.open();
    	Timer.delay(.1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
