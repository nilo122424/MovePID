// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class DriveTrainPrueba extends SubsystemBase {
  WPI_TalonFX motorDerecha1;
  WPI_TalonFX motorDerecha2;
  WPI_TalonFX motorIzquierda1;
  WPI_TalonFX motorIzquierda2;

  MotorControllerGroup derecho;
  MotorControllerGroup izquierdo;

  DifferentialDrive drive; 
 
  /** Creates a new DriveTrainPrueba. */
  public DriveTrainPrueba() {
    motorDerecha1 = new WPI_TalonFX(Constants.IDMOTOR1);
    motorDerecha1.setInverted(false);
    motorDerecha2 = new WPI_TalonFX(Constants.IDMOTOR2);
    motorDerecha2.setInverted(true);
    motorIzquierda1 = new WPI_TalonFX(Constants.IDMOTOR3);
    motorIzquierda1.setInverted(false);
    motorIzquierda2 = new WPI_TalonFX(Constants.IDMOTOR4);
    motorIzquierda2.setInverted(true);

    derecho = new MotorControllerGroup(motorDerecha1, motorDerecha2);
    izquierdo = new MotorControllerGroup(motorIzquierda1, motorIzquierda2);

    drive = new DifferentialDrive(izquierdo, derecho);

    motorDerecha1.getSensorCollection().setIntegratedSensorPosition(0, 0);

  }

public void DriveJoysticks(XboxController control1, double speed) {
  drive.arcadeDrive(control1.getRawAxis(Constants.XBOXSpeed)*speed, control1.getRawAxis(Constants.XBOXRotation));
}

public void Auto1(double velocidad, double rotacion) {
  drive.arcadeDrive(velocidad, rotacion);
}

public double EncoderChassis(){
  return motorDerecha1.getSelectedSensorPosition();
}

public void stop(){
  drive.arcadeDrive(0, 0);
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
