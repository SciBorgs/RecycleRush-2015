package org.usfirst.frc.team1155.robot.subsystems;

import org.usfirst.frc.team1155.robot.Robot;
import org.usfirst.frc.team1155.robot.commands.WinchSet;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Winch extends Subsystem {
	
	private final double TOTE_HEIGHT = 190101, BIN_HEIGHT = 101494; //where Winch should go before closing
	private WinchSet winchCommand;
	
	public Winch() {
		winchCommand = new WinchSet(this);
		//add more commands later
	}
	
	public double getHeight() {
		return Robot.hardware.winchEncoder.getDistance(); //change to actual useful method later
	}
	
	public void set(double targetHeight) {
		winchCommand.setTargetHeight(targetHeight);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stuff	
	}
}
