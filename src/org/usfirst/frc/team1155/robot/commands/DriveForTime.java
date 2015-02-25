package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.Hardware;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForTime extends Command {

	private long duration, startTime;
	private int curMode;
	private CANTalon frontLeftTalon, frontRightTalon, backLeftTalon, backRightTalon;
	private final int DRIVE = 0, TURN_LEFT = 1, TURN_RIGHT = 2;
	private final double SPEED = 0.6;
	
    public DriveForTime(int duration, int mode) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	frontLeftTalon = Hardware.INSTANCE.frontLeftTalon;
		frontRightTalon = Hardware.INSTANCE.frontRightTalon;
		backLeftTalon = Hardware.INSTANCE.backLeftTalon;
		backRightTalon = Hardware.INSTANCE.backRightTalon;
		
    	curMode = mode;
    	this.duration = (long) duration * (long) Math.pow(10, 9);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startTime = System.nanoTime();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	switch(curMode) {
    	case DRIVE:
    		frontLeftTalon.set(-SPEED);
			backLeftTalon.set(-SPEED);
			frontRightTalon.set(SPEED);
			backRightTalon.set(SPEED);
    		break;
    	case TURN_LEFT:
    		frontLeftTalon.set(SPEED);
			backLeftTalon.set(SPEED);
			frontRightTalon.set(SPEED);
			backRightTalon.set(SPEED);
    		break;
    	case TURN_RIGHT:
    		frontLeftTalon.set(-SPEED);
			backLeftTalon.set(-SPEED);
			frontRightTalon.set(-SPEED);
			backRightTalon.set(-SPEED);
    		break;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return System.nanoTime() - duration > startTime;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
