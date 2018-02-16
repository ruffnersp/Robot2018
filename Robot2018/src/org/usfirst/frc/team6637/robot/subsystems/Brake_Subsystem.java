package org.usfirst.frc.team6637.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Brake_Subsystem extends Subsystem {

	DoubleSolenoid sol;
	public Brake_Subsystem() {
		sol = new DoubleSolenoid(2,3);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new Brake_Open_Command());
    }
    
    public void open() {
    	sol.set(DoubleSolenoid.Value.kForward);
    }
    
    public void close() {
    	sol.set(DoubleSolenoid.Value.kReverse);
    }
}

