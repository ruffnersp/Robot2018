package org.usfirst.frc.team6637.robot.subsystems;

import org.usfirst.frc.team6637.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drive_Encoder_Subsystem extends Subsystem {

    Encoder LDriveEncoder, RDriveEncoder;
	
	public static final double wheelDiameter = 6;
	public static final double pulsePerRevolution = 360;
	
	public Drive_Encoder_Subsystem() {
		
		// initiate encoders
		LDriveEncoder = new Encoder(RobotMap.LDriveEncoderA, RobotMap.LDriveEncoderB, true, Encoder.EncodingType.k4X);
		RDriveEncoder = new Encoder(RobotMap.RDriveEncoderA, RobotMap.RDriveEncoderB, false, Encoder.EncodingType.k4X);
    	
		LDriveEncoder.setDistancePerPulse(Math.PI * wheelDiameter / pulsePerRevolution); // inches / pulse
    		LDriveEncoder.setMinRate(.1);
    		LDriveEncoder.setSamplesToAverage(7);
    	
    		RDriveEncoder.setDistancePerPulse(Math.PI * wheelDiameter / pulsePerRevolution); // inches / pulse
    		RDriveEncoder.setMinRate(.1);
    		RDriveEncoder.setSamplesToAverage(7);
    	   	
    		resetEncoders();
    	
	}
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
   
    public double getLeftDistance(){
		return LDriveEncoder.getDistance();
    }

    public double getLeftRate(){
		return LDriveEncoder.getRate();	
    }    
    
    public double getRightDistance(){
    		return RDriveEncoder.getDistance();
    }
    
    public double getRightRate(){
    		return RDriveEncoder.getRate();
    }
    
    public double getAverageDistance(){
    		return (getLeftDistance() + getRightDistance()) / 2;
    }
    
    public void resetEncoders(){
    		LDriveEncoder.reset();
    		RDriveEncoder.reset();
    }
}