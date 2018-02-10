package org.usfirst.frc.team6637.robot;

import org.usfirst.frc.team6637.robot.commands.Elevator_Lower_Command;
import org.usfirst.frc.team6637.robot.commands.Elevator_Raise_Command;
import org.usfirst.frc.team6637.robot.commands.Gripper_Close_Command;
import org.usfirst.frc.team6637.robot.commands.Gripper_Open_Command;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);
	

	public Joystick joystick = new Joystick(RobotMap.Joystick);
    public Button lowerLift = new JoystickButton(joystick, 5);
    public Button raiseLift = new JoystickButton(joystick, 6);
    public Button openGripper = new JoystickButton(joystick, 1);
    public Button closeGripper = new JoystickButton(joystick, 2);
	
	public OI() {
   		//joystick.setDeadband(0.2);
		
		lowerLift.whileHeld(new Elevator_Lower_Command());
		raiseLift.whileHeld(new Elevator_Raise_Command());
		openGripper.whenPressed(new Gripper_Open_Command());
		closeGripper.whenPressed(new Gripper_Close_Command());
		
	}

}