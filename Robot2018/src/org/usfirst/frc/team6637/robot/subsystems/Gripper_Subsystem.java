package org.usfirst.frc.team6637.robot.subsystems;

//import edu.wpi.first.wpilibj.Compressor;
//import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gripper_Subsystem extends Subsystem {

	
	//Compressor gripperCompressor = //new Compressor();
	//DoubleSolenoid gripperSolenoid = new DoubleSolenoid(0, 1);
	
	public Gripper_Subsystem() {
		//gripperSolenoid.set(DoubleSolenoid.Value.kForward);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void open() {
    	//gripperSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void close() {
    	//gripperSolenoid.set(DoubleSolenoid.Value.kReverse);
	 }
}