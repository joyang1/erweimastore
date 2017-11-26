package cn.tommyyang.erweimastore.controller.product;

import cn.tommyyang.erweimastore.controller.BaseController;
import cn.tommyyang.erweimastore.model.Product;
import cn.tommyyang.erweimastore.service.IProductService;
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
import java.io.IOException;
import java.util.List;

/**
 * Created by TommyYang on 2017/11/26.
 */
@Controller
@RequestMapping("product")
public class ProductController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private IProductService productService;

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
                           @RequestParam(value = "storename") String storename,
                           @RequestParam(value = "productimg", required = false) MultipartFile productimg) {
        return renderString(response, "productmanage");
    }

    @RequestMapping(value = "/getproductinfo.do", method = RequestMethod.GET)
    @ResponseBody
    public void getStoreInfo(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = productService.get();
        try {
            if(productList != null){
                this.writeResponseContent(response, JsonUtils.getProductJson(productList));
            }
        } catch (IOException e) {
            logger.error("get store info error:\n",e);
        }
    }

}
