package org.usfirst.frc.team1155.robot;

import edu.wpi.first.wpilibj.*;

public enum Hardware {
	INSTANCE;
	
	
	public CANTalon frontLeftTalon, frontRightTalon, backLeftTalon, backRightTalon;
	public CANTalon leftElevatorTalon, rightElevatorTalon;
	public Encoder elevatorEncoder;
	public Ultrasonic leftUltrasonic, rightUltrasonic, frontUltrasonic;
//	public CameraServer camera;
	public Solenoid clawSolenoid;
	public CameraServer camera;
	public Gyro gyro;
	public Joystick rightJoystick, leftJoystick;
	
	Hardware() {
		//drive
		frontLeftTalon = new CANTalon(1); //change device numbers to accommodate CAN electronics network
		backLeftTalon = new CANTalon(2);
		frontRightTalon = new CANTalon(3);
		backRightTalon = new CANTalon(4);
		
		//winch
		leftElevatorTalon = new CANTalon(5);
		rightElevatorTalon = new CANTalon(6);
		elevatorEncoder = new Encoder(0,1); //change channels later
		
		//leftUltrasonic = new Ultrasonic()
		
		//claw
		clawSolenoid = new Solenoid(0, 1); //change channel to accommodate Pneumatics Control Module

	}
		
}

