package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Push Park (red or blue)")
public class AutoTemplate2 extends LinearOpMode{
    Robot robot;
    LinearOpMode opMode;

    public void runHorizontal(int step) {
        robot.driving.horizontal(step);
        while(!robot.checkEndTape()){
            telemetry.addData("tape","not found");
            telemetry.update();
            robot.driving.horizontal(0.5f);
            opMode.sleep(20);
        }
        robot.driving.stop();
    }
    public void runOpMode() throws InterruptedException {
        robot = new Robot(this);

        waitForStart();

        if (opModeIsActive()) {
            runHorizontal(-1);
            runHorizontal(1);
        }

    }
}
