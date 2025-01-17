package org.firstinspires.ftc.teamcode.Autons;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.ArmLift.Enums.ClawPosition;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.StrafeDrive;

//Level 4 in Slideshow
//@Disabled
@Autonomous(name = "Specimen, Push Block, & Park", group="spec")
public class SpecPark extends LinearOpMode {

    Robot robot;
    StrafeDrive driving;

    LinearOpMode opMode;

    public void runOpMode() throws InterruptedException {
        robot = new Robot(this);
        driving = robot.driving;

        waitForStart();

        if (opModeIsActive()) {

            robot.fullLift.drawbridge.runToPosition(4765);

            //moving forward to place spec
            driving.vertical(0.25);
            telemetry.addData("moving forward", "no loop");
            telemetry.update();
            sleep(500);

            telemetry.addData("back distance:", robot.backDistance.getDistance());
            telemetry.update();

            //get specific distance while moving at a slower pace
            driving.vertical(0.25);
            while (robot.backDistance.isDistanceGreater(54)) {
                telemetry.addData("back distance:", robot.backDistance.getDistance());
                telemetry.update();
                sleep(10);
            }

            //TODO robot places spec
            while (!robot.fullLift.topLiftLimit.isPressed()){
                robot.fullLift.claw.moveClaw(ClawPosition.CLOSE);
                robot.fullLift.cascade.setMotorPower(0.25f);
            }

            robot.driving.vertical(0.25f);
            sleep(1000);

            robot.fullLift.cascade.setMotorPower(-0.5f);
            sleep(2000);
            robot.fullLift.claw.moveClaw(ClawPosition.OPEN);

            //moving back to the wall after placing the spec
            driving.vertical(-0.25);

            while (robot.backDistance.isDistanceLess(10)) {
                telemetry.addData("back distance:", robot.backDistance.getDistance());
                telemetry.update();
                sleep(10);
            }

            //moving to observation zone
            driving.horizontal(0.7);
            sleep(5000);
            driving.horizontal(0.5);
            while(!(robot.leftColor.redOrBlueTape() || robot.rightColor.redOrBlueTape())){
                telemetry.addData("tape","not found");
                telemetry.update();
                sleep(20);
            }

            robot.driving.stop();
        }
    }

}
