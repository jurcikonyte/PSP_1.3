package com.user.web.jpa;

import com.user.web.model.User;
import com.user.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandLineRunner implements CommandLineRunner {
    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new User("Vardas1", "Pavarde1", "860123456", "v.parvarde@gmail.com", "Gatve g. 1", "Slaptazodis1."));
        repository.save(new User("Vardas2", "Pavarde2", "860123457", "p.vardas@gmail.com", "Gatve g. 2", "Slaptazodis3!"));
        repository.save(new User("Vardas3", "Pavarde3", "860123458", "vardas.pavarde@gmail.com", "Gatve g. 3", "Slaptazodis2/"));
    }
}
