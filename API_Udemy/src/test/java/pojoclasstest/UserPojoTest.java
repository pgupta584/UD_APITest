package pojoclasstest;

import org.testng.annotations.Test;

public class UserPojoTest
{
    @Test
    public void pojoTest()
    {
        UsersTest u = new UsersTest();
        u.setName("Pankaj");
        u.setJob("SDET");
        System.out.println("Name "+u.getName());
        System.out.println("Job "+u.getJob());

    }
}
