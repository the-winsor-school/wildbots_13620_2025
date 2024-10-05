package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Close Park (red or blue)")
public class AutoTemplate extends LinearOpMode {

    Robot robot;

    LinearOpMode opMode;

    public void runOpMode() throws InterruptedException {
        robot = new Robot(this);

        waitForStart();

        if (opModeIsActive()) {
            robot.driving.horizontal(1);
            while(!robot.checkEndTape()){
                telemetry.addData("tape","not found");
                telemetry.update();
                robot.driving.horizontal(0.5f);
                opMode.sleep(20);
            }
            robot.driving.stop();
        }

    }
}