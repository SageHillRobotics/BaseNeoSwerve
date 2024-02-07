package frc.robot.commands.SwervePIDCommands;

import frc.robot.Constants;
import frc.robot.subsystems.Swerve;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

public class SpeakerPID extends Command {
    private Swerve s_Swerve;
    private DoubleSupplier translationSup;
    private DoubleSupplier strafeSup;
    private ProfiledPIDController angleController;
    private SlewRateLimiter translationLimiter = new SlewRateLimiter(3.0);
    private SlewRateLimiter strafeLimiter = new SlewRateLimiter(3.0);
    public SpeakerPID(Swerve s_Swerve, DoubleSupplier translationSup, DoubleSupplier strafeSup){
        addRequirements(s_Swerve);
        this.s_Swerve = s_Swerve;
        this.translationSup = translationSup;
        this.strafeSup = strafeSup;
    }
    @Override
    public void initialize(){
        angleController = new ProfiledPIDController(.01, 0, 0, Constants.AutoConstants.kThetaControllerConstraints);
        angleController.setGoal(180);
        angleController.enableContinuousInput(-180, 180);
        angleController.setTolerance(3);
    }
    @Override
    public void execute() {
        Pose2d currPose = s_Swerve.getPose();
        double currRotation = currPose.getRotation().getDegrees();
        double output = angleController.calculate(currRotation);
        double translationVal =
        translationLimiter.calculate(
            MathUtil.applyDeadband(translationSup.getAsDouble(), 0.2));
        double strafeVal =
        strafeLimiter.calculate(
            MathUtil.applyDeadband(strafeSup.getAsDouble(), 0.2));

 
        s_Swerve.drive(new Translation2d(translationVal, strafeVal).times(Constants.Swerve.maxSpeed),
        output,
        true,
        true);
        SmartDashboard.putNumber("currPose", currRotation);
        SmartDashboard.putNumber("output", output);
    }


    @Override
    public boolean isFinished() {
        return angleController.atSetpoint();
    }
}