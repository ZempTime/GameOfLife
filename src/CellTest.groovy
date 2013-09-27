import org.junit.Test

import static junit.framework.Assert.assertEquals
import static junit.framework.Assert.assertTrue

/**
 * Created with IntelliJ IDEA.
 * User: zempelc
 * Date: 9/26/13
 * Time: 1:03 AM
 * To change this template use File | Settings | File Templates.
 */
class CellTest {

    @Test
    public void dontBlowUp(){
        //this cell test does not extend JUNIT test
    }

    @Test
    public void isStartingDeadCellAlive(){
        //if cell starts dead
        Cell cell = Cell.createDeadCell();
        assertEquals(false, cell.isAlive());
    }

    @Test
    public void isStartingAliveCellAlive(){
        Cell cell = Cell.createAliveCell()
        assertEquals(true, cell.isAlive());

    }

    @Test
    public void zeroNeighborTick(){
        Cell cell = Cell.createAliveCell();
        cell.tick();
        assertEquals(false, cell.isAlive());
    }

    @Test
    public void oneNeighborTick(){
        Cell cell = Cell.createAliveCell();
        Cell neighbor = Cell.createAliveCell();
        cell.addNeighbor(neighbor);
        cell.tick();
        assertEquals(false, cell.isAlive());
    }

    @Test
    public void twoNeighborTick(){
        Cell cell = Cell.createAliveCell();
        Cell neighbor1 = Cell.createAliveCell();
        Cell neighbor2 = Cell.createAliveCell();
        cell.addNeighbor(neighbor1);
        cell.addNeighbor(neighbor2);
        assertEquals(true, cell.isAlive());
    }

    @Test
    public void threeNeighborTickWithAliveCell(){
        ArrayList neighborList = Arrays.asList(Cell.createAliveCell(), Cell.createAliveCell(), Cell.createAliveCell());
        Cell cell = Cell.createAliveCell();
        for (Cell c : neighborList){
            cell.addNeighbor(c);
        }
        cell.tick();
        assertEquals(true, cell.isAlive());
    }

    @Test
    public void threeNeighborTickWithDeadCell(){
        ArrayList neighborList = Arrays.asList(Cell.createAliveCell(), Cell.createAliveCell(), Cell.createAliveCell());
        Cell cell = Cell.createDeadCell();
        for (Cell c : neighborList){
            cell.addNeighbor(c);
        }
        cell.tick();
        assertEquals(true, cell.isAlive());
    }

    @Test
    public void fourNeighborTick(){
        ArrayList neighborList = Arrays.asList(Cell.createAliveCell(), Cell.createAliveCell(), Cell.createAliveCell(), Cell.createAliveCell());
        Cell cell = Cell.createAliveCell();
        for (Cell c : neighborList){
            cell.addNeighbor(c);
        }
        cell.tick();
        assertEquals(false, cell.isAlive());
    }

    @Test
    public void fiveNeighborTick(){
        ArrayList neighborList = Arrays.asList(Cell.createAliveCell(), Cell.createAliveCell(), Cell.createAliveCell(), Cell.createAliveCell(), Cell.createAliveCell());
        Cell cell = Cell.createAliveCell();
        for (Cell c : neighborList){
            cell.addNeighbor(c);
        }
        cell.tick();
        assertEquals(false, cell.isAlive());
    }

    @Test
    public void twoNeighborCells(){
        Cell cell1 = Cell.createAliveCell();
        Cell cell2 = Cell.createAliveCell();
        cell1.addNeighbor(cell2);
        cell2.addNeighbor(cell1);
    }

    @Test
    public void singleCellGrid(){
        Grid grid = new Grid();
        Cell center = Cell.createAliveCell();
        grid.centerCell()
    }

}
