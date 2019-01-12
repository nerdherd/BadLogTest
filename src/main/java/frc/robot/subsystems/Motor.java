/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import badlog.lib.BadLog;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Motor extends Subsystem {
  
  private TalonSRX m_motor;

  public Motor() {
    m_motor = new TalonSRX(5);
    m_motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
  }

  public void initLoggingData() {
    BadLog.createTopic("Motor/Position", "rad", () -> m_motor.getSelectedSensorPosition() * 6.28 / 4096.);
    BadLog.createTopic("Motor/Velocity", "rad/s", () -> m_motor.getSelectedSensorVelocity() * 62.8 / 4096.);
    
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
