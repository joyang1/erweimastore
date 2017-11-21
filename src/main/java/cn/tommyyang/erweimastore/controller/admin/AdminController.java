package cn.tommyyang.erweimastore.controller.admin;

import cn.tommyyang.erweimastore.controller.BaseController;
import cn.tommyyang.erweimastore.model.Admin;
import cn.tommyyang.erweimastore.service.IAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by TommyYang on 2017/11/20.
 */
@Controller
@RequestMapping("admin")
public class AdminController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private IAdminService adminService;

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response,
                     @RequestParam(value = "name", required = false) String name,
                     @RequestParam(value = "passwd", required = false) String passwd) {
        HttpSession session = request.getSession();
        String existName = "";
        if(session != null && session.getAttribute("name") != null){
            existName = session.getAttribute("name").toString();
        }

        if(existName.equals(name)){
            return renderString(response, "admin");
        }else {
            Admin admin = adminService.checkAdmin(name, passwd);
            if(admin != null){
                return renderString(response, "admin");
            } else{
                return "error";
            }
        }

    }

    @RequestMapping(value = "/gologin.do", method = RequestMethod.GET)
    public String goLogin(HttpServletRequest request, HttpServletResponse response) {
        return renderString(response, "login");
    }
}
