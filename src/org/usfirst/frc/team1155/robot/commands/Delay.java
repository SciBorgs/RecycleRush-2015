package org.usfirst.frc.team1155.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class Delay extends Command {

	long delay;
	long startTime;
	public Delay(double d) {
		this.delay = (long) (d * (int) Math.pow(10, 9));
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		startTime = System.nanoTime();
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return startTime + delay < System.nanoTime();
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
