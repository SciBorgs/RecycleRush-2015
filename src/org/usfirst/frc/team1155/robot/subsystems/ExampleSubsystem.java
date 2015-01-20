
package org.usfirst.frc.team1155.robot.subsystems;

import org.usfirst.frc.team1155.robot.commands.ExampleCommand;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ExampleSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	ExampleCommand command;
	
	public ExampleSubsystem() {
		command = new ExampleCommand();
	}
	
    public void initDefaultCommand() {

    }
    
    public void goToHeight(int height) {
    	if(command.isRunning()) command.cancel();
    	command.start();
    }
}

