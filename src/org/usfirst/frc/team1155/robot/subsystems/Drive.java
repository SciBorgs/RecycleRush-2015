package org.usfirst.frc.team1155.robot.subsystems;

import org.usfirst.frc.team1155.robot.commands.DriveSet;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Drive extends Subsystem {
	DriveSet driveCommand;
	public Drive() {
		driveCommand = new DriveSet(this);
	}
	
	
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	
}
