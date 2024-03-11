package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase
{
    private final CANSparkMax[] motors = new CANSparkMax[4];
    private final MotorControllerGroup right, left;
    private final DifferentialDrive differentialDrive;

    public DriveSubsystem()
    {
        right = new MotorControllerGroup(motors[0], motors[1]);
        left = new MotorControllerGroup(motors[2], motors[3]);
        right.setInverted(true);

        differentialDrive = new DifferentialDrive(left, right);

        for (int i = 0; i < motors.length; i++)
        {
            motors[i] = new CANSparkMax(DriveConstants.motorPorts[i], MotorType.kBrushless);
            motors[i].setSmartCurrentLimit(DriveConstants.kCurrentLimit);
            motors[i].setSecondaryCurrentLimit(DriveConstants.kCurrentLimit);
            motors[i].setIdleMode(IdleMode.kBrake);
        }
    }

    public void tankDrive(double l_speed, double r_speed)
    {
        differentialDrive.tankDrive(l_speed, r_speed);
    }
}
