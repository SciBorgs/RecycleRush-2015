package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.Robot;

public class EncoderCommand extends Command{
	
	
	double TicksPerInch = 360/(/*wheelDiameter*/1 * Math.PI);//One inch in Ticks
	
	double LeftEncoderDistance, RightEncoderDistance, AvgDistance;//distance In inches
	
	protected void initialize(){
		//Starts all Encoders at 0
		Robot.hardware.leftEncoder.reset();
		Robot.hardware.rightEncoder.reset();
	}
	
	protected void excute(){
		//Calculates distance traveled in inches
		LeftEncoderDistance = Robot.hardware.leftEncoder.get()/TicksPerInch;
		RightEncoderDistance = Robot.hardware.rightEncoder.get()/TicksPerInch;
		AvgDistance = (LeftEncoderDistance + RightEncoderDistance)/2;
	}
	
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
}
