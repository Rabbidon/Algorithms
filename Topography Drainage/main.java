import java.lang.reflect.Array;
import java.util.Arrays;

public class main
{
    public static void main(String[] args)
    {
        Topography worldMap = new Topography(new int[][] {{0,3,3,3,0},{0,2,0,1,0},{0,3,3,3,0}},new Coordinates(1,0),new Coordinates(1,4));
        System.out.println(Arrays.deepToString(worldMap.calcDrain()));
    }
}
