package org.usfirst.frc.team1155.robot;

import edu.wpi.first.wpilibj.*;

public class PIDDriver {

    PIDController rightPid = new PIDController(1, 0, 0.5, Robot.hardware.rightEncoder, Robot.hardware.frontRightTalon);
    PIDController leftPid = new PIDController(1, 0, 0.5, Robot.hardware.leftEncoder, Robot.hardware.frontLeftTalon);


    public void initialize(){
        rightPid.setContinuous(true);
        leftPid.setContinuous(true);
    }
    
    public void function (){     
        rightPid.setSetpoint(Robot.hardware.rightJoy.getY());
        leftPid.setSetpoint(Robot.hardware.leftJoy.getY());
        
        Robot.hardware.frontRightTalon.pidWrite(rightPid.get());
        Robot.hardware.backRightTalon.pidWrite(rightPid.get());
        Robot.hardware.frontLeftTalon.pidWrite(leftPid.get());
        Robot.hardware.backLeftTalon.pidWrite(leftPid.get());
    }
}
