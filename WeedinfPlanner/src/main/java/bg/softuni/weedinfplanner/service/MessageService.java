package bg.softuni.weedinfplanner.service;

import bg.softuni.weedinfplanner.model.service.MessageSendServiceModel;
import bg.softuni.weedinfplanner.model.service.MessageServiceModel;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

public interface MessageService {

    void userSendMessage(String recipientEmail, Principal principal, MessageSendServiceModel messageSendServiceModel);

    void supplierSendMessage(String recipient, Principal principal, MessageSendServiceModel messageSendServiceModel);

    List<MessageServiceModel> finAllInboxMessagesForSupplier(Principal principal);

    List<MessageServiceModel> finAllSendMessagesFromSupplier(Principal principal);

    List<MessageServiceModel> findAllInboxMessagesForUser(Principal principal);

    List<MessageServiceModel> findAllSendMessagesForUser(Principal principal);
}
