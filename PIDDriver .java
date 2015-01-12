package roboticstest;

public class testTalonPID extends PIDController{

    //instatiating electronics
    Encoder lPidEncoder = new Encoder(1, 2);
    Encoder rPidEncoder = new Encoder(1, 2);
    

    CANTalon frPIDTalon = new CANTalon(3);
    CANTalon flPIDTalon = new CANTalon(4);    
    CANTalon brPIDTalon = new CANTalon(5);
    CANTalon blPIDTalon = new CANTalon(6);
    
    PIDController rPid = new PIDController(1, 0, 0.5, rPidEncoder, frPIDTalon);
    PIDController lPid = new PIDController(1, 0, 0.5, lPidEncoder, flPIDTalon);


    Joystick rJoy = new Joystick(5);
    Joystick lJoy = new Joystick(6);

    public void initialize(){
        rPid.setContinuous(true);
        lPid.setContinuous(true);
    }
    
    public void function (){
        
        rPid.setSetpoint(rJoy.getY());
        lPid.setSetpoint(lJoy.getY());
        
        frPIDTalon.pidWrite(rPid.get());
        brPIDTalon.pidWrite(rPid.get());
        blPIDTalon.pidWrite(lPid.get());
        flPIDTalon.pidWrite(lPid.get());
    }
}
