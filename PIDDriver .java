package roboticstest;

public class testTalonPID extends PIDController{

    Encoder pidEncoder = new Encoder(1, 2);
    CANTalon PIDTalon = new CANTalon(3);
    PIDController pid = new PIDController(1, 1, 1, pidEncoder, PIDTalon);

    public function (){
        
    }

    // CANTalon liftClaw = new CANTalon(1);
    
    // public liftClaw {
    //   super("ClawLift", 2.0, 0.0, 0.0);
    //   setAbsoluteTolerance(0.05);
    //   getPIDController().setContinuous(false);
    // }
    
}
   
    //probably none of this actually works
