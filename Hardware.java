public class Hardware {
  
  //drive chassis
  public static Talon frontRightTalon;
  public static Talon frontLeftTalon;
  public static Talon backRightTalon;
  public static Talon backLeftTalon;
  public static Encoder leftEncoder;
  public static Encoder rightEncoder;
  
  //claw
  public static Talon leftArmTalon;
  public static Talon rightArmTalon;
  public static Encoder armEncoder;
  public static Solenoid clawSol;
  
  //driver station
  public static DriverStationLCD dLCD;

  public Hardware(){
    //drive chassis hardware
    frontLeftTalon = new Talon(1); //front left drive - channel 1
    backLeftTalon = new Talon(2); //back left drive talon - channel 2
    frontRightTalon = new Talon(9); //front right drive talon - channel 9
    backRightTalon = new Talon(10); //back right drive talon - channel 10
    
    //claw hardware
    leftArmTalon = new Talon(5); //left arm talon - channel 5
    rightArmTalon = new Talon(6); //right arm talon - channel 6
  
    
  }
}
