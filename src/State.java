/**
 * Represents the state of the sliding puzzle game, containing the current board configuration.
 */
public class State {
    public Board board;
    /**
     * Constructs a State object with the specified board.
     *
     * @param board the board representing the current state of the game
     */
    public State(Board board){
        this.board = board;
    }
    /**
     * Returns the board associated with this state.
     *
     * @return the board representing the current state of the game
     */
    public Board getBoard(){
        return board;
    }
    /**
     * Checks if this state is equal to another object.
     * Two states are considered equal if their board configurations are identical.
     *
     * @param other the object to compare with
     * @return true if the states are equal, false otherwise
     */

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof State)) {
            return false;
        }
        State otherState = (State) other;
        return board.equals(otherState.board);
    }
    /**
     * Checks if the current state is the goal state, where all tiles are in their correct positions.
     *
     * @return true if the current state is the goal state, false otherwise
     */
    public boolean isGoal(){
        int row = board.getNumberRows();
        int columns = board.getNumberColumns();
        int counter = 1;

        for(int i=0;i<row;i++){
            for(int j=0;j<columns;j++){
                if(counter == columns*row){
                    return true;
                }
                if(counter!=board.getTileAt(i,j).getValue()){
                    return false;
                }
                counter++;
            }
        }
        return false;
    }
    /**
     * Returns an array of possible actions that can be performed in the current state.
     *
     * @return an array of possible actions in the current state
     */
    public Direction[] actions(){
        Direction[] direction = new Direction[4];
        Tile blankTile = board.getBlankTile();
        int counter = 0;
        if(blankTile.getX()<board.getNumberRows()-1){
            counter++;
            direction[0] = Direction.UP;
        }
        if(blankTile.getX()>0){
            counter++;
            direction[1] = Direction.DOWN;
        }
        if(blankTile.getY()<board.getNumberColumns()-1){
            counter++;
            direction[2] = Direction.LEFT;
        }
        if(blankTile.getY()>0){
            counter++;
            direction[3] = Direction.RIGHT;
        }
        Direction[] directionNew = new Direction[counter];
        counter = 0;
        for(int i=0;i<4;i++){
            if(direction[i]!=null){
                directionNew[counter] = direction[i];
                counter++;
            }

        }
        return directionNew;
    }
    /**
     * Generates a new state by performing an action on the current state.
     *
     * @param act the action to perform
     * @return the new state resulting from the action
     */
    public State result(Action act){
        Board newBoard = new Board(board.getTileBoard());
        Direction d = act.getDirection();
        int x = act.getTile().getX();
        int y = act.getTile().getY();
        switch (d) {
            case UP:
                newBoard.swapTiles(x,y,x-1,y);
                break;
            case DOWN:
                newBoard.swapTiles(x,y,x+1,y);
                break;
            case LEFT:
                newBoard.swapTiles(x,y,x,y-1);
                break;
            case RIGHT:
                newBoard.swapTiles(x,y,x,y+1);
                break;
        }
        State newState = new State(newBoard);
        return newState;
    }
    /**
     * Returns the hash code value for the state.
     *
     * @return the hash code value for the state
     */

    @Override
    public int hashCode() {
        return board.hashCode();
    }
}
