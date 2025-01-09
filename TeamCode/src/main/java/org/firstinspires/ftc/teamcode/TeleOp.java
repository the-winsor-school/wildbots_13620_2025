package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.ArmLift.Enums.ClawPosition;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "TeleOp")
public class TeleOp extends LinearOpMode {

    Robot robot;

    public void runOpMode() throws InterruptedException {
        robot = new Robot(this);

        waitForStart();

        while (opModeIsActive()){

            //_______________________________________________
            //             MAIN CONTROLLER (gamepad1)
            //_______________________________________________
            
            float x = gamepad1.right_stick_x;
            float y = -gamepad1.right_stick_y; //inputs from joystick are opposite
            float t = gamepad1.left_stick_x;

            robot.driving.joystickDrive(x, y, t);


            //_______________________________________________
            //             MECH CONTROLLER (gamepad2)
            //_______________________________________________

            //joystick controls

            //have to fix cascade
            robot.fullLift.joystickControlCascade(gamepad2.left_stick_y);
            robot.fullLift.joystickControlDrawbridge(gamepad2.right_stick_y);

            //levels - not tested yet
/*            if (gamepad1.x)
                robot.fullLift.moveLiftToPosition(FullArmLift.LIFT_POSITION.RESET);
            if (gamepad1.a)
                robot.fullLift.moveLiftToPosition(FullArmLift.LIFT_POSITION.HIGH_RUNG);
            if (gamepad1.b)
                robot.fullLift.moveLiftToPosition(FullArmLift.LIFT_POSITION.LOW_RUNG);
                */

            //claw code
            if (gamepad2.right_bumper)
                robot.fullLift.claw.moveClaw(ClawPosition.CLOSE);
            if (gamepad2.left_bumper)
                robot.fullLift.claw.moveClaw(ClawPosition.OPEN);
            if (!gamepad2.left_bumper && !gamepad2.right_bumper)
                robot.fullLift.claw.moveClaw(ClawPosition.STOP);

            //_______________________________________________
            //             PRINT STATEMENTS
            //_______________________________________________


            telemetry.addLine("_________________WHEELS_________________");

            //joystick inputs
            telemetry.addData("x: ", x);
            telemetry.addData("y: ", y);
            telemetry.addData("t: ", t);

            //wheels powers
            /*
            robot.printWheelPowers();
             */

            telemetry.addLine("_________________LIFT_________________");

            telemetry.addData("Cascade: ", robot.fullLift.cascade.getMotorState());
            telemetry.addData("Drawbridge: ", robot.fullLift.drawbridge.getMotorState());

            telemetry.addData("claw position: ", robot.fullLift.claw.getCurrentPosition());

            telemetry.update();
        }
    }
}