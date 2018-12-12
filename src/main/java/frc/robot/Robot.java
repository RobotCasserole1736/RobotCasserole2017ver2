/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;

import edu.wpi.first.wpilibj.GenericHID.Hand;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  Drivetrain drivetrain;
  Turret turret;
  XboxController operatorController;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    drivetrain = new Drivetrain();
    turret = new Turret();
    operatorController = new XboxController(0);

  }

  /**
   * This function is called once at the start of operator control.
   */
  @Override
  public void teleopInit() {

  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    drivetrain.setFwdRevCommand(0); //todo populate this from xbox rather than "0"
    drivetrain.setRotateCommand(0); //todo populate this from xbox rather than "0"
    drivetrain.update();

    if((operatorController.getAButton()) == true){
      turret.setClosedLoopIndex(0);
    }else if((operatorController.getBButton()) == true){
      turret.setClosedLoopIndex(1);
    }else if((operatorController.getXButton()) == true){
      turret.setClosedLoopIndex(2);
    }
    turret.setOpenLoopRotationCommand(operatorController.getX(Hand.kLeft)); 
    turret.update();

  }

}
