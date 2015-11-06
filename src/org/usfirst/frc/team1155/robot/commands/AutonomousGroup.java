package org.usfirst.frc.team1155.robot.commands;



import org.usfirst.frc.team1155.robot.Hardware;
import org.usfirst.frc.team1155.robot.Robot;
import org.usfirst.frc.team1155.robot.subsystems.Winch;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousGroup extends CommandGroup {
	
	private CommandGroup alignTote;
	private final double DISTANCE_FOR_TURN = 1100, BACKUP_DISTANCE = 0,
			DISTANCE_TO_AUTOZONE = 6000; //Encoder ticks
	private final double TIME_TO_AUTOZONE = 3.25;  //Seconds
	private final double CLAW_CLEARANCE_DISTANCE = 18, TOTE_DISTANCE_BEFORE_GAP = 11.5, PULL_UP_DISTANCE = 14,
			TOTE_DISTANCE_IN_GAP = 12; //Inches
	private final double voltageRange = 0;
	
    public AutonomousGroup(int mode) {
    	alignTote = new CommandGroup();
    	alignTote.addSequential(new ClawControl(ClawControl.CLOSE));
    	alignTote.addSequential(new ClawControl(ClawControl.OPEN));
    	
    	switch(getRoutine()) {
    	case 1:
    		driveToAutozone();
    		break;
    	case 2:
    		toteToAutozone();
    		break;
    	case 3:
    		binToAutozone(true);
    		break;
    	case 4:
    		binAndToteToAutozone();
    		break;
    	case 5:
    		threeTotesToAutozone();
    		break;
    	case 6:
    		binAndThreeTotesToAutozone();
    		break;
    	case 7:
    		testRoutine1();
    		break;
    	case 8:
    		testRoutine2();
//    		binToAutozone(false);
    		break;
    	}
    }
    
    public int getRoutine() {
		double voltage = Hardware.INSTANCE.autoSwitch.getVoltage();
		return (int) Math.floor((-20.0 / 11.0) * voltage + 9.5);
    }
    
    public void testRoutine1() {
    	addSequential(new Delay(7));
    	//First tote
    	addSequential(new ClawControl(ClawControl.CLOSE));  //Close on tote
    	addSequential(new Delay(0.3));
    	addParallel(new PositionElevator(3000));  //Lift the tote
    	addSequential(new Delay(0.3));
    	//Go to second
    	addSequential(new UltrasonicDrive(PULL_UP_DISTANCE, false));
    	addSequential(new Delay(0.3));
    	addParallel(new PositionElevator(Winch.TOTE_2 - Winch.TOTE_MID));
    	addSequential(new Delay(0.3));
    	addSequential(new ClawControl(ClawControl.OPEN));
    	//Back up
    	addSequential(new UltrasonicDrive(CLAW_CLEARANCE_DISTANCE, true));
    	addParallel(new PositionElevator(Winch.TOTE_1));  
    	//Grab second tote
    	addSequential(new Delay(0.2));
    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_IN_GAP, false));
    	addSequential(new ClawControl(ClawControl.CLOSE));
    	
//    	//Third tote
//    	addSequential(new Delay(0.3));
//    	addParallel(new PositionElevator(3000));  //Lift the tote
//    	addSequential(new Delay(0.3));
//    	//Go to second
//    	addSequential(new UltrasonicDrive(PULL_UP_DISTANCE, false));
//    	addSequential(new Delay(0.3));
//    	addParallel(new PositionElevator(Winch.TOTE_2 - Winch.TOTE_MID));
//    	addSequential(new Delay(0.3));
////    	addSequential(new ClawControl(ClawControl.OPEN));
//    	//Back up
//    	addSequential(new UltrasonicDrive(CLAW_CLEARANCE_DISTANCE, true));
//    	addParallel(new PositionElevator(Winch.TOTE_1));  
//    	//Grab second tote
//    	addSequential(new Delay(0.2));
//    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_IN_GAP, false));
//    	addSequential(new ClawControl(ClawControl.CLOSE));
//    	
//    	addSequential(new Delay(0.3));
//    	addSequential(new EncoderDrive(DISTANCE_FOR_TURN, EncoderDrive.TURN_RIGHT));
//    	addSequential(new Delay(20));
//    	addSequential(new EncoderDrive(DISTANCE_TO_AUTOZONE, EncoderDrive.DRIVE));
//    	
//    	addParallel(new PositionElevator(3000));
//    	addSequential(new Delay(0.2));
//    	//Go to third
//    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_IN_GAP, false));
//    	addParallel(new PositionElevator(Winch.TOTE_2 - Winch.TOTE_MID));
//    	addSequential(new Delay(0.2));
//    	addSequential(new ClawControl(ClawControl.OPEN));
//    	//Back up
//    	addSequential(new UltrasonicDrive(CLAW_CLEARANCE_DISTANCE, true));
//    	addParallel(new PositionElevator(Winch.TOTE_1)); 
//    	addSequential(new Delay(0.2));
//    	//Grab third
//    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_IN_GAP, false));
//    	addSequential(new ClawControl(ClawControl.CLOSE));
//    	add(new Delay(1));
//    	//Turn and go
//    	addSequential(new EncoderDrive(DISTANCE_FOR_TURN, EncoderDrive.TURN_RIGHT)); //Turn towards the autozone
//    	addSequential(new Delay(1));
//    	addParallel(new PositionElevator(Winch.TOTE_2 - Winch.TOTE_MID));  //Lift the tote
//    	addSequential(new Delay(1));
//    	addSequential(new EncoderDrive(DISTANCE_TO_AUTOZONE, DriveForTime.DRIVE));  //Drive into the autozone
//    	addSequential(new PositionElevator(Winch.TOTE_1), 1); //Lower the tote
//    	addSequential(new ClawControl(ClawControl.OPEN)); //Open the claw
//    	addSequential(new EncoderDrive(BACKUP_DISTANCE, EncoderDrive.DRIVE)); //Back up slightly so we are not touching tote
//    	
    	
    }
    
    public void testRoutine2() {
    	addSequential(new EncoderDrive(DISTANCE_FOR_TURN, EncoderDrive.TURN_RIGHT));
    }
    
    public void driveToAutozone() {
    	addSequential(new DriveForTime(TIME_TO_AUTOZONE, DriveForTime.DRIVE));  //Drive into the autozone
    }
    
    public void toteToAutozone() {
    	addSequential(new ClawControl(ClawControl.CLOSE));  //Close on tote
    	addSequential(new Delay(1));
    	addSequential(new EncoderDrive(DISTANCE_FOR_TURN, EncoderDrive.TURN_RIGHT)); //Turn towards the autozone
    	addParallel(new PositionElevator(Winch.TOTE_2 - Winch.TOTE_MID));  //Lift the tote
    	addSequential(new Delay(1));
    	addSequential(new EncoderDrive(DISTANCE_TO_AUTOZONE, DriveForTime.DRIVE));  //Drive into the autozone
    	addSequential(new PositionElevator(Winch.TOTE_1), 1); //Lower the tote
    	addSequential(new ClawControl(ClawControl.OPEN)); //Open the claw
    	addSequential(new EncoderDrive(BACKUP_DISTANCE, EncoderDrive.DRIVE)); //Back up slightly so we are not touching tote
    }
    
    public void binToAutozone(boolean turn) {
    	if(turn){
    		addSequential(new ClawControl(ClawControl.CLOSE));  //Close on bin
        	addParallel(new PositionElevator(Winch.BIN_HEIGHT));  //Lift the bin
        	addSequential(new Delay(1));
        	addSequential(new EncoderDrive(DISTANCE_FOR_TURN, EncoderDrive.TURN_LEFT));  //Turn towards the autozone
        	addSequential(new Delay(1));
        	addSequential(new EncoderDrive(DISTANCE_TO_AUTOZONE, DriveForTime.DRIVE));
    	}
    	else{
    	addSequential(new ClawControl(ClawControl.CLOSE));  //Close on bin
    	addParallel(new PositionElevator(Winch.BIN_HEIGHT));  //Lift the bin
    	addSequential(new Delay(1));
    	addSequential(new DriveForTime(TIME_TO_AUTOZONE, DriveForTime.REVERSE));  //Drive into the autozone
    	addParallel(new PositionElevator(Winch.TOTE_1)); //Lower the bin
    	addSequential(new Delay(1));
    	addSequential(new ClawControl(ClawControl.OPEN)); //Open the claw
    	addSequential(new EncoderDrive(BACKUP_DISTANCE, EncoderDrive.DRIVE)); //Back up slightly so we are not touching bin
    	}
    }
    
    public void binAndToteToAutozone() {
    	addSequential(new ClawControl(ClawControl.CLOSE)); //Close on bin
//    	addParallel(new PositionElevator(Winch.BIN_HEIGHT)); //Lift the bin
//    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_BEFORE_GAP)); //Drive forward to first tote
//    	addSequential(new ClawControl(ClawControl.OPEN)); //Open the claw
//    	addSequential(new UltrasonicDrive(CLAW_CLEARANCE_DISTANCE)); //Drive backwards
//    	addParallel(new PositionElevator(Winch.TOTE_1)); //Drop the claw
//    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_BEFORE_GAP)); //Drive slightly forward
//    	addSequential(alignTote); //Align the tote
//    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_IN_GAP)); //Drive forward all of the way
    	addSequential(new ClawControl(ClawControl.CLOSE)); //Close on tote
    	addParallel(new PositionElevator(Winch.TOTE_2)); //Lift tote and bin
    	addSequential(new EncoderDrive(DISTANCE_FOR_TURN, EncoderDrive.TURN_LEFT)); //Turn towards the autozone
    	addSequential(new EncoderDrive(DISTANCE_TO_AUTOZONE, EncoderDrive.DRIVE)); //Drive into the autozone
    	addParallel(new PositionElevator(Winch.TOTE_1)); //Lower the tote and bin
    	addSequential(new ClawControl(ClawControl.OPEN)); //Open the claw
    	addSequential(new EncoderDrive(BACKUP_DISTANCE, EncoderDrive.DRIVE)); //Back up slightly so we are not touching them
    }
    
    public void threeTotesToAutozone() {
    	addSequential(new ClawControl(ClawControl.CLOSE)); //Close on tote
    	addParallel(new PositionElevator(Winch.TOTE_2)); //Lift tote and bin
    	//Second tote
//    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_BEFORE_GAP)); //Drive forward to second tote
//    	addSequential(new ClawControl(ClawControl.OPEN)); //Open the claw
//    	addSequential(new UltrasonicDrive(CLAW_CLEARANCE_DISTANCE)); //Drive backwards
//    	addParallel(new PositionElevator(Winch.TOTE_1)); //Drop the claw
//    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_BEFORE_GAP)); //Drive slightly forward
//    	addSequential(alignTote); //Align the tote
//    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_IN_GAP)); //Drive forward all of the way
//    	addSequential(new ClawControl(ClawControl.CLOSE)); //Close on tote
//    	addParallel(new PositionElevator(Winch.TOTE_2)); //Lift totes and bin
//    	//Third tote
//    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_BEFORE_GAP)); //Drive forward to third tote
//    	addSequential(new ClawControl(ClawControl.OPEN)); //Open the claw
//    	addSequential(new UltrasonicDrive(CLAW_CLEARANCE_DISTANCE)); //Drive backwards
//    	addParallel(new PositionElevator(Winch.TOTE_1)); //Drop the claw
//    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_BEFORE_GAP)); //Drive slightly forward
//    	addSequential(alignTote); //Align the tote
//    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_IN_GAP)); //Drive forward all of the way
//    	addSequential(new ClawControl(ClawControl.CLOSE)); //Close on tote
//    	addParallel(new PositionElevator(Winch.TOTE_2)); //Lift totes and bin
//    	//Drive to autozone
//    	addSequential(new EncoderDrive(DISTANCE_FOR_TURN, EncoderDrive.TURN_LEFT)); //Turn towards the autozone
//    	addSequential(new EncoderDrive(DISTANCE_TO_AUTOZONE, EncoderDrive.DRIVE)); //Drive into the autozone
//    	addParallel(new PositionElevator(Winch.TOTE_1)); //Lower the totes and bin
//    	addSequential(new ClawControl(ClawControl.OPEN)); //Open the claw
    	addSequential(new EncoderDrive(BACKUP_DISTANCE, EncoderDrive.DRIVE)); //Back up slightly so we are not touching them
    }
    
    public void binAndThreeTotesToAutozone() {
    	//Bin
//    	addSequential(new ClawControl(ClawControl.CLOSE)); //Close on bin
//    	addParallel(new PositionElevator(Winch.BIN_HEIGHT)); //Lift the bin
//    	//First tote
//    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_BEFORE_GAP)); //Drive forward to first tote
//    	addSequential(new ClawControl(ClawControl.OPEN)); //Open the claw
//    	addSequential(new UltrasonicDrive(CLAW_CLEARANCE_DISTANCE)); //Drive backwards
//    	addParallel(new PositionElevator(Winch.TOTE_1)); //Drop the claw
//    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_BEFORE_GAP)); //Drive slightly forward
//    	addSequential(alignTote); //Align the tote
//    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_IN_GAP)); //Drive forward all of the way
//    	addSequential(new ClawControl(ClawControl.CLOSE)); //Close on tote
//    	addParallel(new PositionElevator(Winch.TOTE_2)); //Lift tote and bin
//    	//Second tote
//    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_BEFORE_GAP)); //Drive forward to second tote
//    	addSequential(new ClawControl(ClawControl.OPEN)); //Open the claw
//    	addSequential(new UltrasonicDrive(CLAW_CLEARANCE_DISTANCE)); //Drive backwards
//    	addParallel(new PositionElevator(Winch.TOTE_1)); //Drop the claw
//    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_BEFORE_GAP)); //Drive slightly forward
//    	addSequential(alignTote); //Align the tote
//    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_IN_GAP)); //Drive forward all of the way
//    	addSequential(new ClawControl(ClawControl.CLOSE)); //Close on tote
//    	addParallel(new PositionElevator(Winch.TOTE_2)); //Lift totes and bin
//    	//Third tote
//    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_BEFORE_GAP)); //Drive forward to third tote
//    	addSequential(new ClawControl(ClawControl.OPEN)); //Open the claw
//    	addSequential(new UltrasonicDrive(CLAW_CLEARANCE_DISTANCE)); //Drive backwards
//    	addParallel(new PositionElevator(Winch.TOTE_1)); //Drop the claw
//    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_BEFORE_GAP)); //Drive slightly forward
//    	addSequential(alignTote); //Align the tote
//    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_IN_GAP)); //Drive forward all of the way
//    	addSequential(new ClawControl(ClawControl.CLOSE)); //Close on tote
//    	addParallel(new PositionElevator(Winch.TOTE_2)); //Lift totes and bin
    	//Drive to autozone
    	addSequential(new EncoderDrive(DISTANCE_FOR_TURN, EncoderDrive.TURN_LEFT)); //Turn towards the autozone
    	addSequential(new EncoderDrive(DISTANCE_TO_AUTOZONE, EncoderDrive.DRIVE)); //Drive into the autozone
    	addParallel(new PositionElevator(Winch.TOTE_1)); //Lower the totes and bin
    	addSequential(new ClawControl(ClawControl.OPEN)); //Open the claw
    	addSequential(new EncoderDrive(BACKUP_DISTANCE, EncoderDrive.DRIVE)); //Back up slightly so we are not touching them
    }
}
