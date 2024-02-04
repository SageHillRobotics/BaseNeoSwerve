package frc.robot.subsystems;

import java.util.Optional;

import org.photonvision.EstimatedRobotPose;
import org.photonvision.PhotonCamera;
import org.photonvision.PhotonPoseEstimator;
import org.photonvision.PhotonPoseEstimator.PoseStrategy;

import edu.wpi.first.apriltag.AprilTagFieldLayout;
import edu.wpi.first.apriltag.AprilTagFields;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.geometry.Translation3d;

public class Vision {
    private AprilTagFieldLayout aprilTagFieldLayout;  
    private PhotonCamera cam;
    private PhotonPoseEstimator photonPoseEstimator;
    public Vision(){
        try {
            aprilTagFieldLayout = AprilTagFieldLayout.loadFromResource(AprilTagFields.k2024Crescendo.m_resourceFile);
        } catch (Exception IOExeption) {
            System.out.println("invalid field file");
        }
        //cam = new PhotonCamera("cam1");
        //Transform3d robotToCam  = new Transform3d(new Translation3d(0.5, 0.0, 0.5), new Rotation3d(0,Math.toRadians(30),0));
        //photonPoseEstimator = new PhotonPoseEstimator(aprilTagFieldLayout, PoseStrategy.MULTI_TAG_PNP_ON_COPROCESSOR, cam, robotToCam);

    }
    //public Optional<EstimatedRobotPose> getEstimatedGlobalPose() {
        //return photonPoseEstimator.update();
    //}

}
