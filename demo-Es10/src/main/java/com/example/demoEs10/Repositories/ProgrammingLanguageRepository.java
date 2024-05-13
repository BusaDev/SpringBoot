package com.example.demoEs10.repositories;

import com.example.demoEs10.entities.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.Path;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource(path = "repo-prog-languages")
public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Long> {
}
