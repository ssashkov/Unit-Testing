package cats;

import org.junit.Test;
import static org.junit.Assert.*;

public class HouseTests {
    @Test(expected = NullPointerException.class)
    public void TestSetNameShouldFailIfNull() {
        new House(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void TestSetNameShouldFailIfEmpty() {
        new House("", 10);
    }

    @Test
    public void TestSetNameSuccessfully() {
        House house = new House("test_house", 10);
        assertEquals("test_house", house.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestSetCapacityShouldFailIfLessThanZero() {
        new House("test_house", -1);
    }

    @Test
    public void TestSetCapacitySuccessfully() {
        House house = new House("test_house", 10);
        assertEquals(10, house.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestAddCatShouldFailIfNoCapacity() {
        House house = new House("test_house", 0);
        Cat cat = new Cat("test_cat");
        house.addCat(cat);
    }

    @Test
    public void TestAddCatShouldAddCatSuccessfully() {
        House house = new House("test_house", 10);
        Cat cat = new Cat("test_cat");
        house.addCat(cat);
        assertEquals(1, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestRemoveCatShouldFailIfNoSuchFish() {
        House house = new House("test_house", 10);
        house.removeCat("test_cat");
    }

    @Test
    public void TestRemoveCatShouldRemoveCatSuccessfully() {
        House house = new House("test_house", 10);
        Cat cat = new Cat("test_cat");
        house.addCat(cat);
        house.removeCat("test_cat");
        assertEquals(0, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestSellCatShouldFailWhenNoSuchCatAdded() {
        House house = new House("test_house", 10);
        house.catForSale("test_cat");
    }

    @Test
    public void TestSellCatCorrectly() {
        House house = new House("test_house", 10);
        Cat cat = new Cat("test_cat");
        house.addCat(cat);
        house.catForSale("test_cat");
        assertFalse(cat.isHungry());
    }

    @Test
    public void TestGetInfo(){
        House house = new House("test_house", 10);
        house.addCat(new Cat("test_cat"));
        house.addCat(new Cat("test_cat1"));
        house.addCat(new Cat("test_cat2"));

        String expected = "The cat test_cat, test_cat1, test_cat2 is in the house test_house!";

        assertEquals(expected, house.statistics());
    }
}
