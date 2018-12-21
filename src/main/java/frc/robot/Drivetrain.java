package frc.robot;

import edu.wpi.first.wpilibj.VictorSP;

import frc.robot.Xbox;

public class Drivetrain {

    VictorSP motorFrontLeft;
    VictorSP motorFrontRight;
    VictorSP motorRearLeft;
    VictorSP motorRearRight;

    double curFwdRevCmd = 0;
    double curRotateCmd = 0;

    public Drivetrain(){
        motorFrontLeft = new VictorSP(1);
        motorFrontRight = new VictorSP(2);
        motorRearLeft = new VictorSP(3);
        motorRearRight = new VictorSP(4);

    }
    
    public void setFwdRevCommand(double cmd_in) {
        cmd_in = curFwdRevCmd;

    }

    public void setRotateCommand(double cmd_in){
        cmd_in = curRotateCmd;
    }
    
    public void update(){
        
    }


}