package cn.tommyyang.erweimastore.controller.product;

import cn.tommyyang.erweimastore.controller.BaseController;
import cn.tommyyang.erweimastore.dao.IStoreDao;
import cn.tommyyang.erweimastore.model.Product;
import cn.tommyyang.erweimastore.model.Store;
import cn.tommyyang.erweimastore.service.IProductService;
import cn.tommyyang.erweimastore.service.IStoreService;
import cn.tommyyang.erweimastore.utils.Constants;
import cn.tommyyang.erweimastore.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by TommyYang on 2017/11/26.
 */
@Controller
@RequestMapping("product")
public class ProductController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private IProductService productService;
    @Autowired
    private IStoreService storeService;

    @RequestMapping(value = "/productmanage.do", method = RequestMethod.GET)
    public String storeManage(HttpServletRequest request, HttpServletResponse response) {
        return renderString(response, "productmanage");
    }

    @RequestMapping(value = "/productpost.do", method = RequestMethod.GET)
    public String storePost(HttpServletRequest request, HttpServletResponse response) {
        return renderString(response, "productpost");
    }

    @RequestMapping(value = "/addproduct.do", method = RequestMethod.POST)
    public String addStore(HttpServletRequest request, HttpServletResponse response,
                           @RequestParam(value = "name") String name,
                           @RequestParam(value = "price") float price,
                           @RequestParam(value = "percent") float percent,
                           @RequestParam(value = "storeid") Integer storeid,
                           @RequestParam(value = "productimg") MultipartFile productimg) {
        String tmpPath = System.getProperty("erweimastore.root") + Constants.IMG_PATH;
        String imgName = name + "_" + UUID.randomUUID().toString().replaceAll("-", "") + ".png";
        try {
            imgName = new String((imgName).getBytes("UTF-8"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("imgname to utf-8 code error");
        }
        try {
            File dir = new File(tmpPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            String filePath = tmpPath + "/" + imgName;
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            productimg.transferTo(file);
            productService.add(name, price, percent, filePath, storeid);
        } catch (Exception e) {
            logger.error("add product error:\n", e);
        }
        return renderString(response, "productmanage");
    }

    @RequestMapping(value = "/getproductinfo.do", method = RequestMethod.GET)
    @ResponseBody
    public void getProductInfo(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = productService.get();
        Map<Integer, Store> map = storeService.getMap();
        try {
            if (productList != null && map != null) {
                this.writeResponseContent(response, JsonUtils.getProductJson(productList, map));
            }
        } catch (IOException e) {
            logger.error("get store info error:\n", e);
        }
    }

    @RequestMapping(value = "/delproduct.do", method = RequestMethod.POST)
    @ResponseBody
    public String delProduct(HttpServletRequest request, HttpServletResponse response,
                             @RequestParam(value = "id") Integer id,
                             @RequestParam(value = "path") String path) {
        try {
            File file = new File(path);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            logger.error("delete product error:\n", e);
            return "0";
        }
        if (productService.delete(id)) {
            return "1";
        } else {
            return "0";
        }
    }

}
