package org.usfirst.frc.team1155.robot;

import edu.wpi.first.wpilibj.*;

public class PIDDriver {
	//creates pid controller for right and left wheels 
    PIDController rightPid = new PIDController(1, 0, 0.5, Robot.hardware.rightEncoder, Robot.hardware.frontRightTalon); 
    PIDController leftPid = new PIDController(1, 0, 0.5, Robot.hardware.leftEncoder, Robot.hardware.frontLeftTalon);


    public void initialize(){
    	//Sets the pids to constantly check for input
        rightPid.setContinuous(true);
        leftPid.setContinuous(true);
    }
    
    public void function (){     
        //Sets the setpoint equal to the joystick value
    	rightPid.setSetpoint(Robot.hardware.rightJoy.getY());
        leftPid.setSetpoint(Robot.hardware.leftJoy.getY());
        
        //writes the pid values to the Talons
        Robot.hardware.frontRightTalon.pidWrite(rightPid.get());
        Robot.hardware.backRightTalon.pidWrite(rightPid.get());
        Robot.hardware.frontLeftTalon.pidWrite(leftPid.get());
        Robot.hardware.backLeftTalon.pidWrite(leftPid.get());
    }
}
