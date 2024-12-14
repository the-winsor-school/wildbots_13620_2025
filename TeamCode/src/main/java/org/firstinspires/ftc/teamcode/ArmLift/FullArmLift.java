package org.firstinspires.ftc.teamcode.ArmLift;

import org.firstinspires.ftc.teamcode.ArmLift.Claw;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class FullArmLift {
    public GenericLiftMotor cascade;
    public GenericLiftMotor drawbridge;

    //arm location encoder values
    //private lift_reset = 0

    public Claw claw;

    public FullArmLift(DcMotorEx cascadeMotor, DcMotorEx drawbridgeMotor, CRServo clawServo){
        cascade = new GenericLiftMotor(cascadeMotor,0.8, 200);
        drawbridge = new GenericLiftMotor(drawbridgeMotor, 0.8, 200);
        claw = new Claw(clawServo);
    }

    public void moveLiftToPosition (LIFT_POSITION pos){
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
    }

    public void joystickControlCascade(float input) {
        cascade.setMotorPower(input);
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