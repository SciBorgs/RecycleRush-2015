package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.Hardware;
import org.usfirst.frc.team1155.robot.subsystems.Winch;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Command;

public class MoveElevator extends Command {

	private CANTalon leftElevatorTalon, rightElevatorTalon;
	private float targetHeight;
	
	public MoveElevator(Winch subsystem) {
		leftElevatorTalon = Hardware.INSTANCE.leftElevatorTalon;
		rightElevatorTalon = Hardware.INSTANCE.rightElevatorTalon;
		requires(subsystem);
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {

	}
	
	protected void setHeight(float height) {
		targetHeight = height;
	}

}
