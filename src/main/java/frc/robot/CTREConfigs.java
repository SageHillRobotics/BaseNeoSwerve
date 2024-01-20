package frc.robot;

import com.ctre.phoenix6.configs.CANcoderConfiguration;

public final class CTREConfigs {
    public CANcoderConfiguration swerveCANcoderConfig = new CANcoderConfiguration();

    public CTREConfigs(){
        /** Swerve CANCoder Configuration */
        swerveCANcoderConfig.MagnetSensor.SensorDirection = Constants.Swerve.canCoderInvert;


    }
}