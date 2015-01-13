package roboticstest;

public class CANDrive {
    
    CANTalon frontLeftTalon = new CANTalon(1);
    CANTalon frontRightTalon = new CANTalon(2);
    CANTalon backLeftTalon = new CANTalon(3);
    CANTalon backRightTalon = new CANTalon(4);
    
    CANTalon testVertTalon = new CANTalon(5);
    CANTalon testHorzTalon = new CANTalon(6);
    
    Joystick leftJoy = new Joystick(1);
    Joystick rightJoy = new Joystick(2);
    
    double rightVal;
    double leftVal; 
    
    //public double horzSpeed = testHorzTalon.getSpeed();
    //public double vertSpeed = testVertTalon.getSpeed();
    
    //Gets value from left/right joysticks and sets to talons
    public void function(){
        
        //Getting values from each joystick
        rightVal = rightJoy.getY();
        leftVal = leftJoy.getY();
        
        //Setting values for left and right talons
        if(leftVal > 0.1 || leftVal < -0.1){
            frontRightTalon.set(leftVal);
            backRightTalon.set(leftVal);
        }
        else{
            frontRightTalon.set(0);
            backRightTalon.set(0);
        }
        if(rightVal > 0.1 || rightVal < -0.1){
            frontLeftTalon.set(-rightVal);
            backLeftTalon.set(-rightVal);
        }
        else{
            frontLeftTalon.set(0);
            backLeftTalon.set(0);
        }
    
    }
}
