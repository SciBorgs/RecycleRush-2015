package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class EncoderCommand extends Command{
	
	
	double TicksPerInch = 360/(/*wheelDiameter*/1 * Math.PI);//One inch in Ticks
	
	double LeftEncoderDistance, RightEncoderDistance, AvgDistance;//distance In inches
	
	@Override
	protected void initialize(){
		//Starts all Encoders at 0
		Robot.hardware.leftEncoder.reset();
		Robot.hardware.rightEncoder.reset();
	}
	
	@Override
	protected void execute(){
		//Calculates distance traveled in inches
		LeftEncoderDistance = Robot.hardware.leftEncoder.get()/TicksPerInch;
		RightEncoderDistance = Robot.hardware.rightEncoder.get()/TicksPerInch;
		AvgDistance = (LeftEncoderDistance + RightEncoderDistance)/2;
	}
	
	@Override
	protected void end(){
		
	}
	
	//All Distance is calculated is in Inches
	public double DistanceTraveledWithLeftEncoder(){
		return LeftEncoderDistance;
	}
	
	public double DistanceTraveledWithRightEncoder(){
		return RightEncoderDistance;
	}
	
	public double AvgDistanceTraveled(){
		return AvgDistance;
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
}
