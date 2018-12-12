package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;

import edu.wpi.first.wpilibj.GenericHID.Hand;

public class Xbox {

    XboxController xboxCtrlr;

    double XboxFwdRevCmd = 0;
    double XboxLeftRightCmd = 0;

    
private Xbox() {
    xboxCtrlr = new XboxController(0);
}


public double getX(GenericHID.Hand kRight){
    return XboxLeftRightCmd;
}
public double getY(GenericHID.Hand kLeft){
    return XboxFwdRevCmd;
}







}





