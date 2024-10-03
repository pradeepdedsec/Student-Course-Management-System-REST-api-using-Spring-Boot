package com.sample.api.service;

import java.util.Optional;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.api.entity.Course;
import com.sample.api.entity.CourseMaterial;
import com.sample.api.entity.Guardian;
import com.sample.api.entity.Student;
import com.sample.api.entity.Teacher;
import com.sample.api.exception.StudentNotFoundException;
import com.sample.api.repo.CourseMaterialRepository;
import com.sample.api.repo.CourseRepository;
import com.sample.api.repo.GuardianRepository;
import com.sample.api.repo.StudentRepository;
import com.sample.api.repo.TeacherRepository;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Autowired
	CourseRepository courseRepository;

    @Autowired
    CourseService courseService;

	@Autowired
    CourseMaterialRepository courseMaterialRepository;


	@Autowired
    TeacherRepository teacherRepository;

    @Autowired
    TeacherService teacherService;

    @Autowired
    GuardianRepository guardianRepository;

    @Override
    public Student getStudent(Long id) {
        return unwrapStudent(studentRepository.findById(id), id);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) { 
        unwrapStudent(studentRepository.findById(id), id);     
        studentRepository.deleteById(id);  
    }

    @SuppressWarnings("unchecked")
    @Override
    public Set<Student> getStudents() {
        return (Set<Student>) studentRepository.findAll();
    }

    @Override
    public Set<Course> getEnrolledCourses(Long id) {
        Student student = getStudent(id);
        return student.getCourses();
    }

    static Student unwrapStudent(Optional<Student> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new StudentNotFoundException(id);
    }


    @Override
    public void insertData(){
            
        Course course1 = new Course(null, "Introduction to Java", 3, null,null);
        Course course2 = new Course(null, "Database Systems", 4, null,null);
        Course course3 = new Course(null, "Web Development", 3, null,null);
        Course course4 = new Course(null, "Algorithms", 4, null,null);
        Course course5 = new Course(null, "Data Structures", 3, null,null);
        courseRepository.saveAll(List.of(course1, course2, course3, course4, course5));

        CourseMaterial material1 = new CourseMaterial(null, "http://example.com/java-material", course1);
        CourseMaterial material2 = new CourseMaterial(null, "http://example.com/database-material", course2);
        CourseMaterial material3 = new CourseMaterial(null, "http://example.com/webdev-material", course3);
        CourseMaterial material4 = new CourseMaterial(null, "http://example.com/algorithms-material", course4);
        CourseMaterial material5 = new CourseMaterial(null, "http://example.com/data-structures-material", course5);
        courseMaterialRepository.saveAll(List.of(material1, material2, material3, material4, material5));


        Guardian guardian1 = new Guardian(null,"John Doe", "john.doe@gmail.com", "1234567890");
        Guardian guardian2 = new Guardian(null,"Jane Roe", "jane.roe@gmail.com", "0987654321");
        Guardian guardian3 = new Guardian(null,"Emily Smith", "emily.smith@gmail.com", "5551234567");
        Guardian guardian4 = new Guardian(null,"Michael Johnson", "michael.johnson@gmail.com", "5559876543");
        Guardian guardian5 = new Guardian(null,"Laura Davis", "laura.davis@gmail.com", "5556789012");
        guardianRepository.saveAll(List.of(guardian1,guardian2,guardian3,guardian4,guardian5));

        Student student1 = new Student(null, "John", "Doe", "john.doe@example.com", Set.of(course1,course2,course3),guardian5);
        Student student2 = new Student(null, "Alice", "Smith", "alice.smith@example.com", Set.of(course1,course2,course3),guardian4);
        Student student3 = new Student(null, "Chris", "Wilson", "chris.wilson@example.com", Set.of(course1,course2,course3),guardian3);
        Student student4 = new Student(null, "Natalie", "Taylor", "natalie.taylor@example.com", Set.of(course1,course2,course3),guardian2);
        Student student5 = new Student(null, "David", "Anderson", "david.anderson@example.com", Set.of(course1,course2,course3),guardian1);
        studentRepository.saveAll(List.of(student1, student2, student3, student4, student5));
       

        Teacher teacher1 = new Teacher(null, "Emily", "Johnson", course1);
        Teacher teacher2 = new Teacher(null, "Michael", "Brown", course2);
        Teacher teacher3 = new Teacher(null, "Sophia", "Martinez", course3);
        Teacher teacher4 = new Teacher(null, "Daniel", "Garcia", course4);
        Teacher teacher5 = new Teacher(null, "Olivia", "Harris", course5);
        teacherRepository.saveAll(List.of(teacher1, teacher2, teacher3, teacher4, teacher5));

    }

    @Override
    public Set<Student> getStudentsByCourse(Course course) {
        return studentRepository.findByCoursesIn(List.of(course));

    }

    @Override
    public Set<Student> getStudentsByTeacher(Teacher teacher) {
        Course course  = teacher.getCourse();
        return studentRepository.findByCoursesIn(List.of(course));
    }

    @Override
    public Set<Student> getStudentsByTeacherList(List<Teacher> teachers) {
        List<Course> courses=new ArrayList<Course>();
        for (Teacher teacher : teachers)
            courses.add(teacher.getCourse());
        return studentRepository.findByCoursesIn(courses);
    }

    @Override
    public Set<Student> getStudentsByGaurdian(Guardian guardian) {
        return studentRepository.findByGuardian(guardian);
    }

    @Override
    public Set<Student> getStudentsByGaurdianName(String guardian_name) {
        return studentRepository.findByGuardianName("pradeep");
    }

    @Override
    public Set<Student> getStudentsByCourseList(List<Course> courses) {
        return studentRepository.findByCoursesIn(courses);
    }

    @Override
    public Set<Student> getStudentsByGaurdianList(List<Guardian> guardians) {
        return studentRepository.findByGuardianIn(guardians);
    }

    

    @Override
    public Set<Student> getStudentsByCourseId(Long id) {
        Course course=CourseService.unwrapCourse(courseRepository.findById(id),id);

        return studentRepository.findByCoursesIn(List.of(course));
    }

    @Override
    public Set<Student> getStudentsByTeacherId(Long id) {
        Teacher teacher = TeacherService.unwrapTeacher(teacherRepository.findById(id), id);
        
        return studentRepository.findByCoursesIn(List.of(teacher.getCourse()));
    }

    @Override
    public Set<Student> getStudentsByTeacherIdList(List<Long> idList) {
        Set<Student> students=new HashSet<>();
        Set<Course> courses=new HashSet<>();

        for (Long id : idList)
            courses.add(courseService.getCourseByTeacherId(id));
            
        for (Course course : courses)
            students.addAll(getStudentsByCourse(course));
        return students;
    }
    
}
