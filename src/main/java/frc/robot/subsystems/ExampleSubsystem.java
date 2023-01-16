// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ExampleSubsystem extends SubsystemBase {
  
  TalonSRX _motor;
  PhotonCamera _cam;
  PIDController _pid;
  public ExampleSubsystem() {
    _motor = new TalonSRX(5);
    _cam = new PhotonCamera("Global_Shutter_Camera");
    _pid = new PIDController(0.008, 0, 0);
  }

  @Override
  public void periodic() {
    var result = _cam.getLatestResult();
    if (result.hasTargets())
    {
      PhotonTrackedTarget _target = result.getBestTarget();
      double _yaw = _target.getYaw();
      
        _motor.set(ControlMode.PercentOutput, MathUtil.clamp(_pid.calculate(_yaw, 0) ,-0.25, 0.25));
        System.out.println(_yaw);
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
