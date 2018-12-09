package org.usfirst.frc.team7688.subsystems;

import org.usfirst.frc.team7688.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;

public class Pneumatics {
	Compressor c = null;
	Solenoid s = null;
	DoubleSolenoid ds = null;
	
	public Pneumatics () {
		c = new Compressor(RobotMap.PN_COMPRESSOR_A);
		//s = new Solenoid(RobotMap.PN_SOLENOID_AF);
		ds = new DoubleSolenoid(RobotMap.PN_SOLENOID_AF, RobotMap.PN_SOLENOID_AR);
	}
	
	public void extend () {
		ds.set(DoubleSolenoid.Value.kForward);
	}
	
	public void retract() {
		ds.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void off() {
		ds.set(DoubleSolenoid.Value.kOff);
	}
}
