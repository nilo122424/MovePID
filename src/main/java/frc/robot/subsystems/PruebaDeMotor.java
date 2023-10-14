// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PruebaDeMotor extends SubsystemBase {
  WPI_TalonFX MotorSolo1;
  /** Creates a new PruebaDeMotor. */
  public PruebaDeMotor() {
MotorSolo1 = new WPI_TalonFX(Constants.IDMOTORS1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void MoverMotor(XboxController control2){
    MotorSolo1.set(control2.getRawAxis(Constants.XBOXSpeed2));

  }
}
