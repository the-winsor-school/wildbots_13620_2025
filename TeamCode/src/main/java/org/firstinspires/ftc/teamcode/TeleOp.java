package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.ArmLift.FullArmLift;
import org.firstinspires.ftc.teamcode.ArmLift.MotorState;

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
            robot.fullLift.joystickControlCascade(gamepad1.left_stick_y);
            robot.fullLift.joystickControlDrawbridge(gamepad1.right_stick_y);

            //levels - not tested yet
/*            if (gamepad1.x)
                robot.fullLift.moveLiftToPosition(FullArmLift.LIFT_POSITION.RESET);
            if (gamepad1.a)
                robot.fullLift.moveLiftToPosition(FullArmLift.LIFT_POSITION.HIGHRUNG);
            if (gamepad1.b)
                robot.fullLift.moveLiftToPosition(FullArmLift.LIFT_POSITION.LOWRUNG);
                */

            //_______________________________________________
            //             PRINT STATEMENTS
            //_______________________________________________


            telemetry.addLine("----------------WHEELS-------------------------");

            //joystick inputs
            telemetry.addData("x: ", x);
            telemetry.addData("y: ", y);
            telemetry.addData("t: ", t);

            //wheels powers
            robot.printWheelPowers();


            telemetry.update();
        }
    }
}