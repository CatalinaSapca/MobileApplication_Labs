package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import server.model.Message;
import server.service.RecipeService;
import server.service.MailService;

@RestController
public class MailController {
    @Autowired
    private RecipeService recipeService;

    @PostMapping("/email")
    public ResponseEntity<Message> email(@RequestBody Message message) {
        MailService.send(message, recipeService.findAllRecipes());
        return ResponseEntity.accepted().body(message);
    }
}
