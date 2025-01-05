package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class WristSubsystem extends SubsystemBase{
    private final SparkMax wristMotor = new SparkMax(10, MotorType.kBrushless);

    public void run(double speed) {
        wristMotor.set(speed);
    }

    public void stop() {
        wristMotor.stopMotor();
    }
}