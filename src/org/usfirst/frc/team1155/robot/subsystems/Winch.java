package org.usfirst.frc.team1155.robot.subsystems;

import org.usfirst.frc.team1155.robot.Hardware;
import org.usfirst.frc.team1155.robot.Robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Winch extends Subsystem {
	public static final double TOTE_1 = 0, TOTE_2 = 1500, TOTE_3 = 3000, TOTE_4 = 4500, BIN_HEIGHT = 101494; //where Winch should go before closing
	private final double MAX_HEIGHT= 100 , MIN_HEIGHT = 100;
	private CANTalon mainTalon, assistTalon;
	
	public Winch() {
		mainTalon = Hardware.INSTANCE.elevatorMainTalon;
		assistTalon = Hardware.INSTANCE.elevatorAssistTalon;
		
		setPositionMode(false); //Winch defaults to speed mode
	}
	
	public void setPositionMode(boolean positionMode) {
		if(positionMode){
			mainTalon.changeControlMode(CANTalon.ControlMode.Position);
			//Set feedback device to the Analog Encoder and set PID
			mainTalon.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
			mainTalon.setPID(0.4, 0, 0);
		}
		else {
			mainTalon.changeControlMode(CANTalon.ControlMode.PercentVbus);
			mainTalon.set(0);
		}
		assistTalon.changeControlMode(CANTalon.ControlMode.Follower);
		assistTalon.set(mainTalon.getDeviceID());
				
		mainTalon.enableControl();
		assistTalon.enableControl();
	}
	
	public void setPIDMode(boolean positionMode) {
		if(positionMode) {
			mainTalon.setPID(0.4, 0, 0);
		}
		else {
			mainTalon.setPID(1, 0, 0);
		}
	}
	
	public void setSpeed(double speed) {
		mainTalon.set(speed);		
	}
	
	public void setPosition(double position) {
		if(position > 6200) mainTalon.set(6200);
		else if(position < 0) mainTalon.set(0);
		else mainTalon.set(position);
	}
	
	public double getPosition() {
		return mainTalon.getSetpoint();
	}
	
	public boolean getLimitSwitch() {
		return Hardware.INSTANCE.bottomLimitSwitch.get();
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stuff	
	}
}
