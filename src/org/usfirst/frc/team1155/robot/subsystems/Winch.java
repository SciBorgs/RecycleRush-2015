package org.usfirst.frc.team1155.robot.subsystems;

import org.usfirst.frc.team1155.robot.Hardware;
import org.usfirst.frc.team1155.robot.Robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Winch extends Subsystem {
	public static final double TOTE_1 = 0, TOTE_2 = 2100, TOTE_3 = 3000, TOTE_4 = 4500, 
			BIN_HEIGHT = 1700, TOTE_MID = 500; //where Winch should go before closing
	private CANTalon mainTalon, assistTalon;
	
	public Winch() {
		mainTalon = Hardware.INSTANCE.elevatorMainTalon;
		assistTalon = Hardware.INSTANCE.elevatorAssistTalon;
		
	}
	public void setTalonMode(String mode) {
		switch (mode) {
		case "position":
			mainTalon.changeControlMode(CANTalon.ControlMode.Position);
			break;
		case "voltage":
			mainTalon.changeControlMode(CANTalon.ControlMode.PercentVbus);
			Robot.dash.putString("Mode" , "PercentVBus Enabled");
			break;
		default: 
			mainTalon.changeControlMode(CANTalon.ControlMode.Speed);
			break;
		}
		assistTalon.changeControlMode(CANTalon.ControlMode.Follower);
		assistTalon.set(mainTalon.getDeviceID());
				
		mainTalon.enableControl();
		assistTalon.enableControl();
	}
	
	public void setPIDMode(boolean positionMode) {
		if(positionMode) {
			mainTalon.setPID(0.6, 0, 0);
		}
		else {
			mainTalon.setPID(1, 0, 0);
		}
	}
	
	public void setValue(double value) {
		mainTalon.set(value);
		assistTalon.set(mainTalon.getDeviceID());
		Robot.dash.putNumber("Value", value);
	}
	
//	public double getPosition() {
//		return mainTalon.getSetpoint();
//	}
	
	public boolean getLimitSwitch() {
		return Hardware.INSTANCE.bottomLimitSwitch.get();
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stuff	
	}
}