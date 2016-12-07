package org.usfirst.frc.team967.robot;

import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.*;

public class Robot extends SampleRobot {
	
    // Tell the program what objects will exist
	RobotDrive myRobot;  // class that handles basic drive operations
    Joystick leftStick;  // set to ID 1 in DriverStation
    Joystick rightStick; // set to ID 2 in DriverStation
    CANTalon motor;
    
    public Robot() {
   //     myRobot = new RobotDrive(0, 1);
   //     myRobot.setExpiration(0.1);
      //***Give the joysticks a name
        leftStick = new Joystick(1);
        rightStick = new Joystick(5);
        motor.set(.5);
    }
    
    /**
     * Runs the motors with tank steering.
     */
    public void operatorControl() {
    	while (isOperatorControl() && isEnabled()) {
    //	motor.set(leftStick.getRawAxis(1));
    	Timer.delay(.005);
    	}
    	/*     myRobot.setSafetyEnabled(true);
        while (isOperatorControl() && isEnabled()) {
        	myRobot.tankDrive(leftStick, rightStick);
            Timer.delay(0.005);		// wait for a motor update time
        }*/
    }
}
