package org.usfirst.frc.team1155.robot.commands;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

//This is a command that can be used to move forward slightly
public class AccelerometerCommand extends Command{
	
    private double oldYAccel = 0;
    
    private double currentYAccel = 0;
    
    private double changeInYAccel = 0;
    
    private double oldTime = 0;
    private double currentTime = 0;
    private double changeInTime = 0;
    
    private double distance;
    
    private double speed;
    
    Timer timer;
	BuiltInAccelerometer accel;

	@Override
	protected void initialize() {
		accel = new BuiltInAccelerometer();
		timer = new Timer();
		timer.start();
	}

	@Override
	protected void execute() {
		oldTime = currentTime;
		
		oldYAccel = currentYAccel;
		
		currentYAccel = accel.getY();

		changeInYAccel = currentYAccel - oldYAccel;
		
		currentTime = timer.get();
		changeInTime = currentTime - oldTime;
		
		distance = changeInYAccel * changeInTime * changeInTime * 9.8; //In meters 
		speed = distance/changeInTime;
	}
	
	public double returnDistance() {
		return distance;
	}
	
	public double getXCoordinate() {
		return Math.cos(90-Robot.hardware.gyro.get()) * returnDistance();
	}
	
	public double getYCoordinate() {
		return Math.sin(90-Robot.hardware.gyro.get()) * returnDistance();
	}
	
	public double getX() {
		return accel.getX();
	}
	
	public double getY() {
		return accel.getY();
	}
	
	public double getZ() {
		return accel.getZ();
	}
	
	@Override
	protected void end() {
		
	}
	@Override
	protected void interrupted() {
		
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
}
