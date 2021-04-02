package fr.davidrobin.api.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String customerName;
    private Date openingDate;
    private String reference;

    @ManyToMany
    @JoinTable(name = "message_folder", joinColumns = @JoinColumn(name = "message_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "folder_id", referencedColumnName = "id"))
    private Set<Message> messages = new HashSet<Message>();

    public Folder() {

    }

    public Long getId() {
        return id;
    }

    public Set<Message> getMessages() {
        return this.messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
