package com.example.pictureupload.bean;

import java.util.List;

/*
 * 图文分享详情JavaBean
 *  */
public class PhotoDetailBean {

    /**
     * code : 200
     * msg : 成功
     * data : {"id":"8201","pUserId":"1841359797463683072","imageCode":"1841391435262332928","title":"测试","content":"积分换手机","createTime":"1727856908096","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/10/02/50fc1804-3fc6-4edf-ac5d-b78e5c847ec2.jpg","https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/10/02/c80bd642-72bd-4c2d-9667-170dd9608171.jpg"],"likeId":null,"likeNum":null,"hasLike":false,"collectId":null,"collectNum":null,"hasCollect":false,"hasFocus":false,"username":"c1","avatar":null}
     */

    private Integer code;
    private String msg;
    private DataBean data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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
         * id : 8201
         * pUserId : 1841359797463683072
         * imageCode : 1841391435262332928
         * title : 测试
         * content : 积分换手机
         * createTime : 1727856908096
         * imageUrlList : ["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/10/02/50fc1804-3fc6-4edf-ac5d-b78e5c847ec2.jpg","https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/10/02/c80bd642-72bd-4c2d-9667-170dd9608171.jpg"]
         * likeId : null
         * likeNum : null
         * hasLike : false
         * collectId : null
         * collectNum : null
         * hasCollect : false
         * hasFocus : false
         * username : c1
         * avatar : null
         */

        private String id;
        private String pUserId;
        private String imageCode;
        private String title;
        private String content;
        private String createTime;
        private String likeId;
        private Integer likeNum;
        private Boolean hasLike;
        private String collectId;
        private Integer collectNum;
        private Boolean hasCollect;
        private Boolean hasFocus;
        private String username;
        private Object avatar;
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

        public Integer getLikeNum() {
            // 点赞数目为0时防止页面上显示null
            return likeNum != null ? likeNum : 0;
        }

        public void setLikeNum(Integer likeNum) {
            this.likeNum = likeNum;
        }

        public Boolean isHasLike() {
            return hasLike;
        }

        public void setHasLike(Boolean hasLike) {
            this.hasLike = hasLike;
        }

        public String getCollectId() {
            return collectId;
        }

        public void setCollectId(String collectId) {
            this.collectId = collectId;
        }

        public Integer getCollectNum() {
            // 收藏数目为0时防止页面上显示null
            return collectNum != null ? collectNum : 0;
        }

        public void setCollectNum(Integer collectNum) {
            this.collectNum = collectNum;
        }

        public Boolean isHasCollect() {
            return hasCollect;
        }

        public void setHasCollect(Boolean hasCollect) {
            this.hasCollect = hasCollect;
        }

        public Boolean isHasFocus() {
            return hasFocus;
        }

        public void setHasFocus(Boolean hasFocus) {
            this.hasFocus = hasFocus;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Object getAvatar() {
            return avatar;
        }

        public void setAvatar(Object avatar) {
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
