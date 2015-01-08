package roboticstest;

public class CANDrive {
    CANTalon frontLeftTalon = new CANTalon(1);
    CANTalon frontRightTalon = new CANTalon(2);
    CANTalon backLeftTalon = new CANTalon(3);
    CANTalon backRightTalon = new CANTalon(4);

    Joystick leftJoy = new Joystick(1);
    Joystick rightJoy = new Joystick(2);
    
    rightVal = Hardware.rightJoy.getY();
    leftVal = Hardware.leftJoy.getY();
    
    public void function(){
    
      if(leftVal > 0.1 || leftVal < -0.1){
            Hardware.frontRightTalon.set(leftVal);
            Hardware.backRightTalon.set(leftVal);
        }else{
            Hardware.frontRightTalon.set(0);
            Hardware.backRightTalon.set(0);
        }
        //same deal but for right joystick
        if(rightVal > 0.1 || rightVal < -0.1){
            Hardware.frontLeftTalon.set(-rightVal);
            Hardware.backLeftTalon.set(-rightVal);
        }else{
            Hardware.frontLeftTalon.set(0);
            Hardware.backLeftTalon.set(0);
        }
    
    }
}
