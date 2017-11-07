package ua.kvelinskyi.spring.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.kvelinskyi.dao.impl.UserDao;
import ua.kvelinskyi.entity.User;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@SessionAttributes(types = User.class)
public class LoginServlet {

    @Autowired
    HttpSession httpSession;

    @Autowired
    FormValidator formValidator;

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "mainPageUser", method = RequestMethod.POST)
    public ModelAndView doMainPageUser(@RequestParam("login") String login,
                                       @RequestParam("password") String password
                                        ) {
        ModelAndView mod = new ModelAndView();
        userDao.LOGGER.info("LoginServlet , RequestMapping - mainPageUser");
        User user= userDao.isExistUser(login, password);
        if (user!=null){
            mod.addObject("user", user);
            if(userDao.isExistAdmin("admin")){
                List<User> listAllUsers = userDao.getAll();
                mod.addObject("listAllUsers", listAllUsers);
                mod.setViewName("/admin/usersEditData");
            }else {
                mod.setViewName("/user/mainUserPage");
            }
        }else {
            mod.setViewName("index");
        }
        return mod;
    }

    @RequestMapping(value = "registrationPage", method = RequestMethod.GET)
    public String manageRegistrationPage(Model model){
        User user = new User();
        model.addAttribute("registeredUser", user);
        return "registration";
    }

    @RequestMapping(value = "userRegistration", method = RequestMethod.POST)
    public ModelAndView doRegistration(
            //@ModelAttribute : it is the same modelAttribute as in jsp 	// (registration.jsp)
            // data from the form should be moved to User user directly
            // so names of inputs should be the same as fields in User class
            @ModelAttribute("registeredUser")
            // to be validated by Validator
            @Validated
                    User user
            // results of form validation
            , BindingResult result) {
        ModelAndView mod = new ModelAndView();
        if (result.hasErrors()) {
            mod.setViewName("registration");
        } else {

            if (userDao.isExistUserLogin(user.getLogin())) {
                user.setLogin("");
                mod.setViewName("registration");
            } else {
                user.setRole("user");
                userDao.create(user);
                mod.addObject("user", user);
                mod.setViewName("/user/userEditDataPage");
            }
        }
        return mod;
    }
    @InitBinder
    protected void initValidator(WebDataBinder binder) {
        // bind validator to controller
        binder.setValidator(this.formValidator); }



    @RequestMapping(value = "userUpdateData", method = RequestMethod.POST)
    public ModelAndView doUserEditData(@RequestParam("password") String password,
                                       @RequestParam("userName") String userName,
            @Validated
                    User user)
    {
        ModelAndView mod = new ModelAndView();
        user.setPassword(password);
        user.setUserName(userName);
        user = userDao.update(user);
        mod.addObject("user", user);
        mod.setViewName("/user/userEditDataPage");
        return mod;
    }
    @RequestMapping(value = "editUserDataPage", method = RequestMethod.POST)
    public ModelAndView doUserEditDataPage(
                                       @Validated
                                               User user)
    {
        ModelAndView mod = new ModelAndView();
        mod.addObject("user", user);
        mod.setViewName("/user/userEditDataPage");
        return mod;
    }
}
