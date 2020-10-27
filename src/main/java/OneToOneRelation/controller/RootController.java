package OneToOneRelation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import OneToOneRelation.entity.Instructor;
import OneToOneRelation.entity.InstructorDetail;
import OneToOneRelation.repository.InstructorDetailRepository;
import OneToOneRelation.repository.InstructorRepository;

import java.util.LinkedHashMap;

@Controller
public class RootController {
    InstructorRepository instructorRepository;
    InstructorDetailRepository instructorDetailRepository;

    public RootController(InstructorRepository instructorRepository, InstructorDetailRepository instructorDetailRepository) {
        this.instructorRepository = instructorRepository;
        this.instructorDetailRepository = instructorDetailRepository;
    }

    @GetMapping("/instructorDetails")
    public ResponseEntity<InstructorDetail> getDetailsHandler(@RequestParam Long id){
        return new ResponseEntity<>(instructorDetailRepository.findById(id).get(),HttpStatus.OK);
    }

    @DeleteMapping("/instructorDetails")
    public ResponseEntity<Long> deleteDetailsHandler(@RequestParam Long id){
        instructorDetailRepository.deleteById(id);
        return new ResponseEntity<>(id,HttpStatus.OK);
    }

    @GetMapping("/instructor")
    public ResponseEntity<Instructor> getHandler(@RequestParam Long id){
        return new ResponseEntity<>(instructorRepository.findById(id).get(),HttpStatus.OK);
    }

    @PostMapping("/instructor")
    public ResponseEntity<Instructor> postHandler(@RequestBody LinkedHashMap requestBody){
        Instructor instructor = new Instructor();
        instructor.setName(requestBody.get("name").toString());
        instructor.setLastname(requestBody.get("lastname").toString());
        instructor.setInstructorDetail(new InstructorDetail(requestBody.get("hobby").toString(),instructor));
        instructorRepository.save(instructor);
        return new ResponseEntity<>(instructor,HttpStatus.OK);
    }

    @DeleteMapping("/instructor")
    public ResponseEntity<Long> deleteHandler(@RequestParam Long id){
        instructorRepository.deleteById(id);
        return new ResponseEntity<>(id,HttpStatus.OK);
    }
}
