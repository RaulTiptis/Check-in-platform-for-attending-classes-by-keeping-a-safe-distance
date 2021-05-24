package ro.euvt.tp.classroomDistancing.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ro.euvt.tp.classroomDistancing.model.Classroom;
import ro.euvt.tp.classroomDistancing.service.ClassroomService;

import java.util.List;

@RestController
@RequestMapping("/Classroom")
public class ClassroomController {

  private final ClassroomService classroomService;

  public ClassroomController(ClassroomService classroomService){
    this.classroomService = classroomService;
  }

  @GetMapping("/all")
  public ResponseEntity<List<Classroom>> getAllClassrooms(){
    List<Classroom> classrooms = classroomService.findAllClassrooms();
    return new ResponseEntity<>(classrooms, HttpStatus.OK);
  }

  @GetMapping("/find/{id}")
  public ResponseEntity<Classroom> getClassroomById(@PathVariable("id") Integer id){
    Classroom classroom = classroomService.findClassroomById(id);
    return new ResponseEntity<>(classroom, HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<Classroom> addClassroom(@RequestBody Classroom classroom){
    Classroom newClassroom = classroomService.addClassroom(classroom);
    return new ResponseEntity<>(newClassroom, HttpStatus.CREATED);
  }

  @PutMapping("/update")
  public ResponseEntity<Classroom> updateClassroom(@RequestBody Classroom classroom){
    Classroom updateClassroom = classroomService.updateClassroom(classroom);
    return new ResponseEntity<>(updateClassroom, HttpStatus.OK);
  }

  @Transactional
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Classroom> deleteClassroom(@PathVariable("id") Integer id){
    classroomService.deleteClassroom(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
