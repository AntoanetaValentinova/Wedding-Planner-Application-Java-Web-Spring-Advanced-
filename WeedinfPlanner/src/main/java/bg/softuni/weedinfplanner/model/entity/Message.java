package bg.softuni.weedinfplanner.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="messages")
public class Message extends BaseEntity{
    private Boolean isOpen;
    private User user;
    private Supplier supplier;
    private String body;
    private Boolean isReplyFromSupplier;
    private LocalDateTime date;

    public Message() {
    }
    @Column(nullable = false)
    public Boolean getOpen() {
        return isOpen;
    }

    public Message setOpen(Boolean open) {
        isOpen = open;
        return this;
    }
    @ManyToOne(optional = false)
    public User getUser() {
        return user;
    }

    public Message setUser(User user) {
        this.user = user;
        return this;
    }

    @ManyToOne(optional = false)
    public Supplier getSupplier() {
        return supplier;
    }

    public Message setSupplier(Supplier supplier) {
        this.supplier = supplier;
        return this;
    }

    @Column(columnDefinition = "TEXT",nullable = false)
    public String getBody() {
        return body;
    }

    public Message setBody(String body) {
        this.body = body;
        return this;
    }

    @Column(name = "is_reply_from_supplier",nullable = false)
    public Boolean getReplyFromSupplier() {
        return isReplyFromSupplier;
    }

    public Message setReplyFromSupplier(Boolean replyFromSupplier) {
        isReplyFromSupplier = replyFromSupplier;
        return this;
    }

    @Column(nullable = false)
    public LocalDateTime getDate() {
        return date;
    }

    public Message setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    @PrePersist
    public void setDateNow() {
        this.date=LocalDateTime.now();
    }
}
