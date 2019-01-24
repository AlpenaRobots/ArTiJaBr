// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5505.ArTiJaBr.subsystems;


import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import org.usfirst.frc5505.ArTiJaBr.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;





/**
 *
 */
public class driveTrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS


    private CANSparkMax sparkMax1;
    private CANSparkMax sparkMax2;
    private CANSparkMax sparkMax3;
    private CANSparkMax sparkMax4;
    private RobotDrive robotDrive41;
    private DoubleSolenoid shifterSolenoid;

    private CANEncoder rightEncoder;
    private CANEncoder leftEncoder;



    public driveTrain() {

        sparkMax1 = new CANSparkMax(1, MotorType.kBrushless);
        
        
        
        sparkMax2 = new CANSparkMax(2, MotorType.kBrushless);
        
        
        
        sparkMax3 = new CANSparkMax(3, MotorType.kBrushless);
        
        
        
        sparkMax4 = new CANSparkMax(4, MotorType.kBrushless);
        
        
        
        leftEncoder = new CANEncoder(sparkMax1);

        rightEncoder = new CANEncoder(sparkMax4);

        robotDrive41 = new RobotDrive(sparkMax1, sparkMax2,
        sparkMax3, sparkMax4);
        
        robotDrive41.setSafetyEnabled(false);
        robotDrive41.setExpiration(0.1);
        robotDrive41.setSensitivity(0.5);
        robotDrive41.setMaxOutput(1.0);

        shifterSolenoid = new DoubleSolenoid(0, 0, 1);
            addChild("Climber Solenoid 1", shifterSolenoid);

        


    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new DriveBase());
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
        //double rightPos = rightEncoder.getPosition();
        //double leftPos = leftEncoder.getPosition();
        SmartDashboard.putNumber("Right Encoder", rightEncoder.getPosition());
        SmartDashboard.putNumber("Left Encoder", leftEncoder.getPosition());
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void driveBase(Joystick stick) {
        double reduction = 1;
        robotDrive41.tankDrive(stick.getRawAxis(1)*reduction, stick.getRawAxis(5)*reduction);
    }

    public void shift() {
        System.out.println("Shifitng Command Started");
        if (shifterSolenoid.get() != Value.kForward) {
            shifterSolenoid.set(Value.kForward);
            System.out.println("Shifted Forward");
        } else {
            shifterSolenoid.set(Value.kReverse);
            System.out.println("Shifted Backward");
        }
    }

    public void driveStraight(double distance, double speed) {
        double encoderStartValue = rightEncoder.getPosition();

    }
}

