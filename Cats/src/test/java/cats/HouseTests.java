package cats;

import org.junit.Test;

public class HouseTests {

    @Test(expected = NullPointerException.class)
    public void TestNameShouldFailIfNameIsNull() {
        new House(null, 10);
    }



}
