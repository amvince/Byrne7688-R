package org.usfirst.frc.team7688.commands;

import org.usfirst.frc.team7688.robot.Robot;
import org.usfirst.frc.team7688.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SampleCommand extends Command {

	private Timer m_timer = new Timer(); 
	public static Drivetrain drivetrain = null;
	
    public SampleCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires (Robot.sampleSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		m_timer.reset();
		m_timer.start();
		drivetrain = new Drivetrain();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		// Drive for 2 seconds
		if (m_timer.get() < 2.0) {
			drivetrain.tankDrive(0.5, 0.0); // drive forwards half speed
		} else {
			drivetrain.stop(); // stop robot
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
