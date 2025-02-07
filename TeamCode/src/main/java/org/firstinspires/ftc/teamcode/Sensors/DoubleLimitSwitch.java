package org.firstinspires.ftc.teamcode.Sensors;
import android.text.method.Touch;

import org.firstinspires.ftc.teamcode.ArmLift.FullArmLift;

import com.qualcomm.robotcore.hardware.TouchSensor;

public class DoubleLimitSwitch {
    private TouchSensor topLimit;
    private TouchSensor bottomLimit;

    public DoubleLimitSwitch(TouchSensor topLimit, TouchSensor bottomLimit) {
        this.topLimit = topLimit;
        this.bottomLimit = bottomLimit;
    }

    public boolean isUpperHit() {return topLimit.isPressed();}
    public boolean isBottomHit() {return bottomLimit.isPressed();}

    /**
     * assuming that when input is -1 it goes up
     * @param input
     * @return
     */
    public boolean canGo(float input) {
        if(input < 0 && isUpperHit()){
            return false;
        }
        if(input > 0 && isBottomHit()){
            return false;
        }
        return true;
    }

}