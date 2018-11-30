package frc.robot;

import edu.wpi.first.wpilibj.VictorSP;

public class Drivetrain {

    VictorSP motorFrontLeft;
    VictorSP motorFrontRight;
    VictorSP motorRearLeft;
    VictorSP motorRearRight;

    public Drivetrain(){
        motorFrontLeft = new VictorSP(1);
        motorFrontRight = new VictorSP(2);
        motorRearLeft = new VictorSP(3);
        motorRearRight = new VictorSP(4);

    }

    public void setFwdRevCommand(double cmd_in){

    }

    public void setRotateCommand(double cmd_in){

    }
    
    public void update(){

    }


}