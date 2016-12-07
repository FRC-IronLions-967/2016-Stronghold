package org.usfirst.frc.team967.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;

/**
 *
 */
public class Shooter extends Subsystem {
    CANTalon motor; 
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public Shooter() {
    	motor = new CANTalon(5);
    	motor.changeControlMode(TalonControlMode.Speed);
    	motor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	motor.reverseSensor(false);
    	motor.configEncoderCodesPerRev(12);//Needs to be checked with sensors. 
    	motor.configNominalOutputVoltage(+0.0f, -0.0f);
    	motor.configPeakOutputVoltage(+12.0f, -12.0f);
    	motor.setProfile(0);
    	motor.setP(0);
    	motor.setI(0);
    	motor.setD(0);
    	motor.setF(0);// www.chiefdelphi.com/forums/showthread.php?t=142381
    }
    
    
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

