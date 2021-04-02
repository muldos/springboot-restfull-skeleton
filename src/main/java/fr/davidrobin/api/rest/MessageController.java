package fr.davidrobin.api.rest;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.davidrobin.api.entity.Message;
import fr.davidrobin.api.repository.MessageRepository;

@RestController
@RequestMapping(path = "/api")
public class MessageController {
    @Autowired
    private MessageRepository messageRepository;

    @PostMapping("/message")
    public ResponseEntity<Message> addNewMessage(@RequestBody Message messageInput) {
        try {
            Message m = new Message();
            m.setContent(messageInput.getContent());
            m.setAuthorName(messageInput.getAuthorName());
            m.setChannel(messageInput.getChannel());
            m.setCreationDate(new Date());
            Message created = messageRepository.save(m);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/message/{id}")
    public ResponseEntity<Message> getMessagelById(@PathVariable("id") long id) {
        Optional<Message> messageData = messageRepository.findById(id);

        if (messageData.isPresent()) {
            return new ResponseEntity<>(messageData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/message/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable("id") long id, @RequestBody Message messageInput) {
        Optional<Message> messageData = messageRepository.findById(id);

        if (messageData.isPresent()) {
            Message msg = messageData.get();
            msg.setAuthorName(messageInput.getAuthorName());
            msg.setContent(messageInput.getContent());
            msg.setChannel(messageInput.getChannel());
            return new ResponseEntity<>(messageRepository.save(msg), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
