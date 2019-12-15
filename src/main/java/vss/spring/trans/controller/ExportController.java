package vss.spring.trans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import vss.spring.trans.repositories.UserRepository;

@Controller
public class ExportController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/export", method = RequestMethod.GET, headers = "Accept=application/pdf")
    public ModelAndView exportUsers() {
        ModelAndView view = new ModelAndView("pdfView", "usersList", userRepository.findAll());
        return view;
    }
}
