package org.firstinspires.ftc.teamcode.ArmLift;

import org.firstinspires.ftc.teamcode.ArmLift.Claw;
import org.firstinspires.ftc.teamcode.Sensors.DoubleLimitSwitch;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class FullArmLift {
    public GenericLiftMotor cascade;
    public GenericLiftMotor drawbridge;

    public DoubleLimitSwitch liftLimit;
    public DoubleLimitSwitch drawLimit;
    public Claw claw;

    public FullArmLift(DcMotorEx cascadeMotor,
                       DcMotorEx drawbridgeMotor,
                       CRServo clawServo,
                       TouchSensor topLiftLimit,
                       TouchSensor botLiftLimit,
                       TouchSensor topDrawLimit,
                       TouchSensor botDrawLimit) {
        cascade = new GenericLiftMotor(cascadeMotor,0.8, 200);
        drawbridge = new GenericLiftMotor(drawbridgeMotor, 0.8, 200);
        claw = new Claw(clawServo);
        liftLimit = new DoubleLimitSwitch(topLiftLimit, botLiftLimit);
        drawLimit = new DoubleLimitSwitch(topDrawLimit, botDrawLimit);

    }

    public void joystickControlCascade(float input) {

        if (Math.abs(input) < 0.1f){
            input = 0;
        }
        if(!liftLimit.canGo(input)){
            cascade.setMotorPower(0);
            return;
        }
        cascade.setMotorPower(input);
    }

    public void joystickControlDrawbridge(float input) {
        if (Math.abs(input) < 0.1f){
            input = 0;
        }
        if(!drawLimit.canGo(input)){
            drawbridge.setMotorPower(0);
            return;
        }
        drawbridge.setMotorPower(input);
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



    public enum LIFT_POSITION {
        RESET,
        HIGHRUNG,
        LOWRUNG

    }
}