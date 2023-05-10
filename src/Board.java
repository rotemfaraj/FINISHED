import java.util.Arrays;

public class Board {
    private Tile[] tiles;
    private int rows;
    private int cols;
    public Board(String s){
        int count = 0;
        int size = 0;
        // count numbers in s
        // 0          10
        // 012345678901234567
        // 1 2 3|_ 4 5|6 7 81
        int last = s.length() - 1;
        while(s.charAt(last) == ' '){
            last--;
        }
        size = Integer.parseInt(s.substring(last+1));
        // init tiles array
        tiles = new Tile[size];
        int index = 0;

        // create tile and add to array;
        String[] rows = s.split("|");
        this.rows = rows.length;
        for(int i = 0; i < rows.length; i++){
            String[] cols = rows[i].split(" ");
            this.cols = cols.length;
            for(int c = 0; c < cols.length; c++){
                if(!cols[c].equals(" ")){
                    int v = Integer.parseInt(cols[c]);
                    Tile t = new Tile(v);
                    tiles[index] = t;
                    index++;
                    // tiles[index++] = new Tile(v);
                }

            }
        }
        // tiles: [ {value=1}, {value=2}.....]
    }
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Board)) {
            return false;
        }
        Board board = (Board) other;
        return Arrays.deepEquals(tiles, board.tiles);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(tiles);
    }
}
