package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.Hardware;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Command;

public class DistanceDrive extends Command{
	private CANTalon frontLeftTalon, frontRightTalon, backLeftTalon, backRightTalon;
	private AccelerometerCommand distanceAccel;
	
	private double distance; 
	private int direction; //1 for forward, 0 for backwards
	
	private boolean isFinished;

	//Distance must be in METERS
	public DistanceDrive(double driveDistance, int driveDirection) {
		frontLeftTalon = Hardware.INSTANCE.frontLeftTalon;
		frontRightTalon = Hardware.INSTANCE.frontRightTalon;
		backLeftTalon = Hardware.INSTANCE.backLeftTalon;
		backRightTalon = Hardware.INSTANCE.backRightTalon;
		distanceAccel = new AccelerometerCommand();
		
		distance = driveDistance;
		direction = driveDirection;
	}
	
	@Override
	protected void initialize() {
		frontLeftTalon.set(0);
		frontRightTalon.set(0);
		backLeftTalon.set(0);
		backRightTalon.set(0);
		
		distanceAccel.resetTotalDistance();
		isFinished = false;
	}

	@Override
	protected void execute() {
		if(distanceAccel.returnTotalDistance() <= distance && !isFinished) {
			if(direction == 1) {
				frontLeftTalon.set(1);
				frontRightTalon.set(1);
				backLeftTalon.set(1);
				backRightTalon.set(1);
			}else {
				frontLeftTalon.set(-1);
				frontRightTalon.set(-1);
				backLeftTalon.set(-1);
				backRightTalon.set(-1);
			}
		}
		isFinished = true;	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isFinished;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
