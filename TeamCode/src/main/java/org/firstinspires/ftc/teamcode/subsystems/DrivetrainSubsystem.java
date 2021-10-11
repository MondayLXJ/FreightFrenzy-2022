package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class DrivetrainSubsystem extends SubsystemBase {
    private Motor leftMotorFront;
    private Motor leftMotorBack;
    private Motor rightMotorFront;
    private Motor rightMotorBack;

    public DrivetrainSubsystem(Motor leftMotorBack, Motor leftMotorFront, Motor rightMotorBack, Motor rightMotorFront){
        this.leftMotorBack = leftMotorBack;
        this.leftMotorFront = leftMotorFront;
        this.rightMotorBack = rightMotorBack;
        this.rightMotorFront = rightMotorFront;
    }

    public void forward(){
        leftMotorFront.set(1.0);
        leftMotorBack.set(1.0);
        rightMotorFront.set(1.0);
        rightMotorBack.set(1.0);
    }

    public void backward(){
        leftMotorFront.set(-1.0);
        leftMotorBack.set(-1.0);
        rightMotorFront.set(-1.0);
        rightMotorBack.set(-1.0);
    }

    /*
    public void left(){
        leftMotorFront.set(1.0);
        leftMotorBack.set(1.0);
        rightMotorFront.set(1.0);
        rightMotorBack.set(1.0);
    }

    public void right(){
        leftMotorFront.set(1.0);
        leftMotorBack.set(1.0);
        rightMotorFront.set(1.0);
        rightMotorBack.set(1.0);
    }
    */
    public void stop() {
        leftMotorBack.stopMotor();
        rightMotorBack.stopMotor();
        leftMotorFront.stopMotor();
        rightMotorFront.stopMotor();
    }
}
