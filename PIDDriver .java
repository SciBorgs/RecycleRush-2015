package roboticstest;

public class testTalonPID extends PIDController{

    Encoder pidEncoder = new Encoder(1, 2);
    CANTalon PIDTalon = new CANTalon(3);
    
    PIDController pid = new PIDController(1, 0, 0.5, pidEncoder, PIDTalon);

    private double proportion,  derivative, propError, deriError;
    /*
    kerr = setPoint - currentPoint
    proportion = constant * kerr
    derr = kerr - previousKerr
    derivative = constant * derr
    */
    private double k, setpoint;
    private boolean isEnabled = false;

    public void function (){
        if (isEnabled == true){
            proportion = pid.getP();
            differential = pid.getD();
        }
        propError = setpoint - proportion;
        proportion = k * propError;
        
        PIDTalon.pidWrite(pidEncoder.pidGet());
    }
    
    }
    public void toggle() {
        if (isEnabled)
            pid.disable();
        else
            pid.enable();
        isEnabled = !isEnabled;
    }
    
    
}
   
    //probably none of this actually works
    //derreggs
