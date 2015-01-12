public class RoboRIOAccelerometer {
  public BuiltInAccelerometer accelerometer = new BuiltInAccelerometer();
  public double x, y, z;
  
  public void function() {
    x = accelerometer.getX();
    y = accelerometer.getY();
    z = accelerometer.getZ();
  }
}
