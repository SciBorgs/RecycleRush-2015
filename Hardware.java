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
  public static DoubleSolenoid clawSol;
  
  //miscellaneous
  public static Compressor compressor;
  
  //driver station
  public static DriverStationLCD dLCD;

  public Hardware(){
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
    
    //miscellaneous
    compressor = new Compressor(7); //device CAN pcm ID numbers subject to change
    
    public void initialize() {
      leftArmTalon.setFeedbackDevice(armEncoder);
      rightArmTalon.setFeedbackDevice(armEncoder);
    }
  }
}
