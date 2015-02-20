/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Translation;

/**
 *
 * @author Pranit Anand
 */
public class Greeting {

    private ITranslator ttranslator;
    
    //following we inject the dependency, namely the ITranslator
    public Greeting(ITranslator translator){
        this.ttranslator=translator;
    }
    
    public String sayHello(String toLanguage, String name){
return ttranslator.translate("English", "Danish", "Hello")+""+name;        
    }
}   
