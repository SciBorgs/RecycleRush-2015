package org.usfirst.frc.team1155.robot;

import edu.wpi.first.wpilibj.*;

public enum Hardware {
	INSTANCE;
	
	
	public CANTalon frontLeftTalon, frontRightTalon, backLeftTalon, backRightTalon;
	public CANTalon elevatorMainTalon, elevatorAssistTalon;
	public Ultrasonic leftUltrasonic, rightUltrasonic, frontUltrasonic;
//	public CameraServer camera;
	public Compressor compressor;
	public DoubleSolenoid clawSolenoid;
	public Joystick rightJoystick, leftJoystick, gamePad;
	public DigitalInput bottomLimitSwitch;
	
	Hardware() {
		//drive
		frontLeftTalon = new CANTalon(1); //change device numbers to accommodate CAN electronics network
		backLeftTalon = new CANTalon(2);
		frontRightTalon = new CANTalon(4);
		backRightTalon = new CANTalon(3);
		
		//winch
		elevatorMainTalon = new CANTalon(5);
		elevatorAssistTalon = new CANTalon(6);
		
		//leftUltrasonic = new Ultrasonic()
		leftJoystick = new Joystick(0);
		rightJoystick = new Joystick(1);
		gamePad = new Joystick(2);
		
		//claw
		compressor = new Compressor();
		clawSolenoid = new DoubleSolenoid(0, 1); //change channel to accommodate Pneumatics Control Module

		bottomLimitSwitch = new DigitalInput(0);
//		
//		leftUltrasonic = new Ultrasonic(0, 0);
//		rightUltrasonic = new Ultrasonic(0, 0);
//		frontUltrasonic = new Ultrasonic(0, 0);
		
	}
		
}

