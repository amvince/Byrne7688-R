package org.usfirst.frc.team7688.commands;

import org.usfirst.frc.team7688.robot.Robot;
import org.usfirst.frc.team7688.subsystems.Pneumatics;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SolenoidRetract extends Command {

    public SolenoidRetract() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.pneumatics);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Pneumatics.extend();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
