package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;

public class Turret {

    DigitalInput leftLimitSw;
    DigitalInput rightLimitSw;

    double openLoopRotationCmd;
    double closedLoopPosCmd_deg;

    boolean runClosedLoop;

    Spark motorController;

    public Turret(){
        motorController = new Spark(0);
        leftLimitSw = new DigitalInput(0);
        rightLimitSw = new DigitalInput(1);

        runClosedLoop = false;

    }

    public void setOpenLoopRotationCommand(double cmd){
        runClosedLoop = false;
        openLoopRotationCmd = cmd;
    }

    public void setClosedLoopPositionCommand(double pos_deg){
        runClosedLoop = true;
        closedLoopPosCmd_deg = pos_deg;
    }

    public void update(){
        //Todo
    }


}