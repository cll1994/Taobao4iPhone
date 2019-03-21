package com.taobao.qa.wireless.ui.live.taobaotestcase;

import com.alibaba.fastjson.JSON;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.taobao.qa.wireless.base.Base;
import com.taobao.qa.wireless.baseIOS10.BaseIOS10;
import com.taobao.qa.wireless.ui.constant.TimeConstant;
import com.thoughtworks.selenium.webdriven.commands.GetText;
import org.junit.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wanhu on 2018/10/30.
 */
public class TestSkillPage extends BaseIOS10 {

    @BeforeClass
    public static void beforeClassDO() throws Exception {
    }

    @Before
    public static void doBefore() throws Exception {

    }
    @After
    public static void doAfter() throws Exception {
    }

    @AfterClass
    public static void afterClass() {

    }
    @Test
    public void  test1() throws Exception {
        driver.waitForElementByName("技能").click();
        testRecommend("技能");
        driver.elementByName("娱乐").click();
        testRecommend("技能页娱乐");
        driver.elementByName("最新发布").click();
        testRecommend("技能最新发布");
        driver.elementById("com.alibaba.ailabs.tg:id/item_btn_try").click();
        testRecommend("技能最新发布页的尝试");
        driver.elementById("\n" +
            "com.alibaba.ailabs.tg:id/btn_next_step").click();
        testRecommend("下一步");
        driver.drag(200,1500,200,20,3,1);
        testRecommend("最新发布下滑");
        driver.elementById("com.alibaba.ailabs.tg:id/tg_ar_entry");
        testRecommend("返回技能页");

    }
       @Test
//    pageName 页面名称
    public void testRecommend(String pageName) throws Exception {
        //driver.elementByName("技能").click();
        // driver.waitForElementByName("技能").click();
//        driver.elementByName("娱乐").click();
       // driver.elementById("com.alibaba.ailabs.tg:id/item_btn_try").click();

        //driver.elementByName("详情").click();
       // driver.elementById("com.alibaba.ailabs.tg:id/banner_image").click();
      //  Assert.assertFalse(driver.elementById("com.alibaba.ailabs.tg:id/va_my_nav_bar_title").getText().isEmpty());
       // driver.elementById("com.alibaba.ailabs.tg:id/va_nav_bar_left").click();
        Thread.sleep(TimeConstant.WAIT_TIME * 2);	//首次启动，或切换帐号时，延时补偿

        File classScreenCaptureDir = new File(Base.TEST_FAIL_SCREEN_CAPTURE );
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
        Date date =new Date();
        File screenCaptureFile = new File(classScreenCaptureDir,"android"+pageName+sdf.format(date) + ".png");
        driver.saveScreenshot(screenCaptureFile.getAbsolutePath());
        long start = System.currentTimeMillis();
//
        PutObjectResult uploadResult = ossClient.putObject(new PutObjectRequest(bucketName, "Android"+pageName+sdf.format(date),screenCaptureFile));
        System.out.println("=====" + JSON.toJSONString(uploadResult)+ " cost " + (System.currentTimeMillis()-start) + " ms");




        //File downloadFile = new File(classScreenCaptureDir,"ccc" + ".png");
        //if(downloadFile.exists()) {
           // downloadFile.delete();
        //}
       // start = System.currentTimeMillis();
        //ObjectMetadata downloadResult = ossClient.getObject(new GetObjectRequest(bucketName, "001"), new File(classScreenCaptureDir,"ccc" + ".png"));
        //System.out.println("=====" + downloadResult.getContentLength() + " cost " + (System.currentTimeMillis()-start) + " ms");



    }

    @Test
    public void testskillfabu() throws Exception{
        driver.elementByName("技能").click();
        driver.elementById("com.alibaba.ailabs.tg:id/frag_skill_list_theme_tv_more").click();
        driver.elementById("com.alibaba.ailabs.tg:id/item_btn_try").click();



    }
    @Test
    public void homePagetuijian()throws Exception{
        driver.elementByName("首页").click();
        driver.elementByName("推荐").click();
        testRecommend("首页推荐页截图1");
        driver.elementById("com.alibaba.ailabs.tg:id/tg_content_home_fragment_container_banner").click();
        testRecommend("banner页");
        driver.elementById("com.alibaba.ailabs.tg:id/va_nav_bar_left").click();
        driver.elementById("com.alibaba.ailabs.tg:id/tg_content_home_entrance_item_group2").click();
        testRecommend("首页随便点进去1");
        driver.elementById("com.alibaba.ailabs.tg:id/va_nav_bar_left").click();
        driver.drag(350,1500,200,20,3,1);
        testRecommend("首页推荐页截图2");
        driver.elementById("com.alibaba.ailabs.tg:id/tg_content_common_item_title_more").click();
        testRecommend("首页随便点进去2");
        driver.elementById("com.alibaba.ailabs.tg:id/va_my_title_bar_back").click();
        driver.drag(350,1500,200,20,3,1);
        testRecommend("首页截图3");
        driver.elementById("com.alibaba.ailabs.tg:id/tg_content_common_item_title_more").click();
        testRecommend("首页随便点进去3");
        driver.elementById("com.alibaba.ailabs.tg:id/va_my_title_bar_back").click();
        driver.drag(350,1500,200,20,3,1);
        testRecommend("首页截图4");
        driver.elementById("com.alibaba.ailabs.tg:id/tg_content_common_item_title_more").click();
        testRecommend("首页随便点进去4");
        driver.elementById("com.alibaba.ailabs.tg:id/va_my_title_bar_back").click();
    }

    public void testEntertainment() throws Exception {

        driver.waitForElementByName("娱乐").click();
        driver.elementByName("最新发布").click();
        Assert.assertFalse(driver.elementById("com.alibaba.ailabs.tg:id/item_tv_name").getText().isEmpty());
        driver.elementByName("最火技能").click();
        Assert.assertFalse(driver.elementById("com.alibaba.ailabs.tg:id/item_tv_name").getText().isEmpty());



    }

    @Test
    public void testRank() throws Exception {

        driver.waitForElementByName("com.alibaba.ailabs.tg:id/frag_skill_list_theme_tv_more").click();
        Assert.assertFalse(driver.elementById("com.alibaba.ailabs.tg:id/item_tv_name").getText().isEmpty());


    }


}
