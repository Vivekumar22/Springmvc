package springmvc;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpringController {
  
  @Autowired
  SpringDAO dao;
  @GetMapping("/trigger")
  @ResponseBody
  public String fun() {
    return "welcome";
  }

@GetMapping("/show")
public String fun2(Model m) {
  String s="xyz";
  List<Student> sl1=dao.findall();
  m.addAttribute("s1", s);
  m.addAttribute("List", sl1);
  return "show";
   
}
@GetMapping("/add")
public String fun3(Model m)
{
  m.addAttribute("command",new Student());
  return "add";
}

@PostMapping("/add")
public String fun4(@ModelAttribute("s") Student s)
{
  sl.add(s);
  dao.insert(s);
  return "redirect:/show";
}
@GetMapping("/update/{id}")
public String fun5(@PathVariable("id") int id,Model m) {
	Student s=dao.find(id);
	m.addAttribute("command", s);
	return "update";
}
@PostMapping("/update")
public String fun6(@ModelAttribute("s") Student s) {
	dao.update(s);
	return "redirect:/show";
}
@GetMapping("/delete/{id}")
public String fun7(@PathVariable("id") int id) {
	dao.delete(id);
	return "redirect:/show";
}
   static List<Student> sl;
  static {
    Student s1=new Student();
    s1.setId(1);
    s1.setName("Student 1");
    
    Student s2=new Student();
    s2.setId(2);
    s2.setName("Student 2");
    
    sl=new ArrayList<Student>();
    sl.add(s1);
    sl.add(s2);
    
  }

}