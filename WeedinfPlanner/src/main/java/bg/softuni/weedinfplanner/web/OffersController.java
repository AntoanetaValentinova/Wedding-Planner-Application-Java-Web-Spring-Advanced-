package bg.softuni.weedinfplanner.web;

import bg.softuni.weedinfplanner.model.binding.MessageSendBindingModel;
import bg.softuni.weedinfplanner.model.binding.OfferAddBindingModel;
import bg.softuni.weedinfplanner.model.binding.OfferUpdateBindingModel;
import bg.softuni.weedinfplanner.model.binding.PictureAddBindingModel;
import bg.softuni.weedinfplanner.model.entity.enums.CategorySupplierEnum;
import bg.softuni.weedinfplanner.model.service.OfferAddServiceModel;
import bg.softuni.weedinfplanner.model.service.OfferUpdateServiceModel;
import bg.softuni.weedinfplanner.model.service.PictureAddServiceModel;
import bg.softuni.weedinfplanner.model.view.OfferDetailsViewModel;
import bg.softuni.weedinfplanner.model.view.OffersAllViewModel;
import bg.softuni.weedinfplanner.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class OffersController {

    private final OfferService offerService;
    private final SupplierService supplierService;
    private final ModelMapper modelMapper;
    private final WeddingService weddingService;


    public OffersController(OfferService offerService, SupplierService supplierService, ModelMapper modelMapper, WeddingService weddingService) {
        this.offerService = offerService;
        this.supplierService = supplierService;
        this.modelMapper = modelMapper;
        this.weddingService = weddingService;
    }

   //SHOW ALL OFFERS
    @GetMapping("/offers")
    public String allSuppliersOffers(Model model) {
        List<OffersAllViewModel> approvedOffers = this.offerService.getAllApprovedOffersServiceModel()
                .stream()
                .map(offersAllServiceModel -> this.modelMapper.map(offersAllServiceModel, OffersAllViewModel.class))
                .collect(Collectors.toList());
        model.addAttribute("approvedOffers", approvedOffers);
        model.addAttribute("allCategories", CategorySupplierEnum.values());
        return "all-offers";
    }

    //SHOW ALL OFFERS BY CATEGORY
    @GetMapping("/offers/category-{category}")
    public String allSuppliersOffersByCategory(@PathVariable String category,Model model) {
        List<OffersAllViewModel> allApprovedOffersByCategory = this.offerService.getAllApprovedOffersByCategory(category)
                .stream()
                .map(offersAllServiceModel -> this.modelMapper.map(offersAllServiceModel, OffersAllViewModel.class))
                .collect(Collectors.toList());
        model.addAttribute("approvedOffers",allApprovedOffersByCategory);
        model.addAttribute("allCategories", CategorySupplierEnum.values());
        return "all-offers";
    }

    //OFFER DETAILS PAGE
    @ModelAttribute("offerDetailsViewModel")
    public OfferDetailsViewModel offerDetailsViewModel() {
        return new OfferDetailsViewModel();
    }

    @GetMapping("/offers/{id}")
    public String offerDetails(@PathVariable Long id, Model model,Principal principal) {
        if(principal!=null) {
            boolean isFavourite = this.weddingService.findIfOfferIsInFavouriteList(id, principal);
            boolean isHired = this.weddingService.findIfOfferIsInHiredList(id, principal);
            model.addAttribute("isFavourite", isFavourite);
            model.addAttribute("isHired", isHired);
        }
        boolean isCurrentUserOwner = this.offerService.isCurrentUserOwner(principal, id);
        OfferDetailsViewModel offerDetailsViewModel = this.offerService.findOfferViewModelById(id);
        model.addAttribute("isCurrentUserOwner",isCurrentUserOwner);
        model.addAttribute("offer", offerDetailsViewModel);
        return "offer-details";
    }

    // ADD OFFER
    @ModelAttribute
    public OfferAddBindingModel offerAddBindingModel() {
        return new OfferAddBindingModel();
    }

    @GetMapping("/offers/add")
    public String addOffer(Model model) {
        model.addAttribute("categories",CategorySupplierEnum.values());
        return "offer-add";
    }

    @PostMapping("/offers/add")
    public String addOffer(@Valid OfferAddBindingModel offerAddBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           Principal principal) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerAddBindingModel", offerAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerAddBindingModel", bindingResult);
            return "redirect:/offers/add";
        }

        OfferAddServiceModel offerAddServiceModel = this.modelMapper.map(offerAddBindingModel, OfferAddServiceModel.class);
        Long idOffer=this.offerService.addNewOffer(offerAddServiceModel, principal);
        return "redirect:/offers/" + idOffer;
    }

    // EDIT OFFER
    @ModelAttribute
    public OfferUpdateBindingModel offerUpdateBindingModel() {
        return new OfferUpdateBindingModel();
    }

    @GetMapping("/offers/{id}/update")
    public String updateOffer(@PathVariable Long id, Model model) {
        OfferDetailsViewModel offerDetailsViewModel = this.offerService.findOfferViewModelById(id);
        OfferUpdateBindingModel offerUpdateBindingModel = this.modelMapper.map(offerDetailsViewModel, OfferUpdateBindingModel.class);
        model.addAttribute("offer", offerDetailsViewModel);
        model.addAttribute("offerUpdateBindingModel", offerDetailsViewModel);
        return "offer-update";
    }

    @PatchMapping("/offers/{id}/update")
    public String updateOffer(@PathVariable Long id,
                              @Valid OfferUpdateBindingModel offerUpdateBindingModel,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("updateHasErrors",true);
            redirectAttributes.addFlashAttribute("offerUpdateBindingModel", offerUpdateBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerUpdateBindingModel", bindingResult);
            return "redirect:/offers/{id}/update/errors";
        }

        OfferUpdateServiceModel offerUpdateServiceModel = this.modelMapper.map(offerUpdateBindingModel, OfferUpdateServiceModel.class);
        this.offerService.updateOffer(offerUpdateServiceModel,id);

        return "redirect:/offers/"+id;
    }

    @GetMapping("/offers/{id}/update/errors")
    public String updateOfferErrors(@PathVariable Long id, Model model) {
        OfferDetailsViewModel offerDetailsViewModel = this.offerService.findOfferViewModelById(id);
        model.addAttribute("offer", offerDetailsViewModel);
        return "offer-update";
    }

    //ADD NEW PICTURE TO THE EXISTING OFFER
    @ModelAttribute
    public PictureAddBindingModel pictureAddBindingModel() {
        return new PictureAddBindingModel();
    }

    @PostMapping("/offers/{id}/update/add-picture")
    public String addNewPicture(@PathVariable Long id,
                                @Valid PictureAddBindingModel pictureAddBindingModel,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) throws IOException {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("pictureAddHasErrors",true);
            redirectAttributes.addFlashAttribute("pictureAddBindingModel", pictureAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.pictureAddBindingModel", bindingResult);
            return "redirect:/offers/"+id+"/update";
        }

        PictureAddServiceModel pictureAddServiceModel = this.modelMapper.map(pictureAddBindingModel, PictureAddServiceModel.class);
        this.offerService.addNewPicture(pictureAddServiceModel,id);

        return "redirect:/offers/"+id+"/update";
    }


    //DELETE PICTURE FROM EXISTING OFFER
    @DeleteMapping("/offers/{id}/update/delete-picture/{picId}")
    public String deletePicture(@PathVariable Long id, @PathVariable Long picId) {
        this.offerService.deletePicture(picId);
        return "redirect:/offers/"+id+"/update";
    }


    //DELETE OFFER
    @DeleteMapping("/offers/{id}/delete")
    public String deleteOffer(@PathVariable Long id) {
        this.offerService.deleteOffer(id);
        return "redirect:/supplier-profile/my-offers";
    }

    @ModelAttribute
    public MessageSendBindingModel messageSendBindingModel() {
        return new MessageSendBindingModel();
    }
}
