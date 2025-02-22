
package org.firstinspires.ftc.teamcode.Autons;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
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

        robot.fullLift.claw.moveClaw(ClawPosition.CLOSE);

        waitForStart();

        if (opModeIsActive()) {

            while((robot.fullLift.cascade.canGo(0.5f) || robot.fullLift.drawBridge.canGo(0.25f) ) && opModeIsActive()) {
                robot.fullLift.cascade.Go(0.5f);
                robot.fullLift.drawBridge.Go(0.4f);
            }

            robot.fullLift.drawBridge.Go(0);

            //get specific distance while moving at a slower pace

            sleep(2000);
            telemetry.addData("back distance:", robot.backDistance.getDistance());
            telemetry.update();

            while (robot.backDistance.isDistanceLess(72) && opModeIsActive()) {
                driving.vertical(.5);
                telemetry.addData("back distance:", robot.backDistance.getDistance());
                telemetry.update();
            }
            driving.stop();

            sleep(1000);

            robot.fullLift.cascade.Go(-1);
            sleep(2500);
            robot.fullLift.drawBridge.Go(0.5f);
            sleep(500);

            robot.fullLift.cascade.Go(0);
            robot.fullLift.drawBridge.Go(0);

            robot.fullLift.claw.moveClaw(ClawPosition.OPEN);

            //moving back to the wall after placing the spec

            while (robot.backDistance.isDistanceGreater(10)) {
                driving.vertical(-0.5);
                telemetry.addData("back distance:", robot.backDistance.getDistance());
                telemetry.update();
            }

            //moving to observation zone
            robot.driving.turn(-0.75);
            sleep(1500);
            robot.driving.vertical(0.75f);
            sleep(1500);
            while(!(robot.leftColor.redOrBlueTape() || robot.rightColor.redOrBlueTape())){
                telemetry.addData("tape", "not found");
                telemetry.update();
                robot.driving.vertical(0.25f);
                sleep(10);
            }

            robot.driving.stop();

        }
    }

}

