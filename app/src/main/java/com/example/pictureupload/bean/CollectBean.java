package com.example.pictureupload.bean;

import java.util.List;

/*
 * 处理从服务器返回的收藏列表数据的JavaBean
 *  */
public class CollectBean {
    /**
     * code : 200
     * msg : 成功
     * data : {"records":[{"id":"8296","pUserId":"1844413839513358336","imageCode":"1844418299736231936","title":"22","content":"222","createTime":"1728578566022","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/10/11/1296b4ce-789c-4562-80db-31ad7704cb7e.png"],"likeId":"12527","likeNum":2,"hasLike":true,"collectId":"6382","collectNum":null,"hasCollect":true,"hasFocus":false,"username":"1001","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"}],"total":1,"size":10,"current":1}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * records : [{"id":"8296","pUserId":"1844413839513358336","imageCode":"1844418299736231936","title":"22","content":"222","createTime":"1728578566022","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/10/11/1296b4ce-789c-4562-80db-31ad7704cb7e.png"],"likeId":"12527","likeNum":2,"hasLike":true,"collectId":"6382","collectNum":null,"hasCollect":true,"hasFocus":false,"username":"1001","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"}]
         * total : 1
         * size : 10
         * current : 1
         */

        private int total;
        private int size;
        private int current;
        private List<RecordsBean> records;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getCurrent() {
            return current;
        }

        public void setCurrent(int current) {
            this.current = current;
        }

        public List<RecordsBean> getRecords() {
            return records;
        }

        public void setRecords(List<RecordsBean> records) {
            this.records = records;
        }

        public static class RecordsBean {
            /**
             * id : 8296
             * pUserId : 1844413839513358336
             * imageCode : 1844418299736231936
             * title : 22
             * content : 222
             * createTime : 1728578566022
             * imageUrlList : ["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/10/11/1296b4ce-789c-4562-80db-31ad7704cb7e.png"]
             * likeId : 12527
             * likeNum : 2
             * hasLike : true
             * collectId : 6382
             * collectNum : null
             * hasCollect : true
             * hasFocus : false
             * username : 1001
             * avatar : https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg
             */

            private String id;
            private String pUserId;
            private String imageCode;
            private String title;
            private String content;
            private String createTime;
            private String likeId;
            private int likeNum;
            private boolean hasLike;
            private String collectId;
            private Object collectNum;
            private boolean hasCollect;
            private boolean hasFocus;
            private String username;
            private String avatar;
            private List<String> imageUrlList;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getPUserId() {
                return pUserId;
            }

            public void setPUserId(String pUserId) {
                this.pUserId = pUserId;
            }

            public String getImageCode() {
                return imageCode;
            }

            public void setImageCode(String imageCode) {
                this.imageCode = imageCode;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getLikeId() {
                return likeId;
            }

            public void setLikeId(String likeId) {
                this.likeId = likeId;
            }

            public int getLikeNum() {
                return likeNum;
            }

            public void setLikeNum(int likeNum) {
                this.likeNum = likeNum;
            }

            public boolean isHasLike() {
                return hasLike;
            }

            public void setHasLike(boolean hasLike) {
                this.hasLike = hasLike;
            }

            public String getCollectId() {
                return collectId;
            }

            public void setCollectId(String collectId) {
                this.collectId = collectId;
            }

            public Object getCollectNum() {
                return collectNum;
            }

            public void setCollectNum(Object collectNum) {
                this.collectNum = collectNum;
            }

            public boolean isHasCollect() {
                return hasCollect;
            }

            public void setHasCollect(boolean hasCollect) {
                this.hasCollect = hasCollect;
            }

            public boolean isHasFocus() {
                return hasFocus;
            }

            public void setHasFocus(boolean hasFocus) {
                this.hasFocus = hasFocus;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public List<String> getImageUrlList() {
                return imageUrlList;
            }

            public void setImageUrlList(List<String> imageUrlList) {
                this.imageUrlList = imageUrlList;
            }
        }
    }
}
