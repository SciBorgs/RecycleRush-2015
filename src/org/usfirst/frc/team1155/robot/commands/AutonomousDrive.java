package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.Hardware;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousDrive extends Command {
	private final double SPACE_BETWEEN = 6;
	private CANTalon frontLeftTalon, frontRightTalon, backLeftTalon, backRightTalon;
	private Ultrasonic leftUltrasonic, rightUltrasonic; 
	private double horizontal, distance, angle, left, right, encRight, encLeft;
	private boolean turnRight;
	
    public AutonomousDrive() {
    	frontLeftTalon = Hardware.INSTANCE.frontLeftTalon;
		frontRightTalon = Hardware.INSTANCE.frontRightTalon;
		backLeftTalon = Hardware.INSTANCE.backLeftTalon;
		backRightTalon = Hardware.INSTANCE.backRightTalon;
		
		leftUltrasonic = Hardware.INSTANCE.leftUltrasonic;
		rightUltrasonic = Hardware.INSTANCE.rightUltrasonic;
    }

    // Called just before this Command runs the first time
    protected void initialize() {frontLeftTalon.set(0);
		frontRightTalon.set(0);
		backLeftTalon.set(0);
		backRightTalon.set(0);
		backRightTalon.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
    	
		frontRightTalon.changeControlMode(ControlMode.Position);
		frontLeftTalon.changeControlMode(ControlMode.Position);
		backRightTalon.changeControlMode(ControlMode.Follower);
		backLeftTalon.changeControlMode(ControlMode.Follower);
		
		leftUltrasonic.setEnabled(true);
    	
    	leftUltrasonic.ping();
    	rightUltrasonic.ping();
    	
    	distance = getDistance();
    	angle = 180 - angle;
    	
    	encRight = frontRightTalon.getEncPosition();
    	encLeft = frontLeftTalon.getEncPosition();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(left != right) {
    		turn(90);
    		move(horizontal);
    	}
    	turn(angle);
    	move(distance);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return distance == 0;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    private double getDistance() {
    	distance = leftUltrasonic.getRangeInches();
    	return distance;
    }
    
    private void turn(double a) {
    	double diff = a; //Convert angle to encoder change
    	
    	frontRightTalon.changeControlMode(ControlMode.Speed);
    	frontLeftTalon.changeControlMode(ControlMode.Speed);
    	
    	if(turnRight) {
    		if(frontRightTalon.getEncPosition() != encRight + diff && frontLeftTalon.getEncPosition() != encLeft - diff) {
    			frontRightTalon.set(1);
    			frontLeftTalon.set(-1);
    		}
    		else {
    			frontRightTalon.set(0);
    			frontLeftTalon.set(0);
    		}
    		
    	}
    	else {
    		if(frontRightTalon.getEncPosition() != encRight - diff && frontLeftTalon.getEncPosition() != encLeft + diff) {
    			frontRightTalon.set(-1);
    			frontLeftTalon.set(1);
    		}
    		else {
    			frontRightTalon.set(0);
    			frontLeftTalon.set(0);
    		}
    	}
    }
    
    private void move(double d) {
    	
    	frontRightTalon.changeControlMode(ControlMode.Position);
    	frontLeftTalon.changeControlMode(ControlMode.Position);
    	
    	
    }
    
}
