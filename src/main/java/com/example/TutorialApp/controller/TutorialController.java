package com.example.TutorialApp.controller;
import com.example.TutorialApp.model.Tutorial;
import com.example.TutorialApp.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tutorials")
public class TutorialController {

    @Autowired
    private TutorialService tutorialService;


    // Create new tutorial
    @PostMapping("/")
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
        Tutorial savedTutorial = tutorialService.createTutorial(tutorial);
        return new ResponseEntity<>(savedTutorial, HttpStatus.OK);
    }

    // View all tutorials
    @GetMapping("/")
    public ResponseEntity<List<Tutorial>> getAllTutorials() {
        List<Tutorial> tutorials = tutorialService.getAllTutorials();
        return new ResponseEntity<>(tutorials, HttpStatus.OK);
    }

    // View tutorial detail by id
    @GetMapping("/{id}")
    public ResponseEntity<?> getTutorialById(@PathVariable("id") Long id) {
        Optional<Tutorial> tutorialOptional = tutorialService.getTutorialById(id);
        if (tutorialOptional.isPresent()) {
            return new ResponseEntity<>(tutorialOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("{message: \"tutorial not found\"}", HttpStatus.NOT_FOUND);
        }
    }

    // Update tutorial detail by id
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTutorialById(@PathVariable("id") Long id, @RequestBody Tutorial tutorialDetails) {
        Tutorial updatedTutorial = tutorialService.updateTutorialById(id, tutorialDetails);
        return new ResponseEntity<>(updatedTutorial, HttpStatus.OK);
    }

    // Delete tutorial detail by id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTutorialById(@PathVariable("id") Long id) {
        tutorialService.deleteTutorialById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
