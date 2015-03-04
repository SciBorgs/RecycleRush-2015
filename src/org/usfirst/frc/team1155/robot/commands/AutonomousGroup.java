package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.subsystems.Winch;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousGroup extends CommandGroup {
	
	private CommandGroup alignTote;
	private final double DISTANCE_TO_AUTOZONE = 0, DISTANCE_FOR_TURN = 0, BACKUP_DISTANCE = 0, CLAW_CLEARANCE_DISTANCE = 0, TOTE_DISTANCE_BEFORE_GAP = 0, TOTE_DISTANCE_IN_GAP = 0;
	
    public AutonomousGroup() {
    	alignTote = new CommandGroup();
    	alignTote.addSequential(new ClawControl(ClawControl.CLOSE));
    	alignTote.addSequential(new ClawControl(ClawControl.OPEN));
    	
    	switch(getRoutine()) {
    	case 0:
    		driveToAutozone();
    		break;
    	case 1:
    		toteToAutozone();
    		break;
    	case 2:
    		binToAutozone();
    		break;
    	case 3:
    		binAndToteToAutozone();
    		break;
    	case 4:
    		threeTotesToAutozone();
    		break;
    	case 5:
    		binAndThreeTotesToAutozone();
    		break;
    	}
    }
    
    public int getRoutine() {
		return 0;
    }
    
    public void driveToAutozone() {
    	addSequential(new EncoderDrive(DISTANCE_TO_AUTOZONE, EncoderDrive.DRIVE));  //Drive into the autozone
    }
    
    public void toteToAutozone() {
    	addSequential(new ClawControl(ClawControl.CLOSE));  //Close on tote
    	addParallel(new PositionElevator(Winch.TOTE_2));  //Lift the tote
    	addSequential(new EncoderDrive(DISTANCE_FOR_TURN, EncoderDrive.TURN_RIGHT)); //Turn towards the autozone
    	addSequential(new EncoderDrive(DISTANCE_TO_AUTOZONE, EncoderDrive.DRIVE));  //Drive into the autozone
    	addParallel(new PositionElevator(Winch.TOTE_1)); //Lower the tote
    	addSequential(new ClawControl(ClawControl.OPEN)); //Open the claw
    	addSequential(new EncoderDrive(BACKUP_DISTANCE, EncoderDrive.DRIVE)); //Back up slightly so we are not touching tote
    }
    
    public void binToAutozone() {
    	addSequential(new ClawControl(ClawControl.CLOSE));  //Close on bin
    	addParallel(new PositionElevator(Winch.BIN_HEIGHT));  //Lift the bin
    	addSequential(new EncoderDrive(DISTANCE_TO_AUTOZONE, EncoderDrive.DRIVE));  //Drive into the autozone
    	addParallel(new PositionElevator(Winch.TOTE_1)); //Lower the bin
    	addSequential(new ClawControl(ClawControl.OPEN)); //Open the claw
    	addSequential(new EncoderDrive(BACKUP_DISTANCE, EncoderDrive.DRIVE)); //Back up slightly so we are not touching bin
    }
    
    public void binAndToteToAutozone() {
    	addSequential(new ClawControl(ClawControl.CLOSE)); //Close on bin
    	addParallel(new PositionElevator(Winch.BIN_HEIGHT)); //Lift the bin
    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_BEFORE_GAP)); //Drive forward to first tote
    	addSequential(new ClawControl(ClawControl.OPEN)); //Open the claw
    	addSequential(new UltrasonicDrive(CLAW_CLEARANCE_DISTANCE)); //Drive backwards
    	addParallel(new PositionElevator(Winch.TOTE_1)); //Drop the claw
    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_BEFORE_GAP)); //Drive slightly forward
    	addSequential(alignTote); //Align the tote
    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_IN_GAP)); //Drive forward all of the way
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
    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_BEFORE_GAP)); //Drive forward to second tote
    	addSequential(new ClawControl(ClawControl.OPEN)); //Open the claw
    	addSequential(new UltrasonicDrive(CLAW_CLEARANCE_DISTANCE)); //Drive backwards
    	addParallel(new PositionElevator(Winch.TOTE_1)); //Drop the claw
    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_BEFORE_GAP)); //Drive slightly forward
    	addSequential(alignTote); //Align the tote
    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_IN_GAP)); //Drive forward all of the way
    	addSequential(new ClawControl(ClawControl.CLOSE)); //Close on tote
    	addParallel(new PositionElevator(Winch.TOTE_2)); //Lift totes and bin
    	//Third tote
    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_BEFORE_GAP)); //Drive forward to third tote
    	addSequential(new ClawControl(ClawControl.OPEN)); //Open the claw
    	addSequential(new UltrasonicDrive(CLAW_CLEARANCE_DISTANCE)); //Drive backwards
    	addParallel(new PositionElevator(Winch.TOTE_1)); //Drop the claw
    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_BEFORE_GAP)); //Drive slightly forward
    	addSequential(alignTote); //Align the tote
    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_IN_GAP)); //Drive forward all of the way
    	addSequential(new ClawControl(ClawControl.CLOSE)); //Close on tote
    	addParallel(new PositionElevator(Winch.TOTE_2)); //Lift totes and bin
    	//Drive to autozone
    	addSequential(new EncoderDrive(DISTANCE_FOR_TURN, EncoderDrive.TURN_LEFT)); //Turn towards the autozone
    	addSequential(new EncoderDrive(DISTANCE_TO_AUTOZONE, EncoderDrive.DRIVE)); //Drive into the autozone
    	addParallel(new PositionElevator(Winch.TOTE_1)); //Lower the totes and bin
    	addSequential(new ClawControl(ClawControl.OPEN)); //Open the claw
    	addSequential(new EncoderDrive(BACKUP_DISTANCE, EncoderDrive.DRIVE)); //Back up slightly so we are not touching them
    }
    
    public void binAndThreeTotesToAutozone() {
    	//Bin
    	addSequential(new ClawControl(ClawControl.CLOSE)); //Close on bin
    	addParallel(new PositionElevator(Winch.BIN_HEIGHT)); //Lift the bin
    	//First tote
    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_BEFORE_GAP)); //Drive forward to first tote
    	addSequential(new ClawControl(ClawControl.OPEN)); //Open the claw
    	addSequential(new UltrasonicDrive(CLAW_CLEARANCE_DISTANCE)); //Drive backwards
    	addParallel(new PositionElevator(Winch.TOTE_1)); //Drop the claw
    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_BEFORE_GAP)); //Drive slightly forward
    	addSequential(alignTote); //Align the tote
    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_IN_GAP)); //Drive forward all of the way
    	addSequential(new ClawControl(ClawControl.CLOSE)); //Close on tote
    	addParallel(new PositionElevator(Winch.TOTE_2)); //Lift tote and bin
    	//Second tote
    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_BEFORE_GAP)); //Drive forward to second tote
    	addSequential(new ClawControl(ClawControl.OPEN)); //Open the claw
    	addSequential(new UltrasonicDrive(CLAW_CLEARANCE_DISTANCE)); //Drive backwards
    	addParallel(new PositionElevator(Winch.TOTE_1)); //Drop the claw
    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_BEFORE_GAP)); //Drive slightly forward
    	addSequential(alignTote); //Align the tote
    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_IN_GAP)); //Drive forward all of the way
    	addSequential(new ClawControl(ClawControl.CLOSE)); //Close on tote
    	addParallel(new PositionElevator(Winch.TOTE_2)); //Lift totes and bin
    	//Third tote
    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_BEFORE_GAP)); //Drive forward to third tote
    	addSequential(new ClawControl(ClawControl.OPEN)); //Open the claw
    	addSequential(new UltrasonicDrive(CLAW_CLEARANCE_DISTANCE)); //Drive backwards
    	addParallel(new PositionElevator(Winch.TOTE_1)); //Drop the claw
    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_BEFORE_GAP)); //Drive slightly forward
    	addSequential(alignTote); //Align the tote
    	addSequential(new UltrasonicDrive(TOTE_DISTANCE_IN_GAP)); //Drive forward all of the way
    	addSequential(new ClawControl(ClawControl.CLOSE)); //Close on tote
    	addParallel(new PositionElevator(Winch.TOTE_2)); //Lift totes and bin
    	//Drive to autozone
    	addSequential(new EncoderDrive(DISTANCE_FOR_TURN, EncoderDrive.TURN_LEFT)); //Turn towards the autozone
    	addSequential(new EncoderDrive(DISTANCE_TO_AUTOZONE, EncoderDrive.DRIVE)); //Drive into the autozone
    	addParallel(new PositionElevator(Winch.TOTE_1)); //Lower the totes and bin
    	addSequential(new ClawControl(ClawControl.OPEN)); //Open the claw
    	addSequential(new EncoderDrive(BACKUP_DISTANCE, EncoderDrive.DRIVE)); //Back up slightly so we are not touching them
    }
}
