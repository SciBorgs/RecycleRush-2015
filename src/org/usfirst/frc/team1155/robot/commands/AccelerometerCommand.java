package org.usfirst.frc.team1155.robot.commands;


import org.usfirst.frc.team1155.robot.Robot;

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
    private double totalDistance;
    
    private double speed;
    
    private double initAngle;
    private double currentAngle;
    
    Timer timer;
	BuiltInAccelerometer accel;

	@Override
	protected void initialize() {
		accel = new BuiltInAccelerometer();
		timer = new Timer();
		timer.start();
		distance = totalDistance = 0;
	}
	//This method waits until the robot stops turning and then returns 'initAngle'
	public double getInitAngle(){
		while(Robot.hardware.gyro.getRate() != 0){
			initAngle = Robot.hardware.gyro.getAngle();
		}
		return initAngle;
	}
	
	/*Updates 'currentAngle'until the robot moves straight or stops then returns the value
	public double getCurrAngle(){
		while(accel.getX() == 0){
			currentAngle = Robot.hardware.gyro.getAngle();
			//new rotated angle = getAngle - current angle
		}
		return currentAngle;
	}*/
	
	@Override
	protected void execute() {
		oldTime = currentTime;
				
		oldYAccel = currentYAccel;
		
		currentYAccel = accel.getY();

		changeInYAccel = currentYAccel - oldYAccel;
		
	    currentTime = timer.get();
		changeInTime = currentTime - oldTime;
		
		distance = changeInYAccel * changeInTime * changeInTime * 9.81;
		totalDistance += distance;
		
		speed = distance/changeInTime;
	}
	
	public void resetTotalDistance() {
		totalDistance = 0;
	}
	
	public double returnDistance() {
		return distance;
	}
	
	public double returnTotalDistance() {
		return totalDistance;
	}
	
	public double getXCoordinate() {
		return Math.sin(getInitAngle()) * distance;
	}
	
	public double getYCoordinate() {
		return Math.cos(getInitAngle()) * distance;
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
	
/*
	public double getInitAngle(){
		return Robot.hardware.gyro.getAngle();
		
	}
*/
		
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
