package org.usfirst.frc.team6637.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gripper_Subsystem extends Subsystem {

	DoubleSolenoid gripperSolenoid = new DoubleSolenoid(1, 2);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void open() {
    	gripperSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void close() {
    	gripperSolenoid.set(DoubleSolenoid.Value.kReverse);
	 }
}