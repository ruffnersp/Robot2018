package org.usfirst.frc.team6637.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// PWM
	public static final int RFVictor = 0;
	public static final int RRVictor = 1;	
	public static final int LRVictor = 2;
	public static final int LFVictor = 3;
	
	// DriveStation
	public static final int Joystick = 0;
	
	// DIO
	public static final int LDriveEncoderA = 0;
	public static final int LDriveEncoderB = 1;
	public static final int RDriveEncoderA = 2;
	public static final int RDriveEncoderB = 3;
	
}
