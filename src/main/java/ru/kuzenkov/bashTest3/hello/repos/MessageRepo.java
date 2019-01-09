package ru.kuzenkov.bashTest3.hello.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import ru.kuzenkov.bashTest3.hello.domain.Message;

public interface MessageRepo extends CrudRepository<Message, Integer> {

    Page<Message> findByTag(String tag, Pageable pageable);

    Page<Message> findAll(Pageable pageable);

}
