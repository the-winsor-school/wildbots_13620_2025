package org.firstinspires.ftc.teamcode.Autons;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot;

//Level 1 Auton in Slideshow
@Autonomous(name = "Close Park (red or blue)", group = "park")
public class Park extends LinearOpMode {

    Robot robot;

    LinearOpMode opMode;

    public void runOpMode() throws InterruptedException {
        robot = new Robot(this);

        waitForStart();

        if (opModeIsActive()) {
            robot.driving.horizontal(0.5);
            sleep(200);
            while(!(robot.leftColor.redOrBlueTape() || robot.rightColor.redOrBlueTape())){
                telemetry.addData("tape","not found");
                telemetry.update();
                robot.driving.horizontal(0.5f);
                opMode.sleep(20);
            }
            robot.driving.stop();
        }

    }
}