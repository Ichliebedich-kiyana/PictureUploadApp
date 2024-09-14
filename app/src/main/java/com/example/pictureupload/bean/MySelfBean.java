package com.example.pictureupload.bean;

import java.util.List;

/*
 * 处理从服务器返回的我发布过列表数据的JavaBean
 *  */
public class MySelfBean {
    /**
     * code : 200
     * msg : 成功
     * data : {"records":[{"id":"8295","pUserId":"1844413839513358336","imageCode":"1844417379329773568","title":"123","content":"1111","createTime":"1728578346223","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/10/11/b93c24d3-9b87-4908-aee8-ad1d453969e1.png"],"likeId":null,"likeNum":0,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":true,"hasFocus":false,"username":"1001","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"}],"total":1,"size":10,"current":1}
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
         * records : [{"id":"8295","pUserId":"1844413839513358336","imageCode":"1844417379329773568","title":"123","content":"1111","createTime":"1728578346223","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/10/11/b93c24d3-9b87-4908-aee8-ad1d453969e1.png"],"likeId":null,"likeNum":0,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":true,"hasFocus":false,"username":"1001","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"}]
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
             * id : 8295
             * pUserId : 1844413839513358336
             * imageCode : 1844417379329773568
             * title : 123
             * content : 1111
             * createTime : 1728578346223
             * imageUrlList : ["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/10/11/b93c24d3-9b87-4908-aee8-ad1d453969e1.png"]
             * likeId : null
             * likeNum : 0
             * hasLike : false
             * collectId : null
             * collectNum : 0
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
            private Object likeId;
            private int likeNum;
            private boolean hasLike;
            private Object collectId;
            private int collectNum;
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

            public Object getLikeId() {
                return likeId;
            }

            public void setLikeId(Object likeId) {
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

            public Object getCollectId() {
                return collectId;
            }

            public void setCollectId(Object collectId) {
                this.collectId = collectId;
            }

            public int getCollectNum() {
                return collectNum;
            }

            public void setCollectNum(int collectNum) {
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
