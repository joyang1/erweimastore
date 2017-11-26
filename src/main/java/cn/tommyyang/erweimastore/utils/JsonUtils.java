package cn.tommyyang.erweimastore.utils;

import cn.tommyyang.erweimastore.model.Product;
import cn.tommyyang.erweimastore.model.Store;

import java.util.List;

/**
 * Created by TommyYang on 2017/11/23.
 */
public class JsonUtils {
    /*
     * 获得店铺信息的json数据
     */
    public static String getStoreJson(List<Store> list) {
        String json = "[";
        for (Store store : list) {
            json += "{\"sid\":\"" + store.getId() + "\",\"sname\":\"" + store.getName() + "\",\"surl\":\""
                    + store.getUrl() + "\",\"scode\":\""
                    + store.getQrCodePath() + "\"},";
        }
        json = json.substring(0, json.length() - 1);
        json += "]";
        return json;
    }

    /*
     * 获得商品信息的json数据
     */
    public static String getProductJson(List<Product> list) {
        String json = "[";
        for (Product product : list) {
            json += "{\"pid\":\"" + product.getId() + "\",\"pname\":\"" + product.getName() + "\",\"purl\":\""
                    + product.getPicturePath() + "\",\"pprice\":\"" + product.getPrice() + "\"" +
                    ",\"ppercent\":\"" + product.getPercent() + "\",\"pstorename\":\"" + product.getStoreName() + "\"},";
        }
        json = json.substring(0, json.length() - 1);
        json += "]";
        return json;
    }

    /**
     * JSON字符串特殊字符处理，比如：“\A1;1300”
     * @param s
     * @return String
     */
    public static String stringtoJson(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            switch (c){
//             case '\"':
//                 sb.append("\\\"");
//                 break;
                case '"':
                    sb.append("'");break;
//             case '\\':
//                 sb.append("\\\\");
//                 break;
//             case '/':
//                 sb.append("\\/");
//                 break;
//             case '\b':
//                 sb.append("\\b");
//                 break;
//             case '\f':
//                 sb.append("\\f");
//                 break;
//             case '\n':
//                 sb.append("\\n");
//                 break;
//             case '\r':
//                 sb.append("\\r");
//                 break;
//             case '\t':
//                 sb.append("\\t");
//                 break;
                default:
                    sb.append(c);
            }
        }
        return sb.toString();
    }

}
