package com.example.app.Controler;

import com.example.app.Models.CardMembers;
import com.example.app.Service.CardMembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card-members")
public class CardMembersController {

    private final CardMembersService cardMembersService;

    @Autowired
    public CardMembersController(CardMembersService cardMembersService) {
        this.cardMembersService = cardMembersService;
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<CardMembers> getCardMemberById(@PathVariable Long memberId) {
        CardMembers cardMember = cardMembersService.getCardMemberById(memberId);
        return ResponseEntity.ok(cardMember);
    }

    @GetMapping
    public ResponseEntity<List<CardMembers>> getAllCardMembers() {
        List<CardMembers> cardMembersList = cardMembersService.getAllCardMembers();
        return ResponseEntity.ok(cardMembersList);
    }

    @PostMapping
    public ResponseEntity<CardMembers> createCardMember(@RequestBody CardMembers cardMember) {
        CardMembers createdCardMember = cardMembersService.saveCardMember(cardMember);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCardMember);
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteCardMember(@PathVariable Long memberId) {
        cardMembersService.deleteCardMember(memberId);
        return ResponseEntity.noContent().build();
    }
}
