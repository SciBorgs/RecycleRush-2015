
package org.usfirst.frc.team1155.robot;

import org.usfirst.frc.team1155.robot.commands.AutonomousGroup;
import org.usfirst.frc.team1155.robot.subsystems.Autonomous;
import org.usfirst.frc.team1155.robot.subsystems.Drive;
import org.usfirst.frc.team1155.robot.subsystems.Winch;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.AxisCamera;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

public class Robot extends IterativeRobot {
	public static Drive drive;
    public static Winch winch;
    public static Command oi;
    public static CommandGroup autonomous;
    
    int session;
    Image frame;
    AxisCamera camera;
    String ip = "insertIPhere";
    DigitalInput ultrasonicIn = Hardware.INSTANCE.ultrasonicIn;
    DigitalOutput ultrasonicOut = Hardware.INSTANCE.ultrasonicOut;
	
    public void robotInit() {
		winch = new Winch();
		drive = new Drive();
		oi = new OI();
		autonomous = new AutonomousGroup(0);
//		camera = new AxisCamera(ip);
//		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
	}
	
	public void disabledInit() {}
	
	public void disabledPeriodic() {}
	
	public void autonomousInit() {
		autonomous.start();
	}
	
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}
	
	public void teleopInit() {
		SmartDashboard dash = new SmartDashboard();
		dash.putString("String 1", "Teleop Initiated");
		oi.start();
	}
	
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		camera.getImage(frame);
        CameraServer.getInstance().setImage(frame);
	}
	
	public void testPeriodic() {
		ultrasonicOut.set(false);
		Timer.delay(0.002);
		ultrasonicOut.set(true);
		Timer.delay(0.005);
		ultrasonicOut.set(false);
		
		while(!ultrasonicIn.get()){
		}
		long startTime = System.nanoTime();
		while(ultrasonicIn.get()) {
		}
		long endTime = System.nanoTime();

		long duration = (endTime - startTime);
		
	}
}