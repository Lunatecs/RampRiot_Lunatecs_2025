// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.List;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.path.GoalEndState;
import com.pathplanner.lib.path.PathConstraints;
import com.pathplanner.lib.path.PathPlannerPath;
import com.pathplanner.lib.path.Waypoint;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.CommandSwerveDrivetrain;


/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class TrackToCageCommand extends Command {
  /** Creates a new TrackToCageCommand. */
  private CommandSwerveDrivetrain drivetrain;
  Pose2d goalPose;
  Pose2d currentPose;
  String cage;
  Alliance alliance;
  PathPlannerPath path;
  List<Waypoint> waypoints;
  PathConstraints constraints;

  public TrackToCageCommand(CommandSwerveDrivetrain drivetrain, String cage, Alliance alliance) {
    this.alliance = alliance;
    this.drivetrain = drivetrain;
    this.cage = cage;
    addRequirements(drivetrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (alliance == Alliance.Blue){
      if (cage.equals("right")){
        goalPose =  new Pose2d(8.143, 5.078, Rotation2d.fromDegrees(180));
      }
      if (cage.equals("center")){
        goalPose = new Pose2d(8.143, 6.175, Rotation2d.fromDegrees(180));
      }
      if (cage.equals("left")){
        goalPose = new Pose2d(8.143, 7.265, Rotation2d.fromDegrees(180));
      }
    }
    if (alliance == Alliance.Red){
      if (cage.equals("right")){
        goalPose =  new Pose2d(9.372, 3, Rotation2d.fromDegrees(0));
      }
      if (cage.equals("center")){
        goalPose = new Pose2d(9.372, 1.909, Rotation2d.fromDegrees(0));
      }
      if (cage.equals("left")){
        goalPose = new Pose2d(9.372, 0.812, Rotation2d.fromDegrees(0));
      }
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {



                SmartDashboard.putString("Selected Cage Alliance", alliance.toString());
                SmartDashboard.putString("Selected Cage Position", cage.toString());

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isFinished();
   
  }
}
