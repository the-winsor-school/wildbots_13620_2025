package org.firstinspires.ftc.teamcode.Autons;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.StrafeDrive;

//Level 2 Auton in Slideshow
@Autonomous(name = "Push Park (red or blue)", group ="park")
public class PushPark extends LinearOpMode{
    Robot robot;
    StrafeDrive driving;
    public void runOpMode() throws InterruptedException {
        robot = new Robot(this);
        driving = robot.driving;

        waitForStart();

        if (opModeIsActive()) {
            driving.horizontal(-0.7f);
            sleep(1000);

            //moves to the left until it pushed cube into zone by detecting tape
            driving.horizontal(-0.5f);
            while(!robot.leftColor.redOrBlueTape()) { //moves until sees tape
                telemetry.addData("tape","not found");
                robot.printColorValues(robot.leftColor);
                telemetry.update();
                sleep(10);
            }

            //moves back to the right (for parking)
            driving.horizontal(0.7f);
            sleep(3000);

            driving.horizontal(0.5f);
            while(!robot.rightColor.redOrBlueTape()) { //moves until sees tape
                telemetry.addData("tape","not found");
                robot.printColorValues(robot.rightColor);
                telemetry.update();
                sleep(10);
            }

            driving.stop();
        }

    }

}