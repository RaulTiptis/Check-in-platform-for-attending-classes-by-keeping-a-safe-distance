package ro.euvt.tp.classroomDistancing.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ro.euvt.tp.classroomDistancing.model.Classroom;
import ro.euvt.tp.classroomDistancing.service.ClassroomService;
import ro.euvt.tp.classroomDistancing.service.SubjectService;
import ro.euvt.tp.classroomDistancing.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/Classroom")
public class ClassroomController {

  private final ClassroomService classroomService;
  private final SubjectService subjectService;
  private final UserService userService;

  public ClassroomController(ClassroomService classroomService, SubjectService subjectService, UserService userService){
    this.classroomService = classroomService;
    this.subjectService = subjectService;
    this.userService = userService;
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

  @PostMapping("/addd")
  public ResponseEntity<Classroom> adddClassroom(@RequestBody List<String> list){
    Classroom classroom = new Classroom();
    classroom.setSubject(subjectService.findSubjectById(Integer.parseInt(list.get(4))));
    classroom.setTeacher(userService.findUserById(Integer.parseInt(list.get(3))));
    classroom.setName(list.get(0));
    classroom.setLocation(list.get(1));
    classroom.setCapacity(Integer.parseInt(list.get(2)));
    Classroom newClassroom = classroomService.addClassroom(classroom);
    return new ResponseEntity<>(newClassroom, HttpStatus.CREATED);
  }

  @PutMapping("/update")
  public ResponseEntity<Classroom> updateClassroom(@RequestBody List<String> list){
    Classroom classroom = new Classroom();
    classroom.setSubject(subjectService.findSubjectById(Integer.parseInt(list.get(4))));
    classroom.setTeacher(userService.findUserById(Integer.parseInt(list.get(3))));
    classroom.setId(Integer.parseInt(list.get(5)));
    classroom.setName(list.get(0));
    classroom.setLocation(list.get(1));
    classroom.setCapacity(Integer.parseInt(list.get(2)));
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
