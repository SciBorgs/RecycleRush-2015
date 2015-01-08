package roboticstest;

public class testTalonPID extends PIDController{

    CANTalon liftClaw = new CANTalon(1);
    
    public liftClaw {
      super("ClawLift", 2.0, 0.0, 0.0);
      setAbsoluteTolerance(0.05);
      getPIDController().setContinuous(false);
    }
    
    
   
    //probably none of this actually works
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //victor motor...lol
