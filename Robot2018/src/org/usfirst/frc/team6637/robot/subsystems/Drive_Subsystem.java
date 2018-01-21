package org.usfirst.frc.team6637.robot.subsystems;

import org.usfirst.frc.team6637.robot.RobotMap;
import org.usfirst.frc.team6637.robot.commands.Drive_Arcade_Command;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Drive_Subsystem extends Subsystem {

		private Victor VLeftFront, VLeftRear, VRightFront, VRightRear;
		private DifferentialDrive drive;
		
		public Drive_Subsystem() {
			  			
		    VLeftFront = new Victor(RobotMap.LFVictor);
		    VLeftRear = new Victor(RobotMap.LRVictor);
		    SpeedControllerGroup m_left = new SpeedControllerGroup(VLeftFront, VLeftRear);
		    
			VRightFront = new Victor(RobotMap.RFVictor);
			VRightRear = new Victor(RobotMap.RRVictor);
			SpeedControllerGroup m_right = new SpeedControllerGroup(VRightFront, VRightRear);
			
			drive = new DifferentialDrive(m_left, m_right);
		}
		
		public void initDefaultCommand() {
	        // Set the default command for a subsystem here.
	        setDefaultCommand(new Drive_Arcade_Command());
	    }
		
		public void autonDrive(double move, double turn) {
			drive.arcadeDrive(-move, turn);
		}
		
		public void teleopDrive(double move, double turn) {
			drive.arcadeDrive(-move, turn);
		}
		
		public void setPower(double leftPower, double rightPower) {
			drive.tankDrive(leftPower, rightPower);
		}
		
		public void stop() {
			drive.tankDrive(0.0, 0.0);
		}
		
	}