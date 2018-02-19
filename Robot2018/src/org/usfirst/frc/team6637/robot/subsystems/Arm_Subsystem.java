package org.usfirst.frc.team6637.robot.subsystems;

import org.usfirst.frc.team6637.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm_Subsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public Spark Arm = new Spark(RobotMap.Arm);
    public static final double armSpeed = 0.25;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void rotateForward() {
    		Arm.set(armSpeed);
    }
    
    public void rotateBack() {
    		Arm.set(-armSpeed);
    }
    
    public void stop() {
    		Arm.set(0.0);
    }
}