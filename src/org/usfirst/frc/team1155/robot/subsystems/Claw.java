package org.usfirst.frc.team1155.robot.subsystems;

import org.usfirst.frc.team1155.robot.Hardware;
import org.usfirst.frc.team1155.robot.Robot;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Claw extends Subsystem {
	
	private Solenoid claw;
	
	public Claw() {
		claw = Hardware.INSTANCE.clawSolenoid;
	}
	
	public void close() {
		
	}
	
	public void open() {
		
	}
	
	public void get() {
		
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
}
