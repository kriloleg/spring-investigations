package com.kriloleg.inv.rest;

import com.kriloleg.inv.config.Configuration;
import com.kriloleg.inv.entity.Message;
import com.kriloleg.inv.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private Configuration conf;

    @Autowired
    private MessageRepository messageRepository;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String home() {
        return "Hello from Spring Boot application!";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Message addMessage(@RequestParam("message") String message) {
        return messageRepository.save(new Message(message));
    }


    @RequestMapping(value = "/add/json", method = RequestMethod.POST)
    public Message addMessage(@RequestBody Message message) {
        return messageRepository.save(message);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    @RequestMapping(value = "/all/page/{pageNumber}", method = RequestMethod.GET)
    public List<Message> getAllPaginated(@PathVariable("pageNumber") int page) {
        return messageRepository.findAll(new PageRequest(page, conf.getPageLimit())).getContent();
    }
}
