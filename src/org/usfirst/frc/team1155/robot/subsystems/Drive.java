package org.usfirst.frc.team1155.robot.subsystems;

import org.usfirst.frc.team1155.robot.Hardware;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drive extends Subsystem {
	
	private CANTalon frontLeftTalon, backLeftTalon, frontRightTalon, backRightTalon;
	
	public Drive() {
		frontLeftTalon = Hardware.INSTANCE.frontLeftTalon;
		backLeftTalon = Hardware.INSTANCE.backLeftTalon;
		frontRightTalon = Hardware.INSTANCE.frontRightTalon;
		backRightTalon = Hardware.INSTANCE.backRightTalon;
		
		setMode(false);
	}
	
	public void set(double leftVal, double rightVal) {
		frontLeftTalon.set(-leftVal);
		frontRightTalon.set(rightVal);
	}
	
	public void setMode(boolean distanceMode) {
		if(distanceMode) {
			frontLeftTalon.changeControlMode(CANTalon.ControlMode.Position);
			frontRightTalon.changeControlMode(CANTalon.ControlMode.Position);
			
			frontLeftTalon.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
			frontRightTalon.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
			
			frontLeftTalon.setPID(0.4, 0, 0);
			frontRightTalon.setPID(0.4, 0, 0);
		}
		else {
			frontLeftTalon.changeControlMode(CANTalon.ControlMode.PercentVbus);
			frontRightTalon.changeControlMode(CANTalon.ControlMode.PercentVbus);
			
			frontLeftTalon.set(0);
			frontRightTalon.set(0);
		}
		
		backLeftTalon.changeControlMode(CANTalon.ControlMode.Follower);
		backRightTalon.changeControlMode(CANTalon.ControlMode.Follower);
		
		backLeftTalon.set(frontLeftTalon.getDeviceID());
		backRightTalon.set(frontRightTalon.getDeviceID());
	}
	
	public void setLeftPosition(double position) {
		frontLeftTalon.setPosition(position);
	}
	
	public void setRightPosition(double position) {
		frontRightTalon.setPosition(position);
	}
	
	public double getLeftPosition() {
		return frontLeftTalon.getSetpoint();
	}
	
	public double getRightPosition() {
		return frontRightTalon.getSetpoint();
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
