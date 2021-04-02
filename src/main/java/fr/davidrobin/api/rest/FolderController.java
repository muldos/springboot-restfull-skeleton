package fr.davidrobin.api.rest;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
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

import fr.davidrobin.api.entity.Folder;
import fr.davidrobin.api.entity.Message;
import fr.davidrobin.api.repository.FolderRepository;
import fr.davidrobin.api.repository.MessageRepository;

@RestController
@RequestMapping(path = "/api")
public class FolderController {
    @Autowired
    private FolderRepository folderRepository;

    @Autowired
    private MessageRepository messageRepository;

    @PostMapping("/folder")
    public ResponseEntity<Folder> addNewFolder(@RequestBody Folder folderInput) {
        try {
            Folder f = new Folder();
            String customerName = folderInput.getCustomerName();
            f.setCustomerName(customerName);
            f.setReference(folderInput.getReference());
            f.setOpeningDate(new Date());
            List<Message> sameAuthorMessages = messageRepository.findByAuthorName(customerName);
            f.setMessages(new HashSet<>(sameAuthorMessages));
            Folder created = folderRepository.save(f);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/folder/{id}")
    public ResponseEntity<Folder> getFolderlById(@PathVariable("id") long id) {
        Optional<Folder> folderData = folderRepository.findById(id);

        if (folderData.isPresent()) {
            return new ResponseEntity<>(folderData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/folders")
    public ResponseEntity<List<Folder>> getAllFolder() {
        List<Folder> allFolders = (List<Folder>) folderRepository.findAll();
        return new ResponseEntity<List<Folder>>(allFolders, HttpStatus.OK);
    }

    @PutMapping("/folder/{id}")
    public ResponseEntity<Folder> updateFolder(@PathVariable("id") long id, @RequestBody Folder folderInput) {
        Optional<Folder> folderData = folderRepository.findById(id);
        if (folderData.isPresent()) {
            Folder folder = folderData.get();
            folder.setCustomerName(folderInput.getCustomerName());
            folder.setReference(folderInput.getReference());
            return new ResponseEntity<>(folderRepository.save(folder), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/folder/{id}/messages")
    public ResponseEntity<Folder> addMessage(@PathVariable("id") long id, @RequestBody MessageId input) {
        Optional<Folder> folderData = folderRepository.findById(id);
        Optional<Message> messageData = messageRepository.findById(input.getMsgId().longValue());
        if (folderData.isPresent() && messageData.isPresent()) {
            Folder folder = folderData.get();
            folder.getMessages().add(messageData.get());
            return new ResponseEntity<>(folderRepository.save(folder), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

class MessageId {
    private Long msgId;

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public MessageId() {
    }
}