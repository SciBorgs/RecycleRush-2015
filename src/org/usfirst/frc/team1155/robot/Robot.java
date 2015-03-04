
package org.usfirst.frc.team1155.robot;

import org.usfirst.frc.team1155.robot.commands.AutonomousGroup;
import org.usfirst.frc.team1155.robot.subsystems.Autonomous;
import org.usfirst.frc.team1155.robot.subsystems.Drive;
import org.usfirst.frc.team1155.robot.subsystems.Winch;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	
    public void robotInit() {
		winch = new Winch();
		drive = new Drive();
		oi = new OI();
		autonomous = new AutonomousGroup();
	}
	
	public void disabledInit() {}
	
	public void disabledPeriodic() {}
	
	public void autonomousInit() {
		autonomous.start();
	}
	
	public void autonomousPeriodic() {}
	
	public void teleopInit() {
		SmartDashboard dash = new SmartDashboard();
		dash.putString("String 1", "Teleop Initiated");
		oi.start();
	}
	
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
	
	public void testPeriodic() {}
}
