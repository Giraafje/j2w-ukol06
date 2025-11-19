package cz.czechitas.java2webapps.ukol6.controller;

import cz.czechitas.java2webapps.ukol6.entity.Vizitka;
import cz.czechitas.java2webapps.ukol6.service.VizitkaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VizitkaController {
  private final VizitkaService vizitkaService;

  //Connection to the service
  @Autowired
  public VizitkaController(VizitkaService vizitkaService) {
    this.vizitkaService = vizitkaService;
  }

  @InitBinder
  public void nullStringBinding(WebDataBinder binder) {
    //prázdné textové řetězce nahradit null hodnotou
    binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
  }

  @GetMapping("/")
  public ModelAndView seznam() {
    return new ModelAndView("seznam")
        .addObject("seznamVizitek", vizitkaService.getAll());
  }

  @GetMapping("/nova")
  public ModelAndView nova() {
    return new ModelAndView("formular")
        .addObject("vizitka", vizitkaService.newCard());
  }

  @PostMapping("/nova")
  public String pridat(@ModelAttribute("vizitka") @Valid Vizitka vizitka, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "formular";
    }
    vizitkaService.append(vizitka);
    return "redirect:/";
  }

  @GetMapping("/{id:[0-9]+}")
  public ModelAndView detail(@PathVariable Integer id) {
    var vizitkaModelAndView = new ModelAndView("vizitka");
    return vizitkaService.getById(id)
        .map(vizitka -> vizitkaModelAndView.addObject("vizitka", vizitka))
        .orElse(new ModelAndView("error", HttpStatus.NOT_FOUND));
  }
}
