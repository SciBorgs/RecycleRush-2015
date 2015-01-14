public class Hardware {
  
  //drive chassis
  public static CANTalon frontRightTalon;
  public static CANTalon frontLeftTalon;
  public static CANTalon backRightTalon;
  public static CANTalon backLeftTalon;
  public static Encoder leftEncoder;
  public static Encoder rightEncoder;
  
  //claw
  public static CANTalon leftArmTalon;
  public static CANTalon rightArmTalon;
  public static Encoder armEncoder;
  public static Solenoid clawSol;
  
  //driver station
  public static DriverStationLCD dLCD;

  public Hardware(){
    //drive chassis hardware
    frontLeftTalon = new CANTalon(1); //device ID numbers subject to change
    frontRightTalon = new CANTalon(2); 
    backLeftTalon = new CANTalon(3); 
    backRightTalon = new CANTalon(4); 
    
    //claw hardware
    leftArmTalon = new Talon(5); 
    rightArmTalon = new Talon(6);
  
    
  }
}
