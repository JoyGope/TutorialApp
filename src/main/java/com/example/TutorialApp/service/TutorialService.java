package com.example.TutorialApp.service;

import com.example.TutorialApp.model.Tutorial;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface TutorialService {

    Tutorial createTutorial(Tutorial tutorial);
    List<Tutorial> getAllTutorials();
    Optional<Tutorial> getTutorialById(Long id);
    Tutorial updateTutorialById(Long id, Tutorial tutorialDetails);
    void deleteTutorialById(Long id);
}
