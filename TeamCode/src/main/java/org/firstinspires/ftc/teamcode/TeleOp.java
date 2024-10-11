package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Arm.Claw;

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

            //robot.driving.joystickDrive(x, y, t);


            //_______________________________________________
            //             MECH CONTROLLER
            //_______________________________________________


            //ADD MECH CODE HERE FOR GAMEPAD2
            if (gamepad2.right_bumper) {
                robot.clawServo.moveClaw(ClawPosition.OPEN);
            }
            if (gamepad2.left_bumper) {
                robot.clawServo.moveClaw(ClawPosition.CLOSE);
            }
            if (!gamepad2.left_bumper && !gamepad2.right_bumper){
                robot.clawServo.moveClaw(ClawPosition.STOP);
            }
            //_______________________________________________
            //             PRINT STATEMENTS
            //_______________________________________________


            telemetry.addLine("----------------WHEELS-------------------------");

            //joystick inputs
            telemetry.addData("x: ", x);
            telemetry.addData("y: ", y);
            telemetry.addData("t: ", t);

            //wheels powers
            /*
            robot.printWheelPowers();
             */

            telemetry.update();
        }
    }
}