/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7688.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


public class Robot extends IterativeRobot 
{	
	private Joystick m_stick = new Joystick(0);
	
	
	

	
	@Override
	public void robotInit() 
	{
		
	}

	
	@Override
	public void autonomousInit() 
	{
		
	}

	
	@Override
	public void autonomousPeriodic() 
	{
	
	}


	
	@Override
	public void teleopInit() 
	{
		
	}

	
	@Override
	public void teleopPeriodic() 
	{
		for(int i = 1; i < 15; i++)
		{
			if(m_stick.getRawButton(i))
			{
				System.out.println(i);
			}
		}
	}

	
	@Override
	public void testPeriodic() 
	{
	}
}
