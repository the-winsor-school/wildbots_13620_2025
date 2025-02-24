package org.firstinspires.ftc.teamcode.Autons;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name = "QUALIFIER PARK short", group = "park" )
public class SimpleParkShort extends LinearOpMode {
    Robot robot;

    LinearOpMode OpMode;

    public void runOpMode() throws InterruptedException {
        robot = new Robot(this);

        waitForStart();

        if(opModeIsActive()) {
            robot.driving.horizontal(0.75f);
            sleep(3000);
            robot.driving.vertical(-0.5f);
            sleep(500);
            robot.driving.stop();
        }
    }
}
