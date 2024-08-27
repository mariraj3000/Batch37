package com.tnsif.sm.CollegeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/colleges")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @GetMapping
    public List<College> getAllColleges() {
        return collegeService.findAll();
    }

    @GetMapping("/colleges/{id}")
    public ResponseEntity<College> getCollegeById(@PathVariable Long id) {
        Optional<College> college = collegeService.findById(id);
        return college.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/colleges")
    public College createCollege(@RequestBody College college) {
        return collegeService.save(college);
    }

    @PutMapping("/colleges/{id}")
    public ResponseEntity<College> updateCollege(@PathVariable Long id, @RequestBody College college) {
        if (!collegeService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        college.setId(id);
        return ResponseEntity.ok(collegeService.save(college));
    }

    @DeleteMapping("/colleges/{id}")
    public ResponseEntity<Void> deleteCollege(@PathVariable Long id) {
        if (!collegeService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        collegeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
