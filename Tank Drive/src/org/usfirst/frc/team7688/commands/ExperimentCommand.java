package org.usfirst.frc.team7688.commands;

import org.usfirst.frc.team7688.robot.Robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 *
 */
public class ExperimentCommand extends Command {

	// private Timer m_timer = null;
	private Gyro gyro;
//	private double kp = 0.03;
    public ExperimentCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.experimental);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		// m_timer.reset();
		// m_timer.start();
		
		gyro = new AnalogGyro(1);
		
		
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		// Gyroscope Drive for 2 seconds
    	gyro.reset();
		// if (m_timer.get() < 2.0) {
			double angle = gyro.getAngle();
			System.out.println(angle);
		//	Robot.drivetrain.arcadeDrive(0.5,-angle*kp); // drive forwards half speed
		// } else {
		//	Robot.drivetrain.stop(); // stop robot
		// } 
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	// Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
