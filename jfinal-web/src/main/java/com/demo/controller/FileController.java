package com.demo.controller;

import com.google.gson.Gson;
import com.jfinal.kit.PathKit;
import com.jfinal.upload.UploadFile;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

/**
 * Created by xxx on 2017/5/3.
 */
public class FileController extends BaseController {

    private String qiniuUrl;
    public static final String ACCESSKEY = "nfUWNGPDk_c5O14fzPK6tLOWcdJfQF3wG0RmY2CG";
    public static final String SECRETKEY = "6qFd1ucIiguUGXBhqHxYWCH1NJed9Tk09dhLYEBb";
    public static final String BUCKET = "jingdongjiaju";
    public static final String QINIUURL = "http://opb1qpf4g.bkt.clouddn.com/";

    public void uploadImage() {
        String contextPath = PathKit.getWebRootPath();
        String path = "/" + getNYR();
        UploadFile file = getFile("uploadFile", path);
        String fileName = file.getFileName();
        // 全路径
        String filePath = contextPath + "\\upload" + path + "\\" + fileName;
        //构造一个带指定Zone对象的配置类 华南
        Configuration cfg = new Configuration(Zone.zone2());
        UploadManager uploadManager = new UploadManager(cfg);
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = null;
        Auth auth = Auth.create(ACCESSKEY, SECRETKEY);
        String upToken = auth.uploadToken(BUCKET);
        try {
            Response response = uploadManager.put(filePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            // 返回的图片url http://opb1qpf4g.bkt.clouddn.com/FqAwys5nEsXlnETx9ZKfEV9Bbnix
            qiniuUrl = QINIUURL + putRet.hash;
            System.out.println(putRet);
        } catch (QiniuException e) {
            e.printStackTrace();
        }

        // 返回的图片 url
        String fileUrl = qiniuUrl;
        renderText(fileUrl);
    }
}
