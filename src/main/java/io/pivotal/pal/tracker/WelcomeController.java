package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.lang.String;

@RestController
public class WelcomeController {


    private java.lang.String myString = "hello";

    public WelcomeController(@Value("${WELCOME_MESSAGE}") String msg){
        myString = msg;
    }

    @GetMapping("/")
    public String sayHello() {

        return myString;
    }
}
