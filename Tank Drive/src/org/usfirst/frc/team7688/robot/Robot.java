/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7688.robot;



import org.usfirst.frc.team7688.commands.DriveTank;
import org.usfirst.frc.team7688.commands.ExperimentCommand;
import org.usfirst.frc.team7688.commands.SampleCommand;
import org.usfirst.frc.team7688.subsystems.Drivetrain;
import org.usfirst.frc.team7688.subsystems.ExperimentalSystem;
import org.usfirst.frc.team7688.subsystems.Pneumatics;
import org.usfirst.frc.team7688.subsystems.SampleSystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends IterativeRobot {
	
	public static final SampleSystem sampleSystem = new SampleSystem();
	SendableChooser<Command> chooser = new SendableChooser<>();
	Command autonomousCommand;
	Command teleOpCommand;
	
	
	public static Pneumatics pneumatics = null;
	public static Drivetrain drivetrain = null;
	public static ExperimentalSystem experimental = null;
	public static OI oi;
	
	@Override
	public void robotInit() {
 		
		drivetrain = new Drivetrain();
		pneumatics = new Pneumatics();
		experimental = new ExperimentalSystem();
		
		oi = new OI();
		
		chooser.addDefault("Default Auto", new SampleCommand());
		chooser.addObject("Experimental Autonomous", new ExperimentCommand());
		SmartDashboard.putData("Autonomous Mode", chooser);
		
		SmartDashboard.putData(Scheduler.getInstance());
		SmartDashboard.putData("Drivetrain Test", drivetrain);
		SmartDashboard.putData("Pneumatics Test", pneumatics);
		
		teleOpCommand = new DriveTank();
		
	}

	@Override
	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
		teleOpCommand.start();

	}
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
	}
	
	@Override
	public void autonomousInit() {
		
		if (teleOpCommand != null)
			teleOpCommand.cancel();
		
		autonomousCommand = chooser.getSelected();
		if (autonomousCommand != null)
			autonomousCommand.start();
	}
	
	@Override
	public void autonomousPeriodic() {

		Scheduler.getInstance().run();
	}
	
	@Override
	public void testPeriodic() {
		
	}
	
}
