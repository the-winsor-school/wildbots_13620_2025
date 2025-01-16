package org.firstinspires.ftc.teamcode.ArmLift;

import org.firstinspires.ftc.teamcode.ArmLift.Claw;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class FullArmLift {
    public GenericLiftMotor cascade;
    public GenericLiftMotor drawbridge;

    public Claw claw;

    public TouchSensor topLiftLimit;
    public TouchSensor bottomLiftLimit;

    public FullArmLift(DcMotorEx cascadeMotor, DcMotorEx drawbridgeMotor, CRServo clawServo, TouchSensor tLiftLimit, TouchSensor botLiftLimit){
        cascade = new GenericLiftMotor(cascadeMotor,0.8, 200);
        drawbridge = new GenericLiftMotor(drawbridgeMotor, 0.8, 200);
        claw = new Claw(clawServo);
        topLiftLimit = tLiftLimit;
        bottomLiftLimit = botLiftLimit;

    }

    /*public void moveLiftToPosition (LIFT_POSITION pos){
        if(pos == LIFT_POSITION.RESET){
            cascade.runToPosition(0);
            drawbridge.runToPosition(0);
        }
        if(pos == LIFT_POSITION.HIGHRUNG){
            //motor.setTargetPosition(); test for encoder
        }
        if(pos == LIFT_POSITION.LOWRUNG){
            //motor.setTargetPosition(); test for encoder
        }
        //add one more for PICKINGUP if RESET does not work
    }*/

    public void joystickControlCascade(float input) {

        if (Math.abs(input) < 0.1f){
            cascade.setMotorPower(0);
        }

        if(!(topLiftLimit.isPressed()) && input > 0 || !(bottomLiftLimit.isPressed()) && input < 0){
            cascade.setMotorPower(input);
        } else if(topLiftLimit.isPressed()){
            while(topLiftLimit.isPressed()){
                cascade.setMotorPower(-0.7f);
            }
        } else if(bottomLiftLimit.isPressed()){
            while(bottomLiftLimit.isPressed()){
                cascade.setMotorPower(0.7f);
            }
        }
    }

    public void joystickControlDrawbridge(float input) {
        drawbridge.setMotorPower(input);
    }


    public enum LIFT_POSITION {
        RESET,
        HIGHRUNG,
        LOWRUNG

    }
}