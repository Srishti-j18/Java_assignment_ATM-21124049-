//custom-made datatype for storing three values i.e. password, balance and name of user
public class Key {
    public int x;
    public int y;
    public String s;

    public Key(int x, int y, String s) {
        this.x = x;
        this.y = y;
        this.s = s;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Key))
            return false;
        Key key = (Key) o;
        return x == key.x && y == key.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
