package org.firstinspires.ftc.teamcode.opModes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.commands.intake.IntakeCommand;
import org.firstinspires.ftc.teamcode.commands.intake.OuttakeCommand;
import org.firstinspires.ftc.teamcode.commands.drive.DriveBackwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.subsystems.DrivetrainSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;

    @Autonomous
    public class MainAuto extends CommandOpMode {
        //motors
        private Motor intakeMotor;
        private Motor leftMotorFront;
        private Motor leftMotorBack;
        private Motor rightMotorFront;
        private Motor rightMotorBack;

        //subsystems
        private IntakeSubsystem intakeSubsystem;
        private DrivetrainSubsystem drivetrainSubsystem;

        //commands
        private IntakeCommand intakeCommand;
        private OuttakeCommand outtakeCommand;
        private DriveForwardCommand driveForwardCommand;
        private DriveBackwardCommand driveBackwardCommand;

        //gamepads
        private GamepadEx driver;

        @Override
        public void initialize() {
            //this.intakeMotor = new Motor(hardwareMap, "intake");
            this.leftMotorFront = new Motor(hardwareMap, "leftMotorFront");
            this.rightMotorFront = new Motor(hardwareMap, "rightMotorFront");
            //this.leftMotorBack = new Motor(hardwareMap, "leftMotorBack");
            //this.rightMotorBack = new Motor(hardwareMap, "rightMotorBack");
            //this.intakeSubsystem = new IntakeSubsystem(this.intakeMotor);
            this.drivetrainSubsystem = new DrivetrainSubsystem(this.leftMotorFront, this.rightMotorFront);

            //this.intakeCommand = new IntakeCommand(this.intakeSubsystem);
            //this.outtakeCommand = new OuttakeCommand(this.intakeSubsystem);
            this.driveForwardCommand = new DriveForwardCommand(this.drivetrainSubsystem);
            this.driveBackwardCommand = new DriveBackwardCommand(this.drivetrainSubsystem);

            //driver.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenHeld(this.intakeCommand);
            //driver.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenHeld(this.outtakeCommand);
            //driver.getGamepadButton(GamepadKeys.Button.A).whenHeld(this.driveForwardCommand);
            //driver.getGamepadButton(GamepadKeys.Button.B).whenHeld(this.driveBackwardCommand);
            driveForwardCommand.execute();
            sleep(2000);
            drivetrainSubsystem.stop();
            sleep(2000);
            driveBackwardCommand.execute();
            sleep(2000);
            drivetrainSubsystem.stop();
        }
    }

