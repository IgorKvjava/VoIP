package ua.kvelinskyi.spring.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import ua.kvelinskyi.dao.impl.UserDao;
import ua.kvelinskyi.entity.User;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes(types = User.class)
public class LoginServlet {
    @Autowired
    HttpSession httpSession;

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "/mainPageUser", method = RequestMethod.POST)
    public ModelAndView doMainPageUser(@RequestParam("login") String login,
                                       @RequestParam("password") String password
                                        ) {
        ModelAndView mod = new ModelAndView();
        User user= userDao.isExistUser(login, password);
        if (user!=null){
            mod.addObject("user", user);
            mod.setViewName("/user/mainUserPage");
        }else {
            mod.setViewName("index");
        }
        return mod;
    }

}
