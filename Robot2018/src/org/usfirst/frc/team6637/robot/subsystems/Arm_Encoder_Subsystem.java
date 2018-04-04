package org.usfirst.frc.team6637.robot.subsystems;

import org.usfirst.frc.team6637.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm_Encoder_Subsystem extends Subsystem {

	Encoder ArmEncoder;
	public char[] getDistance;

	public Arm_Encoder_Subsystem() {

		ArmEncoder = new Encoder(RobotMap.ArmEncoderA, RobotMap.ArmEncoderB, true, Encoder.EncodingType.k4X);

		resetEncoders();
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public double getDistance() {
		return -ArmEncoder.getDistance();
	}

	public void resetEncoders() {
		ArmEncoder.reset();
	}
}
