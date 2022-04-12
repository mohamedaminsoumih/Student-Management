package ma.enset.studentmanagement.web;

import lombok.AllArgsConstructor;
import ma.enset.studentmanagement.entities.Student;
import ma.enset.studentmanagement.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class StudentController {
    private StudentRepository studentRepository;

    @GetMapping(path = "/index")
    public String students(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "size", defaultValue = "3") int size,
                           @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Page<Student> studentPage = studentRepository.findAll(PageRequest.of(page, size));
        model.addAttribute("studentList", studentPage.getContent());
        model.addAttribute("pages", new int[studentPage.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "students";
    }
    @GetMapping("/delete")
    public String delete(Long id, String keyword, int page){
        studentRepository.deleteById(id);
        return "redirect:/index?page="+ page + "&keyword=" + keyword;

    }

    @GetMapping("/")
    public String home(){
        return "Redirect:/index";

    }

    @GetMapping("students")
    @ResponseBody
    public List<Student> studentList(){
        return studentRepository.findAll();
    }


}
