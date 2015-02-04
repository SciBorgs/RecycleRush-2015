package org.usfirst.frc.team1155.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


public enum Hardware {
  
	INSTANCE;
	
  //drive chassis
  public CANTalon frontRightTalon;
  public CANTalon frontLeftTalon;
  public CANTalon backRightTalon;
  public CANTalon backLeftTalon;
  public Encoder leftEncoder;
  public Encoder rightEncoder;
  public Ultrasonic leftUltrasonic, rightUltrasonic, frontUltrasonic;
  
  //claw
  public CANTalon leftArmTalon;
  public CANTalon rightArmTalon;
  public Encoder armEncoder;
  public DoubleSolenoid clawSol;
  
  //miscellaneous
  public Compressor compressor;
  
  //driver station
  public DriverStation dLCD;
  
  public Joystick leftJoy, rightJoy;
  
  public Button leftFastTurn = new JoystickButton(leftJoy, 1);
  public Button rightFastTurn = new JoystickButton(rightJoy, 1);
  
  public Gyro gyro;
  
  public AnalogInput[] analogInput = new AnalogInput[6];
  
  Hardware(){
    //drive chassis hardware
    frontLeftTalon = new CANTalon(1); //device CAN pcm ID numbers subject to change
    frontRightTalon = new CANTalon(2);
    backLeftTalon = new CANTalon(3); 
    backRightTalon = new CANTalon(4); 
    
    //claw hardware
    leftArmTalon = new CANTalon(5); 
    rightArmTalon = new CANTalon(6);
    armEncoder = new Encoder(1, 2); //channels subject to change to accomodate CAN
    clawSol = new DoubleSolenoid(1, 2); //channels subject to change to accomodate CAN
    
    leftJoy = new Joystick(1);
    rightJoy = new Joystick(2);
    
    //miscellaneous
    compressor = new Compressor(7); //device CAN pcm ID numbers subject to change
    
    gyro = new Gyro(1);
    
    
    
    /*public void intialize() {
      leftArmTalon.setFeedbackDevice(armEncoder);
      rightArmTalon.setFeedbackDevice(armEncoder);
    }*/
  }
}
