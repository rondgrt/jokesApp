package nl.rondgrt.learn.jokesapp.controllers;

import nl.rondgrt.learn.jokesapp.services.JokeService;
import nl.rondgrt.learn.jokesapp.services.JokeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokesController {

    private final JokeService jokeService;

    @Autowired
    public JokesController(JokeServiceImpl jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping({"/", ""})
    public String jokes(Model model) {
        model.addAttribute("joke", jokeService.getRandomJoke());

        return "chucknorris";
    }
}
