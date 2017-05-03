package com.demo.controller;

import com.jfinal.kit.PathKit;
import com.jfinal.upload.UploadFile;

import java.util.Calendar;


/**
 * Created by xxx on 2017/5/3.
 */
public class FileController extends BaseController {
    public void uploadImage() {
        PathKit pathKit = new PathKit();
        String contextPath = pathKit.getWebRootPath();
        String path = "/upload/" + Calendar.YEAR + "/" + Calendar.MONTH + 1 + "/" + Calendar.DAY_OF_MONTH + "/";
        System.out.println(path);
        String pathUrl = contextPath + path;
        UploadFile file = getFile("uploadImage");
    }
}
