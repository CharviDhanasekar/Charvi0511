package models;

import utils.Direction;
import utils.Position;

import java.util.Set;

public class Rover {
    private Position position;
    private Direction direction;
    private Grid grid;
    private Set<Position> obstacles;

    public Rover(Position position, Direction direction, Grid grid, Set<Position> obstacles) {
        this.position = position;
        this.direction = direction;
        this.grid = grid;
        this.obstacles = obstacles;
    }

    public void move() {
        Position newPosition = position;

        switch (direction) {
            case NORTH:
                newPosition = new Position(position.getX(), position.getY() + 1);
                break;
            case EAST:
                newPosition = new Position(position.getX() + 1, position.getY());
                break;
            case SOUTH:
                newPosition = new Position(position.getX(), position.getY() - 1);
                break;
            case WEST:
                newPosition = new Position(position.getX() - 1, position.getY());
                break;
        }

        if (isValidPosition(newPosition)) {
            position = newPosition;
        } else {
            if (!grid.isWithinBounds(newPosition)) {
                System.out.println("Cannot move to the new position: (" + newPosition.getX() + ", " + newPosition.getY() + "). It is outside the grid.");
            } else if (obstacles.contains(newPosition)) {
                System.out.println("Cannot move to the new position: (" + newPosition.getX() + ", " + newPosition.getY() + "). It is an obstacle.");
            }
        }
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    private boolean isValidPosition(Position pos) {
        return grid.isWithinBounds(pos) && !obstacles.contains(pos);
    }

    public void checkObstacles() {
        if (obstacles.contains(position)) {
            System.out.println("Obstacle detected at " + position);
        }
    }
}
