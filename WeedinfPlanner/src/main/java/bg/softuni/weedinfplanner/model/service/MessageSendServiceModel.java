package bg.softuni.weedinfplanner.model.service;

public class MessageSendServiceModel {
    private String body;

    public MessageSendServiceModel() {
    }

    public String getBody() {
        return body;
    }

    public MessageSendServiceModel setBody(String body) {
        this.body = body;
        return this;
    }
}
