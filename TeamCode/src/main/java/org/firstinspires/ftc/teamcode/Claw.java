package org.firstinspires.ftc.teamcode;
package org.firstinspires.ftc.teamcode.Arm;

import com.qualcomm.robotcore.hardware.CRServo;

public class Claw {

    public CRServo servo;

    public Claw(CRServo clawServo) {
        servo = clawServo;
    }

        //moves claw asynchronously

    public void moveClaw(ClawPosition position) {
        if (position == ClawPosition.CLOSE) {
            servo.setPower(-0.5);
        }
        if (position == ClawPosition.OPEN) {
            servo.setPower(0.5);
        }
        if (position == ClawPosition.STOP) {
            servo.setPower(0);
        }
    }

    public double getPower() {
        return servo.getPower();
    }

}
