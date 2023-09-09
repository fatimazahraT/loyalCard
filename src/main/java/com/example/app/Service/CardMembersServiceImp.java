package com.example.app.Service;

import com.example.app.Models.CardMembers;
import com.example.app.Repository.CardMembersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardMembersServiceImp implements CardMembersService {
    private final CardMembersRepository cardMembersRepository;

    public CardMembersServiceImp(CardMembersRepository cardMembersRepository) {
        this.cardMembersRepository = cardMembersRepository;
    }

    @Override
    public CardMembers getCardMemberById(Long memberId) {
        return cardMembersRepository.findById(memberId).orElse(null);
    }

    @Override
    public List<CardMembers> getAllCardMembers() {
        return cardMembersRepository.findAll();
    }

    @Override
    public CardMembers saveCardMember(CardMembers cardMember) {
        return cardMembersRepository.save(cardMember);
    }

    @Override
    public void deleteCardMember(Long memberId) {
        cardMembersRepository.deleteById(memberId);
    }
}
