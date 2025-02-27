package com.example.messageInterface.Controller;

import com.example.messageInterface.Model.Message;
import com.example.messageInterface.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MessageController {
    @Autowired
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String content, @RequestParam String author, Model model) {
        Message message = messageService.createMessage(content, author);
        model.addAttribute("message", message);
        return "redirect:/quote";
    }

    @GetMapping("/quote")
    public String showQuotePage(Model model) {
        model.addAttribute("quote", "La vie est belle !");
        return "quote";
    }

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("message", new Message());
        return "messageForm";
    }

    @PostMapping("/messages")
    public String submitMessage(@ModelAttribute Message message) {
        System.out.println("Message: " + message.getContent());
        messageService.saveMessage(message);
        return "redirect:/quote";
    }
}
