// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5505.ArTiJaBr;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc5505.ArTiJaBr.commands.*;
import org.usfirst.frc5505.ArTiJaBr.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in 
 * the project.
 */
public class Robot extends TimedRobot {

    Command autonomousCommand;
    SendableChooser<Command> chooser = new SendableChooser<>();

    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static driveTrain driveTrain;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    //Sets up varables required to read values from the GRIP networktables
    NetworkTableInstance inst = NetworkTableInstance.getDefault();
    NetworkTable GRIPLines = inst.getTable("GRIP/horizontalLines");
    double[] defaultValue = new double[0];
    NetworkTableEntry x1Net;
    double[] x1Array;
    double x1 = 0;
    NetworkTableEntry x2Net;
    double[] x2Array;
    double x2 = 0;
    NetworkTableEntry y1Net;
    double[] y1Array;
    double y1 = 0;
    NetworkTableEntry y2Net;
    double[] y2Array;
    double y2 = 0;
    NetworkTableEntry angleNet;
    double[] angleArray;
    double lineAngle = 0;
    NetworkTableEntry lengthNet;
    double[] lengthArray;
    double lenght = 0;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */

    @Override
    public void robotInit() {

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrain = new driveTrain();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // Add commands to Autonomous Sendable Chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        chooser.setDefaultOption("Autonomous Command", new AutonomousCommand());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        SmartDashboard.putData("Auto mode", chooser);

        CameraServer.getInstance().startAutomaticCapture("Camera 1", 0);
        
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    @Override
    public void disabledInit(){

    }

    @Override
    public void disabledPeriodic() {
        x1Net = GRIPLines.getEntry("x1");
        x1Array = x1Net.getDoubleArray(defaultValue);
        x2Net = GRIPLines.getEntry("x2");
        x2Array = x2Net.getDoubleArray(defaultValue);
        y1Net = GRIPLines.getEntry("y1");
        y1Array = y1Net.getDoubleArray(defaultValue);
        y2Net = GRIPLines.getEntry("y2");
        y2Array = y2Net.getDoubleArray(defaultValue);
        angleNet = GRIPLines.getEntry("angle");
        angleArray = angleNet.getDoubleArray(defaultValue);
        lengthNet = GRIPLines.getEntry("angle");
        lengthArray = angleNet.getDoubleArray(defaultValue);
        try {
            x1 = x1Array[0];
            x2 = x2Array[0];
            y1 = y1Array[0];
            y2 = y2Array[0];
            lineAngle = angleArray[0];
            lenght = lengthArray[0];
            Robot.driveTrain.getX1(x1);
            Robot.driveTrain.getX2(x2);
            Robot.driveTrain.getY1(y1);
            Robot.driveTrain.getY2(y2);
            Robot.driveTrain.getLineAngle(lineAngle);
            Robot.driveTrain.getLineLength(lenght);
            SmartDashboard.putBoolean("Are There Lines", true);
        } catch(Exception e) {
            SmartDashboard.putBoolean("Are There Lines", false);
        }
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        autonomousCommand = chooser.getSelected();
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        x1Net = GRIPLines.getEntry("x1");
        x1Array = x1Net.getDoubleArray(defaultValue);
        x2Net = GRIPLines.getEntry("x2");
        x2Array = x2Net.getDoubleArray(defaultValue);
        y1Net = GRIPLines.getEntry("y1");
        y1Array = y1Net.getDoubleArray(defaultValue);
        y2Net = GRIPLines.getEntry("y2");
        y2Array = y2Net.getDoubleArray(defaultValue);
        angleNet = GRIPLines.getEntry("angle");
        angleArray = angleNet.getDoubleArray(defaultValue);
        lengthNet = GRIPLines.getEntry("angle");
        lengthArray = angleNet.getDoubleArray(defaultValue);
        try {
            x1 = x1Array[0];
            x2 = x2Array[0];
            y1 = y1Array[0];
            y2 = y2Array[0];
            lineAngle = angleArray[0];
            lenght = lengthArray[0];
            Robot.driveTrain.getX1(x1);
            Robot.driveTrain.getX2(x2);
            Robot.driveTrain.getY1(y1);
            Robot.driveTrain.getY2(y2);
            Robot.driveTrain.getLineAngle(lineAngle);
            Robot.driveTrain.getLineLength(lenght);
            SmartDashboard.putBoolean("Are There Lines", true);
        } catch(Exception e) {
            SmartDashboard.putBoolean("Are There Lines", false);
        }
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */


    @Override
    public void teleopPeriodic() {
        x1Net = GRIPLines.getEntry("x1");
        x1Array = x1Net.getDoubleArray(defaultValue);
        x2Net = GRIPLines.getEntry("x2");
        x2Array = x2Net.getDoubleArray(defaultValue);
        y1Net = GRIPLines.getEntry("y1");
        y1Array = y1Net.getDoubleArray(defaultValue);
        y2Net = GRIPLines.getEntry("y2");
        y2Array = y2Net.getDoubleArray(defaultValue);
        angleNet = GRIPLines.getEntry("angle");
        angleArray = angleNet.getDoubleArray(defaultValue);
        lengthNet = GRIPLines.getEntry("angle");
        lengthArray = angleNet.getDoubleArray(defaultValue);
        try {
            x1 = x1Array[0];
            x2 = x2Array[0];
            y1 = y1Array[0];
            y2 = y2Array[0];
            lineAngle = angleArray[0];
            lenght = lengthArray[0];
            Robot.driveTrain.getX1(x1);
            Robot.driveTrain.getX2(x2);
            Robot.driveTrain.getY1(y1);
            Robot.driveTrain.getY2(y2);
            Robot.driveTrain.getLineAngle(lineAngle);
            Robot.driveTrain.getLineLength(lenght);
            SmartDashboard.putBoolean("Are There Lines", true);
        } catch(Exception e) {
            SmartDashboard.putBoolean("Are There Lines", false);
        }
        Scheduler.getInstance().run();
    }
}
