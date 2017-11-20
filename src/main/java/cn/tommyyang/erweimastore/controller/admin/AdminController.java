package cn.tommyyang.erweimastore.controller.admin;

import cn.tommyyang.erweimastore.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by TommyYang on 2017/11/20.
 */
@Controller
@RequestMapping("admin")
public class AdminController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(AdminController.class);

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response,
                     @RequestParam(value = "name") String name,
                     @RequestParam(value = "passwd") String passwd) {
        return renderString(response, "admin");
    }

    @RequestMapping(value = "/gologin.do", method = RequestMethod.GET)
    public String goLogin(HttpServletRequest request, HttpServletResponse response) {
        return renderString(response, "login");
    }
}
