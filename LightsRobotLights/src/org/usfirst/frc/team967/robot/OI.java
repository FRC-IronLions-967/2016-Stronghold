package org.usfirst.frc.team967.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team967.robot.commands.ExampleCommand;
import org.usfirst.frc.team967.robot.commands.shiftDrive;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
    Joystick xbox1 = new Joystick(0);
    Joystick msp430 = new Joystick(2);
	
    JoystickButton xbox1_a = new JoystickButton(xbox1, 1);
    
    JoystickButton a_button = new JoystickButton(xbox1, 1);
    JoystickButton b_button = new JoystickButton(xbox1, 2);
    JoystickButton x_button = new JoystickButton(xbox1, 3);
    JoystickButton y_button = new JoystickButton(xbox1, 4);
    
    JoystickButton button1 = new JoystickButton(msp430, 1);
    JoystickButton button2 = new JoystickButton(msp430, 2);
    JoystickButton button3 = new JoystickButton(msp430, 3);
    JoystickButton button4 = new JoystickButton(msp430, 4);
    
    public OI(){
    	a_button.whenPressed(new shiftDrive());
    }
    
	//xbox1_a.whenPressed(new Shoot(600));
	
    

    
	public Joystick getXbox1(){
		return xbox1;
	}
	
	public Joystick getmsp430(){
		return msp430;
	}
		
	//// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


}

