package aquarium;

import org.junit.Test;
import static org.junit.Assert.*;

public class AquariumTests {

    @Test(expected = NullPointerException.class)
    public void TestSetNameShouldFailWhenNameIsNull() {
        new Aquarium(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void TestSetNameShouldFailWhenNameIsWhitespaces() {
        new Aquarium("   ", 10);
    }

    @Test
    public void TestSetNameShouldSetNameCorrectly() {
        Aquarium aquarium = new Aquarium("test_name", 10);
        assertEquals("test_name", aquarium.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestSetCapacityShouldFailWhenCapacityIsLessThanZero() {
        new Aquarium("test_name", -1);
    }

    @Test
    public void TestSetCapacityShouldSetCorrectly() {
        Aquarium aquarium = new Aquarium("test_name", 10);
        assertEquals(10, aquarium.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestAddFishShouldFailWhenAquariumIsFull() {
        Aquarium aquarium = new Aquarium("test_name", 0);
        aquarium.add(new Fish("test_fish"));
    }

    @Test
    public void TestAddingFishShouldIncreaseFishCount() {
        Aquarium aquarium = new Aquarium("test_name", 10);
        aquarium.add(new Fish("test_fish"));
        assertEquals(1, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestRemoveFishShouldFailWhenFishDoesntExist() {
        Aquarium aquarium = new Aquarium("test_name", 10);
        aquarium.remove("test_fish");
    }

    @Test
    public void TestRemoveFishShouldDecreaseFishCount() {
        Aquarium aquarium = new Aquarium("test_name", 10);
        aquarium.add(new Fish("test_fish"));
        aquarium.add(new Fish("test_fish2"));
        aquarium.remove("test_fish2");
        assertEquals(1, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestSellFishShouldFailWhenNoSuchFishAdded() {
        Aquarium aquarium = new Aquarium("test_name", 10);
        aquarium.sellFish("test_fish");
    }

    @Test
    public void TestSellFishCorrectly() {
        Aquarium aquarium = new Aquarium("test_name", 10);
        Fish fish = new Fish("test_fish");
        aquarium.add(fish);
        aquarium.sellFish("test_fish");
        assertFalse(fish.isAvailable());
    }

   @Test
   public void TestGetInfo(){
        Aquarium aquarium = new Aquarium("test_name", 10);
        aquarium.add(new Fish("test_fish"));
        aquarium.add(new Fish("test_fish1"));
        aquarium.add(new Fish("test_fish2"));

        String expected = "Fish available at test_name: test_fish, test_fish1, test_fish2";

        assertEquals(expected, aquarium.report());
   }
}

