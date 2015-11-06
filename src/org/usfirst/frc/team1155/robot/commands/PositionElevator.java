package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.Hardware;
import org.usfirst.frc.team1155.robot.Robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Command;

public class PositionElevator extends Command {
	private double targetHeight;
	private CANTalon mainTalon, assistTalon;
	
	public PositionElevator(double height) {
		requires(Robot.winch);
		targetHeight = height;	
	}

	@Override
	protected void initialize() {
		Robot.winch.setTalonMode("position");
		Robot.winch.setPIDMode(true);
	}

	@Override
	protected void execute() {
		System.out.println("Going to" + targetHeight);
		Robot.winch.setValue(targetHeight);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		if(mainTalon.getSpeed() > 0) {
			Robot.winch.setTalonMode("speed");
			Robot.winch.setValue(0);
		}
	}

	@Override
	protected void interrupted() {
		
	}
}
