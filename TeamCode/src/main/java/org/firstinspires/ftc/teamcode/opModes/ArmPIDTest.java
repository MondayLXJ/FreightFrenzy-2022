package org.firstinspires.ftc.teamcode.opModes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.arm.ArmCommand;
import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;

@TeleOp
public class ArmPIDTest extends CommandOpMode {
    //motors
    private Motor armMotor;

    //subsystems
    private ArmSubsystem armSubsystem;

    //commands
    private ArmCommand armCommand;

    //gamepads
    private GamepadEx driver;

    @Override
    public void initialize() {
        this.armMotor = new Motor(hardwareMap, "armMotor");

        this.armSubsystem = new ArmSubsystem(armMotor);

        this.armCommand = new ArmCommand(armSubsystem, telemetry);
        this.driver = new GamepadEx(gamepad1);

        driver.getGamepadButton(GamepadKeys.Button.Y).whenPressed(armCommand);
    }
}
