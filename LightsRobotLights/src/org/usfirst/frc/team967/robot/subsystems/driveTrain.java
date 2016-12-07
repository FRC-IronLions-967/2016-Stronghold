package org.usfirst.frc.team967.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team967.robot.Robot;
import org.usfirst.frc.team967.robot.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 *
 */
public class driveTrain extends Subsystem {
    private CANTalon bleft,bright,fleft,fright,tright,tleft;
    private DoubleSolenoid shifter;
    double leftStick;
	double rightStick;
//    private encoder encoder;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public driveTrain() {
    	tright = new CANTalon(36);
    	bleft = new CANTalon(31);
    	fright = new CANTalon(34);
    	bright = new CANTalon(35);
    	fleft = new CANTalon(33);
    	tleft = new CANTalon(30);
    	
    	shifter = new DoubleSolenoid(0,1);
    	
    }
    
    public void move(double left, double right){
    	bleft.set(left);
    	bright.set(-right);
    	fleft.set(left);
    	fright.set(-right);
    	tleft.set(left);
    	tright.set(-right);
    }
    
    public void arcadeDrive1(double xAxis, double yAxis){
    	double deadband = .2;
    	if((yAxis< deadband) && (yAxis > -deadband)){ yAxis=0;}
    	if((xAxis< deadband) && (xAxis > -deadband)){ xAxis=0;}
    	
    	double L = yAxis + xAxis;
    	double R = yAxis - xAxis;
    	double max = Math.abs(L);
    	if(Math.abs(R) > max) max = Math.abs(R);
    	if((Math.abs(yAxis) <= 1) && (Math.abs(xAxis) <= 1) && (max < 1)){
    		move(L,R);
    	}else
    		move(L/max, R/max);
    	SmartDashboard.putNumber("R", R);
    	SmartDashboard.putNumber("L", L);
    	SmartDashboard.putNumber("R/max", R/max);
    	SmartDashboard.putNumber("L/max", L/max);
    }
    
    public void tankDrive(){
    	rightStick = Robot.oi.getXbox1().getRawAxis(5);
    	leftStick = Robot.oi.getXbox1().getRawAxis(1);
    	
    	if (leftStick > -.1 && leftStick < .1){
    		leftStick = 0;
    		
    	}
    	if (rightStick > -.1 && rightStick < .1){
    		rightStick = 0;
    	}
    	bleft.set(leftStick);
    	bright.set(-rightStick);
    	fleft.set(leftStick);
    	fright.set(-rightStick);
    	tleft.set(leftStick);
    	tright.set(-rightStick);
    	//Robot.oi.getXbox1().getAxis(1);
    }
    
    public void shiftDrive(){
    	shifter.set(DoubleSolenoid.Value.kForward);
    	if( shifter.get() == DoubleSolenoid.Value.kForward ){
    		shifter.set(DoubleSolenoid.Value.kReverse);
    		
    	}else{
    		shifter.set(DoubleSolenoid.Value.kForward);
    	}
    	
    	
    }
    
    public void initDefaultCommand() {
    	setDefaultCommand(new arcadeDrive());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

}

