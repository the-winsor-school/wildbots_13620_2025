package org.firstinspires.ftc.teamcode.Autons;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.StrafeDrive;

//Level 3 Auton in Slideshow
@Disabled
@Autonomous(name = "Specimen & Park", group="spec")
public class SpecPark extends LinearOpMode {

    Robot robot;
    StrafeDrive driving;

    public void runOpMode() throws InterruptedException {
        robot = new Robot(this);
        driving = robot.driving;

        waitForStart();

        if (opModeIsActive()) {

            //moving forward to place spec
            driving.vertical(0.7f);
            telemetry.addData("moving forward", "no loop");
            telemetry.update();
            sleep(500);

            //get specific distance while moving at a slower pace
            driving.vertical(0.5f);
            while (robot.backDistance.isDistanceGreater(54)) {
                telemetry.addData("back distance:", robot.backDistance.getDistance());
                telemetry.update();
                sleep(10);
            }

            //TODO robot places spec
            sleep(2000);

            //moving back to the wall after placing the spec
            driving.vertical(-0.5f);

            //get specific distance while moving at a slower pace
            while (robot.backDistance.isDistanceLess(15)) {//moves until distance at certain point
                telemetry.addData("back distance:", robot.backDistance.getDistance());
                telemetry.update();
                sleep(10);
            }


            //PARKING IN OBSERVATION ZONE

            robot.driving.horizontal(0.7);
            //moves until tape is detected
            while (!robot.rightColor.redOrBlueTape()) {
                telemetry.addData("tape", "not found");
                telemetry.update();
                sleep(20);
            }
        }

    }
}
