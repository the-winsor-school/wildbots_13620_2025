package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "testing")
public class TestingAuton extends LinearOpMode {

    Robot robot;

    LinearOpMode opMode;

    public void runOpMode() throws InterruptedException {

        waitForStart();

        while (opModeIsActive()) {

            telemetry.addLine("_______Gampepad1________");
            telemetry.addData("right x:", gamepad1.right_stick_x);
            telemetry.addData("right y:", gamepad1.right_stick_y);
            telemetry.addData("left x:", gamepad1.left_stick_x);
            telemetry.addData("left y:", gamepad1.left_stick_y);
            telemetry.addLine();
            telemetry.addData("a:", gamepad1.a);
            telemetry.addData("b:", gamepad1.b);
            telemetry.addData("x:", gamepad1.x);
            telemetry.addData("y:", gamepad1.y);
            telemetry.addLine();
            telemetry.addData("dpad up:", gamepad1.dpad_up);
            telemetry.addData("dpad down:", gamepad1.dpad_down);
            telemetry.addData("dpad left:", gamepad1.dpad_left);
            telemetry.addData("dpad right:", gamepad1.dpad_right);
            telemetry.addLine();
            telemetry.addData("right bumper:", gamepad1.right_bumper);
            telemetry.addData("left bumper:", gamepad1.left_bumper);
            telemetry.addData("right trigger:", gamepad1.right_trigger);
            telemetry.addData("left trigger:", gamepad1.left_trigger);

            telemetry.update();
        }

    }
}