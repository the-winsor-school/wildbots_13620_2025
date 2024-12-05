package org.firstinspires.ftc.teamcode.Autons.SpecBasketPark;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.StrafeDrive;

@Disabled
@Autonomous(name = "Specimen Basket Park")
public class SpecBasketPark extends LinearOpMode {

    Robot robot;
    StrafeDrive driving;

    public void runOpMode() throws InterruptedException {
        robot = new Robot(this);
        driving = robot.driving;

        waitForStart();

        if (opModeIsActive()) {
            //moving forward to place spec
            driving.vertical(0.7);
            telemetry.addData("moving forward", "no loop");
            telemetry.update();
            sleep(500);

            //get specific distance while moving at a slower pace
            driving.vertical(0.5);
            while (robot.backDistance.isDistanceGreater(54)) {
                telemetry.addData("back distance:", robot.backDistance.getDistance());
                telemetry.update();
                sleep(10);
            }

            //TODO robot places spec
            sleep(2000);

            //moving back to the wall after placing the spec
            driving.vertical(-0.5);

            //get specific distance while moving at a slower pace
            while (robot.backDistance.isDistanceLess(10)) {//moves until distance at certain point
                telemetry.addData("back distance:", robot.backDistance.getDistance());
                telemetry.update();
                sleep(10);
            }

            //MOVING TO NUETRALS

            //TODO finish this code

            robot.driving.horizontal(1);
            while(robot.leftDistance.isDistanceGreater(35)){
                telemetry.addData("left distance:", robot.leftDistance.getDistance());
                telemetry.update();
                sleep(10);
            }
            robot.driving.stop();

            //turn left ninety degrees, figure out how to use driving library and IMU

            //strafe left and push yellow sample into triangle zone, using the color sensor

            //using distance sensor
            while (robot.leftDistance.isDistanceGreater(5)) {//moves until distance at certain point
                telemetry.addData("left distance:", robot.leftDistance.getDistance());
                telemetry.update();
                sleep(10);
            }
            robot.driving.stop();

            //using color sensor
            while(!robot.rightColor.redOrBlueTape()){
                telemetry.addData("tape","not found");
                telemetry.update();
                robot.driving.horizontal(-0.5f);
                sleep(20);
            }
            robot.driving.stop();

            //turn right ninety degrees

            //strafe all the way right into the red parking zone

            while(!robot.rightColor.redOrBlueTape()){
                telemetry.addData("tape","not found");
                telemetry.update();
                robot.driving.horizontal(0.5f);
                sleep(20);
            }
            robot.driving.stop();

        }

    }

}
