package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class StrafeDrive {

    private DcMotor rf;
    private DcMotor rb;
    private DcMotor lf;
    private DcMotor lb;

    private double speed = 0.25;

    public StrafeDrive(DcMotor rf, DcMotor rb, DcMotor lf, DcMotor lb, DcMotor.ZeroPowerBehavior zeroPowerBehavior) {
        this.rf = rf;
        this.rb = rb;
        this.lf = lf;
        this.lb =lb;

        rf.setZeroPowerBehavior(zeroPowerBehavior);
        rb.setZeroPowerBehavior(zeroPowerBehavior);
        lf.setZeroPowerBehavior(zeroPowerBehavior);
        lb.setZeroPowerBehavior(zeroPowerBehavior);
    }


    public void joystickDrive (float X, float Y, float T) {
        //threshold for values (bc our controllers are old and bad)
        //these are condensed if statements
        float x = (Math.abs(X) < 0.1f) ? 0 : X;
        float y = (Math.abs(Y) < 0.1f) ? 0 : Y;
        float t = (Math.abs(T) < 0.1f) ? 0 : T;

        //explanation in drive and slack
        rf.setPower((y - x - t) * speed);
        rb.setPower((y + x - t) * speed);
        lf.setPower((y + x + t) * speed);
        lb.setPower((y - x + t) * speed);
    }

    public void turn (double t) {
        setEachPower(t, t, -t, -t);
    }

    public void horizontal (double power) { //right positive
        setEachPower(-power, power, power, -power); // -rf, +rb, lf, -lb)
    }

    public void vertical (double power) { //forward positive
        setEachPower(power,  power, power, power); //one side negative -rf, -rb
    }

    public void stop () {
        rf.setPower(0);
        rb.setPower(0);
        lf.setPower(0);
        lb.setPower(0);
    }

    private void setEachPower (double rfp, double rbp, double lfp, double lbp) {
        rf.setPower(rfp * speed);
        rb.setPower(rbp * speed);
        lf.setPower(lfp * speed);
        lb.setPower(lbp * speed);
    }

    public void adjustSpeed(double x) {
        speed = speed + x;
    }

    public double getSpeed() { return speed; }

}
