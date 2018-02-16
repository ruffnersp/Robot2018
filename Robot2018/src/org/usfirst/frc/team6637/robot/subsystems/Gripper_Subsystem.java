package org.usfirst.frc.team6637.robot.subsystems;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.Compressor;
//import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gripper_Subsystem extends Subsystem {

	DoubleSolenoid gripperSolenoid = new DoubleSolenoid(0, 1);
	DigitalInput limitSwitch;
	Counter counter;
	
	public Gripper_Subsystem() {
		limitSwitch = new DigitalInput(5);
		counter = new Counter(limitSwitch);
		gripperSolenoid.set(DoubleSolenoid.Value.kReverse);
	}

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
    
    // isLimitSet
    public boolean isLimitSet() {
    	return counter.get() > 0;
    }
    
    // resetLimitSwitch
    public void resetCounter() {
        counter.reset();
    }
}