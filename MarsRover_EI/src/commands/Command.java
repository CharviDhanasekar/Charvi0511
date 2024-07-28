package commands;

import models.Rover;

public interface Command {
    void execute(Rover rover);
}
