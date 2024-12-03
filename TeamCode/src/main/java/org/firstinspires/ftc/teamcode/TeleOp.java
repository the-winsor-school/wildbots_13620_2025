package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.ArmLift.ClawPosition;


@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "TeleOp")
public class TeleOp extends LinearOpMode {

    Robot robot;

    public void runOpMode() throws InterruptedException {
        robot = new Robot(this);

        waitForStart();

        while (opModeIsActive()){

            //_______________________________________________
            //             MAIN CONTROLLER
            //_______________________________________________
            
            float x = gamepad1.right_stick_x;
            float y = -gamepad1.right_stick_y; //inputs from joystick are opposite
            float t = gamepad1.left_stick_x;

            robot.driving.joystickDrive(x, y, t);


            //_______________________________________________
            //             MECH CONTROLLER
            //_______________________________________________

            //joystick controls

            //have to fix cascade
            robot.fullLift.joystickControlCascade(gamepad2.left_stick_y);

            robot.fullLift.joystickControlDrawbridge(gamepad2.right_stick_y);

            //levels - not tested yet
/*            if (gamepad1.x)
                robot.fullLift.moveLiftToPosition(FullArmLift.LIFT_POSITION.RESET);
            if (gamepad1.a)
                robot.fullLift.moveLiftToPosition(FullArmLift.LIFT_POSITION.HIGHRUNG);
            if (gamepad1.b)
                robot.fullLift.moveLiftToPosition(FullArmLift.LIFT_POSITION.LOWRUNG);
                */

            //ADD MECH CODE HERE FOR GAMEPAD2
            if (gamepad2.right_bumper) {
                robot.fullLift.claw.moveClaw(ClawPosition.CLOSE);
            }
            if (gamepad2.left_bumper) {
                robot.fullLift.claw.moveClaw(ClawPosition.OPEN);
            }
            if (!gamepad2.left_bumper && !gamepad2.right_bumper) {
                robot.fullLift.claw.moveClaw(ClawPosition.STOP);
            }

            //robot.claw.moveClaw(ClawPosition.OPEN);
            //sleep(100);



            //_______________________________________________
            //             PRINT STATEMENTS
            //_______________________________________________


            telemetry.addLine("----------------WHEELS-------------------------");

            //joystick inputs
            telemetry.addData("x: ", x);
            telemetry.addData("y: ", y);
            telemetry.addData("t: ", t);

            telemetry.addData("claw position: ", robot.fullLift.claw.getCurrentPosition());

            //wheels powers
            /*
            robot.printWheelPowers();
             */

            telemetry.addLine("----------------LIFT-------------------------");

            telemetry.addData("Cascade", robot.fullLift.cascade.getMotorState());
            telemetry.addData("Drawbridge", robot.fullLift.drawbridge.getMotorState());

            telemetry.update();
        }
    }
}