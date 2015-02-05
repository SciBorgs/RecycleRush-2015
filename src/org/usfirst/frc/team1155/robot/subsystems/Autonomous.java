package org.usfirst.frc.team1155.robot.subsystems;

import org.usfirst.frc.team1155.robot.Robot;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Autonomous extends Subsystem {
	private CommandGroup[] routines = new CommandGroup[6];
	private AnalogInput analogInput;
	
	private final double ERROR = 0.1;
	
	private int pick;
	
	public Autonomous() {
		analogInput = new AnalogInput(1);
		
		for (int count = 0; count < 6; count++) {
			routines[count] = new CommandGroup();
		}
		
		if(analogInput.getVoltage() < 4.45 + ERROR || analogInput.getVoltage() < 4.45 - ERROR){
			pick = 1;
		}else if(analogInput.getVoltage() < 3.9 + ERROR || analogInput.getVoltage() < 3.9 - ERROR) {
			pick = 2;
		}else if(analogInput.getVoltage() < 3.34 + ERROR || analogInput.getVoltage() < 3.34 - ERROR) {
			pick = 3;
		}else if(analogInput.getVoltage() < 2.77 + ERROR || analogInput.getVoltage() < 2.77 - ERROR) {
			pick = 4;
		}else if(analogInput.getVoltage() < 2.21 + ERROR || analogInput.getVoltage() < 2.21 - ERROR) {
			pick = 5;
		}else if(analogInput.getVoltage() < 1.66 + ERROR || analogInput.getVoltage() < 1.66 - ERROR) {
			pick = 6;
		}
	}
	
	public void start() {
		routines[pick].start();
	}
	
	public void end() {
		routines[pick].cancel();
	}
	
	@Override
	protected void initDefaultCommand() {
		pick = 1;
	}
}