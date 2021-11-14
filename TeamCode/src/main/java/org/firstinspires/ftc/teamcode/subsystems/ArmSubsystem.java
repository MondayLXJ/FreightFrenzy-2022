package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.Servo;

public class ArmSubsystem extends SubsystemBase {
    private Servo arm;
    private boolean dumping = false;

    final double armSpeed = 0.3;
    double armPos = 0.0;

    public final static double ARM_HOME = 0.0;
    public final static double ARM_MIN_RANGE = 0.0;
    public final static double ARM_MAX_RANGE = 1.0;

    public ArmSubsystem(Servo arm){ this.arm = arm; }

    public void resetArm(){
        arm.setPosition(.1);
        this.dumping = false;
    }

    public void moveArmUp(){arm.setPosition(armSpeed);}

    public void moveArmDown(){arm.setPosition(-armSpeed);}



    public boolean isDumping() {
        return this.dumping;
    }

    public void dumpArm(){
        arm.setPosition(.75);
        this.dumping = true;
    }
}

