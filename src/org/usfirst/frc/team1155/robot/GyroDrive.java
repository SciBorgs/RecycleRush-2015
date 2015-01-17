package org.usfirst.frc.team1155.robot;

import edu.wpi.first.wpilibj.*;

public class GyroDrive {

	// Constant variables for ANGLE
	private static final double ANGLE = 45;
	public static final double BUFFER = 5;
	private static final double MIN_SPEED = 0.5, MAX_SPEED = 1;

	double fixedVal = 0;
	double startVal = 0;

	// Starts everything
	public void start() {
		Robot.hardware.gyro.initGyro(); // Resets gyro value to 0
	}

	public void fastTurnLeft() {
		setAngles();
		while (Robot.hardware.gyro.getAngle() < (fixedVal)) {
			Robot.hardware.frontRightTalon.set(1); 
			Robot.hardware.backRightTalon.set(1);
			Robot.hardware.frontLeftTalon.set(-1);
			Robot.hardware.backLeftTalon.set(-1);
		}
	}

	public void fastTurnRight() {
		setAngles();
		while (Robot.hardware.gyro.getAngle() < (startVal + ANGLE)) {
			Robot.hardware.frontRightTalon.set(-1);
			Robot.hardware.backRightTalon.set(-1);
			Robot.hardware.frontLeftTalon.set(1);
			Robot.hardware.backLeftTalon.set(1);
		}
	}

	private void setAngles() {
		
		/*
		//
		startVal = (Robot.hardware.gyro.getAngle() >= 360) ? Robot.hardware.gyro.getAngle() % 360 : Robot.hardware.gyro.getAngle();
		//
		fixedVal = (startVal - ANGLE < 0) ? startVal - ANGLE + 360 : startVal - ANGLE;
		*/
	}
	
	public double getAngle() {
		return Robot.hardware.gyro.getAngle();
	}
}
