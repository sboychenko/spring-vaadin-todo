package ru.sboychenko.vaadin.todo.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.sboychenko.vaadin.todo.model.Priority;
import ru.sboychenko.vaadin.todo.model.Todo;

import java.time.LocalDate;

@Service
@ConditionalOnProperty(name = "clean.enable", havingValue = "true")
public class CleanService {
    Logger log = LoggerFactory.getLogger(this.getClass().getName());

    final
    TodoRepository repository;

    @Autowired
    public CleanService(TodoRepository repository) {
        this.repository = repository;
        addDemoData();
    }

    @Scheduled(cron = "0 0 * * * *")
    public void clear() {
        log.info("CLEAR DB");
        repository.deleteAll();
        addDemoData();
    }

    private void addDemoData() {
        repository.save(new Todo("Test application", LocalDate.now(), Priority.NORMAL, true));
        repository.save(new Todo("Do something", null, Priority.LOW, false));
        repository.save(new Todo("Do something els", LocalDate.of(2021, 12, 2), Priority.HIGH, false));
    }
}
