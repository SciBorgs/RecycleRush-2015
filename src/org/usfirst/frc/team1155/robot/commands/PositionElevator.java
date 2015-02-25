package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.Hardware;
import org.usfirst.frc.team1155.robot.Robot;
import org.usfirst.frc.team1155.robot.subsystems.Winch;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Command;

public class PositionElevator extends Command {
	private final int MAX_ERROR = 10; //Need to determine if this should be inches or encoder ticks
	private final float MAX_HEIGHT= 100 , MIN_HEIGHT = 100;
	private double targetHeight;
	private CANTalon mainTalon, assistTalon;
	
	public PositionElevator(double height) {
		requires(Robot.winch);
		targetHeight = height;
		//Copy over references to main and assist talons
		mainTalon = Hardware.INSTANCE.elevatorMainTalon;
		assistTalon = Hardware.INSTANCE.elevatorAssistTalon;
		
	}

	@Override
	protected void initialize() {
		Robot.winch.setPositionMode(true);
		Robot.winch.setPIDMode(true);
	}

	@Override
	protected void execute() {
		System.out.println("Going to" + targetHeight);
		mainTalon.set(targetHeight);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		if(mainTalon.getSpeed() > 0) {
			mainTalon.changeControlMode(CANTalon.ControlMode.Speed);
			mainTalon.set(0);
		}
	}

	@Override
	protected void interrupted() {
		
	}
}
