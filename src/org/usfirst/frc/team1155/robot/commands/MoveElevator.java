package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.Hardware;
import org.usfirst.frc.team1155.robot.subsystems.Winch;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

public class MoveElevator extends Command {

	private CANTalon leftElevatorTalon, rightElevatorTalon;
	private float targetHeight;
	private PIDController elevatorPID;
	
	public MoveElevator(Winch subsystem) {
		requires(subsystem);
		leftElevatorTalon = Hardware.INSTANCE.leftElevatorTalon;
		rightElevatorTalon = Hardware.INSTANCE.rightElevatorTalon;
		elevatorPID = new PIDController(1, 0, 0.5, Hardware.INSTANCE.elevatorEncoder, leftElevatorTalon);
	}
	
	@Override
	protected void initialize() {
		elevatorPID.setContinuous(true);
		elevatorPID.setOutputRange(1, -1);
	}

	@Override
	protected void execute() {
		leftElevatorTalon.set(elevatorPID.get());
		rightElevatorTalon.set(elevatorPID.get());
	}

	@Override
	protected boolean isFinished() {
		return elevatorPID.onTarget();
	}

	@Override
	protected void end() {

	}

	@Override
	protected void interrupted() {

	}
	
	protected void setHeight(float height) {
		targetHeight = height;
		//HEIGHT NEEDS TO BE CONVERTED FROM THIS TO ENCODER DISTANCE/REVOLUTIONS
		elevatorPID.setSetpoint(targetHeight);
	}

}
