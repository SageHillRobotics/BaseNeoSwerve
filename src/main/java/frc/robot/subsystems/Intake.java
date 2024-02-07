package frc.robot;
import edu.wpi.first.wpilibj.TimedRobot;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class Elevator extends SubsystemBase{
    private final CANSparkMax intakeRetractionMotor;
    private final RelativeEncoder intakeMotorEncoder;
    private final SparkAbsoluteEncoder intakeAbsoluteEncoder;
    
    public double kP, kI, kD;

    public Intake(){
        
        intakeRetractionMotor = new CANSparkMax(deviceID, MotorType.kBrushless);
        SparkPIDController pid = intakeRetractionMotor.getPIDController();
        pid.setOutputRange(-0.5,0.5);
        pid.setSmartCurrentLimit​(int 0, int 5700);
        intakeMotorEncoder = intakeRetractionMotor.getEncoder();
        intakeAbsoluteEncoder=intakeRetractionMotor.getEncoder();

        //add motor feedback sensor
       


    }
    public void retract(){
        m_encoder= m_motor. getEncoder();
        public double getPositionError();
        m_motor.set(pid.calculate(m_encoder.getDistance(), setpoint));
        
     

    }
}
