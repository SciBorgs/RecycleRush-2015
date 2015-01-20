package org.usfirst.frc.team1155.robot;

import edu.wpi.first.wpilibj.*;

public enum Hardware {
	INSTANCE;
	
	
	public CANTalon frontLeftTalon, frontRightTalon, backLeftTalon, backRightTalon;
	public CANTalon leftWinchTalon, rightWinchTalon;
	public Encoder winchEncoder;
	public Solenoid clawSolenoid;
	public Ultrasonic leftUltrasonic, rightUltrasonic, frontUltrasonic;
//	public CameraServer camera;
	public CANTalon winchTalon1, winchTalon2;
	public Solenoid claw;
	public Ultrasonic left, right, front;
	public CameraServer camera;
	public Gyro gyro;
	public Encoder clawEncoder;
	public Joystick rightJoystick;
	public Joystick leftJoystick;
	
	Hardware() {
		//drive
		frontLeftTalon = new CANTalon(1); //change device numbers to accommodate CAN electronics network
		backLeftTalon = new CANTalon(2);
		frontRightTalon = new CANTalon(3);
		backRightTalon = new CANTalon(4);
		
		//winch
		leftWinchTalon = new CANTalon(5);
		rightWinchTalon = new CANTalon(6);
		winchEncoder = new Encoder(0,1); //change channels later
		
		//leftUltrasonic = new Ultrasonic()
		
		//claw
		clawSolenoid = new Solenoid(0, 1); //change channel to accommodate Pneumatics Control Module

	}
		
}

