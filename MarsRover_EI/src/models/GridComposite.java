package models;

import utils.Position;
import java.util.Set;
import java.util.HashSet;

public class GridComposite implements GridComponent {
    private final int width;
    private final int height;
    private final Set<Position> obstacles = new HashSet<>();

    public GridComposite(int width, int height, Set<Position> obstacles) {
        this.width = width;
        this.height = height;
        this.obstacles.addAll(obstacles);
    }

    @Override
    public boolean isValidPosition(Position position) {
        if (position.getX() < 0 || position.getX() >= width || position.getY() < 0 || position.getY() >= height) {
            return false;
        }
        // Check for obstacles
        return !obstacles.contains(position);
    }
}
