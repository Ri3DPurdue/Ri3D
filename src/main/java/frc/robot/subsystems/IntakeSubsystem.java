package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase{
    private final double speed = 1;
    private final SparkMax intakeMotor = new SparkMax(9,MotorType.kBrushless);

    public void grab() {
        intakeMotor.set(speed);
    }

    public void release() {
        intakeMotor.set(-speed);
    }

    public void stop() {
        intakeMotor.stopMotor();
    }
}
