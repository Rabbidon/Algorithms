import java.lang.reflect.Array;
import java.util.*;

//This class describes a 2D grid where each sqaure has a non-negative height, and one square in each ocean is denoted by a set of coordinates.
public class Topography {
    int[][] areaHeight;
    Coordinates ocean1;
    Coordinates ocean2;

    public Topography(int[][] areaHeight, Coordinates ocean1, Coordinates ocean2) {
        this.areaHeight = areaHeight;
        this.ocean1 = ocean1;
        this.ocean2 = ocean2;
    }

    //We could calculate drain in the natural way by simlating rainfall -- gradually increasing the water level until all squares drain into
    //an ocean. However, the same effect can be achieved by starting at each ocean and checking at each square how high the water level
    //needs to be for that ocean to connect to that square. We do this by simulating the ocean growing during rainfall.
    //We essentially have our ocean as "territory" and then expand to the square neighbouring our territory with least altitude.
    //This will necessarily give the path from the ocean to a given square with leat maximum altitude, which is what we want:
    //if we pop a square from the queue with height h, then we must have already considered every square aong all paths from
    //the ocean with height less than h. Additionally, when we hit a square with the water level at h, we have a path with maximum water
    //level h, so we know this is optimal. This is why the following algorithm is guaranteed to find the actual height required for drainage
    //for ocean 1 (and in O(n) no less!).
    public int[][] calcDrain() {
        //Initialises a grid showing which squares drain where - 1 indicates ocean 1, 2 indicates ocean 2, 3 indicates both.
        int[][] areaDrainage = new int[Array.getLength(this.areaHeight)][Array.getLength(this.areaHeight[0])];
        //Stores squares we have already visited - this ensures we don't visit the same square twice.
        Set<Coordinates> visited = new HashSet<Coordinates>();
        //A priority queue dictating which sqaure to visit next. We want to visit the lowest altitude square in the queue first.
        PriorityQueue<Coordinates> toVisit = new PriorityQueue<Coordinates>((Coordinates c1, Coordinates c2) -> this.areaHeight[c1.arg1][c1.arg2] - this.areaHeight[c2.arg1][c2.arg2]);
        int waterLevel = 0;
        //Initialises the algorithm starting somewhere in ocean 1.
        toVisit.add(ocean1);
        visited.add(ocean1);
        while (!toVisit.isEmpty()) {
            Coordinates currentCell = (toVisit.poll());
            //Checks to see if the new square is taller than all previous sqaures. If so, increasing water level to that value.
            if (this.areaHeight[currentCell.arg1][currentCell.arg2] > waterLevel) {
                waterLevel = this.areaHeight[currentCell.arg1][currentCell.arg2];
            }
            //Assigns the draingage height of the current square to the current water level.
            areaDrainage[currentCell.arg1][currentCell.arg2] = waterLevel;
            for (Coordinates i : currentCell.neighbours(this)) {
                if (!visited.contains(i))
                {
                    visited.add(i);
                    toVisit.add(i);
                }
            }
        }
        toVisit.clear();
        visited.clear();
        waterLevel = 0;
        toVisit.add(ocean2);
        visited.add(ocean2);
        //Performs the above for ocean 2, then resolves drainage by seeing which of the two drainage heights is less.
        while (!toVisit.isEmpty()) {
            Coordinates currentCell = (toVisit.poll());
            visited.add(currentCell);
            if (this.areaHeight[currentCell.arg1][currentCell.arg2] > waterLevel) {
                waterLevel = this.areaHeight[currentCell.arg1][currentCell.arg2];
            }
            if (areaDrainage[currentCell.arg1][currentCell.arg2] > waterLevel) {
                areaDrainage[currentCell.arg1][currentCell.arg2] = 1;
            } else if (areaDrainage[currentCell.arg1][currentCell.arg2] < waterLevel) {
                areaDrainage[currentCell.arg1][currentCell.arg2] = 2;
            } else {
                areaDrainage[currentCell.arg1][currentCell.arg2] = 3;
            }
            for (Coordinates i : currentCell.neighbours(this)) {
                if (!visited.contains(i))
                {
                    visited.add(i);
                    toVisit.add(i);
                }
            }
        }
        return areaDrainage;
    }
}

