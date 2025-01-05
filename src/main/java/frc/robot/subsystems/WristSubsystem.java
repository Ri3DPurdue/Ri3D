package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class WristSubsystem {
    private final double speed = 0.5;
    private final SparkMax wristMotor = new SparkMax(10, MotorType.kBrushless);

    public void tiltDown() {
        wristMotor.set(speed);
    }

    public void tiltUp() {
        wristMotor.set(-speed);
    }

    public void stop() {
        wristMotor.stopMotor();
    }
}
