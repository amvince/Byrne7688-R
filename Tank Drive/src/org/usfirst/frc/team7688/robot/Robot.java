/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7688.robot;


import org.usfirst.frc.team7688.commands.SampleCommand;
import org.usfirst.frc.team7688.subsystems.Drivetrain;
import org.usfirst.frc.team7688.subsystems.Pneumatics;
import org.usfirst.frc.team7688.subsystems.SampleSystem;

// import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
// import edu.wpi.first.wpilibj.Spark;
// import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends IterativeRobot {
	
	private DifferentialDrive m_Robot;
	private Joystick x_controller;
	//private WPI_TalonSRX m_frontLeft;
	//private WPI_TalonSRX m_frontRight;
	// private Spark m_left;
	// private Spark m_right;
	//private SpeedControllerGroup m_left;
	//private SpeedControllerGroup m_right;
	
	public static final SampleSystem sampleSystem = new SampleSystem();
	SendableChooser<Command> chooser = new SendableChooser<>();
	Command autonomousCommand;
	private Timer m_timer = new Timer(); 
	public static Pneumatics pneumatics = null;
	public static Drivetrain drivetrain = null;
	public static OI oi;
	
	@Override
	public void robotInit() {
 
		// x_controller = new Joystick(0);
		
		drivetrain = new Drivetrain();
		pneumatics = new Pneumatics();
		
		oi = new OI();
		
		chooser.addDefault("Default Auto", new SampleCommand());
		SmartDashboard.putData("Auto Mode", chooser);
		SmartDashboard.putData(drivetrain);
		SmartDashboard.putData(pneumatics);
		
	}

	@Override
	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		
	}
	
	@Override
	public void autonomousInit() {
		
		m_timer.reset();
		m_timer.start();
		autonomousCommand = chooser.getSelected();
		if (autonomousCommand != null)
			autonomousCommand.start();
	}
	
	@Override
	public void autonomousPeriodic() {
		// Drive for 2 seconds
		if (m_timer.get() < 2.0) {
			m_Robot.tankDrive(0.5, 0.0); // drive forwards half speed
		} else {
			m_Robot.stopMotor(); // stop robot
		}
		Scheduler.getInstance().run();
	}
	
	
}
