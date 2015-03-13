package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class EncoderDrive extends Command {

	private double distance;
	private int curMode;
	public static final int DRIVE = 0, TURN_LEFT = 1, TURN_RIGHT = 2, BUFFER = 0;
	
	public EncoderDrive(double tickDistance, int mode) {
		requires(Robot.drive);
		
		distance = tickDistance;
		curMode = mode;
	}
	
	@Override
	protected void initialize() {
		Robot.drive.setMode(true);
		Robot.drive.setLeftPosition(0);
	}

	@Override
	protected void execute() {
		//Needs to be calibrated based on encoder directions
		switch(curMode) {
    	case DRIVE:
    		Robot.drive.set(distance, distance);
    		break;
    	case TURN_LEFT:
    		Robot.drive.set(-distance, distance);
    		break;
    	case TURN_RIGHT:
    		Robot.drive.set(distance, -distance);
    		break;
    	}
	}

	@Override
	protected boolean isFinished() {
		return Math.abs(Robot.drive.getLeftPosition() - distance) < BUFFER;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}

}
