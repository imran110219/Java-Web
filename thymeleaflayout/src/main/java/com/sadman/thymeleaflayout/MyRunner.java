package com.sadman.thymeleaflayout;

import com.sadman.thymeleaflayout.model.Account;
import com.sadman.thymeleaflayout.model.Task;
import com.sadman.thymeleaflayout.repository.AccountRepository;
import com.sadman.thymeleaflayout.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
//        taskRepository.save(new Task("Shopping", "Buy Milk and Butter...", "2017.01.01 13:22:42"));
//        taskRepository.save(new Task("Books", "Read 'Lords of The Ring'", "2017.01.02 15:22:42"));
//
//        accountRepository.save(new Account("user", passwordEncoder.encode("demo"), "ROLE_USER"));
//        accountRepository.save(new Account("admin", passwordEncoder.encode("admin"), "ROLE_ADMIN"));
        System.out.println("Done!");
    }
}
