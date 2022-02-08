package Anotacije;

import org.testng.annotations.*;

public class Zad1 {

    /*
    Napraviti 3 test metode, u svakoj test metodi ubaciti po jedan TIP testiranja (iz prve nedelje - teorija),
    u BeforeClass napisati vase ime i prezime, u BeforeMethod upisati "ITBootcamp". U AfterMethod napisati koja je
    nedelja kursa, u AfterClass napisati "Kraj"
     */

    @BeforeClass
    public void BeforeClass () {
        System.out.println("Tamara Gojkovic");
    }

    @BeforeMethod
    public void BeforeMethod () {
        System.out.println("ITBootcamp");
    }

    @Test
    public void Test1 () {
        System.out.println("Exploratory test");
    }

    @Test
    public void Test2 () {
        System.out.println("Smoke test");
    }

    @Test
    public void Test3 () {
        System.out.println("User acceptance test");
    }

    @AfterMethod
    public void AfterMethod () {
        System.out.println("Sedma nedelja kursa");
    }

    @AfterClass
    public void AfterClass () {
        System.out.println("Kraj");
    }


}
