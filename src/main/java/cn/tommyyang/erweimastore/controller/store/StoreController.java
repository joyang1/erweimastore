package cn.tommyyang.erweimastore.controller.store;

import cn.tommyyang.erweimastore.controller.BaseController;
import cn.tommyyang.erweimastore.model.Product;
import cn.tommyyang.erweimastore.model.Store;
import cn.tommyyang.erweimastore.service.IProductService;
import cn.tommyyang.erweimastore.service.IStoreService;
import cn.tommyyang.erweimastore.utils.JsonUtils;
import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;
import org.apache.commons.codec.net.QCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TommyYang on 2017/11/23.
 */
@Controller
@RequestMapping("store")
public class StoreController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(StoreController.class);

    @Autowired
    private IStoreService storeService;
    @Autowired
    private IProductService productService;

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
        if (storeService.delete(id)) {
            return "1";
        } else {
            return "0";
        }
    }

    @RequestMapping(value = "/getstoreinfo.do", method = RequestMethod.GET)
    @ResponseBody
    public void getStoreInfo(HttpServletRequest request, HttpServletResponse response) {
        List<Store> storeList = storeService.get();
        try {
            if (storeList != null) {
                this.writeResponseContent(response, JsonUtils.getStoreJson(storeList));
            }
        } catch (IOException e) {
            logger.error("get store info error:\n", e);
        }
    }

    @RequestMapping(value = "/storedisplay.do", method = RequestMethod.GET)
    public String storeDisplay(HttpServletRequest request, HttpServletResponse response) {
        return renderString(response, "storedisplay");
    }

    @RequestMapping(value = "/generateqrcode.do", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> storeGenerateQRCode(HttpServletRequest request, HttpServletResponse response,
                                                   @RequestParam(value = "url") String url) {
        ByteArrayOutputStream out = QRCode.from(url).to(ImageType.PNG).stream();
        String base64Code = new BASE64Encoder().encode(out.toByteArray());
        return renderData(response, "data:image/jpg;base64," + base64Code);
    }

    @RequestMapping(value = "/goqrcode.do", method = RequestMethod.GET)
    public String storeQRCode(HttpServletRequest request, HttpServletResponse response) {
        return renderString(response, "storegenerateqrcode");
    }

    @RequestMapping(value = "/getStorePage.do", method = RequestMethod.GET)
    public ModelAndView getStorePage(HttpServletRequest request, HttpServletResponse response,
                                     @RequestParam(value = "storeid") Integer id) {
        List<Product> products = productService.get(id);
        Map<String, Object> map = new HashMap<String, Object>();
        for (Product product : products) {
            File file = new File(product.getPicturePath());
            product.setPicturePath(this.generateImgToBASE64String(file));
        }
        map.put("products", products);
        ModelAndView view = new ModelAndView("storedisplay", map);
        return view;
    }

    private String generateImgToBASE64String(File file) {
        //图片转化成base64字符串
        //将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try {
            in = new FileInputStream(file);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            logger.error("product img to base64 code error:\n", e);
        }
        //对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return "data:image/png;base64," + encoder.encode(data);//返回Base64编码过的字节数组字符串
    }

}
