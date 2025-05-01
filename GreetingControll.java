package Stafff;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingControll {

    // Nane : MOhamed alin osmaan , Id:c1220249, class: CA221

    @GetMapping
    public String welcome() {
        return "Welcome to the Greeting API!";


    }

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return "Hello, " + name + "!";

    }

}
