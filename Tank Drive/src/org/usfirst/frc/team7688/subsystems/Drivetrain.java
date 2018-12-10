package org.usfirst.frc.team7688.subsystems;

import org.usfirst.frc.team7688.commands.DriveTank;
import org.usfirst.frc.team7688.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Drivetrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Spark m_left = null;
	Spark m_right = null;
	
	DifferentialDrive m_drive = null;
	
	public Drivetrain() {
		m_left = new Spark(RobotMap.DRIVETRAIN_LEFT_FRONT);
		m_right = new Spark(RobotMap.DRIVETRAIN_RIGHT_FRONT);
		
		m_drive = new DifferentialDrive(m_left, m_right);
	}
	public void tankDrive(double leftSpeed, double rightSpeed) {
		m_drive.tankDrive(leftSpeed, rightSpeed);
	}
	
	public void stop() {
		m_drive.tankDrive(0, 0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand( new DriveTank());
    }
}

