package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService service) {
        this.userService = service;
    }

    @GetMapping
    public String printUsers(ModelMap modelMap) {
        List<User> users = userService.getUsers();

        modelMap.addAttribute("users", users);

        return "index";
    }

    @GetMapping("/{id}")
    public String printUserProfile(@PathVariable("id") long id, ModelMap modelMap) {
        modelMap.addAttribute("user", userService.getUserById(id));

        return "profile";
    }

    @GetMapping("/create")
    public String printCreateForm(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        modelMap.addAttribute("isCreate", true);

        return "create";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") User user, ModelMap modelMap) {
        userService.createUser(user);

        modelMap.addAttribute("isCreate", true);
        modelMap.addAttribute("user", new User());

        return "create";
    }

    @GetMapping("/edit")
    public String printEditForm(@RequestParam(value = "id", required = false) Long id, ModelMap modelMap) {
        String redirectNotExistsTo = "/users";
        User user = userService.getUserById(id);

        if (user == null) return "redirect:" + redirectNotExistsTo;

        modelMap.addAttribute("isCreate", false);
        modelMap.addAttribute("user", user);

        return "create";
    }

    @PostMapping("/edit")
    public String editUser(@RequestParam("id") Long id, @ModelAttribute("user") User user) {
        userService.updateUser(user);

        return "redirect:/users/" + id;
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam(value = "id") Long id) {
        userService.deleteUser(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllUsers() {
        userService.deleteUsers();
    }
}
