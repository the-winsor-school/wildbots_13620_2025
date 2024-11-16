package org.firstinspires.ftc.teamcode.ArmLift;

import com.qualcomm.robotcore.hardware.DcMotor;

public class FullArmLift {
    public LiftMotor motor;
    public FullArmLift(DcMotor liftMotor){
        motor = new LiftMotor (liftMotor,0.8);
    }

    public void moveLiftToPosition (LIFT_POSITION pos){
        if(pos == LIFT_POSITION.RESET){
            motor.setTargetPosition(0);
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