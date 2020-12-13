package springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;



@SessionAttributes({"name","id"})


@Controller
@RequestMapping
//@SessionAttributes("name")
public class TodoController {

    @Autowired
    TodoService service;


    @RequestMapping(value ="/list-todos", method = RequestMethod.GET)
    public String showpage(ModelMap model){
         String user = (String) model.get("name");


        model.addAttribute("todos", service.retrieveTodos(user));
        return "list-todos";

    }


    @RequestMapping(value ="/add-todo", method = RequestMethod.GET)
    public String showtodopage(){
        return "todo";
    }

    @RequestMapping(value ="/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @RequestParam String desc){



        service.addTodo("Joy", desc, new Date(),false);

        model.clear();
        return "redirect:/list-todos";
    }


    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(ModelMap model, @RequestParam int id) {
        model.addAttribute("todo", service.retrieve(id));

        model.put("id", id);

        return "todo";
    }



    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String showUpdate(ModelMap model, @RequestParam String desc) {



        int us = (int) model.get("id");

        System.out.println(us);

        service.deleteTodo(us);

        service.addTodo1(us,"Joy",desc,new Date(),false);


        model.clear();
        return "redirect:/list-todos";

    }


    @RequestMapping(value ="/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(ModelMap model, @RequestParam int id){


        service.deleteTodo(id);

        model.clear();
        return "redirect:/list-todos";
    }


}
