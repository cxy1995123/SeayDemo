package com.example.administrator.seaydemo.Entity;

import java.util.List;

/**
 * Created by Administrator on 2017/3/7.
 */

public class ImageFengmian {


    /**
     * status : true
     * total : 65
     * tngou : [{"count":3936,"fcount":0,"galleryclass":2,"id":618,"img":"/ext/160215/e6bf8ea5f556b149afcc270ec1616246.jpg","rcount":0,"size":19,"time":1455514467000,"title":"尾崎ナナ粉红护士制服秀巨乳"},{"count":3101,"fcount":0,"galleryclass":2,"id":581,"img":"/ext/160121/0bacda6e967589465f2129d85a25e668.jpg","rcount":0,"size":12,"time":1453380694000,"title":"性感OL韩雨菲超短裙制服"},{"count":2696,"fcount":0,"galleryclass":2,"id":580,"img":"/ext/160121/7e5fcb9f520f8bab66f7ed137d14d323.jpg","rcount":0,"size":18,"time":1453380568000,"title":"日本性感美女杉原杏璃OL装"},{"count":2041,"fcount":0,"galleryclass":2,"id":576,"img":"/ext/160118/26e1c439b3dc3ab70ab09bf3019416fd.jpg","rcount":0,"size":9,"time":1453084982000,"title":"女仆妹子沈乔乔羞涩游江南"},{"count":2608,"fcount":0,"galleryclass":2,"id":572,"img":"/ext/160112/cb9ebf0ee7b7413be44c171fc6e54280.jpg","rcount":0,"size":14,"time":1452563094000,"title":"妹子娜依灵儿女仆制服秀性感美臀"},{"count":2753,"fcount":0,"galleryclass":2,"id":570,"img":"/ext/160112/be2adb9e1a36e539dc738580bc3df16a.jpg","rcount":0,"size":17,"time":1452562618000,"title":"浴缸里的制服诱惑"},{"count":1744,"fcount":0,"galleryclass":2,"id":566,"img":"/ext/160110/0ebfa02124f32d99fe3e13321474908f.jpg","rcount":0,"size":8,"time":1452398586000,"title":"日本动漫甜美女仆装美女"},{"count":2988,"fcount":0,"galleryclass":2,"id":563,"img":"/ext/160108/55750beb481e5656ed809aa0ebd14555.jpg","rcount":0,"size":31,"time":1452215695000,"title":"性感美女Ashely丽丽女仆制服诱惑秀爆乳"},{"count":3236,"fcount":0,"galleryclass":2,"id":562,"img":"/ext/160108/46cce6f6b59b5c81bab26ce00d61af9f.jpg","rcount":0,"size":32,"time":1452215658000,"title":"巨乳美女徐小宝女仆制服诱惑写真"},{"count":3382,"fcount":0,"galleryclass":2,"id":561,"img":"/ext/160108/f52eba2f19f04f3a6454fa682f0b3713.jpg","rcount":0,"size":16,"time":1452215619000,"title":"酥胸尤物Luvian性感内衣写真"},{"count":2270,"fcount":0,"galleryclass":2,"id":559,"img":"/ext/160108/c0b01985e2a1adac4ad2b0099d1f1d4d.jpg","rcount":0,"size":11,"time":1452215534000,"title":"美女性感制服女仆装私房诱惑写真"},{"count":3037,"fcount":0,"galleryclass":2,"id":558,"img":"/ext/160108/483a3ce771a5c8aa79ccb7edc21c6b37.jpg","rcount":0,"size":21,"time":1452215507000,"title":"美女玛鲁娜女仆装翘臀性感诱惑"},{"count":2652,"fcount":0,"galleryclass":2,"id":556,"img":"/ext/160105/0098e5738fe242a3c6a7b9b91fc61e17.jpg","rcount":0,"size":17,"time":1451987731000,"title":"推女神美女顾欣怡女仆装美臀诱惑图片"},{"count":1875,"fcount":0,"galleryclass":2,"id":555,"img":"/ext/160105/0506a61445c32321659ffc7549771d3d.jpg","rcount":0,"size":14,"time":1451987320000,"title":"美女小嘛性感女仆装写真图片"},{"count":2465,"fcount":0,"galleryclass":2,"id":554,"img":"/ext/160105/dbb3282275a1bdc0f869f769fd1b66df.jpg","rcount":0,"size":25,"time":1451986991000,"title":"美媛馆艾莉Evelyn性感女仆美臀写真"},{"count":3900,"fcount":0,"galleryclass":2,"id":553,"img":"/ext/160105/7e5abe2d559140feab17cf2b90b04453.jpg","rcount":0,"size":24,"time":1451986894000,"title":"百变制服女郎大尺度私房写真姿势撩人"},{"count":1903,"fcount":0,"galleryclass":2,"id":552,"img":"/ext/160105/9ef07bf8aad0101bb36cf2e2f0601ab5.jpg","rcount":0,"size":14,"time":1451986724000,"title":"美女吕婷昱女仆装秀翘臀"},{"count":2316,"fcount":0,"galleryclass":2,"id":550,"img":"/ext/151231/4452f36af3405100738964eaf3eb7b2a.jpg","rcount":0,"size":19,"time":1451525179000,"title":"日本东京大学学生妹诱惑写真"},{"count":1942,"fcount":0,"galleryclass":2,"id":548,"img":"/ext/151231/04224119c0605ee483ab5a890ec089d9.jpg","rcount":0,"size":7,"time":1451525063000,"title":"甜美学生妹Kira制服比基尼美图"}]
     */

    private boolean status;
    private int total;
    private List<TngouBean> tngou;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<TngouBean> getTngou() {
        return tngou;
    }

    public void setTngou(List<TngouBean> tngou) {
        this.tngou = tngou;
    }

    public static class TngouBean {
        /**
         * count : 3936
         * fcount : 0
         * galleryclass : 2
         * id : 618
         * img : /ext/160215/e6bf8ea5f556b149afcc270ec1616246.jpg
         * rcount : 0
         * size : 19
         * time : 1455514467000
         * title : 尾崎ナナ粉红护士制服秀巨乳
         */

        private int count;
        private int fcount;
        private int galleryclass;
        private int id;
        private String img;
        private int rcount;
        private int size;
        private long time;
        private String title;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getFcount() {
            return fcount;
        }

        public void setFcount(int fcount) {
            this.fcount = fcount;
        }

        public int getGalleryclass() {
            return galleryclass;
        }

        public void setGalleryclass(int galleryclass) {
            this.galleryclass = galleryclass;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getRcount() {
            return rcount;
        }

        public void setRcount(int rcount) {
            this.rcount = rcount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
