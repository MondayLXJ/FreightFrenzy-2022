package org.firstinspires.ftc.teamcode.opModes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.commands.groups.AutoCommand;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSubsystem;

@Autonomous
    public class AutoRoutine extends CommandOpMode {
        //motors

        //subsystems
        private MecanumDriveSubsystem mecanumDriveSubsystem;

        //commands

        //command groups
        private AutoCommand autoRoutine;

        //gamepads

        @Override
        public void initialize() {
            this.mecanumDriveSubsystem = new MecanumDriveSubsystem(new SampleMecanumDrive(hardwareMap), false);
            schedule(this.autoRoutine);
        }
    }

