package fr.davidrobin.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import fr.davidrobin.api.entity.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {
    @RestResource(exported = false)
    List<Message> findByAuthorName(String authorName);
}