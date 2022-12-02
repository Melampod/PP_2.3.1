package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;
import java.util.List;

@Controller
public class UserController {

    private  UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping("/showAllUsers")
    public String showAllUsers(Model model) {
        List<User> usersList = userService.getAllUsers();
        model.addAttribute("usersList", usersList);
        return "user-list";
    }

    @RequestMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-info";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/showAllUsers";

    }

    @RequestMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") Long id, Model model) {
        User user = userService.getUser(id);
        System.out.println("1"+user);
        model.addAttribute("user", user);
        System.out.println("2"+user);

        return "user-info";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "redirect:/showAllUsers";
    }
}

