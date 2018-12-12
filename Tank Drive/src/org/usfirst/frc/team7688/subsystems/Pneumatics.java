package org.usfirst.frc.team7688.subsystems;

import org.usfirst.frc.team7688.commands.SolenoidDefault;
import org.usfirst.frc.team7688.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem{
	static Compressor c = null;
	static Solenoid s = null;
	static DoubleSolenoid ds = null;
	
	public Pneumatics () {
		c = new Compressor(RobotMap.PN_COMPRESSOR_A);
		//s = new Solenoid(RobotMap.PN_SOLENOID_AF);
		ds = new DoubleSolenoid(RobotMap.PN_SOLENOID_AF, RobotMap.PN_SOLENOID_AR);
	}
	
	public static void extend () {
		ds.set(DoubleSolenoid.Value.kForward);
	}
	
	public static void retract() {
		ds.set(DoubleSolenoid.Value.kReverse);
	}
	
	public static void off() {
		ds.set(DoubleSolenoid.Value.kOff);
		c.stop();  // turning compressor off just because.
	}
	
	public static void on() {
		c.start();
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new SolenoidDefault());
		
	}
}
