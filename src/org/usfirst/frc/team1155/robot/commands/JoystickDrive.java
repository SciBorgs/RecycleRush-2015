package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.Hardware;
import org.usfirst.frc.team1155.robot.Robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

public class JoystickDrive extends Command{
	private CANTalon frontLeftTalon, frontRightTalon, backLeftTalon, backRightTalon;
	private Joystick rightJoystick, leftJoystick;
	private Button rightTrigger, leftTrigger, btnSlowLeft, btnSlowRight;
	
	private double leftVal, rightVal;
	private final float maxChange = 0.4f;

	public JoystickDrive(){
		frontLeftTalon = Hardware.INSTANCE.frontLeftTalon;
		frontRightTalon = Hardware.INSTANCE.frontRightTalon;
		backLeftTalon = Hardware.INSTANCE.backLeftTalon;
		backRightTalon = Hardware.INSTANCE.backRightTalon;

		rightJoystick = Hardware.INSTANCE.rightJoystick;
		leftJoystick = Hardware.INSTANCE.leftJoystick;
		
		rightTrigger = new JoystickButton(rightJoystick, 1);
		leftTrigger = new JoystickButton(leftJoystick, 1);
		btnSlowLeft = new JoystickButton(leftJoystick, 3);
		btnSlowRight = new JoystickButton(rightJoystick, 3);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.drive.setMode(false);
		frontLeftTalon.set(0);
		frontRightTalon.set(0);
		backLeftTalon.set(0);
		backRightTalon.set(0);
	}

	@Override
	protected void execute() {
		rightVal = changeTo(rightVal, rightJoystick.getY());
		leftVal = changeTo(leftVal, leftJoystick.getY());
		if(rightTrigger.get() || leftTrigger.get()) {
			leftVal = rightVal;
		}
		if(btnSlowLeft.get() || btnSlowRight.get()) {
			leftVal *= 0.4;
			rightVal *= 0.4;
		}
		else {
			leftVal *= 0.7;
			rightVal *= 0.7;
		}
		if (rightVal == 0 && leftVal == 0) {
			Robot.drive.set(0, 0);
		} else {
			Robot.drive.set(-leftVal, -rightVal);
		}
		
	}

	private double changeTo(double curVal, double targetVal) {
		return targetVal * Math.abs(targetVal);
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
