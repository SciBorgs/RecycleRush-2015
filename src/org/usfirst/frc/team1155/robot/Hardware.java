package org.usfirst.frc.team1155.robot;

import edu.wpi.first.wpilibj.*;

public enum Hardware {
	INSTANCE;
	
	public CANTalon frontLeftTalon, frontRightTalon, backLeftTalon, backRightTalon;
	public CANTalon winchTalon1, winchTalon2;
	public Solenoid claw;
	public Ultrasonic left, right, front;
	public CameraServer camera;
	public Gyro gyro;
	public Encoder clawEncoder;
	
	Hardware() {
		
	}
	
}
