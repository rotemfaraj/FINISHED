import java.util.Arrays;
/**
 * The Board class represents the game board for a sliding puzzle game.
 * It consists of a grid of tiles and provides various methods to manipulate and access the tiles.
 */

public class Board {
    public Tile[][] tiles;
    public Tile blankTile;
    private int rows;
    private int columns;
    /**
     * Constructs a Board object with the specified tile configuration string.
     * The tile configuration string represents the initial arrangement of the tiles on the board.
     * The string should be in the format of rows separated by "|" and values separated by spaces.
     * The "_" character represents the blank tile.
     *
     * @param s the tile configuration string
     */
    public Board(String s) {
        String[] rows = s.split("\\|");
        this.rows = rows.length;
        String[] columns = null;
        this.tiles = new Tile[rows.length][];
        for (int i = 0; i < rows.length; i++) {

            columns = rows[i].split(" ");
            this.columns = columns.length;
            tiles[i] = new Tile[columns.length];
            for (int c = 0; c < columns.length; c++) {
                if (!columns[c].equals("_")) {
                    if(!columns[c].equals("\\|")){
                        int v = Integer.parseInt(columns[c]);

                        Tile t = new Tile(v, i, c);
                        tiles[i][c] = t;

                    }
                } else {
                    this.blankTile = new Tile(0, i, c);
                    tiles[i][c] = blankTile;
                }
            }
        }
    }
    /**
     * Constructs a Board object with the specified tile array.
     * The tile array represents the initial arrangement of the tiles on the board.
     *
     * @param tiles the tile array representing the board configuration
     */
    public Board(Tile[][] tiles) {
        this.rows = tiles.length;
        this.columns = tiles[0].length;
        this.tiles = new Tile[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (tiles[i][j] != null) {
                    this.tiles[i][j] = new Tile(tiles[i][j].getValue(), tiles[i][j].getX(), tiles[i][j].getY());
                }
                if(tiles[i][j].getValue()==0){
                    this.blankTile = this.tiles[i][j];
                }
            }
        }
    }
    /**
     * Finds and returns the tile with the specified value on the board.
     *
     * @param x the value of the tile to find
     * @return the tile with the specified value, or null if not found
     */

    public Tile findTileValueX(int x){
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(tiles[i][j].getValue() == x){
                    return tiles[i][j];
                }
            }
        }
        return null;
    }
    /**
     * Returns the tile array representing the board configuration.
     *
     * @return the tile array representing the board configuration
     */

    public Tile[][] getTileBoard() {
        return tiles;
    }
    /**
     * Swaps the positions of two tiles on the board.
     *
     * @param x the x-coordinate of the first tile
     * @param y the y-coordinate of the first tile
     * @param swapX the x-coordinate of the second tile
     * @param swapY the y-coordinate of the second tile
     */

    public void swapTiles(int x, int y, int swapX, int swapY){

        tiles[x][y].setX(swapX);
        tiles[x][y].setY(swapY);
        tiles[swapX][swapY].setX(x);
        tiles[swapX][swapY].setY(y);
        Tile temp = tiles[x][y];
        tiles[x][y] = tiles[swapX][swapY];
        tiles[swapX][swapY]=temp;


    }

    /**
     * Returns the blank tile on the board.
     *
     * @return the blank tile
     */
    public Tile getBlankTile(){
        return blankTile;
    }
    /**
     * Returns the tile at the specified row and column indices.
     *
     * @param row the row index of the tile
     * @param columns the column index of the tile
     * @return the tile at the specified position
     */
    public Tile getTileAt(int row, int columns){
        return tiles[row][columns];
    }
    /**
     * Returns the number of rows on the board.
     *
     * @return the number of rows
     */
    public int getNumberRows() {
        return rows;
    }
    /**
     * Returns the number of columns on the board.
     *
     * @return the number of columns
     */
    public int getNumberColumns(){
        return columns;
    }
    /**
     * Calculates the heuristic value for the current board state.
     * The heuristic value is a combination of the count of misplaced tiles
     * and the sum of Manhattan distances between each tile's current position
     * and its goal position.
     *
     * @return The heuristic value for the current board state.
     */
    public int getHeuristicValue() {
        int misplacedTiles = 0; // Count of tiles in wrong positions
        int manhattanDistance = 0; // Sum of Manhattan distances

        int counter = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (counter == columns * rows) {
                    break;
                }

                Tile tile = findTileValueX(counter);
                if (tile != null) {
                    int x = tile.getX(); // Current row position of the tile
                    int y = tile.getY(); // Current column position of the tile

                    if (x != i || y != j) {
                        misplacedTiles++; // Increment count of misplaced tiles
                        manhattanDistance += Math.abs(x - i) + Math.abs(y - j); // Add Manhattan distance
                    }

                    counter++;
                }
            }
        }

        // Return the sum of misplaced tiles count and Manhattan distances
        return misplacedTiles + manhattanDistance;
    }


    /**
     * Checks if the board is equal to another object.
     * Two boards are considered equal if their tile configurations are identical.
     *
     * @param other the object to compare with
     * @return true if the boards are equal, false otherwise
     */


    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Board)) {
            return false;
        }
        Board board = (Board) other;
        return Arrays.deepEquals(tiles, board.tiles);
    }
    /**
     * Returns the hash code value for the board.
     *
     * @return the hash code value for the board
     */

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(tiles);
    }
}
