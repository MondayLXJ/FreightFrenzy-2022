package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.util.Timing;

public class ArmSubsystemNoPID extends CommandBase {
    private Motor armMotor;
    private Timing.Timer timer = new Timing.Timer(5);

    public ArmSubsystemNoPID(Motor motor){
        this.armMotor = motor;
    }

    public void raise() {
        armMotor.set(1.0);
    }

    public void reduce() {
        armMotor.set(-1.0);
    }

    public void stop() {
        armMotor.stopMotor();
    }
}
