package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberSubsystem extends SubsystemBase {

    private final SparkMax winchMotor;

    public ClimberSubsystem(int id) {
        winchMotor = new SparkMax(id, MotorType.kBrushless);
    }

    public void setWinch(double speed) {
        winchMotor.set(speed);
    }

    public void winchStop() {
        winchMotor.stopMotor();
    }
}
