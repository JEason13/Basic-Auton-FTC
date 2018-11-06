package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name="TestAuton", group="JacobE")
public class TestAuton extends LinearOpMode {

    /* Declare OpMode members. */
    private DcMotor motorLeft;
    private DcMotor motorRight;
    private ElapsedTime     runtime;

    static final double     DRIVE_SPEED = -0.45;
    static final double     TURN_SPEED = 0.3;
    static final double     SANIC_MODE = 1.0;

    @Override
    public void runOpMode() {
        motorRight = hardwareMap.dcMotor.get("motorRight");
        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        runtime = new ElapsedTime();


        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        motorLeft.setPower(DRIVE_SPEED);
        motorRight.setPower(-DRIVE_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 3.0)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        motorRight.setPower(TURN_SPEED);
        motorLeft.setPower(-TURN_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.3)) {
            telemetry.addData("Path", "Leg 2: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }


        motorRight.setPower(DRIVE_SPEED);
        motorLeft.setPower(-DRIVE_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 2.5)) {
            telemetry.addData("Path", "Leg 3: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        motorRight.setPower(TURN_SPEED);
        motorLeft.setPower(-TURN_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 2.6)) {
            telemetry.addData("Path", "Leg 4: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }


        motorRight.setPower(SANIC_MODE);
        motorLeft.setPower(SANIC_MODE);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 4.0)) {
            telemetry.addData("Path", "Leg 4: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }


        motorRight.setPower(-DRIVE_SPEED);
        motorLeft.setPower(-DRIVE_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.1))
            telemetry.addData("Path", "Leg 5: %2.5f S Elapsed", runtime.seconds());
        telemetry.update();

        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);
    }
}
