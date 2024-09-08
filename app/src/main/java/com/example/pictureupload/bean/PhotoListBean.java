package com.example.pictureupload.bean;

import java.io.Serializable;
import java.util.List;

/*
 * 首页的JavaBean
 *  */
public class PhotoListBean {
    /**
     * code : 200
     * msg : 成功
     * data : {"records":[{"id":"8199","pUserId":"1838631237833592832","imageCode":"1839979071858151424","title":"完蛋","content":"damdamdamdamdamdamdam","createTime":"1727520171533","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/28/921f6d56-3e5d-47a7-a1ad-10fa2d6160d4.jpg"],"likeId":null,"likeNum":1,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"ikun200","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/28/73405173-c432-4ac4-a4f9-c1809f270f97.jpg"},{"id":"8187","pUserId":"1703778455226814464","imageCode":"1839291611058671616","title":"马楼！","content":"玩挺大","createTime":"1727356271916","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/26/1dd2ebd8-7346-4ee7-a4bb-99551783f6f7.jpg"],"likeId":null,"likeNum":1,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"木叶第一扒手","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/20/32e8f7b9-b879-48a5-b6f3-c148cf77d761.jpg"},{"id":"8186","pUserId":"1838572047920402432","imageCode":"1839289419673243648","title":"3","content":"3","createTime":"1727355744872","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/26/324d9fd6-1f21-4f8b-a59d-c8337282b311.jpg"],"likeId":null,"likeNum":1,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"dxw","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"},{"id":"8183","pUserId":"1838159036164476928","imageCode":"1839138613531643904","title":"小米手环","content":"9","createTime":"1727319800698","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/26/375d2ff6-6f0e-42ad-99f3-02893ac86211.jpg"],"likeId":null,"likeNum":2,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"lzz","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"},{"id":"8182","pUserId":"1838159036164476928","imageCode":"1839138437253435392","title":"二梁还在测","content":"314之神","createTime":"1727319754648","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/26/5c152675-60f0-4754-ae9a-7627e1c6a535.jpg"],"likeId":null,"likeNum":1,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"lzz","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"},{"id":"8181","pUserId":"1833535832653434880","imageCode":"1838963620961193984","title":"测试","content":"的大大方方fffffffffffffffffCC冲冲冲cfddjehejrjjejejerjjrjejejrnrjrjrjrjkrnrnfnfnnrbrbrnrnrnenenenrnrnrnejennrnrnrneneedjdjdjdbdbdbdbdjdjdndnnddndndndnnddndndndndndnndnd","createTime":"1727278068475","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/25/4ec9cf5f-8272-47cf-8411-3cdf4537ce91.jpg"],"likeId":null,"likeNum":3,"hasLike":false,"collectId":null,"collectNum":1,"hasCollect":false,"hasFocus":false,"username":"ikun100","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/22/ea07bf39-d211-4fff-bb0d-e61b0bfdc2c0.jpg"},{"id":"8177","pUserId":"1837866689862176768","imageCode":"1838898337483460608","title":"cs","content":"cs","createTime":"1727262503501","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/25/ed10ec65-952c-4dcc-b9cb-47e5f0985996.jpg"],"likeId":null,"likeNum":3,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"ikun001","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/24/1f2d6244-b928-4576-be29-e809a0480ef1.jpg"},{"id":"8176","pUserId":"1837866689862176768","imageCode":"1838898172408238080","title":"cshi","content":"cs","createTime":"1727262464504","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/25/22309da4-18e1-4468-befc-187626a6eee4.jpg"],"likeId":null,"likeNum":2,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"ikun001","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/24/1f2d6244-b928-4576-be29-e809a0480ef1.jpg"},{"id":"8175","pUserId":"1832796652436590592","imageCode":"1838881618232741888","title":"大大大","content":"好好好","createTime":"1727258523677","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/25/68c0c51b-5f43-4788-9d6d-d07e545f162c.png"],"likeId":null,"likeNum":2,"hasLike":false,"collectId":null,"collectNum":2,"hasCollect":false,"hasFocus":false,"username":"木叶第二扒手","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/25/5f2f3def-bb44-4440-8f82-32dcccadb215.jpg"},{"id":"8174","pUserId":"1831710424643538944","imageCode":"1838846158210994176","title":"11","content":"11","createTime":"1727250067044","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/25/46ac023a-627d-460f-af2e-ead7888d5e2f.jpg"],"likeId":null,"likeNum":1,"hasLike":false,"collectId":null,"collectNum":2,"hasCollect":false,"hasFocus":false,"username":"33333","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2023/12/14/b15f3e06-4175-494a-9a81-8ed0b47ae87b.png"},{"id":"8172","pUserId":"1838631237833592832","imageCode":"1838821140198461440","title":"测试","content":"测试","createTime":"1727244103748","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/25/1579a7eb-ad27-4e03-9368-9b1c3bdac168.jpg"],"likeId":null,"likeNum":1,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"ikun200","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/28/73405173-c432-4ac4-a4f9-c1809f270f97.jpg"},{"id":"8171","pUserId":"1838159036164476928","imageCode":"1838788838240161792","title":"计算机网络","content":"计科","createTime":"1727236404880","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/25/202fb27b-940a-4319-8118-a9f52350ba1f.jpg"],"likeId":null,"likeNum":2,"hasLike":false,"collectId":null,"collectNum":1,"hasCollect":false,"hasFocus":false,"username":"lzz","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"},{"id":"8170","pUserId":"1838497840222048256","imageCode":"1838774097606217728","title":"dss","content":"ss","createTime":"1727232882854","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/25/b75ae995-e8ef-4566-8a90-deae94c91c42.jpg"],"likeId":null,"likeNum":0,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"15847244684","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"},{"id":"8169","pUserId":"1838497840222048256","imageCode":"1838774094326272000","title":"dss","content":"ss","createTime":"1727232882475","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/25/8b25d87b-4075-4808-870d-b0340ecce16d.jpg"],"likeId":null,"likeNum":0,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"15847244684","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"},{"id":"8168","pUserId":"1836051442469834752","imageCode":"1838766393173086208","title":"1564","content":"1564","createTime":"1727231099471","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/25/d09ec1a1-c5be-44d3-8992-14c8b7c000dd.jpg"],"likeId":null,"likeNum":1,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"ttg","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"},{"id":"8167","pUserId":"1834230064405942272","imageCode":"1838741269543784448","title":"。。。","content":"。。。","createTime":"1727225057080","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/25/05689ed0-fe54-444e-8422-64ce545e9f4c.jpg"],"likeId":null,"likeNum":0,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"thx","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/24/31736dcd-d5a4-4341-91d5-59a15732aba8.jpg"},{"id":"8166","pUserId":"1836051442469834752","imageCode":"1838732063092641792","title":"。。。","content":"。。。","createTime":"1727222868802","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/25/31b25a4e-6618-434f-bcef-bd2cb08d1057.jpg"],"likeId":null,"likeNum":0,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"ttg","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"},{"id":"8165","pUserId":"1836390774288289792","imageCode":"1838614068324339712","title":"这次测试一个很长很长很长的标题","content":" \u2026\u2026 ！\u2026， \u2026，\u2026 ！ \u2026， \u2026\u2026 ，！\u2026\u2026 ！\u2026\u2026！ \u2026\u2026，\u2026\u2026，！\u2026\u2026\u2026\u2026!，\u2026\u2026，!\u2026\u2026，\u2026\u2026，！！！！嗷呜嗷呜～嗷呜～嗷呜嗷呜～嗷呜呜～嗷呜~~\u2026\u2026，！！！嗷~嗷呜嗷呜～嗷呜嗷呜嗷呜嗷呜嗷呜嗷呜～呜～嗷呜~~嗷～嗷呜～呜呜呜\u2026\u2026！！！！","createTime":"1727194729746","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/25/bc74786d-bc82-4b3f-93e6-44615ec2b590.jpg","https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/25/8a0bbe58-7607-4167-9f30-0755a45616a5.jpg"],"likeId":null,"likeNum":2,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"lzc3","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/22/fed654a9-fffc-402f-9e42-01bd6aaefba0.jpg"},{"id":"8164","pUserId":"1832578841470701568","imageCode":"1838600378212552704","title":"今天早八！","content":"yes ","createTime":"1727191464789","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/24/402b7c7b-6473-4390-a989-738c26fc1c0f.jpg"],"likeId":null,"likeNum":2,"hasLike":false,"collectId":null,"collectNum":1,"hasCollect":false,"hasFocus":false,"username":"975","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/25/5de2c44f-87e5-4d26-968d-ad091f9317f8.jpg"},{"id":"8163","pUserId":"1838159036164476928","imageCode":"1838592103123390464","title":"314","content":"水果之王","createTime":"1727189503853","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/24/5606becf-c18e-49ea-b6c3-f4c03c7c7917.jpg"],"likeId":null,"likeNum":4,"hasLike":false,"collectId":null,"collectNum":2,"hasCollect":false,"hasFocus":false,"username":"lzz","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"},{"id":"8162","pUserId":"1836051442469834752","imageCode":"1838589348203859968","title":"dd","content":"dd","createTime":"1727188838246","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/24/51ffb02b-e038-48ba-9dd0-b9eb4749b851.jpg"],"likeId":null,"likeNum":1,"hasLike":false,"collectId":null,"collectNum":1,"hasCollect":false,"hasFocus":false,"username":"ttg","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"},{"id":"8161","pUserId":"1837866689862176768","imageCode":"1838588527315652608","title":"测试","content":"测试","createTime":"1727188639405","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/24/2baf4980-afe5-412d-8f9e-ee539033bc4f.jpg"],"likeId":null,"likeNum":0,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"ikun001","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/24/1f2d6244-b928-4576-be29-e809a0480ef1.jpg"},{"id":"8160","pUserId":"1836051442469834752","imageCode":"1838588234649702400","title":"hello","content":"hello","createTime":"1727188575917","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/24/d0908ed8-57c2-420b-9f39-c52dba08b783.jpg"],"likeId":null,"likeNum":1,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"ttg","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"},{"id":"8159","pUserId":"1836051442469834752","imageCode":"1838555965503442944","title":"22","content":"22","createTime":"1727180881514","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/24/1f60c3b8-e44d-4ece-8373-c98cd7bd1665.jpg"],"likeId":null,"likeNum":2,"hasLike":false,"collectId":null,"collectNum":1,"hasCollect":false,"hasFocus":false,"username":"ttg","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"},{"id":"8158","pUserId":"1836051442469834752","imageCode":"1838536814957301760","title":"123","content":"123","createTime":"1727176315622","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/24/3f755cb7-ac69-4114-ab2b-f556d9895f9a.jpg"],"likeId":null,"likeNum":0,"hasLike":false,"collectId":null,"collectNum":1,"hasCollect":false,"hasFocus":false,"username":"ttg","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"},{"id":"8157","pUserId":"1836051442469834752","imageCode":"1838534642630791168","title":"123","content":"123","createTime":"1727175805586","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/24/8f4b156b-bed5-4aeb-9641-052ed1383b9e.jpg"],"likeId":null,"likeNum":0,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"ttg","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"},{"id":"8156","pUserId":"1836051442469834752","imageCode":"1838534083806892032","title":"5555","content":"5555","createTime":"1727175674837","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/24/eb6b9fe7-4e07-4d3c-907b-da6e8d25f852.jpg"],"likeId":null,"likeNum":1,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"ttg","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"},{"id":"8155","pUserId":"1836051442469834752","imageCode":"1838533228122738688","title":"0000","content":"0000","createTime":"1727175467732","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/24/a0610a19-a719-44e7-ae48-d53c0b3d0d0a.jpg"],"likeId":null,"likeNum":1,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"ttg","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"},{"id":"8154","pUserId":"1836051442469834752","imageCode":"1838532988598620160","title":"212121","content":"212121","createTime":"1727175411056","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/24/0ba88916-e001-415f-88b7-7baf4cf40b14.jpg"],"likeId":null,"likeNum":1,"hasLike":false,"collectId":null,"collectNum":1,"hasCollect":false,"hasFocus":false,"username":"ttg","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"},{"id":"8153","pUserId":"1836051442469834752","imageCode":"1838532691960664064","title":"77777","content":"77777","createTime":"1727175340459","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/24/a6a7ea14-379e-4140-af21-1becb90d253b.jpg"],"likeId":null,"likeNum":2,"hasLike":false,"collectId":null,"collectNum":1,"hasCollect":false,"hasFocus":false,"username":"ttg","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"}],"total":1843,"size":30,"current":1}
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
         * records : [{"id":"8199","pUserId":"1838631237833592832","imageCode":"1839979071858151424","title":"完蛋","content":"damdamdamdamdamdamdam","createTime":"1727520171533","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/28/921f6d56-3e5d-47a7-a1ad-10fa2d6160d4.jpg"],"likeId":null,"likeNum":1,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"ikun200","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/28/73405173-c432-4ac4-a4f9-c1809f270f97.jpg"},{"id":"8187","pUserId":"1703778455226814464","imageCode":"1839291611058671616","title":"马楼！","content":"玩挺大","createTime":"1727356271916","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/26/1dd2ebd8-7346-4ee7-a4bb-99551783f6f7.jpg"],"likeId":null,"likeNum":1,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"木叶第一扒手","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/20/32e8f7b9-b879-48a5-b6f3-c148cf77d761.jpg"},{"id":"8186","pUserId":"1838572047920402432","imageCode":"1839289419673243648","title":"3","content":"3","createTime":"1727355744872","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/26/324d9fd6-1f21-4f8b-a59d-c8337282b311.jpg"],"likeId":null,"likeNum":1,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"dxw","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"},{"id":"8183","pUserId":"1838159036164476928","imageCode":"1839138613531643904","title":"小米手环","content":"9","createTime":"1727319800698","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/26/375d2ff6-6f0e-42ad-99f3-02893ac86211.jpg"],"likeId":null,"likeNum":2,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"lzz","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"},{"id":"8182","pUserId":"1838159036164476928","imageCode":"1839138437253435392","title":"二梁还在测","content":"314之神","createTime":"1727319754648","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/26/5c152675-60f0-4754-ae9a-7627e1c6a535.jpg"],"likeId":null,"likeNum":1,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"lzz","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"},{"id":"8181","pUserId":"1833535832653434880","imageCode":"1838963620961193984","title":"测试","content":"的大大方方fffffffffffffffffCC冲冲冲cfddjehejrjjejejerjjrjejejrnrjrjrjrjkrnrnfnfnnrbrbrnrnrnenenenrnrnrnejennrnrnrneneedjdjdjdbdbdbdbdjdjdndnnddndndndnnddndndndndndnndnd","createTime":"1727278068475","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/25/4ec9cf5f-8272-47cf-8411-3cdf4537ce91.jpg"],"likeId":null,"likeNum":3,"hasLike":false,"collectId":null,"collectNum":1,"hasCollect":false,"hasFocus":false,"username":"ikun100","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/22/ea07bf39-d211-4fff-bb0d-e61b0bfdc2c0.jpg"},{"id":"8177","pUserId":"1837866689862176768","imageCode":"1838898337483460608","title":"cs","content":"cs","createTime":"1727262503501","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/25/ed10ec65-952c-4dcc-b9cb-47e5f0985996.jpg"],"likeId":null,"likeNum":3,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"ikun001","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/24/1f2d6244-b928-4576-be29-e809a0480ef1.jpg"},{"id":"8176","pUserId":"1837866689862176768","imageCode":"1838898172408238080","title":"cshi","content":"cs","createTime":"1727262464504","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/25/22309da4-18e1-4468-befc-187626a6eee4.jpg"],"likeId":null,"likeNum":2,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"ikun001","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/24/1f2d6244-b928-4576-be29-e809a0480ef1.jpg"},{"id":"8175","pUserId":"1832796652436590592","imageCode":"1838881618232741888","title":"大大大","content":"好好好","createTime":"1727258523677","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/25/68c0c51b-5f43-4788-9d6d-d07e545f162c.png"],"likeId":null,"likeNum":2,"hasLike":false,"collectId":null,"collectNum":2,"hasCollect":false,"hasFocus":false,"username":"木叶第二扒手","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/25/5f2f3def-bb44-4440-8f82-32dcccadb215.jpg"},{"id":"8174","pUserId":"1831710424643538944","imageCode":"1838846158210994176","title":"11","content":"11","createTime":"1727250067044","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/25/46ac023a-627d-460f-af2e-ead7888d5e2f.jpg"],"likeId":null,"likeNum":1,"hasLike":false,"collectId":null,"collectNum":2,"hasCollect":false,"hasFocus":false,"username":"33333","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2023/12/14/b15f3e06-4175-494a-9a81-8ed0b47ae87b.png"},{"id":"8172","pUserId":"1838631237833592832","imageCode":"1838821140198461440","title":"测试","content":"测试","createTime":"1727244103748","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/25/1579a7eb-ad27-4e03-9368-9b1c3bdac168.jpg"],"likeId":null,"likeNum":1,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"ikun200","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/28/73405173-c432-4ac4-a4f9-c1809f270f97.jpg"},{"id":"8171","pUserId":"1838159036164476928","imageCode":"1838788838240161792","title":"计算机网络","content":"计科","createTime":"1727236404880","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/25/202fb27b-940a-4319-8118-a9f52350ba1f.jpg"],"likeId":null,"likeNum":2,"hasLike":false,"collectId":null,"collectNum":1,"hasCollect":false,"hasFocus":false,"username":"lzz","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"},{"id":"8170","pUserId":"1838497840222048256","imageCode":"1838774097606217728","title":"dss","content":"ss","createTime":"1727232882854","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/25/b75ae995-e8ef-4566-8a90-deae94c91c42.jpg"],"likeId":null,"likeNum":0,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"15847244684","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"},{"id":"8169","pUserId":"1838497840222048256","imageCode":"1838774094326272000","title":"dss","content":"ss","createTime":"1727232882475","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/25/8b25d87b-4075-4808-870d-b0340ecce16d.jpg"],"likeId":null,"likeNum":0,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"15847244684","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"},{"id":"8168","pUserId":"1836051442469834752","imageCode":"1838766393173086208","title":"1564","content":"1564","createTime":"1727231099471","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/25/d09ec1a1-c5be-44d3-8992-14c8b7c000dd.jpg"],"likeId":null,"likeNum":1,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"ttg","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"},{"id":"8167","pUserId":"1834230064405942272","imageCode":"1838741269543784448","title":"。。。","content":"。。。","createTime":"1727225057080","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/25/05689ed0-fe54-444e-8422-64ce545e9f4c.jpg"],"likeId":null,"likeNum":0,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"thx","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/24/31736dcd-d5a4-4341-91d5-59a15732aba8.jpg"},{"id":"8166","pUserId":"1836051442469834752","imageCode":"1838732063092641792","title":"。。。","content":"。。。","createTime":"1727222868802","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/25/31b25a4e-6618-434f-bcef-bd2cb08d1057.jpg"],"likeId":null,"likeNum":0,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"ttg","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"},{"id":"8165","pUserId":"1836390774288289792","imageCode":"1838614068324339712","title":"这次测试一个很长很长很长的标题","content":" \u2026\u2026 ！\u2026， \u2026，\u2026 ！ \u2026， \u2026\u2026 ，！\u2026\u2026 ！\u2026\u2026！ \u2026\u2026，\u2026\u2026，！\u2026\u2026\u2026\u2026!，\u2026\u2026，!\u2026\u2026，\u2026\u2026，！！！！嗷呜嗷呜～嗷呜～嗷呜嗷呜～嗷呜呜～嗷呜~~\u2026\u2026，！！！嗷~嗷呜嗷呜～嗷呜嗷呜嗷呜嗷呜嗷呜嗷呜～呜～嗷呜~~嗷～嗷呜～呜呜呜\u2026\u2026！！！！","createTime":"1727194729746","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/25/bc74786d-bc82-4b3f-93e6-44615ec2b590.jpg","https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/25/8a0bbe58-7607-4167-9f30-0755a45616a5.jpg"],"likeId":null,"likeNum":2,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"lzc3","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/22/fed654a9-fffc-402f-9e42-01bd6aaefba0.jpg"},{"id":"8164","pUserId":"1832578841470701568","imageCode":"1838600378212552704","title":"今天早八！","content":"yes ","createTime":"1727191464789","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/24/402b7c7b-6473-4390-a989-738c26fc1c0f.jpg"],"likeId":null,"likeNum":2,"hasLike":false,"collectId":null,"collectNum":1,"hasCollect":false,"hasFocus":false,"username":"975","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/25/5de2c44f-87e5-4d26-968d-ad091f9317f8.jpg"},{"id":"8163","pUserId":"1838159036164476928","imageCode":"1838592103123390464","title":"314","content":"水果之王","createTime":"1727189503853","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/24/5606becf-c18e-49ea-b6c3-f4c03c7c7917.jpg"],"likeId":null,"likeNum":4,"hasLike":false,"collectId":null,"collectNum":2,"hasCollect":false,"hasFocus":false,"username":"lzz","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"},{"id":"8162","pUserId":"1836051442469834752","imageCode":"1838589348203859968","title":"dd","content":"dd","createTime":"1727188838246","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/24/51ffb02b-e038-48ba-9dd0-b9eb4749b851.jpg"],"likeId":null,"likeNum":1,"hasLike":false,"collectId":null,"collectNum":1,"hasCollect":false,"hasFocus":false,"username":"ttg","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"},{"id":"8161","pUserId":"1837866689862176768","imageCode":"1838588527315652608","title":"测试","content":"测试","createTime":"1727188639405","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/24/2baf4980-afe5-412d-8f9e-ee539033bc4f.jpg"],"likeId":null,"likeNum":0,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"ikun001","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/24/1f2d6244-b928-4576-be29-e809a0480ef1.jpg"},{"id":"8160","pUserId":"1836051442469834752","imageCode":"1838588234649702400","title":"hello","content":"hello","createTime":"1727188575917","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/24/d0908ed8-57c2-420b-9f39-c52dba08b783.jpg"],"likeId":null,"likeNum":1,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"ttg","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"},{"id":"8159","pUserId":"1836051442469834752","imageCode":"1838555965503442944","title":"22","content":"22","createTime":"1727180881514","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/24/1f60c3b8-e44d-4ece-8373-c98cd7bd1665.jpg"],"likeId":null,"likeNum":2,"hasLike":false,"collectId":null,"collectNum":1,"hasCollect":false,"hasFocus":false,"username":"ttg","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"},{"id":"8158","pUserId":"1836051442469834752","imageCode":"1838536814957301760","title":"123","content":"123","createTime":"1727176315622","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/24/3f755cb7-ac69-4114-ab2b-f556d9895f9a.jpg"],"likeId":null,"likeNum":0,"hasLike":false,"collectId":null,"collectNum":1,"hasCollect":false,"hasFocus":false,"username":"ttg","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"},{"id":"8157","pUserId":"1836051442469834752","imageCode":"1838534642630791168","title":"123","content":"123","createTime":"1727175805586","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/24/8f4b156b-bed5-4aeb-9641-052ed1383b9e.jpg"],"likeId":null,"likeNum":0,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"ttg","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"},{"id":"8156","pUserId":"1836051442469834752","imageCode":"1838534083806892032","title":"5555","content":"5555","createTime":"1727175674837","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/24/eb6b9fe7-4e07-4d3c-907b-da6e8d25f852.jpg"],"likeId":null,"likeNum":1,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"ttg","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"},{"id":"8155","pUserId":"1836051442469834752","imageCode":"1838533228122738688","title":"0000","content":"0000","createTime":"1727175467732","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/24/a0610a19-a719-44e7-ae48-d53c0b3d0d0a.jpg"],"likeId":null,"likeNum":1,"hasLike":false,"collectId":null,"collectNum":0,"hasCollect":false,"hasFocus":false,"username":"ttg","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"},{"id":"8154","pUserId":"1836051442469834752","imageCode":"1838532988598620160","title":"212121","content":"212121","createTime":"1727175411056","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/24/0ba88916-e001-415f-88b7-7baf4cf40b14.jpg"],"likeId":null,"likeNum":1,"hasLike":false,"collectId":null,"collectNum":1,"hasCollect":false,"hasFocus":false,"username":"ttg","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"},{"id":"8153","pUserId":"1836051442469834752","imageCode":"1838532691960664064","title":"77777","content":"77777","createTime":"1727175340459","imageUrlList":["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/24/a6a7ea14-379e-4140-af21-1becb90d253b.jpg"],"likeId":null,"likeNum":2,"hasLike":false,"collectId":null,"collectNum":1,"hasCollect":false,"hasFocus":false,"username":"ttg","avatar":"https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/09/a1d281ae-e232-44d0-b844-a576116a6913.jpg"}]
         * total : 1843
         * size : 30
         * current : 1
         */

        private Integer total;
        private Integer size;
        private Integer current;
        private List<RecordsBean> records;

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public Integer getCurrent() {
            return current;
        }

        public void setCurrent(Integer current) {
            this.current = current;
        }

        public List<RecordsBean> getRecords() {
            return records;
        }

        public void setRecords(List<RecordsBean> records) {
            this.records = records;
        }

        public static class RecordsBean implements Serializable {
            /**
             * id : 8199
             * pUserId : 1838631237833592832
             * imageCode : 1839979071858151424
             * title : 完蛋
             * content : damdamdamdamdamdamdam
             * createTime : 1727520171533
             * imageUrlList : ["https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/28/921f6d56-3e5d-47a7-a1ad-10fa2d6160d4.jpg"]
             * likeId : null
             * likeNum : 1
             * hasLike : false
             * collectId : null
             * collectNum : 0
             * hasCollect : false
             * hasFocus : false
             * username : ikun200
             * avatar : https://guet-lab.oss-cn-hangzhou.aliyuncs.com/api/2024/09/28/73405173-c432-4ac4-a4f9-c1809f270f97.jpg
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

            public Integer getLikeNum() {
                return likeNum;
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
                return collectNum;
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
