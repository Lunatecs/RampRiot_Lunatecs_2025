// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import static edu.wpi.first.wpilibj2.command.Commands.defer;

import java.util.Set;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.path.PathConstraints;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.field.Field;
import frc.robot.subsystems.CommandSwerveDrivetrain;
import frc.robot.field.Field;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class TrackToRightTagCommand extends SequentialCommandGroup {
  /** Creates a new TrackToLeftTagCommand. */
  public TrackToRightTagCommand(CommandSwerveDrivetrain drivetrain, Field field) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new InstantCommand(() -> drivetrain.resetPoseBasedOnLL()),
            new WaitCommand(0.25),
            defer(
                () -> AutoBuilder.pathfindToPose(
                    field.getNearestReefPoseRight(),
                    new PathConstraints(2, 2, 
                    Math.toRadians(540), 
                    Math.toRadians(720))
                ),
                    Set.of()
                )
    );
  }
}
