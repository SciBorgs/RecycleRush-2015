package roboticstest;

public class GyroDrive {

    //Constant variables for ANGLE
    public static final double ANGLE = 45;
    public static final double BUFFER = 5;
    public static final double SPEED = 0.5;
    
    int leftButton = 1;
    int rightButton = 2;
    
    double gyroAngle;
    double fixedVal = 0;
    double startVal = 0;
    
    //Variables to be used in quick turning 
    private boolean isMoving = true; //Checks if robot is in motion (already turning)
    private double startVal = 0; //Will be changed to the current gyro angle

    Talon flTalon = new Talon(1);
    Talon frTalon = new Talon(2);
    Talon blTalon = new Talon(3);
    Talon brTalon = new Talon(4);

    Joystick lJoy = new Joystick(1);
    Joystick rJoy = new Joystick(2);

    Gyro gyro = new Gyro(1);

    //Starts everything
    public void start() {
        gyro.reset(); //Resets gyro value to 0
        super.start();
    }

    public void function() {
        if (!isMoving && lJoy.getRawButton(leftButton)) {
            getAngles();
            while (gyro.getAngle() < (fixedVal)) {
                frTalon.set(1);
                brTalon.set(1);
                flTalon.set(-1);
                blTalon.set(-1);
            }
        } else if (!isMoving && rJoy.getRawButton(rightButton)) {
            getAngles();
            while (gyro.getAngle() < (startVal + ANGLE)) {
                frTalon.set(-1);
                brTalon.set(-1);
                flTalon.set(1);
                blTalon.set(1);
            }
        }
    }
    
    private void getAngles() {
        gyroAngle = (gyro.getAngle() >= 360) ? gyro.getAngle() %= 360 : gyro.getAngle();
        startVal = gyroAngle;
        fixedVal = (startVal - ANGLE < 0) ? startVal - ANGLE + 360 : startVal - ANGLE;
    }
}
