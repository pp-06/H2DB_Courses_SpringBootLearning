package com.courses.h2dbcourses.Controller;

import com.courses.h2dbcourses.Entity.Learners;
import com.courses.h2dbcourses.Service.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/learner")
public class LearnerController {
    @Autowired
    LearnerService learnerService;

    @GetMapping("/getAll")
    public List<Learners> getAllLearners(){
        return learnerService.getAllLearners();
    }
    @GetMapping("/{id}")
    public Learners getLearnerById(@PathVariable int id){
        return learnerService.getLearnerById(id);
    }

    @PostMapping("/add")
    public Learners addLearner(@RequestBody Learners learner){
        return learnerService.createLearner(learner);
    }

    @GetMapping("/del/{id}")
    public void removeLearnerById(@PathVariable int id){
        learnerService.removeLearnerById(id);
    }

    @GetMapping("/delAll")
    public void removeAllLearners(){
        learnerService.removeAllLearners();
    }
    @GetMapping("/count")
    public long getCount(){
        return learnerService.getCount();
    }

    @GetMapping("/existById/{id}")
    public boolean learnerExistenceById(@PathVariable int id){
        return learnerService.learnerExistenceById(id);
    }

}
