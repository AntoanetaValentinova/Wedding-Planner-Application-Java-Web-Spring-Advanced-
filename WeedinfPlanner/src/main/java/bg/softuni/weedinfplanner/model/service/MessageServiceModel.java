package bg.softuni.weedinfplanner.model.service;

import bg.softuni.weedinfplanner.model.entity.Supplier;
import bg.softuni.weedinfplanner.model.entity.User;

import java.time.LocalDateTime;

public class MessageServiceModel {
    private Long id;
    private String user;
    private String supplier;
    private String body;
    private boolean isReplyFromSupplier;
    private boolean isRead;
    private LocalDateTime date;

    public MessageServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public MessageServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUser() {
        return user;
    }

    public MessageServiceModel setUser(String user) {
        this.user = user;
        return this;
    }

    public String getSupplier() {
        return supplier;
    }

    public MessageServiceModel setSupplier(String supplier) {
        this.supplier = supplier;
        return this;
    }

    public String getBody() {
        return body;
    }

    public MessageServiceModel setBody(String body) {
        this.body = body;
        return this;
    }

    public boolean isReplyFromSupplier() {
        return isReplyFromSupplier;
    }

    public MessageServiceModel setReplyFromSupplier(boolean replyFromSupplier) {
        isReplyFromSupplier = replyFromSupplier;
        return this;
    }

    public boolean isRead() {
        return isRead;
    }

    public MessageServiceModel setRead(boolean read) {
        isRead = read;
        return this;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public MessageServiceModel setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }
}
