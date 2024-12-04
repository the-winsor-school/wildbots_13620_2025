package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Disabled
@Autonomous(name = "testing")
public class TestingAuton extends LinearOpMode {

    Robot robot;

    LinearOpMode opMode;

    public void runOpMode() throws InterruptedException {
        robot = new Robot(this);

        waitForStart();

        while (opModeIsActive()) {

            telemetry.addData("distance", robot.checkBackDistance());
            telemetry.update();


        }

    }
}