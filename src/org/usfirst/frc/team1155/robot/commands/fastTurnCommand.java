package org.usfirst.frc.team1155.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1155.robot.Robot;
//
/*Written by Lucas*/
//
//sensor subsytem may need name change once its actually written
//Joystick buttons not initialized 
//Buttons need to be set to rightButtonPressed & leftButtonPressed 

public class fastTurnCommand extends Command {
    //
    public boolean leftButtonPressed;
    public boolean rightButtonPressed;
    //^^Need to be set to a joybuton
    private boolean isDone = false;
    private static final double ANGLE = 45;
    private static final double BUFFER = 5;
    private static final double MIN_SPEED = 0.5, MAX_SPEED = 1;
    
    
    public fastTurnCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.sensorSubsystem);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    Robot.hardware.gyro.initGyro();
    setAngles();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
      if(leftButtonPressed && getAngle() < fixedVal){
      	//turns robot 45 degrees to the left when leftButtonPressed is true
			Robot.hardware.frontRightTalon.set(1); 
			Robot.hardware.backRightTalon.set(1);
			Robot.hardware.frontLeftTalon.set(-1);
			Robot.hardware.backLeftTalon.set(-1);
      }
      //turns robot 45 degrees to the right when rightButtonPressed is true
      if(rightButtonPressed && getAngle < (startVal + ANGLE)){
      			Robot.hardware.frontRightTalon.set(-1);
			Robot.hardware.backRightTalon.set(-1);
			Robot.hardware.frontLeftTalon.set(1);
			Robot.hardware.backLeftTalon.set(1);
      }
    	
      else if (!(getAngle() < (startVal + ANGLE)) && !(getAngle() < fixedVal)){
      	isFinished(true);
      }	
    }
    
    //sets angles to use in fast turn 
    //fixes bad numbers from gyro
    public void setAngles(){
    startVal = (Robot.hardware.gyro.getAngle() >= 360) ? Robot.hardware.gyro.getAngle() % 360 : Robot.hardware.gyro.getAngle();
    fixedVal = (startVal - ANGLE < 0) ? startVal - ANGLE + 360 : startVal - ANGLE;
    }
    
    public double getAngle(){
    Robot.hardware.gyro.getAngle();
    }
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished(isDone) {
        return isDone;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
