# Charvi0511
Mars Rover Simulation
This project simulates the movement of a Mars Rover on a grid. The rover can move forward, turn left, or turn right based on user input commands. The grid may contain obstacles that the rover needs to navigate around.

Features
Grid Initialization: Define the width and height of the grid.
Rover Initialization: Set the starting position and direction (North, East, South, West) of the rover.
Obstacle Placement: Place obstacles on the grid at specified coordinates.
Command Input: Accept commands to move the rover:
M: Move forward
L: Turn left
R: Turn right
Boundary Checking: Ensure the rover does not move outside the grid boundaries.
Obstacle Detection: Detect obstacles and prevent the rover from moving into them.
Final Position Reporting: Report the final position and direction of the rover after executing all commands.


Design Patterns Used
Behavioral Patterns:
Strategy Pattern
Observer Pattern

Creational Patterns:
Factory Pattern
Singleton Pattern

Structural Patterns:
Adapter Pattern
Decorator Pattern

Compile the Code:
javac -d ../bin main/Main.java

Run the Simulation:
java -cp ../bin main.Main

Provide Inputs:
Enter the grid dimensions.
Enter the rover's starting position and direction.
Specify the number and positions of obstacles.
Input the movement commands for the rover.

Sample Interaction:
Enter grid width: 10
Enter grid height: 10
Enter starting x position: 1
Enter starting y position: 1
Enter starting direction (N, E, S, W): N
Enter the number of obstacles: 2
Enter obstacle 1 x position: 2
Enter obstacle 1 y position: 2
Enter obstacle 2 x position: 3
Enter obstacle 2 y position: 3
Enter commands (M for move, L for turn left, R for turn right): M M R M M L M
Final Position: (2, 4)
Final Direction: NORTH
