package com.earthchen.spring.boot.searchhouse.web.dto;

/**
 * 七牛云的结果集
 *
 * @author: EarthChen
 * @date: 2018/03/13
 */
public final class QiNiuPutRet {

    public String key;
    public String hash;
    public String bucket;
    public int width;
    public int height;

    @Override
    public String toString() {
        return "QiNiuPutRet{" +
                "key='" + key + '\'' +
                ", hash='" + hash + '\'' +
                ", bucket='" + bucket + '\'' +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
