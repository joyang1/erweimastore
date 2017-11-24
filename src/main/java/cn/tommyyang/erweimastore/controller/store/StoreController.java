package cn.tommyyang.erweimastore.controller.store;

import cn.tommyyang.erweimastore.controller.BaseController;
import cn.tommyyang.erweimastore.model.Store;
import cn.tommyyang.erweimastore.service.IStoreService;
import cn.tommyyang.erweimastore.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TommyYang on 2017/11/23.
 */
@Controller
@RequestMapping("store")
public class StoreController extends BaseController{

    private final static Logger logger = LoggerFactory.getLogger(StoreController.class);

    @Autowired
    private IStoreService storeService;

    @RequestMapping(value = "/storemanage.do", method = RequestMethod.GET)
    public String storeManage(HttpServletRequest request, HttpServletResponse response) {
        return renderString(response, "storemanage");
    }

    @RequestMapping(value = "/storepost.do", method = RequestMethod.GET)
    public String storePost(HttpServletRequest request, HttpServletResponse response) {
        return renderString(response, "storepost");
    }

    @RequestMapping(value = "/addstore.do", method = RequestMethod.POST)
    public String addStore(HttpServletRequest request, HttpServletResponse response,
                           @RequestParam(value = "name") String name) {
        storeService.add(name);
        return renderString(response, "storemanage");
    }

    @RequestMapping(value = "/delstore.do", method = RequestMethod.POST)
    @ResponseBody
    public String delStore(HttpServletRequest request, HttpServletResponse response,
                           @RequestParam(value = "id") Integer id) {
        if(storeService.delete(id)){
            return "1";
        }else {
            return "0";
        }
    }

    @RequestMapping(value = "/getstoreinfo.do", method = RequestMethod.GET)
    @ResponseBody
    public void getStoreInfo(HttpServletRequest request, HttpServletResponse response) {
        List<Store> storeList = storeService.get();
        try {
            if(storeList != null){
                this.writeResponseContent(response, JsonUtils.getStoreJson(storeList));
            }
        } catch (IOException e) {
            logger.error("get store info error:\n",e);
        }
    }

}
