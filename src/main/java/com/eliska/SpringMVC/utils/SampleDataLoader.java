package com.eliska.SpringMVC.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.eliska.SpringMVC.SpringMvcApplication;
import com.eliska.SpringMVC.model.UserEntity;
import com.eliska.SpringMVC.repository.ArticleRepository;
import com.eliska.SpringMVC.repository.UserRepository;
import com.eliska.SpringMVC.service.ArticleService;

@Component
public class SampleDataLoader implements CommandLineRunner {

    @Autowired
    ArticleService articleService;

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
       // SpringMvcApplication.MyLog("============== APP START =============");
        loadSeedData();
    }

    private void loadSeedData() {
        //Users
        if (userRepository.count() == 0) {
            UserEntity sampleUser1 = new UserEntity("eliska", "eliska@domain.com");
            UserEntity sampleUser2 = new UserEntity("peter", "peter@domain.cz");
            UserEntity sampleUser3 = new UserEntity("adam", "adam@domain.co-uk");
            UserEntity sampleUser4 = new UserEntity("ursula", "ursula@witches.eu");
            UserEntity sampleUser5 = new UserEntity("peterpan", "peter@domain.com");
            userRepository.save(sampleUser1);
            userRepository.save(sampleUser2);
            userRepository.save(sampleUser3);
            userRepository.save(sampleUser4);
            userRepository.save(sampleUser5);
            //SpringMvcApplication.MyLog(String.format("Table UserEntity was empty, added seed data: %s", userRepository.count()));
        }

        if (articleRepository.count() == 0) {

            articleRepository.save(articleService.createArticle(1L,"Nadpis 1 uzivatele 1)", "Java is an object-oriented language, which means..."));
            articleRepository.save(articleService.createArticle((long)1,"Nadpis 2 uzivatele 1", "Java is an object-oriented language, which means..."));
            articleRepository.save(articleService.createArticle( (long)1,"Nadpis 3 uzivatele 1" , "Java is an object-oriented language, which means..."));
            articleRepository.save(articleService.createArticle( (long)2,"Nadpis 1  uzivatele 2", "Java is an object-oriented language, which means..."));
            articleRepository.save(articleService.createArticle((long)2,"Nadpis 2  uzivatele 2", "Java is an object-oriented language, which means..."));

            //SpringMvcApplication.MyLog(String.format("Table Article was empty, added seed data: %s", articleRepository.count()));
        }

    }

}



