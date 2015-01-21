package org.usfirst.frc.team1155.robot.subsystems;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Autonomous extends Subsystem {
	private CommandGroup[] routines = new CommandGroup[6];
	private int pick;
	
	public Autonomous(int routine) {
		for (int count = 0; count < 6; count++) {
			routines[count] = new CommandGroup();
		}
		//add sequential here
		//routines[0].addSequential();
		
		pick = routine;
	}
	
	public void start() {
		routines[pick].start();
	}
	
	public void end() {
		routines[pick].cancel();
	}
	
	@Override
	protected void initDefaultCommand() {}
}