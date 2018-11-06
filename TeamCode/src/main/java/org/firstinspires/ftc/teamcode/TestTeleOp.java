package org.firstinspires.ftc.teamcode;



import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp (name = "TestTeleOp", group = "JacobE")
public class TestTeleOp extends LinearOpMode
{

    private DcMotor motorLeft;
    private DcMotor motorRight;


    //public TeleOp10620() {

    //}

    @Override
    public void runOpMode()
    {
        DcMotor motorLeft = hardwareMap.dcMotor.get("motorLeft");
        DcMotor motorRight = hardwareMap.dcMotor.get("motorRight");

        motorLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        while(opModeIsActive())
        {

            double leftPower;
            double rightPower;
            double sanic;


            double drive = gamepad1.left_stick_y * 0.6;
            double turn  =  gamepad1.right_stick_x * 0.6;


            sanic = 1.0;
            leftPower    = drive + turn;
            rightPower   = drive - turn;
            double scale = Math.max(Math.abs(leftPower), Math.abs(rightPower));

            if (scale > 1) {
                scale = 1 / scale;
                leftPower *= scale;
                rightPower *= scale;
            }

            motorLeft.setPower(leftPower);
            motorRight.setPower(rightPower);
            if (gamepad1.a){
                motorLeft.setPower(sanic);
                motorRight.setPower(sanic);
            }

            idle();

        }

    }
}
