package FRSD_book.chapter1;

import org.junit.Test;

import static org.junit.Assert.*;

public class GoL_Test {
    @Test
    public void testNewWorldIsEmpty() {
        World world = new World();
        assertTrue(world.isEmpty());

        // Bad: no symmetry
        //        World world = new World();
        //        assertEquals(0, world.getLivingCellsCount());
    }

    @Test
    public void testACellCanBeAddedToTheWorld() {
        World world = new World();
        world.setLivingAt(1, 1);
        assertTrue(world.aliveAt(1, 1));
        assertFalse(world.isEmpty());

        //        World world = new World();
        //        world.setLivingAt(1, 1);
        //        assertEquals(1, world.getLivingCellsCount());
    }



}
