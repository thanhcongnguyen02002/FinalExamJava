package com.example.finalexamjava.config;

import com.example.finalexamjava.repository.GroupRepository;
import com.example.finalexamjava.repository.UserRepository;
import com.example.finalexamjava.repository.postgres.GroupJpaRepository;
import com.example.finalexamjava.repository.postgres.PgGroupRepositoryImpl;
import com.example.finalexamjava.repository.postgres.PgUserRepositoryImpl;
import com.example.finalexamjava.repository.postgres.UserJpaRepository;
import com.example.finalexamjava.service.GroupService;
import com.example.finalexamjava.service.GroupServiceImpl;
import com.example.finalexamjava.service.UserService;
import com.example.finalexamjava.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.OffsetDateTime;
import java.util.Optional;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.finalexamjava.repository")
@EnableJpaAuditing(dateTimeProviderRef = "provider")
public class AppConfig {
    @Bean
    GroupService groupService(GroupRepository repository)
    {
        return  new GroupServiceImpl(repository);
    }
  @Bean
  @Primary
  GroupRepository repository(GroupJpaRepository repository){
        return  new PgGroupRepositoryImpl(repository);
  }
    @Bean
    DateTimeProvider provider() {
        return () -> Optional.of(OffsetDateTime.now());
    }
//    @Bean
//    AuditorAware<String> auditorAware(){
//        return ()->{
//            var authentication = SecurityContextHolder.getContext().getAuthentication();
//            if(authentication== null || !authentication.isAuthenticated()){
//                return Optional.empty();
//            }
//            return Optional.of(SecurityContextHolder.getContext().getAuthentication().getName());
//        };
//    }

    @Bean
    UserService userService(UserRepository repository) {
        return new UserServiceImpl(repository);
    }





}
