package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;

import edu.wpi.first.wpilibj.GenericHID.Hand;

public class Xbox {

    XboxController xbox;

    double xboxFwdRevCmd = 0;
    double xboxRotateCmd;

    
private Xbox() {
    xbox = new XboxController(0);
}


public double getXboxRotateCmd(){
    
    if (xbox.getX(Hand.kRight) > 0.5) {
        xboxRotateCmd *= 0.85;
    if (xbox.getX(Hand.kRight) < 0.15 & xbox.getX(Hand.kRight) > -0.15) {
        xboxRotateCmd = xbox.getX(Hand.kRight);
        }
    }
    xboxRotateCmd = Math.pow(xboxRotateCmd, 3);
    return xboxRotateCmd;
}

public double getY(GenericHID.Hand kLeft){
    
    if (xbox.getX(Hand.kRight) > 0.5) {
        xboxFwdRevCmd *= 0.7;
    if (xbox.getX(Hand.kRight) < 0.15 & xbox.getX(Hand.kRight) > -0.15) {
        xboxFwdRevCmd = xbox.getX(Hand.kRight);
        }
    }
    xboxFwdRevCmd = Math.pow(xboxRotateCmd, 3);
    
    return xboxFwdRevCmd;
}







}






