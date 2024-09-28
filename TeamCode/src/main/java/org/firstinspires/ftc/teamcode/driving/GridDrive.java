package org.firstinspires.ftc.teamcode.driving;

import com.qualcomm.robotcore.hardware.DcMotor;

public class GridDrive implements IDriving {
}

    @Override
    public void turn(float t){
        seteachpower(t,t,-t,-t);
    }
    public void horizontal (float power) {

    }
    private void setEachPower (float rf, float rb, float lf, float lb){
        rf.setPower(rf);
        lf.setPower(rb);
        lf.setPower(lf);
        lb.setPower(lb);
    }
