package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.Hardware;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class JoystickDrive extends Command{
	private CANTalon frontLeftTalon, frontRightTalon, backLeftTalon, backRightTalon;
	private Joystick rightJoystick, leftJoystick;
	private Button rightTrigger, leftTrigger, btnSlowLeft, btnSlowRight;
	
	private double leftVal, rightVal;
	private final float maxChange = 0.4f;
	
	private double frontLeftSpeed, frontRightSpeed, backLeftSpeed, backRightSpeed;
	public JoystickDrive(){
		frontLeftTalon = Hardware.INSTANCE.frontLeftTalon;
		frontRightTalon = Hardware.INSTANCE.frontRightTalon;
		backLeftTalon = Hardware.INSTANCE.backLeftTalon;
		backRightTalon = Hardware.INSTANCE.backRightTalon;

		rightJoystick = Hardware.INSTANCE.rightJoystick;
		leftJoystick = Hardware.INSTANCE.leftJoystick;
		
		rightTrigger = new JoystickButton(rightJoystick, 1);
		leftTrigger = new JoystickButton(leftJoystick, 1);
		btnSlowLeft = new JoystickButton(leftJoystick, 10);
		btnSlowRight = new JoystickButton(rightJoystick, 10);
	}

	@Override
	protected void initialize() {
		SmartDashboard dash = new SmartDashboard();
		dash.putString("String 1", "Joystick Drive Initialized");
		// TODO Auto-generated method stub
		frontLeftTalon.set(0);
		frontRightTalon.set(0);
		backLeftTalon.set(0);
		backRightTalon.set(0);
	}

	@Override
	protected void execute() {
		SmartDashboard dash = new SmartDashboard();
		dash.putString("String 1", "Joystick Drive Running");
		rightVal = changeTo(rightVal, rightJoystick.getY());
		leftVal = changeTo(leftVal, leftJoystick.getY());
		if(rightTrigger.get() || leftTrigger.get()) {
			leftVal = rightVal;
		}
		if(btnSlowLeft.get() || btnSlowRight.get()) {
			leftVal *= 0.5;
			rightVal *= 0.5;
		}
		if (rightVal == 0 && leftVal == 0) {
			frontLeftTalon.set(0);
			frontRightTalon.set(0);
			backLeftTalon.set(0);
			backRightTalon.set(0);
		} else {
			frontLeftTalon.set(-leftVal);
			backLeftTalon.set(-leftVal);
			frontRightTalon.set(rightVal);
			backRightTalon.set(rightVal);
		}
		
	}

	private double changeTo(double curVal, double targetVal) {
		if(Math.abs(curVal - targetVal) > maxChange) {
			curVal += maxChange * targetVal / Math.abs(targetVal);
		}
		else curVal = targetVal;
		return curVal * Math.abs(curVal);
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
