> 个人收藏的Android常用工具类，每次做项目，一些常用的工具类总要重写一篇，烦死了，终于还是建了库，收藏这些常用的。

#Gradle依赖
```java
compile 'com.wuxiaolong.androidutils:androidutils:1.0.6'
```
# 功能简介
## 完全退出
​写在基类，然后每个Activity都去继承
```java
public class BaseActivity extends AppCompatActivity {
    public ActivityManagerUtil activityManagerUtil;
    public Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        mActivity = this;
        activityManagerUtil = ActivityManagerUtil.getInstance();
        activityManagerUtil.pushOneActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //结束Activity&从栈中移除该Activity
        activityManagerUtil.popOneActivity(this);
    }

}
```
需要完全退出
```
activityManagerUtil.appExit();
```

## 全局异常捕获
只要在Application 初始化即可
```java
public class AndroidUtilsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //崩溃处理
        CrashHandlerUtil crashHandlerUtil = CrashHandlerUtil.getInstance();
        crashHandlerUtil.init(this);
        crashHandlerUtil.setCrashTip("很抱歉，程序出现异常，即将退出！");
    }
}
```


## TimeUtil

### 时间戳转北京时间
```java
String unixTimestamp2BeijingTime(Object millisecond, String format)
```

### 北京时间转时间戳
```java
long beijingTime2UnixTimestamp(String beijingTime, String format)
```

## BitmapCompressUtil
图片压缩类

## ArithUtil
算术类，包括加减乘除

## AppUtils
> 工具类集合，不好单独起名都放在AppUtils里

### 指定小数输出
```java
 String decimalFormat(double s, String format)
```

### 关闭键盘
```java
void hideSoftInput(Activity activity)
```

### Bitmap转Byte
```java
byte[] bitmap2Bytes(Bitmap bitmap)
```

### MD5加密
```java
String md5(String plainText)
```

### 安装apk
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

## sp转px
```java
int sp2px(Context context, float spValue)
```

## px转sp
```java
int px2sp(Context context, float pxValue)
```
## AbsolutePathUtil
通过Url获取绝对路径
```java
String getAbsolutePath(final Context context, final Uri uri)
```

## DownloadUtil
步骤1：
```java
AndroidManifest注册
<receiver android:name="com.wuxiaolong.androidutils.library.DownloadUtil$DownloadManagerReceiver">
<intent-filter>
<action android:name="android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED"/>
<action android:name="android.intent.action.DOWNLOAD_COMPLETE"/>
</intent-filter>
</receiver>
```
步骤2：
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
## RegexUtil
### 手机号码，中间4位星号替换
```java
String phoneNoHide(String phone)
```

### 银行卡号，保留最后4位，其他星号替换
```java
String cardIdHide(String cardId)
```

### 身份证号，中间10位星号替换
```java
String idHide(String id)
```

### 是否为车牌号
```
 boolean checkVehicleNo(String vehicleNo)
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

## MediaUtil
多媒体工具类

### 打开系统拍照
``` java
void startActivityForCamera(Activity activity, int requestCode, Uri outputUri)
void startActivityForCamera(Activity activity, int requestCode)
```

### 打开系统相册
``` java
void startActivityForGallery(Activity activity, int requestCode)
```

### 打开系统裁剪
``` java
void startActivityForImageCut(Activity activity, int requestCode,
                                          Uri inputUri, Uri outputUri,
                                          int width, int height)
```

## UriUtil
Uri工具类

# 联系我
我的微信公众号：吴小龙同学，欢迎关注交流。

![](http://7q5c2h.com1.z0.glb.clouddn.com/qrcode_wuxiaolong.jpg)


# 更多交流
Android技术交流群-剩者为王⑤群：590967484

![](http://7q5c2h.com1.z0.glb.clouddn.com/qun5.png)

# 关于作者
[点击查看](http://wuxiaolong.me/about/)

# Licenses
[Apache-2.0](https://opensource.org/licenses/apache2.0.php)
