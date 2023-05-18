/**
 * Represents a node in the search tree for the sliding puzzle game.
 */
public class Node{
    private State state;
    private Node parent;
    private Action action;
    /**
     * Constructs a Node object with the specified state, parent node, and action.
     *
     * @param state  the state associated with this node
     * @param parent the parent node of this node
     * @param action the action that led to this node from its parent
     */
    public Node(State state,Node parent, Action action){
        this.state = state;
        this.parent = parent;
        this.action = action;
    }
    /**
     * Returns the action associated with this node.
     *
     * @return the action associated with this node
     */
    public Action getAction(){
        return action;
    }
    /**
     * Returns the state associated with this node.
     *
     * @return the state associated with this node
     */

    public State getState(){
        return state;
    }
    /**
     * Returns the parent node of this node.
     *
     * @return the parent node of this node
     */
    public Node getParent(){
        return parent;
    }
    /**
     * Expands the current node by generating child nodes for each possible action.
     *
     * @return an array of child nodes resulting from expanding the current node
     */

    public Node[] expand(){
        Direction[] direction = state.actions();
        Node[] expanded = new Node[direction.length];
        Tile optionalTile = null;
        Board board = state.getBoard();
        Tile blanktile = board.getBlankTile();
        for(int i=0;i<direction.length;i++){
            switch (direction[i]) {
                case UP:
                    optionalTile = board.getTileAt(blanktile.getX()+1, blanktile.getY());
                    break;
                case DOWN:
                    optionalTile = board.getTileAt(blanktile.getX()-1, blanktile.getY());
                    break;
                case LEFT:
                    optionalTile = board.getTileAt(blanktile.getX(), blanktile.getY()+1);
                    break;
                case RIGHT:
                    optionalTile = board.getTileAt(blanktile.getX(), blanktile.getY()-1);
                    break;
            }
            Action act = new Action(optionalTile,direction[i]);
            Node previous = new Node(this.state,this.parent,this.action);
            expanded[i] = new Node(state.result(act),previous,act);
        }
        return expanded;
    }
    /**
     * Calculates the heuristic value for the current node.
     *
     * @return the heuristic value of the current node
     */
    public int heuristicValue(){
        Board board = state.getBoard();
        int heuristicValue = board.getHeuristicValue();
        return heuristicValue;
    }

}
