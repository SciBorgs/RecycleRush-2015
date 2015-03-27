package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class EncoderDrive extends Command {

	private double distance;
	private int curMode;
	public static final int DRIVE = 0, TURN_LEFT = 1, TURN_RIGHT = 2, BUFFER = 0;
	public static final float SPEED = 0.4f;
	
	public EncoderDrive(double tickDistance, int mode) {
		requires(Robot.drive);
		
		distance = tickDistance;
		curMode = mode;
	}
	
	@Override
	protected void initialize() {
		Robot.drive.setMode(false);
		Robot.drive.setLeftPosition(0);
	}

	@Override
	protected void execute() {
		//Needs to be calibrated based on encoder directions
		switch(curMode) {
    	case DRIVE:
    		Robot.drive.set(SPEED, SPEED);
    		break;
    	case TURN_LEFT:
    		Robot.drive.set(-SPEED, SPEED);
    		break;
    	case TURN_RIGHT:
    		Robot.drive.set(SPEED, -SPEED);
    		break;
    	}
	}

	@Override
	protected boolean isFinished() {
		return Math.abs(Robot.drive.getLeftPosition()) - distance > 0;
	}

	@Override
	protected void end() {
		Robot.drive.setLeftPosition(0);
		Robot.drive.set(0, 0);
	}

	@Override
	protected void interrupted() {
		Robot.drive.setLeftPosition(0);
		Robot.drive.set(0, 0);
	}

}
