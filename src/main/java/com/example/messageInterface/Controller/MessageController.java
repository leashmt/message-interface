package com.example.messageInterface.Controller;

import com.example.messageInterface.Model.Message;
import com.example.messageInterface.Service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String content, @RequestParam String author, Model model) {
        Message message = messageService.saveMessage(content, author);
        model.addAttribute("message", message);
        return "redirect:/quote";
    }

    @GetMapping("/quote")
    public String showQuotePage(Model model) {
        model.addAttribute("quote", "La vie est belle !");
        return "quote";
    }
}
