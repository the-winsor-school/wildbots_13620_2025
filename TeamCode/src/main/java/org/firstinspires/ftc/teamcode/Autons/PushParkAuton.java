package org.firstinspires.ftc.teamcode.Autons;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name = "Push Park (red or blue)")
public class PushParkAuton extends LinearOpMode{
    Robot robot;
    LinearOpMode opMode;
    public void runOpMode() throws InterruptedException {
        robot = new Robot(this);
        opMode = this;

        waitForStart();

        if (opModeIsActive()) {
            robot.driving.horizontal(-0.7f);
            opMode.sleep(1000);
            runHorizontal(-0.5f);
            robot.driving.horizontal(0.7f);
            opMode.sleep(3000);
            runHorizontal(0.5f);
        }

    }

    public void runHorizontal(float step) {
        robot.driving.horizontal(step);
        while(!robot.checkEndTape()){ //moves until sees tape
            telemetry.addData("tape","not found");
            robot.printColorValues();
            telemetry.update();
            opMode.sleep(10);
        }
        robot.driving.stop();
    }
}
