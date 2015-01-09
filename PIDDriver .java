package roboticstest;

public class testTalonPID extends PIDController{

    Encoder pidEncoder = new Encoder(1, 2);
    CANTalon PIDTalon = new CANTalon(3);
    
    PIDController pid = new PIDController(1, 0, 0.5, pidEncoder, PIDTalon);

    private double proportion,  differential;
    
    private boolean isEnabled = false;

    public void function (){
        if (isEnabled == true){
            proportion = pid.getP();
            differential = pid.getD();
        }
        
        PIDTalon.pidWrite(pidEncoder.pidGet());
    }
    
    public void toggle() {
        isEnabled = !isEnabled;
    }

    
    
}
   
    //probably none of this actually works
