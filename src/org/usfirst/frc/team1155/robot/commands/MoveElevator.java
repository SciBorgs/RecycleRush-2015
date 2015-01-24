package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.Hardware;
import org.usfirst.frc.team1155.robot.subsystems.Winch;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

public class MoveElevator extends Command {

	private final int MAX_ERROR = 10; //Need to determine if this should be inches or encoder ticks
	private CANTalon mainTalon, assistTalon;
	private float targetHeight;
	
	public MoveElevator(Winch subsystem) {
		requires(subsystem);
		//Copy over references to main and assist talons
		mainTalon = Hardware.INSTANCE.elevatorMainTalon;
		assistTalon = Hardware.INSTANCE.elevatorAssistTalon;
		
		//Set main CANTalon to position control (height from encoder)
		mainTalon.changeControlMode(CANTalon.ControlMode.Position);
		//Set feedback device to the Analog Encoder and set PID
		mainTalon.setFeedbackDevice(CANTalon.FeedbackDevice.AnalogEncoder);
		mainTalon.setPID(0, 0, 0.5);
		//Set assist CANTalon to Follower mode and have it follow (mimic) the mainTalon
		assistTalon.changeControlMode(CANTalon.ControlMode.Follower);
		assistTalon.set(mainTalon.getDeviceID());
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		
	}

	@Override
	protected boolean isFinished() {
		//Returns whether the elevator is within a certain distance to the target height
		return Math.abs(mainTalon.getPosition() - targetHeight) < MAX_ERROR;
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
		mainTalon.setPosition(targetHeight);
	}

}
