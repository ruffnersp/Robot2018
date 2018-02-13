
package org.usfirst.frc.team6637.robot;

//import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6637.robot.commands.Center_Auton_CommandGroup;
import org.usfirst.frc.team6637.robot.commands.Drive_GoStraight_Command;
import org.usfirst.frc.team6637.robot.commands.Left_Auton_CommandGroup;
import org.usfirst.frc.team6637.robot.commands.Right_Auton_CommandGroup;
import org.usfirst.frc.team6637.robot.subsystems.DriveTrainEncoders_Subsystem;
import org.usfirst.frc.team6637.robot.subsystems.Drive_Subsystem;
import org.usfirst.frc.team6637.robot.subsystems.Elevator_Subsystem;
import org.usfirst.frc.team6637.robot.subsystems.Gripper_Subsystem;

public class Robot extends IterativeRobot {
	
	// load all subsystems
	public static final Drive_Subsystem driveSubsystem = new Drive_Subsystem();
	public static final DriveTrainEncoders_Subsystem driveTrainEncoders = new DriveTrainEncoders_Subsystem();
	public static final Gripper_Subsystem gripperSubsystem = new Gripper_Subsystem();
	public static final Elevator_Subsystem elevatorSubsystem = new Elevator_Subsystem();
	public static OI oi;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	@Override
	public void robotInit() {
		oi = new OI();
		
		// AUTON CHOOSER SETUP
		//chooser.addDefault("Left Position", new Left_Auton_CommandGroup());
		chooser.addDefault("Left Position", new Drive_GoStraight_Command(168.0));
		chooser.addObject("Center Position", new Center_Auton_CommandGroup());
		chooser.addObject("Right Position", new Right_Auton_CommandGroup());
		SmartDashboard.putData("Auto mode", chooser);	
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
		autonomousCommand = chooser.getSelected();
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
		//LiveWindow.run();
	}
}
