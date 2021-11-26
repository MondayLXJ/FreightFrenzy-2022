package org.firstinspires.ftc.teamcode.commands.groups;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSubsystem;

public class AutoCommand extends SequentialCommandGroup {

    public AutoCommand(MecanumDriveSubsystem dt){
        addCommands(
                new NavToHubCommand(dt),
                new WaitCommand(500)
        );
    }
}
