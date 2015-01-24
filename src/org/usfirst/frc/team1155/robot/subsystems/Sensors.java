package org.usfirst.frc.team1155.robot.subsystems;

import org.usfirst.frc.team1155.robot.Hardware;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Sensors extends Subsystem{
	public Ultrasonic leftUltrasonic, rightUltrasonic, frontUltrasonic;
	
	public Sensors() {
		leftUltrasonic = Hardware.INSTANCE.leftUltrasonic;
		rightUltrasonic = Hardware.INSTANCE.rightUltrasonic;
		frontUltrasonic = Hardware.INSTANCE.frontUltrasonic;
	}
	
	
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	

}
