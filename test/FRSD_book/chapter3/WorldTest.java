package FRSD_book.chapter3;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WorldTest {

    @Test
    public void testAWorldStartsOutEmpty() {
        World world = new World();
        assertTrue(world.isEmpty());
    }

    @Test
    public void testAWorldIsNotEmptyAfterSettingALivingCell() {
        World world = new World();
        world.setLivingAt(new Location(1, 0));
        assertFalse(world.isEmpty());
    }


}
