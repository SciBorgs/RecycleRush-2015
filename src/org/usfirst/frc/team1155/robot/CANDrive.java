package org.usfirst.frc.team1155.robot;

import edu.wpi.first.wpilibj.*;

public class CANDrive {
	
	//speeds that will be set by setSpeed()
	private double leftSpeed, rightSpeed;
    
    //method to set speed values
    public void setSpeed(double leftVal, double rightVal) {
    	leftSpeed = leftVal; //speed to set to the left talons
    	rightSpeed = rightVal; //spped to set to the right talons
    	
    	//sets the speed relative to joystick position
    	//uses 0.1 as a buffer in case the joystick moves very slightly
    	if(leftSpeed > 0.1 || leftSpeed < -0.1){
    		//sets talons to input speed
            Robot.hardware.frontLeftTalon.set(leftSpeed);
            Robot.hardware.backLeftTalon.set(leftSpeed);
        }
        else{
            Robot.hardware.frontLeftTalon.set(0);
            Robot.hardware.backLeftTalon.set(0);
        }
        if(rightSpeed > 0.1 || rightSpeed < -0.1){
            Robot.hardware.frontRightTalon.set(-rightSpeed);
            Robot.hardware.backRightTalon.set(-rightSpeed);
        }
        else{
            Robot.hardware.frontRightTalon.set(0);
            Robot.hardware.backRightTalon.set(0);
        }	
    }
    
    public double getLeftSpeed() {
    	return leftSpeed; //returns the current left talon values
    }
    
    public double getRightSpeed() {
    	return rightSpeed; //returns the current right talon values
    }
}
