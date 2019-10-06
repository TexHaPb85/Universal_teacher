package edu.practise.universal_teacher.controller;

import edu.practise.universal_teacher.exceptions.MessageNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("message")
public class MessageController {

    private int currId = 5;
    private Map<Integer, String> messages = new HashMap<Integer, String>() {{
        put(1, "message one");
        put(2, "message two");
        put(3, "message three");
        put(4, "message four");
    }};

    @GetMapping("{id}")
    public String getOne(@PathVariable Integer id) {
        if (!messages.containsKey(id)) {
            throw new MessageNotFoundException();
        }
        return messages.get(id);
    }

    @PostMapping
    public String createMessage(@RequestBody String message) {
        messages.put(currId++,message);
        return message;
    }

    @PutMapping("{id}")
    public String update(@PathVariable Integer id, @RequestBody String message){
        messages.put(id,message);
        return message;
    }

    @DeleteMapping("{id}")
    public void deleteMessage(@PathVariable Integer id){
        messages.remove(id);
    }

    @GetMapping
    public String list() {
        return messages.toString();
    }

}
