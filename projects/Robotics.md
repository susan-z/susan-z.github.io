---
title: Robotics
layout: page
---
# Robotics
This course, MEAM520: Introduction to Robotics, culminated in a team project. We chose to use a Lynx robot arm to perform actions of locating, picking up, and stacking small blocks. In doing so, we explored several functions: orienting the gripper and grasping the blocks, accounting for droop and weight of the block and Lynx arm itself, and continuously updating the planner to reflect the changing environment for ensured collision prevention. By developing a solution to this problem using Matlab, we gained a stronger understanding of how to finely tune a planner with both velocity, weight, and obstacle considerations.

### PseudoCode
1. Load custom map
2. Generate Configuration space (C-space)
3. Execute A*  path planning to a reachable configuration within a set tolerance of the block, orienting the gripper at end position
4. Utilize velocity inverse kinematics to lower the gripper. Close and raise using IK velocity
5. Execute A* path planning to a viable configuration within tolerance of the target stack location, once again orienting the gripper at the end position
6. Use IK velocity to lower the block onto the stack, open to release and raise end effector vertically up
7. Update obstacles in C-space
8. Repeat, starting with A* to reach next block

<center>
  <iframe width="560" height="315" src="https://www.youtube.com/embed/2dLq227PmDc" frameborder="0" allowfullscreen></iframe>
</center>
<center>
<figcaption>Lynx Stacking 5 Blocks</figcaption>
</center>

[Final Project Paper](https://github.com/susan-z/susan-z.github.io/tree/master/projects/RoboFinalPaper.pdf)

### Main Concepts Learned
* Understand geometry and configuration of a multi-DOF manipulator
* Implement trajectory planning algorithms
* Forward and Inverse kinematics of a manipulator arm
* Standard equations for manipulator dynamics
* Obstacle detection, C-space generation
* Apply to a real-world robot manipulator

<!--[![Lynx Arm Video](//github.com/susan-z/susan-z.github.io/blob/master/img/roboarmvideo.JPG?raw=true)](//youtu.be/2dLq227PmDc "Lynx Stacking 5 Blocks")
<figcaption>Click above to access Youtube video: Lynx Stacking 5 Blocks</figcaption>-->
