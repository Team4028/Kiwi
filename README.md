# Kiwi Team

<br/>

## Goal
The goal for Kiwi Team is to learn the basics of AprilTag vision tracking using PhotonVision.

<br/>

### Task 1: Install PhotonVision
Download the latest PhotonVision beta from the [Releases page.](https://github.com/PhotonVision/photonvision/releases) Install this on a Raspberry Pi 3B+ using [Balena Etcher.](https://www.balena.io/etcher/) Plug in a camera and make sure you can see it in the web viewer. Then follow the docs to get the AprilTags plugin/library working and print out a tag on the printer to verify that it's detected.

<br/>

### Task 2: Track a Target
Attach the printed AprilTag to a clipboard or other solid surface and mount the camera to the turret rig. Write code that keeps the tag in frame as you move it around, allowing the camera to track the target.

<br/>

### Task 3: Pose Estimation
Dig into pose estimation in the photonvision docs and also on Chief Delphi, and find out what it takes to estimate the robot's pose (X, Y coordinates and a rotation angle) on the field. This will take some fiddling and testing to understand fully. Bonus task if this is easy, see if you can run it on a robot driving around the field with an AprilTag mounted on a target.

<br/><br/>

#### **Tips**
- Much of the tuning and fiddling with PhotonVision is actually in the web viewer and not in the robot code.
- You will need to be sure to include the vendor dependencies (REV, CTRE, etc). for any motors.
- When spinning a motor for the first time, _never_ go above 10% speed.



<br/>

#### **Helpful Resources**
- [PhotonVision Docs](https://docs.photonvision.org/en/latest/)
- [PhotonVision Release page](https://github.com/PhotonVision/photonvision/releases)
- [ChiefDelphi thread about AprilTags with PhotonVision](https://www.chiefdelphi.com/t/photonvision-beta-2023-apriltags/415626/250)