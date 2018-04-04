package org.usfirst.frc.team6637.robot.subsystems;

import org.usfirst.frc.team6637.robot.Robot;
import org.usfirst.frc.team6637.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm_Subsystem extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public Spark Arm = new Spark(RobotMap.Arm);
	public static double armSpeed = 1.0;
	public double threshold = 13;

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void rotateForward() {

		// if encoder distance is greater than X, slow the speed
		System.out.println(Robot.armEncoderSubsystem.getDistance());
		Timer.delay(0.004);
		if (Robot.armEncoderSubsystem.getDistance() > threshold) {
			armSpeed = 0.25;
		} else {
			armSpeed = 0.55;
		}

		Arm.set(armSpeed);
	}

	public void rotateBack() {
		armSpeed = 0.4;
		Arm.set(-armSpeed);
	}

	public void stop() {
		Arm.set(0.0);
	}
}