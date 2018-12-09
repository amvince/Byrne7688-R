package org.usfirst.frc.team7688.commands;

import org.usfirst.frc.team7688.robot.Robot;
import org.usfirst.frc.team7688.subsystems.Pneumatics;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SolenoidDefault extends Command {

	boolean control;
	
    public SolenoidDefault() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires (Robot.pneumatics);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/* double control = Robot.oi.getJoystickRightY();
    	if (control < - 0.1) {
    		Pneumatics.retract();
    	} else if (control > 0.1) {
    		Pneumatics.extend();
    	} else {
    		Pneumatics.off();
    	} */
    	control = Robot.oi.getJoystickButtonBlue();
    	if (control = true) { Pneumatics.extend();
    	} else Pneumatics.off();
    	
    	control = Robot.oi.getJoystickButtonRed();
    	if (control = true)  {Pneumatics.retract();
    	} else Pneumatics.off();
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Pneumatics.off();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
