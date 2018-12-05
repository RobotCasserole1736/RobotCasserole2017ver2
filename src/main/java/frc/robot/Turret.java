package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class Turret {

    DigitalInput leftLimitSw;
    DigitalInput rightLimitSw;

    Encoder posEncoder;

    XboxController openLoopController;

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
        openLoopController = new XboxController(0);

        runClosedLoop = false;

    }

    public void setOpenLoopRotationCommand(double cmd){
        runClosedLoop = false;
        openLoopRotationCmd = cmd;
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
        }else if(actualPos <= closedLoopPosCmd_deg){
            motorControl.set(-1);
        }else if(actualPos >= closedLoopPosCmd_deg){
            motorControl.set(1);
        }
    }

    public void update(){
        if(leftLimitSw.get() == true || rightLimitSw.get() == true){
            motorControl.set(0);
            
        }else if(runClosedLoop == false){
            setOpenLoopRotationCommand(openLoopController.getX(Hand.kLeft)); 

        }else if(runClosedLoop == true){
            setClosedLoopPositionCommand(closedLoopIndex); //This index will need to be set. Currently is 0
            getActualPosition();
            bangBang();
        }
    }


}