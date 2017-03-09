package com.example.administrator.seaydemo.Image;

/**
 * Created by Administrator on 2017/3/7.
 */

public class API {

    public static final String Host = "http://tnfs.tngou.net/img";

    //public static final String Host ="http://tnfs.tngou.net/image";

    public static final String leibiao = "http://www.tngou.net/tnfs/api/classify";

    //获取列表标题
    public static String getImage_Url(int id,int page) {

        return "http://www.tngou.net/tnfs/api/list?id="+id+"&page="+page;
    }
    //获取某个id下面所有图
    public static final String Image_List = "http://www.tngou.net/tnfs/api/show?id=";



}
