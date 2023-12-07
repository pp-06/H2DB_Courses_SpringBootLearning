package com.courses.h2dbcourses.Service;

import com.courses.h2dbcourses.Entity.Learners;
import com.courses.h2dbcourses.Repository.LearnersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LearnerService {
    @Autowired
    LearnersRepository learnersRepository;

    //Get all Learners
    public List<Learners> getAllLearners(){
        return learnersRepository.findAll();
    }

    //Get Learner by Id
    public Learners getLearnerById(int id){
        return learnersRepository.findById(id).get();
    }

    //Create User
    public Learners createLearner(Learners learner){
        return learnersRepository.save(learner);
    }
    //Remove User
    public void removeLearnerById(int id){
        Optional<Learners> tempLearner= learnersRepository.findById(id);
        if (tempLearner.isEmpty()){
            throw new RuntimeException("Learner id"+id+"doesn't exist!");
        }
        learnersRepository.deleteById(id);
    }
    //Remove all Learners
    public void removeAllLearners(){
        learnersRepository.deleteAll();
    }
    //Get Count
    public long getCount(){
        return learnersRepository.count();
    }

    //Check Whether Learner Exist By Id
    public boolean learnerExistenceById(int id){

        return learnersRepository.existsById(id);
    }

}
