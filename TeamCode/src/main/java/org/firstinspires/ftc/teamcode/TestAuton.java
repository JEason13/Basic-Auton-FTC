/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/*
This is a 25.6 second long Autonomous program that basically does a bunch of random crap.
Long story short, it drives forward for 3 seconds, then turns right. Then it drives forward for
2 seconds and turns left. it then drives forward for another 2 seconds. then it stops for 3 seconds
to give the motors a quick break, and then goes into sanic mode which means it goes at full power
for 3 seconds. Then stops for another 4 seconds, and then spins in a circle very fast for 5 seconds.
Okay, now it's done and you can go on with your life. go, shoo! get on with it! And never you'll
never speak of this autonomous program again, kapeesh? Other wise, you'll be sleeping with digital
fishes! ha ha ha ha ha ha ha ha ha hah hah hhaahhaahahahahaahahahaa! jk jk jk jk jk jk jkjkkjkjkjk.
*/


@Autonomous(name="TestAuton", group="JacobEason")
public class TestAuton extends LinearOpMode {

    /* Declare OpMode members. */
    private DcMotor motorLeft = hardwareMap.dcMotor.get("motorLeft");
    private DcMotor motorRight = hardwareMap.dcMotor.get("motorRight");
    private ElapsedTime     runtime = new ElapsedTime();


    static final double     FORWARD_SPEED = 0.5;
    static final double     TURN_SPEED    = 0.4;
    static final double     ACCELERATION_MODE = 1.0;
    
    @Override
    public void runOpMode() {
        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Step through each leg of the path, ensuring that the Auto mode has not been stopped along the way

        // Step 1:  Drive forward for 3 seconds
        motorLeft.setPower(FORWARD_SPEED);
        motorRight.setPower(FORWARD_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 3.0)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        // Step 2:  Spin right for 1.3 seconds
        motorLeft.setPower(TURN_SPEED);
        motorRight.setPower(-TURN_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.3)) {
            telemetry.addData("Path", "Leg 2: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        // Step 3:  Drive forward for 2 Seconds
        motorLeft.setPower(FORWARD_SPEED);
        motorRight.setPower(FORWARD_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 2.0)) {
            telemetry.addData("Path", "Leg 3: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        // Step 4:  Spin left for 1.3 seconds
        motorLeft.setPower(-TURN_SPEED);
        motorRight.setPower(TURN_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.3)) {
            telemetry.addData("Path", "Leg 4: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        // Step 5:  Drive forward for 2 Seconds
        motorLeft.setPower(FORWARD_SPEED);
        motorRight.setPower(FORWARD_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 2.0)) {
            telemetry.addData("Path", "Leg 5: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        // Step 6:  Stop for 3 seconds
        motorLeft.setPower(0);
        motorRight.setPower(0);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 3.0)) {
            telemetry.addData("Path", "Leg 6: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        // Step 7:  Go sanic go! (for 3 seconds)
        motorLeft.setPower(ACCELERATION_MODE);
        motorRight.setPower(ACCELERATION_MODE);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 3.0)) {
            telemetry.addData("Path", "Leg 7: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        // Step 8:  Stopping, for good this time... (or is it?)
        motorLeft.setPower(0);
        motorRight.setPower(0);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 4.0)) {
            telemetry.addData("Path", "Leg 8: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        // Step 9:  huh, I guess that wasn't the end... (spin in a circle for 5 seconds, yay!)
        motorLeft.setPower(ACCELERATION_MODE);
        motorRight.setPower(-ACCELERATION_MODE);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 5.0)) {
            telemetry.addData("Path", "Leg 9: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);
    }
}
