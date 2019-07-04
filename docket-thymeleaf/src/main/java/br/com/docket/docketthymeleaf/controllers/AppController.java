package br.com.docket.docketthymeleaf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private CartorioService service;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Cartorio> listCartorios = service.listAll();
        model.addAttribute("listCartorios", listCartorios);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewCartorioForm(Model model) {
        Cartorio cartorio = new Cartorio();
        model.addAttribute("cartorio", cartorio);
        return "new_cartorio";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCartorio(@ModelAttribute("cartorios") Cartorio cartorio) {
        service.save(cartorio);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditCartorioForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_cartorio");
        Cartorio cartorio = service.get(id);
        mav.addObject("cartorio", cartorio);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteCartorio(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }

}
