package org.usfirst.frc.team1155.robot;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.ITableListener;

public class Dashboard extends Command {
	BuiltInAccelerometer accel;
	SmartDashboard dash;
	SendableChooser accelval;
  public void initialize() {
    //declare hardware components to interact with --> moved to Hardware class later
    
    //Hardware hardware = new Hardware();
    //getGyro, getUltrasonic --> return objects
    
    //RoboRIO builtin accelerometer
    
    accelval = new SendableChooser();
	dash = new SmartDashboard();
    accel = new BuiltInAccelerometer();
    ITable t;
    ITableListener l;
    t.addSubTableListener(l);
    //SendableChooser.initTable(t);
  }

@Override
protected void execute() {
	dash.putNumber("X-Value", accel.getX());
	dash.putNumber("Y-Value", accel.getY());
	dash.putNumber("Z-Value", accel.getZ());
}

@Override
protected boolean isFinished() {
	// TODO Auto-generated method stub
	return false;
}

@Override
protected void end() {
	// TODO Auto-generated method stub
	
}

@Override
protected void interrupted() {
	// TODO Auto-generated method stub
	
}
}
