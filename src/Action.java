public class Action {

    private Tile tile;
    private Direction direction;


    public String toString(){
        return "MOVE " + tile + " " + direction;
    }
}
