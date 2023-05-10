public class Tile {
    private final int value;
    public Tile(int v){
        this.value = v;
    }
    @Override
    public boolean equals(Object other) {   // equals(this, other
        if (!(other instanceof Tile)) {
            return false;
        }
        Tile tile = (Tile) other;
        return this.value == tile.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }

    @Override
    public String toString(){
        return this.value +  "";
    }
}

class App{
    public static void main(String[] args) {
        Tile t1 = new Tile(5);
        Tile t2 = new Tile(7);

        String s = "asd";
        if(t1.equals(s) == true){  // Tile.yquals(t1, t2)

        }
        if(t1.equals(t2) == true){  // Tile.yquals(t1, t2)

        }
    }
}