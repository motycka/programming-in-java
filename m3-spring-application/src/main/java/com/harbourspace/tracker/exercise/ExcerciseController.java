package com.harbourspace.tracker.exercise;

import com.harbourspace.tracker.exercise.model.Exercise;
import com.harbourspace.tracker.exercise.model.NewExercise;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/exercise")
public class ExcerciseController {

    private final ExerciseService exerciseService;

    public ExcerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping
    ResponseEntity<List<Exercise>> getExercises() {
        return ResponseEntity.ok(exerciseService.getExercises());
    }


    @GetMapping("{id}")
    ResponseEntity<Exercise> getExerciseById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(exerciseService.getExerciseById(id));
    }

    @PostMapping
    ResponseEntity<Exercise> createExercise(@RequestBody NewExercise exercise) {
        return new ResponseEntity<>(exerciseService.createExercise(exercise), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    ResponseEntity<Exercise> updateExercise(
            @PathVariable("id") Long id,
            @RequestBody Exercise exercise
    ) {
        return ResponseEntity.ok(exerciseService.updateExercise(exercise.copyWithId(id)));
    }

    @DeleteMapping("{id}")
    ResponseEntity<Object> deleteExercise(@PathVariable("id") Long id) {
        exerciseService.deleteExercise(id);
        return ResponseEntity.ok().build();
    }
}
