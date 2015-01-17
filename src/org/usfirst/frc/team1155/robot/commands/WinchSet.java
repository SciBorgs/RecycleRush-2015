package org.usfirst.frc.team1155.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team1155.robot.Robot;
import org.usfirst.frc.team1155.robot.subsystems.ExampleSubsystem;

public class WinchSet extends Command {
	//constants
	private final double BUFFER = 10; //change number to actual value later
	
	//fields
	private double targetHeight;
	private double currentHeight; //create relationship between encoder and currentheight (is radius changing?)
	private boolean completed;
	
    public WinchSet(Subsystem owner) {
        // Use requires() here to declare subsystem dependencies
        requires(owner);
    }
    
    public void setTargetHeight(double height) {
    	this.targetHeight = height;
    	this.execute();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Math.abs(currentHeight - targetHeight) <= BUFFER) {
    		completed = false;
    		//add logic later
    	}
	    else {
	    	completed = true;
	    	cancel();
	    }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return completed;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
