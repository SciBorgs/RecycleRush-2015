package org.usfirst.frc.team1155.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1155.robot.*;



//
//Written by Lucas
//
public class FastTurnCommand extends Command {

	private boolean isDone;
	//Not sure why we need these constants??
	private static final double ANGLE = 45;
	private static final double BUFFER = 5;
	private static final double MIN_SPEED = 0.5, MAX_SPEED = 1;

	private double fixedVal;
	private double startVal;
	
	//direction of turn
	boolean left;
	boolean right;
	
	public FastTurnCommand(boolean turnLeft) {
		if(turnLeft) {
			left = true;
		}else if(!turnLeft) {
			right = true;
		}
	}

	// Called just before this Command runs the first time
	@Override
    protected void initialize() {
		Robot.hardware.gyro.initGyro();
		setAngles();
    }

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
		
		
		if(!isDone) {
			if (left && getAngle() < fixedVal) {
				// turns robot 45 degrees to the left when left is true
				Robot.hardware.frontRightTalon.set(1);
				Robot.hardware.backRightTalon.set(1);
				Robot.hardware.frontLeftTalon.set(-1);
				Robot.hardware.backLeftTalon.set(-1);
			}
			// turns robot 45 degrees to the right when right is true
			if (right && getAngle() < (startVal + ANGLE)) {
				Robot.hardware.frontRightTalon.set(-1);
				Robot.hardware.backRightTalon.set(-1);
				Robot.hardware.frontLeftTalon.set(1);
				Robot.hardware.backLeftTalon.set(1);
			}
			else {
				isDone = true;
			}
		}

	}

	// sets angles to use in fast turn
	// fixes bad numbers from gyro
	public void setAngles() {
		startVal = (Robot.hardware.gyro.getAngle() >= 360) ? Robot.hardware.gyro
				.getAngle() % 360 : Robot.hardware.gyro.getAngle();
		fixedVal = (startVal - ANGLE < 0) ? startVal - ANGLE
				+ 360 : startVal - ANGLE;
	}

	public double getAngle() {
		return Robot.hardware.gyro.getAngle();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isDone;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}