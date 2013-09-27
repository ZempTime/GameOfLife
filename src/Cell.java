import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zempelc
 * Date: 9/26/13
 * Time: 1:00 AM
 * To change this template use File | Settings | File Templates.
 */
public class Cell {

    private List<Cell> neighborList = new ArrayList<Cell>();

    private boolean alive;

    public int getAliveNeighbors(){
        if (neighborList.size() == 0){
            return 0;
        } else {
            int n= 0;
            for (Cell o : neighborList) {
                if (o.isAlive()){n++;}
            }
        return n;
        }
    }

    public static Cell createAliveCell(){
        return new Cell(true);
    }

    public static Cell createDeadCell(){
        return new Cell(false);
    }

    private Cell(boolean LifeStatus){
        this.alive = LifeStatus;
    }

    public void tick(){
        if((getAliveNeighbors() <= 1) || (getAliveNeighbors() >= 4)) {this.alive = false;}
        else if (getAliveNeighbors() == 3){this.alive = true;}
    }

    public boolean isAlive(){
        return this.alive;}

    public void addNeighbor(Cell cell) {
        this.neighborList.add(cell);
    }

    public List getNeighborList(){
        return this.neighborList;
    }

}
