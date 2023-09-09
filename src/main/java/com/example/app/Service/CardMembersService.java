package com.example.app.Service;

import com.example.app.Models.CardMembers;

import java.util.List;

public interface CardMembersService {
    CardMembers getCardMemberById(Long memberId);

    List<CardMembers> getAllCardMembers();

    CardMembers saveCardMember(CardMembers cardMember);

    void deleteCardMember(Long memberId);
}
