package org.usfirst.frc.team1155.robot.commands;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

//This is a command that can be used to move forward slightly
public class SophomoreTestCommand extends Command{
	
    private double yVal;
    private double xVal;
    
    private double oldAccel = 0;
    private double currentAccel = 0;
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
		oldAccel = currentAccel;
		currentAccel = accel.getX();
		changeInXAccel = currentAccel - oldAccel;
		
		xDisplacement = getDisplacement(changeInXAccel, changeInTime);
		
		//gets the change in acceleration over the y axis after one tick
		oldAccel = currentAccel;
		currentAccel = accel.getY();
		changeInYAccel = currentAccel - oldAccel;
		
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
