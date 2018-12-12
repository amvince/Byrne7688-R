package org.usfirst.frc.team7688.subsystems;

import org.usfirst.frc.team7688.commands.SampleCommand;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SampleSystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new SampleCommand());
    }
}

