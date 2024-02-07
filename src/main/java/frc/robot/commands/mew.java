package frc.robot;

import frc.robot.subsystems.Intake;


public class mew extends Command{
    private final m_Intake;
    public mew(Intake m_Intake){
        m_Intake = m_Intake
    }
    
}
@Override
public void initialize(){

}
@Override
public void execute(){
    m_Intake.retract();
}
@Override
public void isFinished(){
    
}