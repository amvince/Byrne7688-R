/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7688.robot;


// import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
// import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends IterativeRobot {
	
	private DifferentialDrive m_Robot;
	private Joystick x_controller;
	//private WPI_TalonSRX m_frontLeft;
	//private WPI_TalonSRX m_frontRight;
	private Spark m_left;
	private Spark m_right;
	//private SpeedControllerGroup m_left;
	//private SpeedControllerGroup m_right;
	
	private Timer m_timer = new Timer(); 
	
	@Override
	public void robotInit() {
		
//		m_left = new WPI_TalonSRX(1); // Testing CAN1
//		m_right = new WPI_TalonSRX(2); // Testing CAN2
		m_left= new Spark(RobotMap.DRIVETRAIN_LEFT_FRONT);
		m_right = new Spark(RobotMap.DRIVETRAIN_RIGHT_FRONT);
//		m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);
//		m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);
		
		m_Robot = new DifferentialDrive(m_left, m_right);
 
		x_controller = new Joystick(0);
	}

	@Override
	public void teleopPeriodic() {
		double x_left= x_controller.getRawAxis(5);
		double x_right = x_controller.getRawAxis(1);
		m_Robot.tankDrive(x_left,  x_right);
		System.out.println("Left: " + x_left + " Right: " + x_right);
	}
	
	@Override
	public void autonomousInit() {
		m_timer.reset();
		m_timer.start();
	}
	
	@Override
	public void autonomousPeriodic() {
		// Drive for 2 seconds
		if (m_timer.get() < 2.0) {
			m_Robot.arcadeDrive(0.5, 0.0); // drive forwards half speed
		} else {
			m_Robot.stopMotor(); // stop robot
		}
	}
	
	
}
