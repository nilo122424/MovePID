// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.subsystems.DriveTrainPrueba;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class Auto1 extends CommandBase {
  DriveTrainPrueba driveTrainPrueba;
  double dist;
  double velocidad;
  private boolean finish = false;
  double rotacion;
  /** Creates a new Auto1. */
  public Auto1(DriveTrainPrueba dr, double di, double ve, double ro) {
    // Use addRequirements() here to declare subsystem dependencies.
driveTrainPrueba = dr;
dist = di;
velocidad = ve;
rotacion=ro;
    addRequirements(driveTrainPrueba);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
   
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if((driveTrainPrueba.EncoderChassis()*0.25*0.625*3.141592*6*2.54) > dist){
      driveTrainPrueba.Auto1(velocidad, rotacion);
    }
    finish = true;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrainPrueba.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finish;
  }
}
