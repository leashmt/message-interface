package com.example.messageInterface.Controller;

import com.example.messageInterface.Model.Message;
import com.example.messageInterface.Model.Quote;
import com.example.messageInterface.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class MessageController {
    @Autowired
    private final MessageService messageService;
    private final RestTemplate restTemplate;

    @Autowired
    public MessageController(MessageService messageService, RestTemplate restTemplate) {
        this.messageService = messageService;
        this.restTemplate = restTemplate;
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
        return "conversation";
    }

    @PostMapping("/messages")
    public String submitMessage(Model model, @ModelAttribute Message message) {
        System.out.println("Message: " + message.getContent());
        model.addAttribute("userMessage", message);
        messageService.saveMessage(message);

        String apiUrl = "http://localhost:8081/quote/random";
        ResponseEntity<Quote> response = restTemplate.getForEntity(apiUrl, Quote.class);

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            model.addAttribute("quote", response.getBody()); // Ajoute un objet, pas du JSON brut
        } else {
            model.addAttribute("error", "Impossible de récupérer une citation.");
        }
        return "conversation";
    }
}
