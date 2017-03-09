package com.example.administrator.seaydemo.Entity;

import java.util.List;

/**
 * Created by duangniu000 on 2017/3/8.
 */

public class ImageSet {

    /**
     * count : 60918
     * fcount : 0
     * galleryclass : 1
     * id : 1035
     * img : /ext/161223/395b860c06ccaf5b35cde317ff082c18.jpg
     * list : [{"gallery":1035,"id":15679,"src":"/ext/161223/395b860c06ccaf5b35cde317ff082c18.jpg"},{"gallery":1035,"id":15680,"src":"/ext/161223/12773d01e3304405ea299699ef62fcff.jpg"},{"gallery":1035,"id":15681,"src":"/ext/161223/319548108cbca63119966e5f438ff7b7.jpg"},{"gallery":1035,"id":15682,"src":"/ext/161223/4949096ddc90a9585a4c05b420ee2321.jpg"},{"gallery":1035,"id":15683,"src":"/ext/161223/3c60b2d028a86be824b2a6e31f6e2d05.jpg"},{"gallery":1035,"id":15684,"src":"/ext/161223/8ed239326464c2077e277bc6e64ff61c.jpg"},{"gallery":1035,"id":15685,"src":"/ext/161223/7a53037200221036a6fc94232c6b5f4f.jpg"},{"gallery":1035,"id":15686,"src":"/ext/161223/b93b92ff9259ecad0303f4d25e68526f.jpg"},{"gallery":1035,"id":15687,"src":"/ext/161223/8d847fbc1844a962421338934111ab67.jpg"}]
     * rcount : 0
     * size : 9
     * status : true
     * time : 1482494660000
     * title : 蕾丝透视装美女性感包臀裙极品私房照
     * url : http://www.tngou.net/tnfs/show/1035
     */

    private int count;
    private int fcount;
    private int galleryclass;
    private int id;
    private String img;
    private int rcount;
    private int size;
    private boolean status;
    private long time;
    private String title;
    private String url;
    private List<ListBean> list;

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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * gallery : 1035
         * id : 15679
         * src : /ext/161223/395b860c06ccaf5b35cde317ff082c18.jpg
         */

        private int gallery;
        private int id;
        private String src;

        public int getGallery() {
            return gallery;
        }

        public void setGallery(int gallery) {
            this.gallery = gallery;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }
    }
}
