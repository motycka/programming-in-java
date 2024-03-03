package com.harbourspace.tracker.exercise;

import com.harbourspace.tracker.exercise.model.Exercise;
import com.harbourspace.tracker.exercise.model.NewExercise;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercises")
public class ExcerciseController {

    private final ExerciseService exerciseService;

    public ExcerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping
    public List<Exercise> getExercises() {
        return exerciseService.getExercises();
    }

    @GetMapping("/{id}")
    public Exercise getExercise(@PathVariable("id") Long id) {
        return exerciseService.getExerciseById(id);
    }

    @PostMapping
    public Exercise createExercise(@RequestBody NewExercise exercise) {
        return exerciseService.createExercise(exercise);
    }

    @PutMapping("/{id}")
    public Exercise updateExercise(
            @PathVariable("id") Long id,
            @RequestBody Exercise exercise
    ) {
        return exerciseService.updateExercise(exercise);
    }

    @DeleteMapping("/{id}")
    public void deleteExercise(@PathVariable("id") Long id) {
        exerciseService.deleteExercise(id);
    }

}
