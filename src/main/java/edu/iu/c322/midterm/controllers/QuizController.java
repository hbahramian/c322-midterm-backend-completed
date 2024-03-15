package edu.iu.c322.midterm.controllers;

import edu.iu.c322.midterm.model.Question;
import edu.iu.c322.midterm.model.Quiz;
import edu.iu.c322.midterm.repository.FileRepository;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/quizzes")
public class QuizController {

    private FileRepository fileRepository;

    public QuizController(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }


    @PostMapping
    public int add(@RequestBody Quiz quiz) {
        try {
            return fileRepository.add(quiz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public Quiz get(@PathVariable int id) {
        try {
            return fileRepository.getTheQuiz(id);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
