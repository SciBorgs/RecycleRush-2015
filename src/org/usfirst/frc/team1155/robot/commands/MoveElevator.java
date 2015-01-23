package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.Hardware;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Command;

public class MoveElevator extends Command {

	private CANTalon leftElevatorTalon, rightElevatorTalon;
	private float targetHeight;
	
	public MoveElevator() {
		leftElevatorTalon = Hardware.INSTANCE.leftElevatorTalon;
		leftElevatorTalon = Hardware.INSTANCE.leftElevatorTalon;
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		if

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}
	
	protected void setHeight(float height) {
		targetHeight = height;
	}

}
