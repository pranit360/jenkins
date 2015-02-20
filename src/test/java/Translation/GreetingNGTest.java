/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Translation;

import static org.testng.Assert.*;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pranit Anand
 */
public class GreetingNGTest {
    
    private final String FROM_LANGUAGE = "English";
 private final String TO_LANGUAGE = "Danish";
private final String NAME = "John";
 
 private ITranslator translator;

    
    public GreetingNGTest() {
    }
Greeting greeting = new Greeting(translator);
   //create mockery context
//hereby it is established that we want to mock
    @Rule
 public JUnitRuleMockery context = new JUnitRuleMockery();


    /**
     * Test of sayHello method, of class Greeting.
     */
@Test
    public void testSayHello() {
 
    // setup mock object
 Mockery context = new JUnit4Mockery();
 final ITranslator mockTranslator =
context.mock(ITranslator.class);
// setup expectations about collaborating behavior
context.checking(new Expectations(){{
 oneOf (mockTranslator).translate(FROM_LANGUAGE,TO_LANGUAGE,NAME);
 will(returnValue("Hej "+NAME));
}});
// execute test
greeting.sayHello("Danish","John"); 

// verify state
 //assertEquals takes TWO parameters
assertEquals("Hej John",greeting.sayHello("Danish","John"));
    
    }
    
}
