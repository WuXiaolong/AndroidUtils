> 个人收藏的Android常用工具类，每次做项目，一些常用的工具类总要重写一篇，烦死了，终于还是建了库，收藏这些常用的。

#Gradle依赖
```java
compile 'com.wuxiaolong.androidutils:androidutils:1.0.2'
```
# 功能简介

## AppUtils
工具类集合，不好单独起名都放在AppUtils里
### MD5加密
```java
String md5(String plainText)
```

## 安装apk
```java
void installAPK(Context context, String path)
```

### 直接拨号，需要增加CALL_PHONE权限
```java
void actionCall(Context context, String phone)
```

### 跳到拨号盘-拨打电话
```
void actionDial(Context context, String phone)
```
## DisplayMetricsUtil
### 获取屏幕分辨率-宽
```java
int getScreenWidth(Context context)
```
### 获取屏幕分辨率-高
```java
int getScreenHeight(Context context)
```
### 根据手机的分辨率从 dp 的单位 转成为 px(像素)
```java
int dip2px(Context context, float dpValue)
```
### 根据手机的分辨率从 px(像素) 的单位 转成为 dp
```java
int px2dip(Context context, float pxValue)
```

## AbsolutePathUtil
通过Url获取绝对路径
```java
String getAbsolutePath(final Context context, final Uri uri)
```

## DownloadUtil
调用DownloadManager下载
```java
DownloadUtil downloadUtil = new DownloadUtil(content, downloadUrl);
//下载显示名字，不能是中文
downloadUtil.setDownloadFileName("apkName" + System.currentTimeMillis() + ".apk");
downloadUtil.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
downloadUtil.start();
```
## LogUtil
log打印类
```java
LogUtil.d("");
```
## RegexUtils
### 手机号码，中间4位星号替换
```java
String phoneNoHide(String phone)
```
### 银行卡号，保留最后4位，其他星号替换
```java
String cardIdHide(String cardId)
```
### 验证Email
```java
boolean checkEmail(String email)
```
### 验证身份证号码
```java
boolean checkIdCard(String idCard)
```
### 验证手机号码
```java
boolean checkMobile(String mobile)
```
### 验证固定电话号码
```java
 boolean checkPhone(String phone)
```
### 验证整数（正整数和负整数）
```java
boolean checkDecimals(String decimals)
```
## SharedPreferencesUtil
SharedPreferences工具类
```java
void setString(Context context, final String key,final String value)
```
## TimeUtil
时间工具类	

## VersionUtil
### 获取版本号
```java
String getVersionName(Context context)
```
### 获取版本code
```java
int getVersionCode(Context context)
```
# AndroidProgrammer
我的微信公众号：Android高手进阶之路，让我们共同学习，每天进步一点点。欢迎微信扫一扫关注。
![](http://7q5c2h.com1.z0.glb.clouddn.com/qrcode_AndroidProgrammer.jpg)

# 关于作者
[点击查看](http://wuxiaolong.me/about/)
