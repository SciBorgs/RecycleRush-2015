package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ClawSet extends Command {
	private boolean open;
	
	public ClawSet(Subsystem owner, boolean o) {
		requires(owner);
		open = o;
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.hardware.clawSolenoid.set(open);
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	
}
