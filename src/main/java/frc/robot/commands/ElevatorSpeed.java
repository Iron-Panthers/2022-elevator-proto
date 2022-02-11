// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;
import frc.robot.Constants;

public class ElevatorSpeed extends CommandBase {
  private final Joystick joystick;
  private final Elevator elevator;
  /** Creates a new ElevatorSpeedCommand. */
  public ElevatorSpeed(Joystick joystick, Elevator elevator) {
    this.joystick = joystick;
    this.elevator = elevator;
    addRequirements(elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute(){
    // forward => positive, backwards => negative
    double power = -joystick.getY();
    elevator.goSpeed(power);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
