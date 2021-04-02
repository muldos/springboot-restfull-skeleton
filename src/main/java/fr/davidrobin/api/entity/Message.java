package fr.davidrobin.api.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import fr.davidrobin.api.constant.Channel;

@Entity
@JsonIgnoreProperties({ "folders" })
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String content;

    private String authorName;

    private Channel channel;

    private Date creationDate;

    @ManyToMany(mappedBy = "messages")
    private Set<Folder> folders = new HashSet<Folder>();

    public Message() {
    }

    public Long getId() {
        return id;
    }

    public void setFolders(Set<Folder> folders) {
        this.folders = folders;
    }

    public Set<Folder> getFolders() {
        return this.folders;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
