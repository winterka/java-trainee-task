package com.example.javatraineetask.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ConfigurationController {

    @Autowired
    ConfigurationRepository configurationRepository;

    @GetMapping("/configurations")
    public ResponseEntity<List<Configuration>> getAllConfigurations(){
        try {
            List<Configuration> configurations = new ArrayList<Configuration>();
            configurationRepository.findAll().forEach(configurations::add);
            if (configurations.isEmpty()) {
                return new ResponseEntity<>(configurations, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(configurations, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/configurations")
    public ResponseEntity<Configuration> addConfiguration(@RequestBody Configuration configuration){
        try{
            Configuration _configuration = configurationRepository.save(new Configuration(
                    configuration.getTitle(),
                    configuration.getUploadDate(),
                    configuration.getAuthor(),
                    configuration.getDescription()
            ));
            return new ResponseEntity<>(_configuration, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @ResponseBody
    @PutMapping("/configurations/{id}")
    public ResponseEntity<Configuration> updateConfiguration(@PathVariable("id") long id, @RequestBody Configuration configuration){
        Optional<Configuration> configurationData = configurationRepository.findById(id);
        if (configurationData.isPresent()){
            Configuration _configuration = configurationData.get();
            _configuration.setTitle(configuration.getTitle());
            _configuration.setUploadDate(configuration.getUploadDate());
            _configuration.setAuthor(configuration.getAuthor());
            _configuration.setDescription(configuration.getDescription());
            return new ResponseEntity<>(configurationRepository.save(_configuration), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @DeleteMapping("/configurations/{id}")
    public ResponseEntity<HttpStatus> deleteConfiguration(@PathVariable("id") long id){
        try{
            configurationRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
