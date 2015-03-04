package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.Hardware;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClawControl extends Command {

	public static final int OPEN = 0, CLOSE = 1;
	private DoubleSolenoid clawSolenoid;
	private DoubleSolenoid.Value positionGoal;
	
    public ClawControl(int value) {
    	clawSolenoid = Hardware.INSTANCE.clawSolenoid;
    	this.positionGoal = (value == OPEN) ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	clawSolenoid.set(positionGoal);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return clawSolenoid.get() == positionGoal;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
