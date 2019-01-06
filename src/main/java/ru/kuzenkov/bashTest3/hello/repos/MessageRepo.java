package ru.kuzenkov.bashTest3.hello.repos;

import org.springframework.data.repository.CrudRepository;
import ru.kuzenkov.bashTest3.hello.domain.Message;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Integer> {

    List<Message> findByTag(String tag);
}
