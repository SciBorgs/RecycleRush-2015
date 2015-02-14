package org.usfirst.frc.team1155.robot.commands;



import org.usfirst.frc.team1155.robot.*;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Command;

public class UltrasonicSensor extends Command{

	private Ultrasonic rightUltrasonic, leftUltrasonic, frontUltrasonic;
	
	private double leftDist = 0, rightDist = 0, frontDist = 0;
	
	public UltrasonicSensor() {
		rightUltrasonic = Hardware.INSTANCE.leftUltrasonic;
		leftUltrasonic = Hardware.INSTANCE.leftUltrasonic;
		frontUltrasonic = Hardware.INSTANCE.frontUltrasonic;
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
	
	
	public double getLeftDist() {
		return leftDist;
	}
	
	public double getRightDist() {
		return leftDist;
	}

	public double getFrontDist() {
		return leftDist;
	}


	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
