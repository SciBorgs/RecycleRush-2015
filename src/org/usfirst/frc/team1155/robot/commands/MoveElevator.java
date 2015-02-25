package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.Hardware;
import org.usfirst.frc.team1155.robot.Robot;
import org.usfirst.frc.team1155.robot.subsystems.Winch;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

public class MoveElevator extends Command {
	private final int MAX_ERROR = 10; //Need to determine if this should be inches or encoder ticks
	private final double MAX_HEIGHT= 100 , MIN_HEIGHT = 100;
	private final double POSITION_CHANGE = 50f;
	private CANTalon mainTalon, assistTalon;
	private Joystick gamePad;
	private double elevatorSpeed;
	
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
		Robot.winch.setPositionMode(true);
		Robot.winch.setPIDMode(false);
	}

	@Override
	protected void execute() {
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
		Robot.winch.setPosition(newPosition);
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
