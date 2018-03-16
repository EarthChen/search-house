package com.earthchen.spring.boot.searchhouse.service.house;

import java.io.File;

import com.earthchen.spring.boot.searchhouse.ApplicationTests;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;

import static org.junit.Assert.*;

/**
 * @author: EarthChen
 * @date: 2018/03/13
 */
public class IQiNiuServiceTest extends ApplicationTests {

    @Autowired
    private IQiNiuService qiNiuService;

    @Test
    public void uploadFile() {
        String fileName = "/home/earthchen/study/spring/SpringBootProjects/search-house/tmp/test.png";
        File file = new File(fileName);

        assertTrue(file.exists());

        try {
            Response response = qiNiuService.uploadFile(file);
            Assert.assertTrue(response.isOK());
        } catch (QiniuException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void uploadFile1() {


    }

    @Test
    public void delete() {
        String key = "Fqeg4FntBd9_BtncRo2YdoX63YPy";
        try {
            Response response = qiNiuService.delete(key);
            Assert.assertTrue(response.isOK());
        } catch (QiniuException e) {
            e.printStackTrace();
        }
    }
}