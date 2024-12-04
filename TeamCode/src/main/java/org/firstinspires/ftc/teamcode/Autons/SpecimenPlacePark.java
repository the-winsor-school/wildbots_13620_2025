/*
package org.firstinspires.ftc.teamcode.Autons;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name = "Specimen Park Auton")
public class SpecimenPlacePark extends LinearOpMode {

    Robot robot;

    LinearOpMode opMode;

    public void runOpMode() throws InterruptedException {
        robot = new Robot(this);
        opMode = this;

        waitForStart();

        if (opModeIsActive()) {
            robot.driving.vertical(0.7f);
            opMode.sleep(500);
            robot.driving.vertical(0.5f);
            telemetry.addData("moving forward", "no loop");
            telemetry.update();

            while (robot.checkBackDistance() < 54) {//moves until distance at certain point
                robot.printBackDistanceValues();
                opMode.sleep(10);
            }
            telemetry.addData("out of loop", "stopping");
            telemetry.update();
            robot.driving.stop();
            opMode.sleep(2000);
            //robot places speciem

            robot.driving.vertical(-0.5f);

            while (robot.checkBackDistance() > 15) {//moves until distance at certain point
                telemetry.addData("distance", "not close");
                robot.printBackDistanceValues();
                telemetry.update();
                opMode.sleep(10);
            }
            robot.driving.stop();

            opMode.sleep(1000);
            runVertical(0.5f);

            robot.driving.horizontal(1);
            while(!robot.checkEndTape()){
                telemetry.addData("tape", "not found");
                telemetry.update();
                robot.driving.horizontal(0.5f);
                opMode.sleep(20);
            }
            robot.driving.stop();

        }

    }


    public void runVertical(float step) {

    }
}*/
