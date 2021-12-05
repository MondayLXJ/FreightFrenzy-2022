package org.firstinspires.ftc.teamcode.subsystems;

/*
 * once again, thx 21864
 * might need to change this to match arm pid
 */

import com.arcrobotics.ftclib.controller.wpilibcontroller.ArmFeedforward;
import com.arcrobotics.ftclib.controller.wpilibcontroller.ProfiledPIDController;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.trajectory.TrapezoidProfile;

public class ArmSubsystem extends ProfiledPIDSubsystem {
    private Motor armMotor;
    private static double kS = 1.0, kCos = 1.0, kV = 1.0, kA = 1.0;
    private final ArmFeedforward armFeedforward = new ArmFeedforward(kS, kCos, kV, kA);

    private static double kP = 1.0, kI = 0, kD = 0;
    private final double distancePerPulse = Math.PI * 0.05 / 537.7; //change based on encoder pulses for given motor

    public ArmSubsystem(Motor motor) {
        super(new ProfiledPIDController(kP, kI, kD, new TrapezoidProfile.Constraints(5.0, 3.0)), 0.0);
        this.armMotor = motor;

        armMotor.encoder.setDistancePerPulse(distancePerPulse);
    }

    @Override
    protected void useOutput(double output, TrapezoidProfile.State setPoint) {
        double feedForward = armFeedforward.calculate(setPoint.position, setPoint.velocity, 1); // idk what to set accel to
        armMotor.set(((output + feedForward) / distancePerPulse) / armMotor.ACHIEVABLE_MAX_TICKS_PER_SECOND);
    }

    @Override
    protected double getMeasurement() {
        return armMotor.encoder.getDistance();
    }

    public void setMotor(){
        armMotor.set(0.5);
    }
}