package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.Hardware;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleCompressor extends Command {
	
	Compressor compressor;
	boolean stateGoal;

    public ToggleCompressor() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	compressor = Hardware.INSTANCE.compressor;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	stateGoal = !compressor.enabled();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(stateGoal) compressor.start();
    	else compressor.stop();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return stateGoal == compressor.enabled();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
