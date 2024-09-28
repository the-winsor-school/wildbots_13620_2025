package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.driving.GridDrive;
import org.firstinspires.ftc.teamcode.driving.IDriving;

public class robot {
    public IDriving driving;
    public Robot(LinearOpMode opMode) {
        HardwareMap map = opMode.hardwareMap;

        rf = map.tryGet(DcMotor.class, "rf");
        lb = map.tryGet(DcMotor.class, "lb");

        driving = new GridDrive(rf, rb, lf, lb);
    }
}