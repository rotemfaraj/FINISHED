/**
 * Represents an action to move a tile in a specific direction in the sliding puzzle game.
 */
public class Action {
    private Tile tile;
    private Direction direction;
    /**
     * Constructs an Action object with the specified tile and direction.
     *
     * @param tile the tile to be moved
     * @param direction the direction in which the tile is moved
     */
    public Action(Tile tile, Direction direction){
        this.tile = tile;
        this.direction = direction;
    }
    /**
     * Returns the tile associated with this action.
     *
     * @return the tile to be moved
     */
    public Tile getTile(){
        return tile;
    }
    /**
     * Returns the direction of this action.
     *
     * @return the direction in which the tile is moved
     */

    public Direction getDirection(){
        return direction;
    }
    /**
     * Returns a string representation of this action.
     * The string includes the value of the tile and the lowercase name of the direction.
     *
     * @return a string representation of the action
     */
    public String toString(){
        return "Move " + tile.getValue() + " " + direction.name().toLowerCase();
    }
}
