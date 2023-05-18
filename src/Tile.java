/**
 * The Tile class represents a single tile in a sliding puzzle game.
 * Each tile has a numeric value, x-coordinate, and y-coordinate.
 */
public class Tile {
    private final int value;
    private int x;
    private int y;
    /**
     * Constructs a Tile object with the specified value, x-coordinate, and y-coordinate.
     *
     * @param v the numeric value of the tile
     * @param i the x-coordinate of the tile
     * @param c the y-coordinate of the tile
     */

    public Tile(int v, int i, int c){
        this.value = v;
        this.x = i;
        this.y = c;
    }
    /**
     * Returns the value of the tile.
     *
     * @return the numeric value of the tile
     */

    public int getValue() {
        return value;
    }
    /**
     * Returns the x-coordinate of the tile.
     *
     * @return the x-coordinate of the tile
     */

    public int getX() {
        return x;
    }
    /**
     * Returns the y-coordinate of the tile.
     *
     * @return the y-coordinate of the tile
     */

    public int getY() {
        return y;
    }
    /**
     * Sets the x-coordinate of the tile to the specified value.
     *
     * @param x the new x-coordinate of the tile
     */
    public void setX(int x){
        this.x =x;
    }
    /**
     * Sets the y-coordinate of the tile to the specified value.
     *
     * @param y the new y-coordinate of the tile
     */
    public void setY(int y){
        this.y=y;
    }
    /**
     * Checks if the specified object is equal to this tile.
     * Two tiles are considered equal if they have the same value.
     *
     * @param other the object to compare
     * @return true if the object is equal to this tile, false otherwise
     */

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tile)) {
            return false;
        }
        Tile tile = (Tile) other;
        return this.value == tile.value; 
    }
    /**
     * Returns the hash code value for this tile.
     *
     * @return the hash code value for this tile
     */

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }

}
