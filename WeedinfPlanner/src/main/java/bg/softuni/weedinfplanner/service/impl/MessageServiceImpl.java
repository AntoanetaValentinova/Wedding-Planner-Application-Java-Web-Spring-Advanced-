package bg.softuni.weedinfplanner.service.impl;

import bg.softuni.weedinfplanner.model.entity.Message;
import bg.softuni.weedinfplanner.model.entity.Supplier;
import bg.softuni.weedinfplanner.model.entity.User;
import bg.softuni.weedinfplanner.model.service.MessageSendServiceModel;
import bg.softuni.weedinfplanner.model.service.MessageServiceModel;
import bg.softuni.weedinfplanner.repository.MessageRepository;
import bg.softuni.weedinfplanner.service.MessageService;
import bg.softuni.weedinfplanner.service.SupplierService;
import bg.softuni.weedinfplanner.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final SupplierService supplierService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public MessageServiceImpl(MessageRepository messageRepository, SupplierService supplierService, UserService userService, ModelMapper modelMapper) {
        this.messageRepository = messageRepository;
        this.supplierService = supplierService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    @Override
    public void userSendMessage(String recipientEmail, Principal principal, MessageSendServiceModel messageSendServiceModel) {
        Supplier supplier = this.supplierService.findSupplierByEmail(recipientEmail);
        User user = this.userService.findUserByEmail(principal.getName());
        Message message = this.modelMapper.map(messageSendServiceModel, Message.class);
        message.setUser(user);
        message.setSupplier(supplier);
        message.setReplyFromSupplier(false);
        message.setOpen(false);
        this.messageRepository.save(message);
    }


    @Override
    public void supplierSendMessage(String recipient, Principal principal, MessageSendServiceModel messageSendServiceModel) {
        Supplier supplier = this.supplierService.findSupplierByEmail(principal.getName());
        User user = this.userService.findUserByEmail(recipient);
        Message message = this.modelMapper.map(messageSendServiceModel, Message.class);
        message.setUser(user);
        message.setSupplier(supplier);
        message.setReplyFromSupplier(true);
        message.setOpen(false);
        this.messageRepository.save(message);
    }

    @Override
    public List<MessageServiceModel> finAllInboxMessagesForSupplier(Principal principal) {
        return this.messageRepository.findAllBySupplierEmailAndReplyFromSupplierOrderByIdDesc(principal.getName(),false)
                .stream()
                .map(message -> {
                    MessageServiceModel messageServiceModel = this.modelMapper.map(message, MessageServiceModel.class);
                    messageServiceModel.setSupplier(message.getSupplier().getEmail());
                    messageServiceModel.setUser(message.getUser().getEmail());
                    return messageServiceModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<MessageServiceModel> finAllSendMessagesFromSupplier(Principal principal) {
        return this.messageRepository.findAllBySupplierEmailAndReplyFromSupplierOrderByIdDesc(principal.getName(),true)
                .stream()
                .map(message -> {
                    MessageServiceModel messageServiceModel = this.modelMapper.map(message, MessageServiceModel.class);
                    messageServiceModel.setSupplier(message.getSupplier().getEmail());
                    messageServiceModel.setUser(message.getUser().getEmail());
                    return messageServiceModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<MessageServiceModel> findAllInboxMessagesForUser(Principal principal) {
        return this.messageRepository.findAllByUserEmailAndReplyFromSupplierOrderByIdDesc(principal.getName(),true)
                .stream()
                .map(message -> {
                    MessageServiceModel messageServiceModel = this.modelMapper.map(message, MessageServiceModel.class);
                    messageServiceModel.setSupplier(message.getSupplier().getEmail());
                    messageServiceModel.setUser(message.getUser().getEmail());
                    return messageServiceModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<MessageServiceModel> findAllSendMessagesForUser(Principal principal) {
        return this.messageRepository.findAllByUserEmailAndReplyFromSupplierOrderByIdDesc(principal.getName(),false)
                .stream()
                .map(message -> {
                    MessageServiceModel messageServiceModel = this.modelMapper.map(message, MessageServiceModel.class);
                    messageServiceModel.setSupplier(message.getSupplier().getEmail());
                    messageServiceModel.setUser(message.getUser().getEmail());
                    return messageServiceModel;
                })
                .collect(Collectors.toList());
    }


}
