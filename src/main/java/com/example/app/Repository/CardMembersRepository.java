package com.example.app.Repository;

import com.example.app.Models.CardMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardMembersRepository  extends JpaRepository<CardMembers,Long> {
}
