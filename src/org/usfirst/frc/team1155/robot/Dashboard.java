package org.usfirst.frc.team1155.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard {
  public void initialize() {
    //declare hardware components to interact with --> moved to Hardware class later
    AccelerometerCommand command = new AccelerometerCommand();
    Gyro gyro = new Gyro();
    Ultrasonic sonic = new UltraSonic()
    
    //Hardware hardware = new Hardware();
    //getGyro, getUltrasonic --> return objects
    
    //RoboRIO builtin accelerometer
    SmartDashboard.putString("Accelerometer Data", new String(""));
    SmartDashboard.putNumber("X: ", command.getX());
    SmartDashboard.putNumber("Y: ", command.getY());
    SmartDashboard.putNumber("Z: ", command.getZ());
    SmartDashboard.putNumber("Distance: ", command.returnDistance());
    
    //gyro angle
    SmartDashboard.putString("Gyro Data", new String(""));
    SmartDashboard.putNumber("Angle: ",gyro.getAngle());
    
    //ultrasonic
    SmartDashboard.putString("Ultrasonic Data", new String(""));
    SmartDashboard.putNumber("Distance",sonic.getDistanceUnits());
  }
}
