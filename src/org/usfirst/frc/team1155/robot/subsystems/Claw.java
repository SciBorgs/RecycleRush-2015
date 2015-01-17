package org.usfirst.frc.team1155.robot.subsystems;

import org.usfirst.frc.team1155.robot.Robot;
import org.usfirst.frc.team1155.robot.commands.ClawSet;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Claw extends Subsystem {
	ClawSet clawCommand;
	public Claw() {
		
	}
	
	public void open() {
		clawCommand = new ClawSet(this, true);
	}
	
	public void close() {
		clawCommand = new ClawSet(this, false);
	}
	
	public boolean isOpen() {
		return Robot.hardware.clawSolenoid.get();
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
}
