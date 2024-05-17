package globals;
import gameobjects.Cuarto;

public enum Direction {
    NORTH, 
    SOUTH, 
    EAST, 
    WEST,
    UP,
    DOWN;

    // Constante para representar la ausencia de salida
    public static final Cuarto NOEXIT = null;
}
