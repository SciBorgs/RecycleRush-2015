package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForTime extends Command {

	private long duration, startTime;
	private int curMode;
	public static final int DRIVE = 0, TURN_LEFT = 1, TURN_RIGHT = 2;
	private final double SPEED = 0.3;
	
    public DriveForTime(double duration, int mode) {
    	requires(Robot.drive);
		
    	curMode = mode;
    	this.duration = (long) duration * (long) Math.pow(10, 9);
    	
    	Robot.drive.setMode(false);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startTime = System.nanoTime();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return System.nanoTime() - duration > startTime;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.set(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drive.set(0, 0);
    }
}
