package org.usfirst.frc.team1155.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class PerpendicularUltrasonic extends Command {
	
	UltrasonicSensor sensor;
	CommandGroup commands;
	 
	private double frontDist = 0, rightDist = 0, leftDist = 0;        
	
	@Override
	protected void initialize() {
		sensor = new UltrasonicSensor();
		sensor.start();
	}

	@Override
	protected void execute() {
		frontDist = sensor.getFrontDist();
		leftDist = sensor.getLeftDist();
		rightDist = sensor.getRightDist();
	}
	
	//must turn left first
	public void leftUltrasonicDrive() {
		commands = new CommandGroup();
		commands.addSequential(new FastTurnCommand(0, 9)); //turns robot to the left
		commands.addSequential(new DistanceDrive(1, leftDist)); //drives forward 
		commands.start();
	}
	
	//must turn right first
	public void rightUltrasonicDrive() {
		commands = new CommandGroup();
		commands.addSequential(new FastTurnCommand(1, 9)); //turns robot to the left
		commands.addSequential(new DistanceDrive(1, rightDist)); //drives forward 
		commands.start();
	}
	
	//doesnt need to turn
	public void frontUltrasonicDrive() {
		new DistanceDrive(1, frontDist).start(); //drives forward
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
