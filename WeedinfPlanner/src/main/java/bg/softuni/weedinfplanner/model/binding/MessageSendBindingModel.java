package bg.softuni.weedinfplanner.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class MessageSendBindingModel {
    private Long id;
    private Long offerId;
    private String body;

    public MessageSendBindingModel() {
    }

    public Long getId() {
        return id;
    }

    public MessageSendBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getOfferId() {
        return offerId;
    }

    public MessageSendBindingModel setOfferId(Long offerId) {
        this.offerId = offerId;
        return this;
    }

    @NotBlank(message = "Message is required!")
    @Size(min=10,max=500,message = "Message must be between 10 anf 500 characters.")
    public String getBody() {
        return body;
    }

    public MessageSendBindingModel setBody(String body) {
        this.body = body;
        return this;
    }
}
