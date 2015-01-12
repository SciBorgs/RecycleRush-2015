public class Dashboard {
  public void initialize() {
    //declare software interfaces
    
    //RoboRIO builtin accelerometer
    private BuiltInAccelerometer accelerometer = new BuiltInAccelerometer();
    SmartDashboard.putNumber("X: ", accelerometer.getX());
    SmartDashboard.putNumber("Y: ", accelerometer.getY());
    SmartDashboard.putNumber("Z: ", accelerometer.getZ());
  }
}
