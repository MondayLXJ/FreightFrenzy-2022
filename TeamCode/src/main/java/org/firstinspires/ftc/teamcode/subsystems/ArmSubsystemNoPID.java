package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class ArmSubsystemNoPID extends CommandBase {
    private Motor armMotor;

    public ArmSubsystemNoPID(Motor motor){
        this.armMotor = motor;
    }

    public void in() {
        armMotor.set(1.0);
    }

    public void out() {
        armMotor.set(-1.0);
    }

    public void stop() {
        armMotor.stopMotor();
    }
}
