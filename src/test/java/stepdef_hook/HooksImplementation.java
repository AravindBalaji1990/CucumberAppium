package stepdef_hook;

import io.cucumber.java.*;
import io.cucumber.java.en.Given;

public class HooksImplementation {

    @Before
    public void Before(){
        System.out.println("this is my before");

    }

    @After
    public void After(){
        System.out.println("this is my after");

    }

//    @BeforeAll
//    public static void BeforeAll(){
//        System.out.println("this is my beforeall");
//
//    }
//
//    @AfterAll
//    public static void AfterAll(){
//        System.out.println("this is my afterall");
//
//    }

    @BeforeStep
    public  void BeforeStep(){
        System.out.println("this is my beforestep");

    }

    @AfterStep
    public void AfterStep(){
        System.out.println("this is my afterstep");

    }
    @Given("User runs the case")
    public void user_runs_the_case() {
        System.out.println("this is my scenario");
    }
}
