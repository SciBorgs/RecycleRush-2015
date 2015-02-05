package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.Hardware;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;

public class OpenClaw extends Command {
	private Solenoid clawSolenoid;
	public OpenClaw() {
		clawSolenoid = Hardware.INSTANCE.clawSol;
	}
	
	@Override
	protected void initialize() {
		clawSolenoid.set(true);
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub		
	}

	@Override
	protected boolean isFinished() {
		return !clawSolenoid.get();
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
