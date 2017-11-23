package cn.tommyyang.erweimastore.controller.store;

import cn.tommyyang.erweimastore.controller.BaseController;
import cn.tommyyang.erweimastore.model.Store;
import cn.tommyyang.erweimastore.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/storemanage.do", method = RequestMethod.GET)
    public String storeManage(HttpServletRequest request, HttpServletResponse response) {
        return renderString(response, "storemanage");
    }

    @RequestMapping(value = "/storepost.do", method = RequestMethod.GET)
    public String storePost(HttpServletRequest request, HttpServletResponse response) {
        return renderString(response, "storepost");
    }

    @RequestMapping(value = "/getstoreinfo.do", method = RequestMethod.GET)
    @ResponseBody
    public void getStoreInfo(HttpServletRequest request, HttpServletResponse response) {
        List<Store> storeList = new ArrayList<Store>();
        Store store1 = new Store(1, "测试店铺一", "http://test.com/dianpu1", "http://test.com/qrcode1");
        Store store2 = new Store(2, "测试店铺一", "http://test.com/dianpu2", "http://test.com/qrcode2");
        Store store3 = new Store(3, "测试店铺一", "http://test.com/dianpu3", "http://test.com/qrcode3");
        storeList.add(store1);
        storeList.add(store2);
        storeList.add(store3);
        try {
            this.writeResponseContent(response, JsonUtils.getStoreJson(storeList));
        } catch (IOException e) {
            logger.error("get store info error:\n",e);
        }
    }

}
