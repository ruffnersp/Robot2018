package org.usfirst.frc.team6637.robot.subsystems;

import org.usfirst.frc.team6637.robot.RobotMap;
import org.usfirst.frc.team6637.robot.commands.Drive_Arcade_Command;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.sensors.PigeonIMU;

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
		WPI_VictorSPX LRMotor = new WPI_VictorSPX(RobotMap.LRVictor);
		WPI_TalonSRX RRMotor = new WPI_TalonSRX(RobotMap.RRTalon);
		
	    DifferentialDrive drive = new DifferentialDrive(LFMotor, RFMotor);
	    
	    public static PigeonIMU gyro;

	    public Drive_Subsystem() {
	    		
	    	// point slaves to masters
	    	LRMotor.follow(LFMotor);
	    	RRMotor.follow(RFMotor);
	    		
	    	// invert if necessary, otherwise delete
	    	LFMotor.setInverted(true);
	    	RFMotor.setInverted(true);
	    	LRMotor.setInverted(true);	    		
	    	RRMotor.setInverted(true);
	    	
	    	// initiate gyro
	    	gyro = new PigeonIMU(RRMotor);
	    	
	    	initEncoders();

	    }
		
		public void initDefaultCommand() {
	        // Set the default command for a subsystem here.
	        setDefaultCommand(new Drive_Arcade_Command()); 
	    }
		
		public void autonDrive(double move, double turn, boolean isTurning) {
			drive.arcadeDrive(move, -turn, isTurning);
		}
		
		public void teleopDrive(double move, double turn) {

			if (Math.abs(move) < 0.10) {				
				move = 0;
			}
			if (Math.abs(turn) < 0.10) {
				turn = 0;
			}
			
			drive.arcadeDrive(move, -turn);
		}
		
		public void setPower(double leftPower, double rightPower) {
			drive.tankDrive(leftPower, rightPower);
		}
		
		public void stop() {
			drive.tankDrive(0.0, 0.0);
		}
		
	    public double getAngle() {
	    	double [] ypr = new double[3];
	    	gyro.getYawPitchRoll(ypr);
	    	double angle = ypr[0];
	    	System.out.println(angle);
	    	return angle;
	    }
	    
	    // CONTROL MODE
	    
	    public void initMotionMagic() {
	    	
	    	/*
	    	 * Which PID slot to pull gains from. Starting 2018, you can choose from
	    	 * 0,1,2 or 3. Only the first two (0,1) are visible in web-based
	    	 * configuration.
	    	 */
	    	int kSlotIdx = 0;
	    	/*
	    	 * Talon SRX/ Victor SPX will supported multiple (cascaded) PID loops. For
	    	 * now we just want the primary one.
	    	 */
	    	int kPIDLoopIdx = 0;
	    	/*
	    	 * set to zero to skip waiting for confirmation, set to nonzero to wait and
	    	 * report to DS if action fails.
	    	 */
	    	int kTimeoutMs = 10;
	    	
	    	

			/* Set relevant frame periods to be at least as fast as periodic rate */
	    	LFMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, kTimeoutMs);
	    	LFMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, kTimeoutMs);
			/* set the peak and nominal outputs */
	    	LFMotor.configNominalOutputForward(0, kTimeoutMs);
	    	LFMotor.configNominalOutputReverse(0, kTimeoutMs);
	    	LFMotor.configPeakOutputForward(1, kTimeoutMs);
	    	LFMotor.configPeakOutputReverse(-1, kTimeoutMs);
	    	/* set closed loop gains in slot0 - see documentation */
	    	LFMotor.selectProfileSlot(kSlotIdx, kPIDLoopIdx);
	    	LFMotor.config_kF(0, 20, kTimeoutMs);
	    	LFMotor.config_kP(0, 0, kTimeoutMs);
	    	LFMotor.config_kI(0, 0, kTimeoutMs);
	    	LFMotor.config_kD(0, 0, kTimeoutMs);
	    	/* set acceleration and vcruise velocity - see documentation */
	    	//changed both from 503
	    	LFMotor.configMotionCruiseVelocity(600, kTimeoutMs);
	    	LFMotor.configMotionAcceleration(400, kTimeoutMs);
		    
			/* Set relevant frame periods to be at least as fast as periodic rate */
	    	RFMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, kTimeoutMs);
	    	RFMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, kTimeoutMs);
			/* set the peak and nominal outputs */
	    	RFMotor.configNominalOutputForward(0, kTimeoutMs);
	    	RFMotor.configNominalOutputReverse(0, kTimeoutMs);
	    	RFMotor.configPeakOutputForward(1, kTimeoutMs);
	    	RFMotor.configPeakOutputReverse(-1, kTimeoutMs);
	    	/* set closed loop gains in slot0 - see documentation */
	    	RFMotor.selectProfileSlot(kSlotIdx, kPIDLoopIdx);
	    	RFMotor.config_kF(0, 20, kTimeoutMs);
	    	RFMotor.config_kP(0, 0, kTimeoutMs);
	    	RFMotor.config_kI(0, 0, kTimeoutMs);
	    	RFMotor.config_kD(0, 0, kTimeoutMs);
	    	/* set acceleration and vcruise velocity - see documentation */
	    	RFMotor.configMotionCruiseVelocity(600, kTimeoutMs);
	    	RFMotor.configMotionAcceleration(400, kTimeoutMs);	    	
	    	 
	    }
	    
	    public void runMotionMagic(double targetPos) {
	    	LFMotor.set(ControlMode.MotionMagic, -targetPos);
	    	RFMotor.set(ControlMode.MotionMagic, targetPos);
	    	
	    }
	    
	    public void initPercentVBus() {
	    	
	    }
	    
	    // ENCODERS
	    
	    public void initEncoders() {
			LFMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
			RFMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
			
			LFMotor.setSensorPhase(true);
			RFMotor.setSensorPhase(true);
			
			resetEncoders();
		}
	    
	    public void resetEncoders() {
	    	LFMotor.setSelectedSensorPosition(0, 0, 10);
	    	RFMotor.setSelectedSensorPosition(0, 0, 10);
	    }
	    
	    public int getLeftPosition() {
	    	int pos = LFMotor.getSensorCollection().getQuadraturePosition();
	    	return pos;    
	    }
	    
	    public int getRightPosition() {
	    	int pos = RFMotor.getSensorCollection().getQuadraturePosition();
	    	return pos;    
	    }
	    
	    public double getLeftPositionInches() {
			double rotations = ((double) getLeftPosition()) / (4 * 360);
			
			return rotationsToInches(rotations);
		}
		
		public double getRightPositionInches() {
			double rotations = ((double) getRightPosition()) / (4 * 360);
			
			return rotationsToInches(rotations);
		}
		
		public double rotationsToInches(double rotations) {
			return rotations * (Math.PI * 6);
		}
		
		public double inchesToRotations(double inches) {
			return inches / (Math.PI * 6);
		}
	}