package bg.softuni.weedinfplanner.model.view;

import java.time.LocalDateTime;

public class MessageViewModel {
    private Long id;
    private String user;
    private String supplier;
    private String body;
    private boolean isReplyFromSupplier;
    private boolean isRead;
    private LocalDateTime date;

    public MessageViewModel() {
    }

    public Long getId() {
        return id;
    }

    public MessageViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUser() {
        return user;
    }

    public MessageViewModel setUser(String user) {
        this.user = user;
        return this;
    }

    public String getSupplier() {
        return supplier;
    }

    public MessageViewModel setSupplier(String supplier) {
        this.supplier = supplier;
        return this;
    }

    public String getBody() {
        return body;
    }

    public MessageViewModel setBody(String body) {
        this.body = body;
        return this;
    }

    public boolean isReplyFromSupplier() {
        return isReplyFromSupplier;
    }

    public MessageViewModel setReplyFromSupplier(boolean replyFromSupplier) {
        isReplyFromSupplier = replyFromSupplier;
        return this;
    }

    public boolean isRead() {
        return isRead;
    }

    public MessageViewModel setRead(boolean read) {
        isRead = read;
        return this;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public MessageViewModel setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }
}
