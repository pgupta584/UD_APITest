package jsonTest;

import org.testng.annotations.Test;

import java.util.Random;

public class TestPlay
{
    @Test
    void testPlay()
    {

        Random rand = new Random();
        System.out.printf("%04d%n", rand. nextInt(10000));
        System.out.printf("Current Time in milli second "+System.currentTimeMillis());


    }
}
