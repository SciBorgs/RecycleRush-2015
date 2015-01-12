public class Dashboard {
  public void initialize() {
    //declare hardware components to interact with --> moved to Hardware class later
    public BuiltInAccelerometer accelerometer = new BuiltInAccelerometer();
    
    //RoboRIO builtin accelerometer
    SmartDashboard.putNumber("X: ", accelerometer.getX());
    SmartDashboard.putNumber("Y: ", accelerometer.getY());
    SmartDashboard.putNumber("Z: ", accelerometer.getZ());
  }
}
