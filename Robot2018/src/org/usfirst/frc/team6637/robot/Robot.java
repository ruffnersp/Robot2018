
package org.usfirst.frc.team6637.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6637.robot.commands.Center_Auton_CommandGroup;
import org.usfirst.frc.team6637.robot.commands.Left_Auton_CommandGroup;
import org.usfirst.frc.team6637.robot.commands.Left_Scale_CommandGroup;
import org.usfirst.frc.team6637.robot.commands.Right_Auton_CommandGroup;
import org.usfirst.frc.team6637.robot.commands.Right_Scale_CommandGroup;
import org.usfirst.frc.team6637.robot.subsystems.Arm_Encoder_Subsystem;
import org.usfirst.frc.team6637.robot.subsystems.Arm_Subsystem;
import org.usfirst.frc.team6637.robot.subsystems.Brake_Subsystem;
import org.usfirst.frc.team6637.robot.subsystems.Drive_Subsystem;
import org.usfirst.frc.team6637.robot.subsystems.Drive_Encoder_Subsystem;
import org.usfirst.frc.team6637.robot.subsystems.Elevator_Subsystem;
import org.usfirst.frc.team6637.robot.subsystems.Gripper_Subsystem;
import org.usfirst.frc.team6637.robot.subsystems.Winch_Subsystem;

public class Robot extends IterativeRobot {

	// load all subsystems
	public static final Drive_Subsystem driveSubsystem = new Drive_Subsystem();
	public static final Drive_Encoder_Subsystem driveEncoderSubsystem = new Drive_Encoder_Subsystem();
	public static final Gripper_Subsystem gripperSubsystem = new Gripper_Subsystem();
	public static final Elevator_Subsystem elevatorSubsystem = new Elevator_Subsystem();
	public static final Brake_Subsystem brakeSubsystem = new Brake_Subsystem();
	public static final Arm_Subsystem armSubsystem = new Arm_Subsystem();
	public static final Arm_Encoder_Subsystem armEncoderSubsystem = new Arm_Encoder_Subsystem();
	public static final Winch_Subsystem winchsubsystem = new Winch_Subsystem();
	public static OI oi;

	Command autonomousCommand;
	SendableChooser<String> chooser = new SendableChooser<>();

	@Override
	public void robotInit() {
		oi = new OI();

		// AUTON CHOOSER SETUP
		chooser.addDefault("Left Position", "Left");
		chooser.addObject("Left - Scale Preferred", "LeftScale");
		chooser.addObject("Center Position", "Center");
		chooser.addObject("Right Position", "Right");
		chooser.addObject("Right - Scale Preferred", "RightScale");
		SmartDashboard.putData("Auto mode", chooser);

		CameraServer.getInstance().startAutomaticCapture();
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		String command = chooser.getSelected();
		if (command.equals("Left")) {
			autonomousCommand = new Left_Auton_CommandGroup();
		} else if (command.equals("LeftScale")) {
			autonomousCommand = new Left_Scale_CommandGroup();
		} else if (command.equals("Center")) {
			autonomousCommand = new Center_Auton_CommandGroup();
		} else if (command.equals("Right")) {
			autonomousCommand = new Right_Auton_CommandGroup();
		} else if (command.equals("RightScale")) {
			autonomousCommand = new Right_Scale_CommandGroup();
		}
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
		// LiveWindow.run();
	}
}
