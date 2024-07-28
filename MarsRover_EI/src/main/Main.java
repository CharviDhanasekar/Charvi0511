package main;

import models.Rover;
import models.Grid;
import utils.Direction;
import utils.Position;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter grid width: ");
        int gridWidth = scanner.nextInt();

        System.out.print("Enter grid height: ");
        int gridHeight = scanner.nextInt();

        System.out.print("Enter starting x position: ");
        int startX = scanner.nextInt();

        System.out.print("Enter starting y position: ");
        int startY = scanner.nextInt();

        System.out.print("Enter starting direction (N, E, S, W): ");
        String directionInput = scanner.next();

        // Parse direction input
        Direction startDirection = Direction.fromInput(directionInput);

        System.out.print("Enter the number of obstacles: ");
        int numObstacles = scanner.nextInt();

        Set<Position> obstacles = new HashSet<>();
        for (int i = 0; i < numObstacles; i++) {
            System.out.printf("Enter obstacle %d x position: ", i + 1);
            int obsX = scanner.nextInt();
            System.out.printf("Enter obstacle %d y position: ", i + 1);
            int obsY = scanner.nextInt();
            obstacles.add(new Position(obsX, obsY));
        }

        Grid grid = new Grid(gridWidth, gridHeight, obstacles);

        // Provide the set of obstacles to the Rover constructor
        Rover rover = new Rover(new Position(startX, startY), startDirection, grid, obstacles);

        System.out.print("Enter commands (M for move, L for turn left, R for turn right): ");
        scanner.nextLine();  // Consume newline left-over
        String commands = scanner.nextLine();

        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'M':
                    rover.move();
                    break;
                case 'L':
                    rover.turnLeft();
                    break;
                case 'R':
                    rover.turnRight();
                    break;
                case ' ':
                    break;  // Skip spaces
                default:
                    System.out.println("Invalid command: " + command);
            }
            rover.checkObstacles();  // Check for obstacles after each move
        }

        Position finalPosition = rover.getPosition();
        Direction finalDirection = rover.getDirection();

        System.out.printf("Final Position: (%d, %d)\n", finalPosition.getX(), finalPosition.getY());
        System.out.printf("Final Direction: %s\n", finalDirection);
    }
}
