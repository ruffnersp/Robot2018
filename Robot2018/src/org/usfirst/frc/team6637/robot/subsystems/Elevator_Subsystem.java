package org.usfirst.frc.team6637.robot.subsystems;

import org.usfirst.frc.team6637.robot.RobotMap;

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
    
    public void raise() {
    	LiftMotor.set(-1.0);
    }
    
    public void lower() {
    	LiftMotor.set(0.05);
    }
    
    public void stop() {
    	LiftMotor.set(0.0);
    }
}
