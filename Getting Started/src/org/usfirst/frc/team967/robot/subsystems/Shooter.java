package org.usfirst.frc.team967.robot.subsystems;

import org.usfirst.frc.team967.robot.Robot;
import org.usfirst.frc.team967.robot.commands.ClimberRotate;
import org.usfirst.frc.team967.robot.commands.Shoot;
import org.usfirst.frc.team967.robot.commands.ShooterWait;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Shooter extends Subsystem {
    private CANTalon flyWheel;
    private int loops = 0;
    private StringBuilder message;
    
    
    public Shooter(){
    	flyWheel = new CANTalon(5);
    	StringBuilder message = new StringBuilder();
    	
    	flyWheel.changeControlMode(TalonControlMode.Speed);
    	flyWheel.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	flyWheel.configEncoderCodesPerRev(128);
    	flyWheel.reverseSensor(false);
    	flyWheel.configNominalOutputVoltage(+0.0f, -0.0f);
    	flyWheel.configPeakOutputVoltage(+12.0f, -12.0f);
    	
    	flyWheel.setProfile(0);
    	flyWheel.setF(0);
    	flyWheel.setP(.01);
    	flyWheel.setI(.001);
    	flyWheel.setD(0);
    }
    
    public void setFlyWheel(int rpm){
//    	double power;
    	double target = rpm;
//    	double motorOutput = flyWheel.getOutputVoltage() / flyWheel.getBusVoltage();
    	
/*    	message.append("\tout:");
    	message.append(motorOutput);
    	message.append("\tspd:");
    	message.append(flyWheel.getSpeed() );
  */  	
//    	if(Robot.oi.getXbox2().getRawButton(5)){
    		double targetSpeed = target;
    	//	flyWheel.changeControlMode(TalonControlMode.Speed);
    		flyWheel.set(targetSpeed);
    		
    /*		message.append("\terr:");
    		message.append(flyWheel.getClosedLoopError());
    		message.append("\ttrg:");
    		message.append(targetSpeed);
    *///	}
/*    	else{
    		flyWheel.changeControlMode(TalonControlMode.PercentVbus);
    		flyWheel.set(target);
    	}*/
    	
    	if(++ loops >= 10){
    		loops = 0;
    	//	System.out.println(message.toString());
    	}
    	//message.setLength(0);
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void log(){
    	SmartDashboard.getNumber("Fly Wheel Speed", flyWheel.get());
    	SmartDashboard.getNumber("Fly Wheel P", flyWheel.getP());
    	SmartDashboard.getNumber("Fly Wheel I", flyWheel.getI());
    	SmartDashboard.getNumber("Fly Wheel D", flyWheel.getD());
    	SmartDashboard.getNumber("Fly Wheel Setpoint", flyWheel.getSetpoint());
    	SmartDashboard.getNumber("position", flyWheel.getEncPosition());
    	//SmartDashboard.getNumber("Fly Wheel Velocity", flyWheel.getEncVelocity());
//    	SmartDashboard.getNumber("Fly Wheel Speed", flyWheel.get());
//    	SmartDashboard.getNumber("Fly Wheel Speed", flyWheel.get());
    	
    }

    public void initDefaultCommand() {
        setDefaultCommand(new ShooterWait());
    	// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

