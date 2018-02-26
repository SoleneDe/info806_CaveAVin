package fr.univ_smb.isc.m2.controllers.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {


    @RequestMapping("/")
    public String home() {
        return "forward:/resources/html/index.html";
    }


    @RequestMapping("/home")
    public String homeJsp() {
        return "anonymous-home";
    }

    @RequestMapping("/creer/bouteilles")
    public String creerBouteille() {
        return "creerBouteille-page";
    }


    @RequestMapping(value = "/bouteilles", method = RequestMethod.GET)
    public String bouteilles() {
        return "bouteilles-page";
    }


    @RequestMapping(value = "/bouteilles/{id}", method = RequestMethod.GET)
    public String bouteille(@PathVariable("id") String id) {
        ModelMap model = new ModelMap();
        model.put("id", id);
        return "bouteille-page";
    }


    @RequestMapping(value = "/casiers", method = RequestMethod.GET)
    public String casiers() {
        return "casiers-page";
    }


    @RequestMapping(value = "/casiers/{id}", method = RequestMethod.GET)
    public String casier(@PathVariable("id") String id) {
        ModelMap model = new ModelMap();
        model.put("id", id);
        return "casier-page";
    }


    @RequestMapping("/admin")
    public ModelAndView admin(Principal principal) {
        return new ModelAndView("admin-home", "user", principal.getName());
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

}
