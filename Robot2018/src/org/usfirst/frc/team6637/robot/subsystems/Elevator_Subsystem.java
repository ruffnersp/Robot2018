package org.usfirst.frc.team6637.robot.subsystems;

import org.usfirst.frc.team6637.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class Elevator_Subsystem extends PIDSubsystem {
	
	public WPI_TalonSRX LiftMotor = new WPI_TalonSRX(RobotMap.LiftTalon);
	public static final double speed = 0.5;

    // Initialize your subsystem here
    public Elevator_Subsystem() {
    	super("Elevator Subsystem", 0.0, 0.0, 0.0);
    	
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }

    protected void initialize(){
    	initEncoder();  
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return 0.0;
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
    
    public void raise(double power) {
    	LiftMotor.set(power);
    }
    
    public void lower(double power) {
    	LiftMotor.set(power);
    }
    
    public void stop() {
    	LiftMotor.set(0.0);
    }
    
    public void initEncoder() {
    	LiftMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);	
    	LiftMotor.setSensorPhase(false);
		resetEncoder();
	}
    public void resetEncoder() {
    	LiftMotor.setSelectedSensorPosition(0, 0, 10);
    }
    
    public int getEncoderPosition() {
    	int pos = LiftMotor.getSensorCollection().getQuadraturePosition();
    	return pos;    
    }
}
