package org.usfirst.frc.team7688.commands;

import org.usfirst.frc.team7688.robot.Robot;
import org.usfirst.frc.team7688.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTank extends Command {

    public DriveTank() {
    	requires(Robot.drivetrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double leftSpeed = Robot.oi.joystick.getRawAxis(RobotMap.OI_LEFT_STICK_Y);
    	double rightSpeed = Robot.oi.joystick.getRawAxis(RobotMap.OI_RIGHT_STICK_Y);
    	double zRotate = Robot.oi.joystick.getRawAxis(RobotMap.OI_LEFT_STICK_X);
    	if (Robot.oi.joystick.getRawButton(RobotMap.OI_BUTTON_Y)) {
    		Robot.drivetrain.tankDrive(leftSpeed*0.5, rightSpeed*0.5);
    	} else {
    		Robot.drivetrain.tankDrive(leftSpeed, rightSpeed);
    	}
    	System.out.println("Rotate: " + zRotate);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.tankDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
