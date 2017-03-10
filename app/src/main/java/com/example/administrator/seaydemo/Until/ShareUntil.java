package com.example.administrator.seaydemo.Until;

import android.content.Context;

import com.example.administrator.seaydemo.Image.API;
import com.example.administrator.seaydemo.R;

import java.net.URL;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by duangniu000 on 2017/3/10.
 */

public class ShareUntil {

    public static void shareSdk(Context context, String URL) {
        ShareSDK.initSDK(context);
        OnekeyShare oks = new OnekeyShare();
//关闭sso授权
        oks.disableSSOWhenAuthorize();

// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle("标题");
// titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setImageUrl("http://7sby7r.com1.z0.glb.clouddn.com/CYSJ_02.jpg");//网络图片rul
        oks.setTitleUrl(API.Host + URL);  //网友点进链接后，可以看到分享的详情
        oks.show(context);
    }
}
