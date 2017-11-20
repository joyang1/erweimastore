package cn.tommyyang.erweimastore.controller;

import com.google.gson.Gson;
import org.apache.http.entity.ContentType;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by TommyYang on 2017/10/22.
 */

public class BaseController {

    protected Map<String, Object> renderData(HttpServletResponse response, Object result) {
        response.setContentType("application/json;charset=UTF-8");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("message", "success");
        map.put("ts", System.currentTimeMillis());
        if (result != null)
            map.put("data", result);
        return map;
    }

    /**
     *
     response.setContentType("application/json");
     response.getWriter().write(map);
     response.getWriter().flush();
     response.getWriter().close();
     */


    protected Map<String, Object> renderErrorData(HttpServletResponse response, Integer errorCode, String message) {
        response.setContentType("application/json;charset=UTF-8");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", errorCode);
        map.put("ts", System.currentTimeMillis());
        map.put("message", message);
        return map;
    }

    protected String renderString(HttpServletResponse response, String message) {
        response.setContentType("text/html;charset=UTF-8");
        return message;
    }

    protected Map<String, Object> renderErrorData(HttpServletResponse response, Integer errorCode, String message, String condition) {
        response.setContentType("application/json;charset=UTF-8");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", errorCode);
        map.put("ts", System.currentTimeMillis());
        map.put("message", message);
        map.put("condition",condition);
        return map;
    }

    protected void writeResponseContent(HttpServletResponse response, String responseContent) throws IOException {
        //返回数据
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(responseContent);
        response.getWriter().flush();
        response.getWriter().close();
    }


    protected void download(HttpServletResponse response, File file) throws IOException {
        //返回数据
        response.setCharacterEncoding("gbk");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;filename=" + file.getName());
        response.addHeader("Content-Length", String.valueOf(file.length()));
        response.setContentType(ContentType.APPLICATION_OCTET_STREAM.getMimeType());
        FileInputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = response.getOutputStream();
        byte[] bytes = new byte[2048];
        int length;
        while ((length = inputStream.read(bytes)) > 0) {
            outputStream.write(bytes, 0, length);
        }
        outputStream.close();
        inputStream.close();
    }


    protected void writeErrorResponseContent(HttpServletRequest request, HttpServletResponse response, Integer errorCode, String errorMsg)
            throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        Gson gson = new Gson();
        map.put("code", errorCode);
        map.put("ts", System.currentTimeMillis());
        map.put("message", errorMsg == null ? "":errorMsg);
        String callback = request.getParameter("callback");
        String responseContent = null;
        if(!StringUtils.isEmpty(callback)){
            responseContent = String.format("%s(%s)", callback, gson.toJson(map));
        }else{
            responseContent = gson.toJson(map);
        }
        writeResponseContent(response, responseContent);

    }

    protected void writeErrorResponseContent(HttpServletRequest request, HttpServletResponse response, Integer errorCode, String errorMsg, String condition)
            throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        Gson gson = new Gson();
        map.put("code", errorCode);
        map.put("ts", System.currentTimeMillis());
        map.put("message", errorMsg == null ? "":errorMsg);
        map.put("condition", errorMsg == null ? "":condition);
        String callback = request.getParameter("callback");
        String responseContent = null;
        if(!StringUtils.isEmpty(callback)){
            responseContent = String.format("%s(%s)", callback, gson.toJson(map));
        }else{
            responseContent = gson.toJson(map);
        }
        writeResponseContent(response, responseContent);

    }

}

