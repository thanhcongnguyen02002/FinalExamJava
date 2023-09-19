package com.example.finalexamjava.config;

import com.example.finalexamjava.repository.GroupRepository;
import com.example.finalexamjava.repository.postgres.GroupJpaRepository;
import com.example.finalexamjava.repository.postgres.PgGroupRepositoryImpl;
import com.example.finalexamjava.service.GroupService;
import com.example.finalexamjava.service.GroupServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

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

}
