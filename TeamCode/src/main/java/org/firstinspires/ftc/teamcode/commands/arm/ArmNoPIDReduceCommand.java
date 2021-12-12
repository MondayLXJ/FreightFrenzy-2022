package org.firstinspires.ftc.teamcode.commands.arm;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystemNoPID;

public class ArmNoPIDReduceCommand extends CommandBase {
    private final ArmSubsystemNoPID armSubsystem;

    public ArmNoPIDReduceCommand(ArmSubsystemNoPID armSubsystem) {
        this.armSubsystem = armSubsystem;
    }

    @Override
    public void execute() {
        armSubsystem.reduce();
    }

    @Override
    public void end(boolean interrupted) {
        armSubsystem.stop();
    }
}
