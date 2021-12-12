package org.firstinspires.ftc.teamcode.opModes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.arm.ArmNoPIDRaiseCommand;
import org.firstinspires.ftc.teamcode.commands.arm.ArmNoPIDReduceCommand;
import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystemNoPID;

@TeleOp
public class ArmNoPIDTest extends CommandOpMode {
    //motors
    private Motor armMotor;

    //subsystems
    private ArmSubsystemNoPID armSubsystem;

    //commands
    private ArmNoPIDReduceCommand reduceCommand;
    private ArmNoPIDRaiseCommand raiseCommand;

    //gamepads
    private GamepadEx driver;

    @Override
    public void initialize() {
        this.armMotor = new Motor(hardwareMap, "armMotor");

        this.armSubsystem = new ArmSubsystemNoPID(armMotor);

        this.reduceCommand = new ArmNoPIDReduceCommand(armSubsystem);
        this.raiseCommand = new ArmNoPIDRaiseCommand(armSubsystem);

        this.driver = new GamepadEx(gamepad1);

        driver.getGamepadButton(GamepadKeys.Button.Y).whenPressed(reduceCommand);
        driver.getGamepadButton(GamepadKeys.Button.X).whenPressed(raiseCommand);
    }
}
