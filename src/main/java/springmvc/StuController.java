package springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.sql.SQLException;

@Controller
@RequestMapping
@SessionAttributes("name")
public class StuController {


    //Gitgub Link: https://github.com/youcantbearme/300312120_RahulSahani_Final_Part_3.git

    StudentService service = new StudentService();

    public StuController() throws SQLException {
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String show() {
        return "list-todos";


    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handleUserLogin(ModelMap model, @RequestParam String name,
                                  @RequestParam String password) {

        return "list-todos";
    }






}
