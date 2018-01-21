
package org.usfirst.frc.team6637.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6637.robot.commands.Drive_GoStraight_Command;
import org.usfirst.frc.team6637.robot.subsystems.DriveTrainEncoders_Subsystem;
import org.usfirst.frc.team6637.robot.subsystems.Drive_Subsystem;

public class Robot extends IterativeRobot {
	
	// load all subsystems
	public static final Drive_Subsystem driveSubsystem = new Drive_Subsystem();
	public static final DriveTrainEncoders_Subsystem driveTrainEncoders = new DriveTrainEncoders_Subsystem();
	public static OI oi;
	
	// gyro
	public static ADXRS450_Gyro gyro;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	@Override
	public void robotInit() {
		oi = new OI();
		
		// AUTON CHOOSER SETUP
		chooser.addDefault("Drive Straight 5 feet", new Drive_GoStraight_Command(60.0, 0.4));
		chooser.addObject("Drive Straight 3 feet", new Drive_GoStraight_Command(36.0, 0.4));
		SmartDashboard.putData("Auto mode", chooser);
		
		// Gyro must be instantiated in the robotInit() function
		gyro = new ADXRS450_Gyro();		
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
