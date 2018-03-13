package org.usfirst.frc.team6637.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// PWM
	public static final int Winch = 0;
	public static final int Arm = 1;
	public static final int LEDStrip = 2;
	
	// CAN
	public static final int LFTalon = 1;	
	public static final int LRVictor = 2;
	public static final int RFTalon = 3;
	public static final int RRTalon = 4;
	public static final int LiftTalon = 5;
	
	// DriveStation
	public static final int Joystick = 0;
	
	// DIO
	public static final int GripperLimitSwitch = 0;

	public static final int LDriveEncoderA = 2;
	public static final int LDriveEncoderB = 3;
	public static final int RDriveEncoderA = 4;
	public static final int RDriveEncoderB = 5;
	
}
