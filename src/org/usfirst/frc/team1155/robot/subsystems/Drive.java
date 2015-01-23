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
	}
	
	public void set(double leftSpeed, double rightSpeed) {
		//Drive curve code goes here
		frontLeftTalon.set(leftSpeed);
		backLeftTalon.set(leftSpeed);
		frontRightTalon.set(rightSpeed);
		backRightTalon.set(rightSpeed);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
