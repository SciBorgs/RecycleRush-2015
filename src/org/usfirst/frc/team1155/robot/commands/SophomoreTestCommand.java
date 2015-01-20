package org.usfirst.frc.team1155.robot.commands;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

//This is a command that can be used to move forward slightly
public class SophomoreTestCommand extends Command{
	
    private double yVal;
    private double xVal;
    
    private double oldXAccel = 0;
    private double oldYAccel = 0;
    
    private double currentXAccel = 0;
    private double currentYAccel = 0;
    
    private double changeInXAccel = 0;
    private double changeInYAccel = 0;
    
    private double oldTime = 0;
    private double currentTime = 0;
    private double changeInTime = 0;
    
    private double xDisplacement;
    private double yDisplacement;
    
    Timer timer;
	BuiltInAccelerometer accel;

	@Override
	protected void initialize() {
		accel = new BuiltInAccelerometer();
		timer = new Timer();
	}

	@Override
	protected void execute() {
		oldTime = currentTime;
		timer.start();
		
		//gets the change in acceleration over the x axis after one tick
		oldXAccel = currentXAccel;
		oldYAccel = currentYAccel;
		
		currentXAccel = accel.getX();
		currentYAccel = accel.getY();
		
		changeInXAccel = currentXAccel - oldXAccel;
		changeInYAccel = currentYAccel - oldYAccel;
		
		xDisplacement = getDisplacement(changeInXAccel, changeInTime);
		yDisplacement = getDisplacement(changeInYAccel, changeInTime);

	    	currentTime = timer.get();
		changeInTime = currentTime - oldTime;
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
	
	private double getDisplacement (double changeInAccel, double changeInTime){
		changeInAccel *= 9.81;
		return 0.25 * (changeInAccel*changeInTime*changeInTime);
	}
}
//dereggs//
