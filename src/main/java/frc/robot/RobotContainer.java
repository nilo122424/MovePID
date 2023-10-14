// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Auto1;
import frc.robot.commands.Autos;
import frc.robot.commands.DriveJoysticks;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.MovePID;
import frc.robot.commands.MoverMotor;
import frc.robot.subsystems.DriveTrainPrueba;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.PruebaDeMotor;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  public final DriveTrainPrueba driveTrainPrueba;
  public final DriveJoysticks driveJoysticks;
  public final Auto1 auto1;
public final MovePID movePID;

  public PruebaDeMotor pruebaDeMotor;
  public MoverMotor moverMotor;

  public static XboxController Joy1;
  public static XboxController Joystick1;
  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    
    driveTrainPrueba = new DriveTrainPrueba();
    driveJoysticks = new DriveJoysticks(driveTrainPrueba);
    driveJoysticks.addRequirements(driveTrainPrueba);
    driveTrainPrueba.setDefaultCommand(driveJoysticks);

    pruebaDeMotor = new PruebaDeMotor();
    moverMotor = new MoverMotor(pruebaDeMotor);
    moverMotor.addRequirements(pruebaDeMotor);
    pruebaDeMotor.setDefaultCommand(moverMotor);

    auto1 = new Auto1(driveTrainPrueba, 50, 0.4, 0);
    auto1.addRequirements(driveTrainPrueba);

    movePID = new MovePID(driveTrainPrueba);
    movePID.addRequirements(driveTrainPrueba);
    Joy1 = new XboxController(Constants.XBOXID);
    
    Joystick1 = new XboxController(Constants.XBOXID2);

    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return movePID;
  }
}
