package com.example.javatraineetask.configuration;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ConfigurationRepository extends JpaRepository<Configuration, Long> {
    List<Configuration> findByAuthor(String author);
    List<Configuration> findByUploadDate(Date uploadDate);
}