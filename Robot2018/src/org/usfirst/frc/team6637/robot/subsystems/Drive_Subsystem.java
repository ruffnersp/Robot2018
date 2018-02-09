package org.usfirst.frc.team6637.robot.subsystems;

import org.usfirst.frc.team6637.robot.RobotMap;
import org.usfirst.frc.team6637.robot.commands.Drive_Arcade_Command;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Drive_Subsystem extends Subsystem {

		// motors for driving
		WPI_TalonSRX LFMotor = new WPI_TalonSRX(RobotMap.LFTalon);
		WPI_TalonSRX RFMotor = new WPI_TalonSRX(RobotMap.RFTalon);
	    
	    // slaves
		WPI_VictorSPX LRMotor = new WPI_VictorSPX(RobotMap.LRTalon);
		WPI_TalonSRX RRMotor = new WPI_TalonSRX(RobotMap.RRTalon);
		
	    DifferentialDrive drive = new DifferentialDrive(LFMotor, RFMotor);

	    public Drive_Subsystem() {
	    		
	    		// point slaves to masters
	    		LRMotor.follow(LFMotor);
	    		RRMotor.follow(RFMotor);
	    		
	    		// invert if necessary, otherwise delete
	    		LFMotor.setInverted(false);
	    		RFMotor.setInverted(false);
	    		LRMotor.setInverted(false);	    		
	    		RRMotor.setInverted(false);

	    }
		
		public void initDefaultCommand() {
	        // Set the default command for a subsystem here.
	        setDefaultCommand(new Drive_Arcade_Command()); 
	    }
		
		public void autonDrive(double move, double turn) {
			drive.arcadeDrive(move, -turn);
		}
		
		public void teleopDrive(double move, double turn) {

			if (Math.abs(move) < 0.10) {
				
				move = 0;
			}
			if (Math.abs(turn) < 0.10) {
				
				turn = 0;
			}
			
			drive.arcadeDrive(-move, -turn);
		}
		
		public void setPower(double leftPower, double rightPower) {
			drive.tankDrive(leftPower, rightPower);
		}
		
		public void stop() {
			drive.tankDrive(0.0, 0.0);
		}
		
	}