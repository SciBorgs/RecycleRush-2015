package org.usfirst.frc.team1155.robot;

import org.usfirst.frc.team1155.robot.commands.CalibrateWinch;
import org.usfirst.frc.team1155.robot.commands.ClawControl;
import org.usfirst.frc.team1155.robot.commands.JoystickDrive;
import org.usfirst.frc.team1155.robot.commands.MoveElevator;
import org.usfirst.frc.team1155.robot.commands.PositionElevator;
import org.usfirst.frc.team1155.robot.commands.ToggleCompressor;
import org.usfirst.frc.team1155.robot.subsystems.Winch;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI extends Command {
	
	private Joystick gamePad;
	private Button btnWinchPos1, btnWinchPos2, btnWinchPos3, btnWinchPos4, btnOpenClaw, btnCloseClaw, btnToggleCompressor, btnCalibrate;
	private Command joystickDrive, moveElevator, calibrator;
	
	public OI() {
	    gamePad = Hardware.INSTANCE.gamePad;
	    // Button button = new JoystickButton(stick, buttonNumber);
	    btnWinchPos1 = new JoystickButton(gamePad, 1);
	    btnWinchPos2 = new JoystickButton(gamePad, 2);
	    btnWinchPos3 = new JoystickButton(gamePad, 3);
	    btnWinchPos4 = new JoystickButton(gamePad, 4);
	    btnOpenClaw = new JoystickButton(gamePad, 5);
	    btnCloseClaw = new JoystickButton(gamePad, 6);
	    btnToggleCompressor = new JoystickButton(gamePad, 8);
	    
	    joystickDrive = new JoystickDrive();
	    moveElevator = new MoveElevator();
	    //calibrator = new CalibrateWinch();
	}
	
	protected void initialize() {
		//Start manual control of joystick and move
		joystickDrive.start();
		moveElevator.start();
        //calibrator.start();
		
		//Set the triggers to a command

//	    btnWinchPos1.whenPressed(new PositionElevator(Winch.TOTE_1));
//	    btnWinchPos2.whenPressed(new PositionElevator(Winch.TOTE_2));
//	    btnWinchPos3.whenPressed(new PositionElevator(Winch.TOTE_3));
//	    btnWinchPos4.whenPressed(new PositionElevator(Winch.TOTE_4));
		btnOpenClaw.whenPressed(new ClawControl(ClawControl.OPEN));
		btnCloseClaw.whenPressed(new ClawControl(ClawControl.CLOSE));
		btnToggleCompressor.whenPressed(new ToggleCompressor());
	}
	
	protected void execute() {
//		if(!moveElevator.isRunning() && gamePad.getPOV() != -1) {
//			moveElevator.start();
//		}
//		if(!calibrator.isRunning()) calibrator.start();
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
		joystickDrive.cancel();
		moveElevator.cancel();
		calibrator.cancel();
	}
	
	@Override
	protected void interrupted() {
		joystickDrive.cancel();
		moveElevator.cancel();
		calibrator.cancel();		
	}
	
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

