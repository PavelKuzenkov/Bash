package ru.kuzenkov.bashTest3.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kuzenkov.bashTest3.hello.domain.Message;
import ru.kuzenkov.bashTest3.hello.domain.User;
import ru.kuzenkov.bashTest3.hello.repos.MessageRepo;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/")
    public String greeting(
            @AuthenticationPrincipal User user,
            @RequestParam(name="name", required=false, defaultValue="User") String name,
            Map<String, Object> model) {
        if (user == null) {
            model.put("name", name);
            model.put("link", "Login.");
        } else {
            model.put("name", user.getUsername());
            model.put("link", "Go to main.");
        }
        //Говнокод. Наверно это делается по-другому.
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Message> messages = messageRepo.findAll();
        if (filter != null && !filter.isEmpty()) {
            messages = messageRepo.findByTag(filter);
        } else {
            messages = messageRepo.findAll();
        }
        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);
        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag, Map<String, Object> model
    ) {
        messageRepo.save(new Message(text, tag, user));
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "main";
    }
}