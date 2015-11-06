
package org.usfirst.frc.team1155.robot;

import org.usfirst.frc.team1155.robot.commands.AutonomousGroup;
import org.usfirst.frc.team1155.robot.subsystems.Autonomous;
import org.usfirst.frc.team1155.robot.subsystems.Drive;
import org.usfirst.frc.team1155.robot.subsystems.Winch;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Ultrasonic;
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
    public static AutonomousGroup autonomous;
    public static SmartDashboard dash;
    
    int session;
    Image frame;
    AxisCamera camera;
    CameraServer server;
    String ip = "169.254.253.235";
    Ultrasonic ultrasonic;
	
    public void robotInit() {
    	
		winch = new Winch();
		drive = new Drive();
		oi = new OI();
		autonomous = new AutonomousGroup(2);
		
	    dash = new SmartDashboard();
	}
	
	public void disabledInit() {}
	
	public void disabledPeriodic() {}
	
	public void autonomousInit() {
		if(oi.isRunning()) oi.cancel();
		autonomous = new AutonomousGroup(0);
		autonomous.start();
		Hardware.INSTANCE.ultrasonic.setAutomaticMode(true);
	}
	
	public void autonomousPeriodic() {
		dash.putNumber("ENCODER", Robot.drive.getLeftPosition());
		Scheduler.getInstance().run();
		System.out.println(Hardware.INSTANCE.ultrasonic.getRangeInches());
	}
	
	public void teleopInit() {
		if(autonomous.isRunning()) autonomous.cancel();
		SmartDashboard dash = new SmartDashboard();
		dash.putString("String 1", "Teleop Initiated");
		oi.start();
	}
	
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
	
	public void testInit() {
	}
	
	public void testPeriodic() {		
		System.out.println(Hardware.INSTANCE.ultrasonic.getRangeInches());
	}
}