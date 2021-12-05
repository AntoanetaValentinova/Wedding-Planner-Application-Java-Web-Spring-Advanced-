package bg.softuni.weedinfplanner.web;

import bg.softuni.weedinfplanner.model.binding.MessageSendBindingModel;
import bg.softuni.weedinfplanner.model.service.MessageSendServiceModel;
import bg.softuni.weedinfplanner.model.view.MessageViewModel;
import bg.softuni.weedinfplanner.service.MessageService;
import bg.softuni.weedinfplanner.service.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MessageController {
    private final MessageService messageService;
    private final ModelMapper modelMapper;
    private final SupplierService supplierService;

    public MessageController(MessageService messageService, ModelMapper modelMapper, SupplierService supplierService) {
        this.messageService = messageService;
        this.modelMapper = modelMapper;
        this.supplierService = supplierService;
    }

    //MESSAGES PAGE FOR SUPPLIER
    @GetMapping("/supplier/messages")
    public String messagesSupplier (Model model,Principal principal) {
            List<MessageViewModel> allInboxMessagesForSupplier= this.messageService.finAllInboxMessagesForSupplier(principal)
                    .stream()
                    .map(messageServiceModel -> this.modelMapper.map(messageServiceModel, MessageViewModel.class))
                    .collect(Collectors.toList());
            List<MessageViewModel> allSendMessagesFromSupplier= this.messageService.finAllSendMessagesFromSupplier(principal)
                    .stream()
                    .map(messageServiceModel -> this.modelMapper.map(messageServiceModel, MessageViewModel.class))
                    .collect(Collectors.toList());
            model.addAttribute("allInboxMessages",allInboxMessagesForSupplier);
            model.addAttribute("allSendMessages",allSendMessagesFromSupplier);
        return "supplier-messages";
    }

    //MESSAGES PAGE FOR USER
    @GetMapping("/user/messages")
    public String messagesUser (Model model,Principal principal) {
        List<MessageViewModel> allInboxMessagesForUser= this.messageService.findAllInboxMessagesForUser(principal)
                .stream()
                .map(messageServiceModel -> this.modelMapper.map(messageServiceModel, MessageViewModel.class))
                .collect(Collectors.toList());
        List<MessageViewModel> allSendMessagesFromUser= this.messageService.findAllSendMessagesForUser(principal)
                .stream()
                .map(messageServiceModel -> this.modelMapper.map(messageServiceModel, MessageViewModel.class))
                .collect(Collectors.toList());
        model.addAttribute("allInboxMessages",allInboxMessagesForUser);
        model.addAttribute("allSendMessages",allSendMessagesFromUser);
        return "user-messages";
    }

    //SEND MESSAGE
    @ModelAttribute
    public MessageSendBindingModel messageSendBindingModel() {
        return new MessageSendBindingModel();
    }

    @PostMapping("/messages/from-user/{recipient}")
    public String userSendMessageFromOffer(@PathVariable String recipient,
                              @Valid MessageSendBindingModel messageSendBindingModel,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,
                              Principal principal) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("messageSendBindingModel", messageSendBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.messageSendBindingModel", bindingResult);
            return "redirect:/offers/"+messageSendBindingModel.getOfferId();
        }
        MessageSendServiceModel messageSendServiceModel = this.modelMapper.map(messageSendBindingModel, MessageSendServiceModel.class);
        this.messageService.userSendMessage(recipient,principal,messageSendServiceModel);

        return "redirect:/offers/"+messageSendBindingModel.getOfferId();
    }

    @PostMapping("/supplier/messages/{recipient}")
    public String supplierSendMessage(@PathVariable String recipient,
                              @Valid MessageSendBindingModel messageSendBindingModel,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,
                              Principal principal) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("hasErrors",true);
            redirectAttributes.addFlashAttribute("idModal",messageSendBindingModel.getId());
            redirectAttributes.addFlashAttribute("messageSendBindingModel", messageSendBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.messageSendBindingModel", bindingResult);
            return "redirect:/supplier/messages";
        }
        MessageSendServiceModel messageSendServiceModel = this.modelMapper.map(messageSendBindingModel, MessageSendServiceModel.class);
        this.messageService.supplierSendMessage(recipient,principal,messageSendServiceModel);

        return "redirect:/supplier/messages";
    }

    @PostMapping("/user/messages/{recipient}")
    public String userSendMessage(@PathVariable String recipient,
                                      @Valid MessageSendBindingModel messageSendBindingModel,
                                      BindingResult bindingResult,
                                      RedirectAttributes redirectAttributes,
                                      Principal principal) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("hasErrors",true);
            redirectAttributes.addFlashAttribute("idModal",messageSendBindingModel.getId());
            redirectAttributes.addFlashAttribute("messageSendBindingModel", messageSendBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.messageSendBindingModel", bindingResult);
            return "redirect:/user/messages";
        }
        MessageSendServiceModel messageSendServiceModel = this.modelMapper.map(messageSendBindingModel, MessageSendServiceModel.class);
        this.messageService.userSendMessage(recipient,principal,messageSendServiceModel);

        return "redirect:/user/messages";
    }
}
