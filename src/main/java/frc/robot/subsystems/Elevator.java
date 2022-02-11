package frc.robot.subsystems;
import frc.robot.commands.ExampleCommand;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase{
    private final CANSparkMax leader ;
    private final CANSparkMax follower1 = new CANSparkMax(13, MotorType.kBrushless);
    private final CANSparkMax follower2 = new CANSparkMax(14, MotorType.kBrushless);
    private final SparkMaxPIDController leaderPIDController;

    public Elevator(){
        leader = new CANSparkMax(15, MotorType.kBrushless);
        follower1.follow(leader, /*invert:*/false);
        follower2.follow(leader, false);
        leaderPIDController = leader.getPIDController();
        // Call the method that sets our PID configuration constants
        configurePIDGains();
    }

    private void configurePIDGains() {
        leaderPIDController.setP(0.075);
        leaderPIDController.setI(0); // I is generally something we want to avoid because of Integral Runoff
        leaderPIDController.setD(0);
    }
    
    public void goSpeed(double speed){
        leader.set(speed);
    }

    /**
     * TODO: fix the units for this goToHeight method
     * @param height
     */
    public void goToHeight(double height){
        leaderPIDController.setReference(height, ControlType.kPosition);
    }
    

}
