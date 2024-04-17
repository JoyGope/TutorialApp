package com.example.TutorialApp.service;

import com.example.TutorialApp.model.Tutorial;
import com.example.TutorialApp.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorialServiceImplement implements TutorialService{
    @Autowired
    private TutorialRepository tutorialRepository;

    @Override
    public Tutorial createTutorial(Tutorial tutorial) {
        return tutorialRepository.save(tutorial);
    }

    @Override
    public List<Tutorial> getAllTutorials() {
        return tutorialRepository.findAll();
    }

    @Override
    public Optional<Tutorial> getTutorialById(Long id) {
        return tutorialRepository.findById(id);
    }

    @Override
    public Tutorial updateTutorialById(Long id, Tutorial tutorialDetails) {
        Optional<Tutorial> tutorialOptional = tutorialRepository.findById(id);
        if (tutorialOptional.isPresent()) {
            Tutorial tutorial = tutorialOptional.get();
            tutorial.setTitle(tutorialDetails.getTitle());
            tutorial.setDescription(tutorialDetails.getDescription());
            tutorial.setPublishedStatus(tutorialDetails.getPublishedStatus());
            return tutorialRepository.save(tutorial);
        } else {
            throw new RuntimeException("Tutorial not found with id: " + id);
        }
    }

    @Override
    public void deleteTutorialById(Long id) {
        if (tutorialRepository.existsById(id)) {
            tutorialRepository.deleteById(id);
        } else {
            throw new RuntimeException("Tutorial not found with id: " + id);
        }
    }
}

