package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.ClosedLoopConfig.ClosedLoopSlot;
import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {

    private final SparkMax armMotor;
    private SparkMaxConfig motorConfig;
    private SparkClosedLoopController closedLoopController;
    private RelativeEncoder encoder;

    public ArmSubsystem(int id) {
        armMotor = new SparkMax(id, MotorType.kBrushless);
        
        closedLoopController = armMotor.getClosedLoopController();
        encoder = armMotor.getEncoder();

        motorConfig = new SparkMaxConfig();

        motorConfig.encoder
            .positionConversionFactor(1)
            .velocityConversionFactor(1);

        // motorConfig.closedLoop
        //     .feedbackSensor(FeedbackSensor.kPrimaryEncoder)
        //     // Set PID values for position control. We don't need to pass a closed loop
        //     // slot, as it will default to slot 0.
        //     .p(0.1)
        //     .i(0)
        //     .d(0)
        //     .outputRange(-1, 1)
        //     // Set PID values for velocity control in slot 1
        //     .p(0.0001, ClosedLoopSlot.kSlot1)
        //     .i(0, ClosedLoopSlot.kSlot1)
        //     .d(0, ClosedLoopSlot.kSlot1)
        //     .velocityFF(1.0 / 5767, ClosedLoopSlot.kSlot1)
        //     .outputRange(-1, 1, ClosedLoopSlot.kSlot1);

        //     armMotor.configure(motorConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);

        // Initialize dashboard values
        SmartDashboard.setDefaultNumber("Arm Target Position", 0);
        SmartDashboard.setDefaultNumber("Arm Target Velocity", 0);
        SmartDashboard.setDefaultBoolean("Arm Control Mode", false);
        SmartDashboard.setDefaultBoolean("Arm Reset Encoder", false);
    }

    public void setArm(double speed) {
        armMotor.set(speed);
    }

    public void stopArm() {
        armMotor.stopMotor();
    }

    @Override
    public void periodic() {
        // Display encoder position and velocity
        SmartDashboard.putNumber("Arm Actual Position", encoder.getPosition());
        SmartDashboard.putNumber("Arm Actual Velocity", encoder.getVelocity());

        if (SmartDashboard.getBoolean("Arm Reset Encoder", false)) {
            SmartDashboard.putBoolean("Arm Reset Encoder", false);
            // Reset the encoder position to 0
            encoder.setPosition(0);
        }

        // if (SmartDashboard.getBoolean("Arm Control Mode", false)) {
        //     /*
        //     * Get the target velocity from SmartDashboard and set it as the setpoint
        //     * for the closed loop controller.
        //     */
        //     double targetVelocity = SmartDashboard.getNumber("Target Velocity", 0);
        //     closedLoopController.setReference(targetVelocity, ControlType.kVelocity);
        // } else {
        //     /*
        //     * Get the target position from SmartDashboard and set it as the setpoint
        //     * for the closed loop controller.
        //     */
        //     double targetPosition = SmartDashboard.getNumber("Target Position", 0);
        //     closedLoopController.setReference(targetPosition, ControlType.kPosition);
        // }
    }
}
