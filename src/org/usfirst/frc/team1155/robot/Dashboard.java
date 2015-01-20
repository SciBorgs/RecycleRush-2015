package org.usfirst.frc.team1155.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard {
  public void initialize() {
    //declare hardware components to interact with --> moved to Hardware class later
    BuiltInAccelerometer accelerometer = new BuiltInAccelerometer();
    Gyro gyro = new Gyro();
    Ultrasonic sonic = new UltraSonic()
    
    //Hardware hardware = new Hardware();
    //getGyro, getUltrasonic --> return objects
    
    //RoboRIO builtin accelerometer
    SmartDashboard.putString("Accelerometer Data", new String(""));
    SmartDashboard.putNumber("X: ", accelerometer.getX());
    SmartDashboard.putNumber("Y: ", accelerometer.getY());
    SmartDashboard.putNumber("Z: ", accelerometer.getZ());
    
    //gyro angle
    SmartDashboard.putString("Gyro Data", new String(""));
    SmartDashboard.putNumber("Angle: ",gyro.getAngle());
    
    //ultrasonic
    SmartDashboard.putString("Ultrasonic Data", new String(""));
    SmartDashboard.putNumber("Distance",sonic.getDistanceUnits());
  }
}
