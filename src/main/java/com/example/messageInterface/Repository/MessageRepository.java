package com.example.messageInterface.Repository;

import com.example.messageInterface.Model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findAllByOrderByAuthorAsc();
}
