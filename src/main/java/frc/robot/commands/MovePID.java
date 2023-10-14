// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.DriveTrainPrueba;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class MovePID extends PIDCommand {
  /** Creates a new MovePID. */
  public MovePID(DriveTrainPrueba drivetrain) {
    super(
        // The controller that the command will use
        new PIDController(0.8, 0.1, 0.1),
        // This should return the measurement
        () -> drivetrain.EncoderChassis(),
        // This should return the setpoint (can also be a constant)
        () -> 1,
        // This uses the output
        output -> {
          drivetrain.Auto1(0, output);
        });
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}
