package org.usfirst.frc.team1155.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class ParallelUltrasonic extends Command {

	UltrasonicSensor sensor;
	
	private double frontDist = 0, rightDist = 0, leftDist = 0;        
	private double distFromCenterToSideUltrasonic;
	
	@Override
	protected void initialize() {
		sensor = new UltrasonicSensor();
		distFromCenterToSideUltrasonic = 1; //Needs to be changed once we have the exact measurement
		sensor.start();
	}

	@Override
	protected void execute() {
		frontDist = sensor.getFrontDist();
		leftDist = sensor.getLeftDist();
		rightDist = sensor.getRightDist();
	}
	

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
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
