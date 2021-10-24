package org.firstinspires.ftc.teamcode.opModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp (name = "Gamepad Drive",group = "Training")
public class GamepadDriveTeleOp extends OpMode {

    DcMotor leftWheel;
    DcMotor rightWheel;

    double leftWheelPower;
    double rightWheelPower;

    @Override
    public void  init(){
        leftWheel = hardwareMap.dcMotor.get("left_wheel");
        rightWheel = hardwareMap.dcMotor.get("right_wheel");

        rightWheel.setDirection(DcMotor.Direction.REVERSE);

    }

    @Override
    public void loop(){
        leftWheelPower = gamepad1.left_stick_y;
        rightWheelPower = gamepad1.right_stick_y;

        leftWheel.setPower(leftWheelPower);
        rightWheel.setPower(rightWheelPower);
    }

}
