package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.Hardware;
import org.usfirst.frc.team1155.robot.Robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class MoveElevator extends Command {
	private final double POSITION_CHANGE = 75f;
	private CANTalon mainTalon, assistTalon;
	private Joystick gamePad;
	
	public MoveElevator() {
		requires(Robot.winch);
		//Copy over references to main and assist talons
		mainTalon = Hardware.INSTANCE.elevatorMainTalon;
		assistTalon = Hardware.INSTANCE.elevatorAssistTalon;
		gamePad = Hardware.INSTANCE.gamePad;
	}
			
	@Override
	protected void initialize() {
		//Set the mode of the winch
		Robot.winch.setTalonMode("voltage");
		Robot.winch.setPIDMode(false);
	}

	@Override
	protected void execute() {
		double outputValue;
		switch(gamePad.getPOV()) {
		case 0: case 45: case 315:
			outputValue = -0.6;
			break;
		case 180: case 135: case 215:
			Robot.dash.putString("ButtonPressed", "it is");
			outputValue = 0.6;
			break;
		default:
			outputValue = 0.0;
		}
		Robot.winch.setValue(outputValue);
		/*
		double newPosition = Robot.winch.getPosition();
		switch(gamePad.getPOV()) {
		case 315: case 0: case 45:
			//Robot.winch.setSpeed(SPEED);
			newPosition += POSITION_CHANGE;
			
			break;
		case 135: case 180: case 225:
			//Robot.winch.setSpeed(-SPEED);
			newPosition -= POSITION_CHANGE;
			
			break;
		default:
			//Robot.winch.setSpeed(0);
			break;
		}
//		Robot.dash.putDouble("New Position", newPosition);
//		Robot.dash.putDouble("Encoder Position", (double) mainTalon.getEncPosition());
//		Robot.winch.setPosition(newPosition);
		*/
	}

	@Override
	protected boolean isFinished() {
		if (!mainTalon.isControlEnabled() || !assistTalon.isControlEnabled())
			return true;
		else
			return false;
	}

	@Override
	protected void end() {
		mainTalon.disableControl();
		assistTalon.disableControl();
		mainTalon.set(0);
		assistTalon.set(0);
	}

	@Override
	protected void interrupted() {
		mainTalon.disableControl();
		assistTalon.disableControl();
	}
	
	/*(protected void setHeight(float height) {
		targetHeight = height;
		//HEIGHT NEEDS TO BE CONVERTED FROM THIS TO ENCODER DISTANCE/REVOLUTIONS
		mainTalon.setPosition(targetHeight);
	}*/

}