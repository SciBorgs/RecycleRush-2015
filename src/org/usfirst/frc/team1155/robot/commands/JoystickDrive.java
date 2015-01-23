package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.Hardware;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class JoystickDrive extends Command{
	private CANTalon frontLeftTalon, frontRightTalon, backLeftTalon, backRightTalon;
	private Joystick rightJoystick, leftJoystick;
	
	private double leftVal, rightVal;
	
	private double frontLeftSpeed, frontRightSpeed, backLeftSpeed, backRightSpeed;
	public JoystickDrive(){
		frontLeftTalon = Hardware.INSTANCE.frontLeftTalon;
		frontRightTalon = Hardware.INSTANCE.frontRightTalon;
		backLeftTalon = Hardware.INSTANCE.backLeftTalon;
		backRightTalon = Hardware.INSTANCE.backRightTalon;
		
		rightJoystick = Hardware.INSTANCE.rightJoystick;
		leftJoystick = Hardware.INSTANCE.leftJoystick;
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		frontLeftTalon.set(0);
		frontRightTalon.set(0);
		backLeftTalon.set(0);
		backRightTalon.set(0);
	}

	@Override
	protected void execute() {
		rightVal = rightJoystick.getY();
		leftVal = leftJoystick.getY();
		if (rightVal == 0 && leftVal == 0){
			frontLeftTalon.set(0);
			frontRightTalon.set(0);
			backLeftTalon.set(0);
			backRightTalon.set(0);
		} else {
			curveSpeed();
		}

	}

	private void curveSpeed() {
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
