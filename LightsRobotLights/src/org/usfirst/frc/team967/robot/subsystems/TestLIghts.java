package org.usfirst.frc.team967.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team967.*;
import org.usfirst.frc.team967.robot.Robot;
import org.usfirst.frc.team967.robot.commands.*;
import edu.wpi.first.wpilibj.DigitalOutput;

/**
 *
 */
public class TestLIghts extends Subsystem {
    private static DigitalOutput lightPattern1, lightPattern2;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public TestLIghts() {
    	lightPattern1 = new DigitalOutput(1);
    	lightPattern2 = new DigitalOutput(2);
    }
    
    public void Pattern1On() {
    	lightPattern1.set(true);
    }
    public void Pattern1Off() {
    	lightPattern1.set(false);
    }
    

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
