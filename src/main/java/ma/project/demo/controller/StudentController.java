package ma.project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ma.project.demo.entity.Student;
import ma.project.demo.repository.StudentRepository;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/students") // Ajoutez le "/" avant "students"
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/save")
    public void save(@RequestBody Student student) {
        studentRepository.save(student);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(required = true) int id) { // Utilisez le type int au lieu de String pour id
        Student s = studentRepository.findById(id);
        if (s != null) {
            studentRepository.delete(s);
        }
    }

    @GetMapping("/all")
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @GetMapping(value = "/count")
    public long countStudent() {
        return studentRepository.count();
    }

    @GetMapping(value = "/byYear")
    public Collection<?> findByYear() {
        return studentRepository.findNbrStudentByYear();
    }
}
