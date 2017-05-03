package com.demo.controller;

import com.jfinal.kit.PathKit;
import com.jfinal.upload.UploadFile;


/**
 * Created by xxx on 2017/5/3.
 */
public class FileController extends BaseController {
    public void uploadImage() {
        PathKit pathKit = new PathKit();
        String contextPath = PathKit.getWebRootPath();
        String now = getNYR();
        String path = "/" + now;
        UploadFile file = getFile("uploadFile", path);
        String fileName = file.getFileName();
        // 全路径
        //String filePath = contextPath + "\\upload" + path + "\\" + fileName;
        String fileUrl = "/upload" + path + "/" + fileName;
        renderText(fileUrl);
    }
}
