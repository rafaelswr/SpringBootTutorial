package com.example.Services;

import com.example.Models.Student;
import com.example.Repositories.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student){
        return studentRepository.save((student));
    }

    public void addNewStudent(Student student) {
        if(studentRepository.findStudentByEmail(student.getEmail()).isPresent()){
            throw new IllegalStateException("email taken");
        }else{
            studentRepository.save(student);
        }
    }

    public void deleteStudent(Long studentID){
        Optional<Student> s = studentRepository.findById(studentID);
        if(s.isPresent()){
            studentRepository.deleteById(studentID);
        }else{
            throw new IllegalStateException("user not found");
        }
    }

    public Optional<Student> getStudentById(Long studentId) {
        Optional<Student> s = studentRepository.findById(studentId);
        if(s.isPresent()){
            return s;
        }else{
            throw  new IllegalStateException("Student not found");
        }
    }

    @Transactional
    public void updateStudent(Long studentId, Student studentUpdated) {
        Student s = studentRepository.findById(studentId).orElseThrow(()->new IllegalStateException("Id Not found"));
        if(studentUpdated.getName()!=null && studentUpdated.getName().length()>0 && !Objects.equals(s.getName(), studentUpdated.getName())){
            s.setName(studentUpdated.getName());
        }
        if(studentUpdated.getEmail()!=null && studentUpdated.getEmail().length()>0 &&  !Objects.equals(s.getEmail(), studentUpdated.getEmail())) {
            if(studentRepository.findStudentByEmail(studentUpdated.getEmail()).isEmpty()){
                s.setEmail(studentUpdated.getEmail());
            }
        }


    }
}
