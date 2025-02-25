package springlearning.controller;

import org.springframework.web.bind.annotation.*;
import springlearning.user.User;
@RestController
@RequestMapping("/hello")
public class HelloRestContoller {
    @RequestMapping(value = {"","/","/home"})
    public String sayHello(){
        return "Hello From BridgeLabz!!!";
    }

    // curl localost:8080/hello/query?name=John -w "\n"
    @RequestMapping(value = {"/query"},method = RequestMethod.GET)
    public String sayHello(@RequestParam(value = "name") String name){
        return " Hello " + name + " ! ";
    }

    // curl localhost:8080/hello/param/John -w "\n"
    @GetMapping("/param/{name}")
    public String sayHelloParam(@PathVariable String name)
    {
        return "Hello " + name + "!";
    }


    //curl -X POST -H "Content-Type: application/json"
    // -d '{"firstName": John" , "lastName": "Cena"}'
    // "http://localhost:8080/hello/post" -w "\n"
    @PostMapping("/post")
    public String sayHello(@RequestBody User user){
        return "Hello " + user.getFirstName() + " "+ user.getLastName() +"!";
    }

    // curl -X PUT localhost:8080/hello/put/John
    // -w "\n"
    @PutMapping("/put/{firstName}")
    public String sayHello(@PathVariable String firstName,@RequestParam(value = "lastName") String lastName){
        return "Hello "+ firstName + " "+ lastName +"!";
    }
}
