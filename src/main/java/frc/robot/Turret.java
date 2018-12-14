package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;

public class Turret {

    DigitalInput leftLimitSw;
    DigitalInput rightLimitSw;

    Encoder posEncoder;

    double openLoopRotationCmd;
    double closedLoopPosCmd_deg;
    double actualPos;

    int closedLoopIndex = 0;

    boolean runClosedLoop;

    Spark motorControl;

    public Turret(){
        motorControl = new Spark(0);
        leftLimitSw = new DigitalInput(0);
        rightLimitSw = new DigitalInput(1);
        posEncoder = new Encoder(2, 3);

        runClosedLoop = false;

    }

    public void setClosedLoop(boolean loop){
        runClosedLoop = loop;
    }

    public void setOpenLoopRotationCommand(double cmd){
        runClosedLoop = false;
        openLoopRotationCmd = cmd;
    }

    public void setClosedLoopIndex(int index){
        closedLoopIndex = index;
    }

    public void setClosedLoopPositionCommand(double index){
        runClosedLoop = true;
        if(index == 0){
            closedLoopPosCmd_deg = 45;
        }else if(index == 1){
            closedLoopPosCmd_deg = 90;
        }else if(index == 2){
            closedLoopPosCmd_deg = 135;
        }
    }

    public void getActualPosition(){
        posEncoder.setDistancePerPulse((1/1024)*(25/500)*(360)); //Values to be changed when we know exact
        actualPos = posEncoder.getDistance();
    }

    public void bangBang(){
        if((actualPos <= (closedLoopPosCmd_deg + 1)) || (actualPos >= (closedLoopPosCmd_deg - 1))){
            motorControl.set(0);
        }else if(actualPos <= (closedLoopPosCmd_deg - 1)){
            motorControl.set(-1);
        }else if(actualPos >= (closedLoopPosCmd_deg + 1)){
            motorControl.set(1);
        }
    }

    public void update(){

        //Safety
        if(leftLimitSw.get() == true && openLoopRotationCmd <= 0){
            motorControl.set(0);
        }else if(rightLimitSw.get() == true && openLoopRotationCmd >=0){
            motorControl.set(0);

        //Open Loop    
        }else if(runClosedLoop == false){
            motorControl.set(openLoopRotationCmd);

        //Closed Loop    
        }else if(runClosedLoop == true){
            setClosedLoopPositionCommand(closedLoopIndex);
            getActualPosition();
            bangBang();
        }
    }
}