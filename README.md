# 各个类功能介绍：

## 1.根目录下：

（1）MainActivity：
-- 程序入口

（2）LoginActivity：
-- 登录逻辑：LoginActivity 主要负责用户登录，包括输入验证、网络请求、处理登录结果。
-- 异步网络请求处理：通过 HttpUtil 发送 POST 请求，并且使用回调函数处理响应结果。登录成功时跳转到主页面，登录失败时给出提示。
-- 数据存储：使用 SharedPreferences 存储用户登录后的数据（如用户 ID），便于其他地方使用。

（3）RegisterActivity
-- RegisterActivity 主要负责用户注册功能，类似于 LoginActivity，但它的网络请求发送到 /user/register
端点，表示注册操作。

（4）MyApplication
-- 共享偏好设置、活动管理和全局实例为整个应用提供了一个便于使用的全局状态管理机制。





## 2.util下

（1）HttpUtil
-- 提供常见的HTTP请求方式，并封装请求和响应的处理逻辑
（2）OkCallBack接口
-- 定义处理请求成功或失败的回调





## 3.ui

### dashboard:

（1）AddListAdapter
-- 为应用中图片列表的展示功能创建的自定义适配器类。在 RecyclerView
中管理和显示收藏图片数据。管理和显示用户收藏的图片列表，：当用户点击图片时，使用 ImageViewer
类打开图片的详细大图查看界面。
（2）DashboardFragment
-- 获取我发布过的列表，是一个包含图片列表并支持上拉加载和下拉刷新的Fragment，其核心功能是通过网络请求获取图片分享列表，并显示在RecyclerView中。
（3）DashboardViewModel
利用LiveData来存储和管理UI所需的数据。保持数据在配置变更（如屏幕旋转）时不被销毁，并确保数据与UI同步。
（4）MySelfPhotoListAdapter
管理和展示用户收藏的图片列表，类似于AddListAdapter

### collect:

（1）CollectFragment
-- 向后端请求收藏列表，展示收藏的Fragment，将其显示在 RecyclerView 中。
（2）CollectListAdapter
-- 展示用户收藏内容的 RecyclerView 适配器。将每个收藏项的数据绑定到 RecyclerView
的列表项中，支持显示图片、头像、用户名、时间等内容

like:（类似与collect）
（1）LikeFragment
-- 用于展示用户点赞列表的 Fragment
（2）LikeListAdapter
-- 对应的适配器

### home:

（1）HomeFragment
-- 用于显示和管理照片列表，并具有刷新和加载更多的功能。
（2）ImgAdapter
-- 显示单个图片列表，点击图片查看大图
（3）PhotoAddActivity
-- 发布界面
（4）PhotoDetailActivity
-- 图文分享详情
（5）PhotoImgAdapter
-- 用于显示图片列表。该适配器使用Glide库来加载图片，并在列表中显示缩略图。
（6）PhotoListAdapter
-- 加载和显示图片列表的RecyclerView适配器

### notifications

（1）NotificationsFragment
-- 是一个基于MVVM架构的Fragment，通过ViewModel实现与界面更新的绑定
（2）NotificationsViewModel
-- 通过LiveData向NotificationsFragmenty提供数据





## 4.bean下：

（1）CollectBean
-- 处理从服务器返回的收藏列表数据
（2）LikeBean
-- 处理从服务器返回的点赞列表数据的JavaBean
（3）MySelfBean
-- 处理从服务器返回的我发布过列表数据的JavaBean
（4）PhotoDetailBean
-- 图文分享详情JavaBean
（5）PhotoListBean
-- 首页的JavaBean
（6）SaveBean
-- 用户保存好的图文分享的JavaBean



# 有关HTTP请求的类以及使用接口

CollectFragment (http 1.获取当前登录用户收藏图文列表 /photo/collect GET)

DashboardFragment http(20.获取我的动态图片分享列表 /photo/share/myself GET)

LikeFragment http (12.获取当前登录用户点赞图文列表 /photo/like GET)

HomeFragment http(15.获取图片分享发现列表 /photo/share GET)

PhotoAddActivity (http 16.新增图文分享 /photo/share/add POST PhotoAddActivity || 11.上传文件 /photo/image/upload POST)

PhotoDetailActivity (http 2.用户对图文分享进行收藏 /photo/collect POST || 3.用户取消对图文分享的收藏 /photo/collect/cancel POST || 13.用户对图文分享进行点赞 /photo/like POST || 14.用户取消对图文分享的点赞 /photo/like/cancel POST || 19.获取单个图文分享的详情 /photo/share/detail GET || 22.保存图文分享 /photo/share/save POST)

NotificationsFragment (http 21.获取已保存的图文分享列表 /photo/share/save GET)

LoginActivity (http 24.用户登录 /photo/user/login POST)

RegisterActivity (http 25.创建用户 /photo/user/register POST)





# 使用接口合集

![image-20241012181832968](C:\Users\28613.LAPTOP-H0IGJDDN\AppData\Roaming\Typora\typora-user-images\image-20241012181832968.png)

![image-20241012181838559](C:\Users\28613.LAPTOP-H0IGJDDN\AppData\Roaming\Typora\typora-user-images\image-20241012181838559.png)

![image-20241012181846600](C:\Users\28613.LAPTOP-H0IGJDDN\AppData\Roaming\Typora\typora-user-images\image-20241012181846600.png)

![image-20241012181856421](C:\Users\28613.LAPTOP-H0IGJDDN\AppData\Roaming\Typora\typora-user-images\image-20241012181856421.png)

![image-20241012181903039](C:\Users\28613.LAPTOP-H0IGJDDN\AppData\Roaming\Typora\typora-user-images\image-20241012181903039.png)

![image-20241012181932800](C:\Users\28613.LAPTOP-H0IGJDDN\AppData\Roaming\Typora\typora-user-images\image-20241012181932800.png)

![image-20241012181954180](C:\Users\28613.LAPTOP-H0IGJDDN\AppData\Roaming\Typora\typora-user-images\image-20241012181954180.png)

![image-20241012182015662](C:\Users\28613.LAPTOP-H0IGJDDN\AppData\Roaming\Typora\typora-user-images\image-20241012182015662.png)

![image-20241012182021362](C:\Users\28613.LAPTOP-H0IGJDDN\AppData\Roaming\Typora\typora-user-images\image-20241012182021362.png)

![image-20241012182029040](C:\Users\28613.LAPTOP-H0IGJDDN\AppData\Roaming\Typora\typora-user-images\image-20241012182029040.png)

![image-20241012182004360](C:\Users\28613.LAPTOP-H0IGJDDN\AppData\Roaming\Typora\typora-user-images\image-20241012182004360.png)

![image-20241012182040881](C:\Users\28613.LAPTOP-H0IGJDDN\AppData\Roaming\Typora\typora-user-images\image-20241012182040881.png)

![image-20241012182045262](C:\Users\28613.LAPTOP-H0IGJDDN\AppData\Roaming\Typora\typora-user-images\image-20241012182045262.png)

![image-20241012182051399](C:\Users\28613.LAPTOP-H0IGJDDN\AppData\Roaming\Typora\typora-user-images\image-20241012182051399.png)

![image-20241012182056661](C:\Users\28613.LAPTOP-H0IGJDDN\AppData\Roaming\Typora\typora-user-images\image-20241012182056661.png)

