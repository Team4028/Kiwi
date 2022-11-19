// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ExampleSubsystem extends SubsystemBase {
  
  TalonSRX _motor;
  PhotonCamera _cam;
  public ExampleSubsystem() {
    _motor = new TalonSRX(5);
    _cam = new PhotonCamera("AprilTagCam");
   
    
  }

  @Override
  public void periodic() {
    var result = _cam.getLatestResult();
    if (result.hasTargets())
    {
      PhotonTrackedTarget _target = result.getBestTarget();
      double _yaw = _target.getYaw();
      if(_yaw < -6){
        _motor.set(ControlMode.PercentOutput, .1);
        System.out.println(_yaw);
      } else if(_yaw > 6){
        _motor.set(ControlMode.PercentOutput, -.1);
        System.out.println(_yaw);
      } else {
        _motor.set(ControlMode.PercentOutput, 0);
      }
    } else {
      _motor.set(ControlMode.PercentOutput, 0);
    }
    
    
    //_motor.set(ControlMode.PercentOutput, .2);
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
