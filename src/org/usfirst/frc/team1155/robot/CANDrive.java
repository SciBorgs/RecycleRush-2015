package org.usfirst.frc.team1155.robot;

import edu.wpi.first.wpilibj.*;

public class CANDrive {
	
	//speeds that will be set by setSpeed()
	private double leftSpeed, rightSpeed;
    
    //method to set speed values
    public void setSpeed(double leftVal, double rightVal) {
    	leftSpeed = leftVal;
    	rightSpeed = rightVal;
    	if(leftSpeed > 0.1 || leftSpeed < -0.1){
            Robot.hardware.frontRightTalon.set(leftSpeed);
            Robot.hardware.backRightTalon.set(leftSpeed);
        }
        else{
            Robot.hardware.frontRightTalon.set(0);
            Robot.hardware.backRightTalon.set(0);
        }
        if(rightSpeed > 0.1 || rightSpeed < -0.1){
            Robot.hardware.frontLeftTalon.set(-rightSpeed);
            Robot.hardware.backLeftTalon.set(-rightSpeed);
        }
        else{
            Robot.hardware.frontLeftTalon.set(0);
            Robot.hardware.backLeftTalon.set(0);
        }	
    }
    
    public double getLeftSpeed() {
    	return leftSpeed; //returns the current left talon values
    }
    
    public double getRightSpeed() {
    	return rightSpeed; //returns the current right talon values
    }
}
