package org.usfirst.frc.team1155.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard {
  public void initialize() {
    //declare hardware components to interact with --> moved to Hardware class later
    BuiltInAccelerometer accelerometer = new BuiltInAccelerometer();
    
    //RoboRIO builtin accelerometer
    SmartDashboard.putNumber("X: ", accelerometer.getX());
    SmartDashboard.putNumber("Y: ", accelerometer.getY());
    SmartDashboard.putNumber("Z: ", accelerometer.getZ());
  }
}
