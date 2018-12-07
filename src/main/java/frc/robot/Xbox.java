package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;

import edu.wpi.first.wpilibj.GenericHID.Hand;

public class Xbox {

    XboxController xboxCtrlr;


    double XboxFwdRevCmd;

    
private Xbox() {
    xboxCtrlr = new XboxController(1);
}

public double getXboxFwdCmd() {
    double driverLeftYValue = -1 * xboxCtrlr.getY(Hand.kLeft);
    if (xboxCtrlr.getTriggerAxis(Hand.kRight) > 0.5 ) {
        XboxFwdRevCmd *= 0.7;
    }
    if (driverLeftYValue > -0.15 & driverLeftYValue < 0.15) {
        XboxFwdRevCmd = 0;
    }
    return (Math.pow(XboxFwdRevCmd,3));
}
}







}