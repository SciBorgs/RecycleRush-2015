package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.Hardware;
import org.usfirst.frc.team1155.robot.Robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Command;

public class UltrasonicDrive extends Command {

	private Ultrasonic ultrasonic;
	private double distance, currentDistance;
	private boolean far;
	private final double SPEED = 0.25, BUFFER = 2;

	public UltrasonicDrive(double distance, boolean far) {
		this.distance = distance;
		this.far = far;
		ultrasonic = Hardware.INSTANCE.ultrasonic;
	}
	
	@Override
	protected void initialize() {
		Robot.drive.setMode(false);
		Timer.delay(0.001);
	}

	@Override
	protected void execute() {
		currentDistance = ultrasonic.getRangeInches();
		if(currentDistance > distance) {
			Robot.drive.set(SPEED, SPEED);
		}
		else if(currentDistance < distance) {
			Robot.drive.set(-SPEED, -SPEED);
		}
	}

	@Override
	protected boolean isFinished() {
		if(far) {
			return distance - ultrasonic.getRangeInches() <= 0;
		}
		else {
			return ultrasonic.getRangeInches() - distance <= 0;
		}
	}

	@Override
	protected void end() {
		Robot.drive.set(0, 0);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		Robot.drive.set(0, 0);
	}

}
