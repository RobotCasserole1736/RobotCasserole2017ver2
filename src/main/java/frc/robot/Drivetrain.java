package main.java.frc.robot;

public class Drivetrain{

    VictorSP motorFrontLeft;
    VictorSP motorFrontRight;
    VictorSP motorRearLeft;
    VictorSP motorRearRight;

    public Drivetrain(){
        motorFrontLeft = new Spark(1);
        motorFrontRight = new Spark(1);
        motorRearLeft = new Spark(1);
        motorRearRight = new Spark(1);

    }

    public void setFwdRevCommand(double cmd_in){

    }

    public void setRotateCommand(double cmd_in){

    }
    
    public void update(){

    }


}