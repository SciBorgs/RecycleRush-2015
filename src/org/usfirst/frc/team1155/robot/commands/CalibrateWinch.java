package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.Hardware;
import org.usfirst.frc.team1155.robot.Robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CalibrateWinch extends Command {

	CANTalon mainTalon, assistTalon;
	DigitalInput calibrationSwitch;
	
    public CalibrateWinch() {
        calibrationSwitch = Hardware.INSTANCE.bottomLimitSwitch; 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println(calibrationSwitch.get());
    	if(!calibrationSwitch.get() && Robot.winch.getPosition() < 10) {
    		Robot.winch.setPosition(0);
    		System.out.println("Calibrated");
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
