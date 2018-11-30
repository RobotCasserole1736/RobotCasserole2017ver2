/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

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

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    drivetrain = new Drivetrain();
    turret = new Turret();

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

    turret.setOpenLoopRotationCommand(0); //todo populate this from xbox rather than "0"
    turret.update();

  }

}
