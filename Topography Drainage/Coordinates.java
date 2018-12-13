import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Set;

//A coordinates class
public class Coordinates extends Object{
    int arg1;
    int arg2;

    public Coordinates(int i, int j) {
        this.arg1 = i;
        this.arg2 = j;
    }

    //Function that calculates neighbours based on a topography. A naive neighbour function is not possible
    //since the world map actualy has boundaries :).
    public Set<Coordinates> neighbours(Topography worldMap) {
        Set<Coordinates> neighbours = new HashSet<Coordinates>();
        if (this.arg1 > 0) {
            neighbours.add(new Coordinates(this.arg1 - 1, this.arg2));
        }
        if (this.arg2 > 0) {
            neighbours.add(new Coordinates(this.arg1, this.arg2 - 1));
        }
        if (this.arg1 < Array.getLength(worldMap.areaHeight)-1) {
            neighbours.add(new Coordinates(this.arg1 + 1, this.arg2));
        }
        if (this.arg2 < Array.getLength(worldMap.areaHeight[0])-1) {
            neighbours.add(new Coordinates(this.arg1, this.arg2 + 1));
        }
        return neighbours;
    }

    //Functions required for HashSet to function.
    @Override
    public boolean equals(Object other)
    {
        if (!(other instanceof Coordinates))
        {
            return false;
        }
        Coordinates rival = (Coordinates) other;
        if ((this.arg1 == rival.arg1)&(this.arg2 == rival.arg2))
        {
            return true;
        }
        return false;

    }

    @Override
    public int hashCode()
    {
        int result = 31*arg2 + arg1;
        return result;
    }
}
