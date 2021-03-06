package org.usfirst.frc.team7688.commands;

import org.usfirst.frc.team7688.robot.Robot;
import org.usfirst.frc.team7688.subsystems.Pneumatics;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SampleCommand extends Command {

	private Timer m_timer = new Timer(); 
	
    public SampleCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires (Robot.sampleSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		m_timer.reset();
		m_timer.start();
		Pneumatics.off();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		// Drive for 2 seconds
	/*	if (m_timer.get() < 2.0) {
			Robot.drivetrain.arcadeDrive(0.75,180); // drive forwards half speed
		} else {
			Robot.drivetrain.stop(); // stop robot
		} */
    	
	/*	while (m_timer.get() < 2.0) {
			Robot.drivetrain.arcadeDrive(0.5,0);
		}
		while (m_timer.get() <4.0) {
			Robot.drivetrain.arcadeDrive(0.5, 90);
		}
		while (m_timer.get() <6.0) {
			Robot.drivetrain.arcadeDrive(0.5,  180);
		}
		while (m_timer.get() <8.0) {
			Robot.drivetrain.arcadeDrive(0.5,  270);
		} */
	//	Robot.drivetrain.stop();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.stop();
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
