package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.ArmLift.FullArmLift;

/**
 * In this file we:
 * initalize all the sensors, motors, and libraries
 * the motors and sensors go here so we are only initializing them in one place in the whole repo
 * (to avoid mistakes and conflicts)
 * the libraries like IDriving and arm etc are intialized here so they are also only in one place
 * the libaries also ahve access to everything within the robot class like the motors if they are intialized in this way
 * when you create a new opMode you should only initlaize the robot class (by passing the opMode (by writing "this" in the parentheses)
 * you cannot access any of the sensors or motors outside of this class (because encapsulation and saefty)
 * you can only control things by using the libraries and the functions within them that are public
 */
public class Robot {

    /**
     * itializtion of all sensors and motors
     */
    //wheels
    //rf, rb, lf, lb
    private DcMotor rf;
    private DcMotor rb;
    private DcMotor lf;
    private DcMotor lb;
    //lift
    private DcMotor liftMotor;

    public StrafeDrive driving;

    private LinearOpMode opMode;

    private ColorSensor color;

    private DistanceSensor distanceBack;

    private DistanceSensor distanceLeft;

    private FullArmLift lift;

    /**
     * @param opMode pass by writing: new Robot(this);
     */
    public Robot(LinearOpMode opMode) {
        HardwareMap map = opMode.hardwareMap;
        this.opMode = opMode;

        //wheels
        rf = map.tryGet(DcMotor.class, "rf");
        rb = map.tryGet(DcMotor.class, "rb");
        lf = map.tryGet(DcMotor.class, "lf");
        lb = map.tryGet(DcMotor.class, "lb");

        lb.setDirection(DcMotor.Direction.REVERSE);

        liftMotor = map.tryGet(DcMotor.class, "lift");

        color = map.tryGet(ColorSensor.class, "color");
        distanceBack = map.tryGet(DistanceSensor.class, "backDistance");
        distanceLeft = map.tryGet(DistanceSensor.class, "leftDistance");
        driving = new StrafeDrive(rf, rb, lf, lb);

        lift = new FullArmLift(liftMotor);
    }

    public void printWheelPowers() {
        opMode.telemetry.addData("rf: ", rf.getPower());
        opMode.telemetry.addData("lf: ", lf.getPower());
        opMode.telemetry.addData("rb: ", rb.getPower());
        opMode.telemetry.addData("lb: ", lb.getPower());

    }

    public enum Direction {
        LEFT,
        RIGHT,
        FRONT,
        BACK
    }

    public boolean checkRedTape() {
        if (color.red()  > 2500) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkBlueTape() {
        if (color.blue() > 2500)
            return true;
        return false;
    }

    public void printColorValues(){
        opMode.telemetry.addData("red:", color.red());
        opMode.telemetry.addData("blue", color.blue());
        opMode.telemetry.addData("green", color.green());
        opMode.telemetry.update();
    }

    public void printBackDistanceValues(){
        opMode.telemetry.addData("back distance", checkBackDistance());
        opMode.telemetry.update();
    }

    public void printLeftDistanceValues(){
        opMode.telemetry.addData("left distance", checkLeftDistance());
        opMode.telemetry.update();
    }

    public boolean checkWhiteTape() {
        if (color.red() > 500 && color.blue() > 500 && color.green() > 500)
            return true;
        return false;
    }

    public boolean checkEndTape() {
        if (checkBlueTape() || checkRedTape())
            return true;
        return false;
    }

    public boolean checkANYTape() {
        if (checkEndTape() || checkWhiteTape())
            return true;
        return false;
    }

    public double checkBackDistance(){
        return distanceBack.getDistance(DistanceUnit.CM);
    }

    public double checkLeftDistance(){
        return distanceLeft.getDistance(DistanceUnit.CM);
    }

}
