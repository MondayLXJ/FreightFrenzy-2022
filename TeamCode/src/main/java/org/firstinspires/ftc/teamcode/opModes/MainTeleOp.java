package org.firstinspires.ftc.teamcode.opModes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.commands.arm.DumpArmCommand;
import org.firstinspires.ftc.teamcode.commands.arm.ResetArmCommand;
import org.firstinspires.ftc.teamcode.commands.drive.MecanumDriveCommand;
import org.firstinspires.ftc.teamcode.commands.intake.IntakeCommand;
import org.firstinspires.ftc.teamcode.commands.intake.OuttakeCommand;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSubsystem;


@TeleOp(name = "TeleOp")
public class  MainTeleOp extends CommandOpMode {
    //motors
    private Motor intakeMotor;
    public Servo arm = null;



    //subsystems
    private IntakeSubsystem intakeSubsystem;
    private MecanumDriveSubsystem mecanumDriveSubsystem;
    private ArmSubsystem armSubsystem;

    //commands
    private IntakeCommand intakeCommand;
    private OuttakeCommand outtakeCommand;
    private DumpArmCommand dumpArmCommand;
    private ResetArmCommand resetArmCommand;
    private MecanumDriveCommand mecanumDriveCommand;

    //gamepads
    private GamepadEx driver;

    HardwareMap hwMap = null;

    @Override
    public void initialize() {
        //this.intakeMotor = new Motor(hardwareMap, "intake");
        //this.armServo = hardwareMap.get(Servo.class, "armServo");

        //this.intakeSubsystem = new IntakeSubsystem(this.intakeMotor);
        this.mecanumDriveSubsystem = new MecanumDriveSubsystem(new SampleMecanumDrive(hardwareMap), false);
        //this.armSubsystem = new ArmSubsystem(this.armServo);

        //this.intakeCommand = new IntakeCommand(this.intakeSubsystem);
        //this.outtakeCommand = new OuttakeCommand(this.intakeSubsystem);
        driver = new GamepadEx(gamepad1);
        this.mecanumDriveCommand = new MecanumDriveCommand(this.mecanumDriveSubsystem, () -> driver.getLeftY(),
                driver::getLeftX, driver::getRightX
        );
        //this.dumpArmCommand = new DumpArmCommand(this.armSubsystem);
        //this.resetArmCommand = new ResetArmCommand(this.armSubsystem);


        //driver.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenHeld(this.intakeCommand);
        //driver.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenHeld(this.outtakeCommand);

        register(this.mecanumDriveSubsystem);
        this.mecanumDriveSubsystem.setDefaultCommand(this.mecanumDriveCommand);

        //driver.getGamepadButton(GamepadKeys.Button.A).whenPressed(
        //        armSubsystem.isDumping() ? this.resetArmCommand : this.dumpArmCommand
        //);


    }
}
