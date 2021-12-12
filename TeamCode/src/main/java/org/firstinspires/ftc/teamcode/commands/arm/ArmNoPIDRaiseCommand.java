package org.firstinspires.ftc.teamcode.commands.arm;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystemNoPID;

public class ArmNoPIDRaiseCommand extends CommandBase {
    private final ArmSubsystemNoPID armSubsystem;

    public ArmNoPIDRaiseCommand(ArmSubsystemNoPID armSubsystem) {
        this.armSubsystem = armSubsystem;
    }

    @Override
    public void execute() {
        armSubsystem.raise();
    }

    @Override
    public void end(boolean interrupted) {
        armSubsystem.stop();
    }
}
