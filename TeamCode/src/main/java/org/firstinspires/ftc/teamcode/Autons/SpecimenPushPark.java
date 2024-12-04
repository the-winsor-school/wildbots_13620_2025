/*
package org.firstinspires.ftc.teamcode.Autons;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.Robot;
import com.qualcomm.hardware.bosch.BNO055IMU;

@Autonomous(name = "Specimen Push Park")
public class SpecimenPushPark extends LinearOpMode {

    Robot robot;

    LinearOpMode opMode;

    public void runOpMode() throws InterruptedException {
        robot = new Robot(this);
        opMode = this;

        waitForStart();

        if (opModeIsActive()) {
            robot.driving.vertical(0.7f);
            opMode.sleep(500);
            robot.driving.vertical(0.7f);
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
            //robot places specimen

            robot.driving.horizontal(1);
            while (robot.checkBackDistance() > 10) {
                telemetry.addData("distance", "not close");
                robot.printBackDistanceValues();
                telemetry.update();
                opMode.sleep(10);
            }
            robot.driving.stop();

            //turn left ninety degrees, figure out how to use driving library and IMU

            //strafe left and push yellow sample into triangle zone, using the color sensor

            //using distance sensor
            while (robot.checkLeftDistance() > 15) {//moves until distance at certain point
                telemetry.addData("distance to left wall", "not close");
                robot.printLeftDistanceValues();
                telemetry.update();
                robot.driving.horizontal(-0.5f);
                opMode.sleep(10);
            }
            robot.driving.stop();
            opMode.sleep(1000);
            runVertical(0.5f);

            //checking for white tape

            while (!robot.checkWhiteTape()) {
                telemetry.addData("white tape", "not found");
                telemetry.update();
                robot.driving.vertical(0.5f);
                opMode.sleep(20);
            }
            robot.driving.stop();
            opMode.sleep(1000);
            runVertical(0.5f);

            while (robot.checkLeftDistance() > 10) {//moves until distance at certain point
                telemetry.addData("distance to left wall", "not close");
                robot.printLeftDistanceValues();
                telemetry.update();
                robot.driving.horizontal(-0.5f);
                opMode.sleep(10);
            }
            robot.driving.horizontal(1);
            while (robot.checkBackDistance() > 10) {
                telemetry.addData("distance", "not close");
                robot.printBackDistanceValues();
                telemetry.update();
                opMode.sleep(10);
            }
            robot.driving.stop();
            opMode.sleep(1000);
            runVertical(0.5f);

            //turn right ninety degrees

            //strafe all the way right into the red parking zone
            robot.driving.horizontal(1);

            while (!robot.checkEndTape()) {
                telemetry.addData("tape at parking", "not found");
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
