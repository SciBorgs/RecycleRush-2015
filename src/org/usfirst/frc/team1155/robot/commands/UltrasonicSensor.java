package org.usfirst.frc.team1155.robot.commands;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1155.robot.Robot;

public class UltrasonicSensor extends Command{

	private Ultrasonic rightUltrasonic, frontUltrasonic;
	
	public double leftDist = 0, rightDist = 0, frontDist = 0;
	
	public UltrasonicSensor() {
		rightUltrasonic = Robot.hardware.rightUltrasonic;
		//rightUltrasonic = Hardware.INSTANCE.rightUltrasonic;
		//frontUltrasonic = Hardware.INSTANCE.frontUltrasonic;
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		leftUltrasonic.setAutomaticMode(true);
		rightUltrasonic.setAutomaticMode(true);
		frontUltrasonic.setAutomaticMode(true);
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		if (leftUltrasonic.isRangeValid())
			leftDist = leftUltrasonic.getRangeInches();
		if (rightUltrasonic.isRangeValid())
			rightDist = rightUltrasonic.getRangeInches();
		if (frontUltrasonic.isRangeValid())
			frontDist = frontUltrasonic.getRangeInches();
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return (!leftUltrasonic.isEnabled() && !rightUltrasonic.isEnabled() && !frontUltrasonic.isEnabled());
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		leftUltrasonic.free();
		rightUltrasonic.free();
		frontUltrasonic.free();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
