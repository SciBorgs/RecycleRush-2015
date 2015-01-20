package org.usfirst.frc.team1155.robot.subsystems;

import org.usfirst.frc.team1155.robot.Robot;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Claw extends Subsystem {
	public Claw() {
		
	}
	
	public void open() {
	}
	
	public void close() {
	}
	
	public boolean isOpen() {
		return Robot.hardware.clawSolenoid.get();
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
}
