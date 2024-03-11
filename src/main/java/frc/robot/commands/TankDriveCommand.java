package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class TankDriveCommand extends Command{
    private final Supplier<Double> leftInput, rightInput;
    private final DriveSubsystem tankDriveSubsystem;
    public TankDriveCommand(
        DriveSubsystem tankDriveSubsystem,
        Supplier<Double> leftInput,
        Supplier<Double> rightInput
    )
    {
        this.tankDriveSubsystem = tankDriveSubsystem;
        this.leftInput = leftInput;
        this.rightInput = rightInput;

        addRequirements(tankDriveSubsystem);
    }
}
