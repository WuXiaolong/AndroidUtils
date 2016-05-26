> 个人收藏的Android常用工具类

# DisplayMetricsUtil
## 获取屏幕分辨率-宽
```java
int getScreenWidth(Activity activity)
```
## 获取屏幕分辨率-高
```java
int getScreenHeight(Activity activity)
```

# AbsolutePathUtil
通过Url获取绝对路径
```java
String getAbsolutePath(final Context context, final Uri uri)
```

# DownloadUtil
调用DownloadManager下载
```java
DownloadUtil downloadUtil = new DownloadUtil(activity, downloadUrl);
//下载显示名字，不能是中文
downloadUtil.setDownloadFileName("apkName" + System.currentTimeMillis() + ".apk");
downloadUtil.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
downloadUtil.start();
```
# LogUtil
log打印类
```java
LogUtil.d("");
```
# RegexUtils
## 验证Email
```java
boolean checkEmail(String email)
```
## 验证身份证号码
```java
boolean checkIdCard(String idCard)
```
## 验证手机号码
```java
boolean checkMobile(String mobile)
```
## 验证固定电话号码
```java
 boolean checkPhone(String phone)
```
## 验证整数（正整数和负整数）
```java
boolean checkDecimals(String decimals)
```
# SharedPreferencesUtil
SharedPreferences工具类
```java
void setString(Context context, final String key,final String value)
```
# TimeUtil
时间工具类	

# VersionUtil
## 获取版本号
```java
String getVersionName(Activity activity)
```
## 获取版本code
```java
int getVersionCode(Activity activity)
```

# AppUtils
工具类集合，不好单独起名都放在AppUtils里
## MD5加密
```java
String md5(String plainText)
```
# 安装apk
```java
void installAPK(Context context, String path)
```

