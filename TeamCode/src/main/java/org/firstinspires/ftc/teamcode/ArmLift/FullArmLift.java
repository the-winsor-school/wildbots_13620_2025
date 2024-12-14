package org.firstinspires.ftc.teamcode.ArmLift;

import org.firstinspires.ftc.teamcode.ArmLift.Claw;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import java.util.HashMap;


public class FullArmLift {
    public GenericLiftMotor cascade;
    public GenericLiftMotor drawbridge;

    //arm location encoder values
    HashMap<LIFT_POSITION, Integer> drawbridgeLocations = new HashMap<LIFT_POSITION, Integer>();
    HashMap<LIFT_POSITION, Integer> cascadeLocations = new HashMap<LIFT_POSITION, Integer>();


    public Claw claw;

    public FullArmLift(DcMotorEx cascadeMotor, DcMotorEx drawbridgeMotor, CRServo clawServo){
        cascade = new GenericLiftMotor(cascadeMotor,0.8, 200);
        drawbridge = new GenericLiftMotor(drawbridgeMotor, 0.8, 200);
        claw = new Claw(clawServo);

        //Initalization of motor encoder positions
        //Drawbridge
        //TODO get these values
        drawbridgeLocations.put(LIFT_POSITION.RESET, 0);
        drawbridgeLocations.put(LIFT_POSITION.LOW_RUNG, 0);
        drawbridgeLocations.put(LIFT_POSITION.HIGH_RUNG, 0);

        //Cascade
        //TODO get these values
        cascadeLocations.put(LIFT_POSITION.RESET, 0);
        cascadeLocations.put(LIFT_POSITION.LOW_RUNG, 0);
        cascadeLocations.put(LIFT_POSITION.HIGH_RUNG, 0);
    }

    public void moveLiftToPosition (LIFT_POSITION pos){
        if(pos == LIFT_POSITION.RESET){
            drawbridge.runToPosition(drawbridgeLocations.get(LIFT_POSITION.RESET));
            cascade.runToPosition(cascadeLocations.get(LIFT_POSITION.RESET));
        }
        else if(pos == LIFT_POSITION.LOW_RUNG){
            drawbridge.runToPosition(drawbridgeLocations.get(LIFT_POSITION.LOW_RUNG));
            cascade.runToPosition(cascadeLocations.get(LIFT_POSITION.LOW_RUNG));
        }
        else if(pos == LIFT_POSITION.HIGH_RUNG){
            drawbridge.runToPosition(drawbridgeLocations.get(LIFT_POSITION.HIGH_RUNG));
            cascade.runToPosition(cascadeLocations.get(LIFT_POSITION.HIGH_RUNG));
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
        HIGH_RUNG,
        LOW_RUNG

    }

}