package issue;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTestng
{
    @Test
    void test1()
    {
        Assert.assertTrue(true);
    }
    @Test
    void test2()
    {
        Assert.assertTrue(true);
    }
    @Test
    void test3()
    {
        Assert.assertTrue(false);
    }
    @Test
    void test4()
    {
        Assert.assertTrue(true);
    }
}
