package com.nini.menu;

import static org.junit.Assert.assertEquals;


import static Core.Strategy.Timer.isEffectiveDate;

import org.junit.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Core.Strategy.CurTime;
import Core.Strategy.Dinner;
import Core.Strategy.Lunch;
import Core.Strategy.OutOfBusiness;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TimerUnitTest {
    @Test
    public void TimerTest() throws ParseException {
        /*
         * 說明：營業時間為11:00:00到22:00:00，午餐時間11:00:00-14:59:59，晚餐時間15:00:00-22:00:00
         * 已打烊時間段：22:00:01-10:59:59
         * */

        //今日日期
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        //午餐時間設定
        Date lunchStartTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date + " 11:00:00");
        Date lunchEndTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date + " 14:59:59");
        //晚餐時間設定
        Date dinnerStartTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date + " 15:00:00");
        Date dinnerEndTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date + " 22:00:00");

        //自行設定現在時間(測試午餐)
        Date nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date + " 12:00:00");
        CurTime ad = new CurTime();
        System.out.println("現在時間>" + nowTime);
        if (isEffectiveDate(nowTime, lunchStartTime, dinnerEndTime)) {
            System.out.println("開始營業");
            //午餐
            if (isEffectiveDate(nowTime, lunchStartTime, lunchEndTime)) {
                ad.choiceStrategy(new Lunch());
                ad.choice();
            }
            //晚餐
            if (isEffectiveDate(nowTime, dinnerStartTime, dinnerEndTime)) {
                ad.choiceStrategy(new Dinner());
                ad.choice();
            }
        } else {
            //已打烊
            ad.choiceStrategy(new OutOfBusiness());
            ad.choice();
        }
        //自行設定現在時間(測試晚餐)
        nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date + " 18:00:00");
        ad = new CurTime();
        System.out.println("現在時間>" + nowTime);
        if (isEffectiveDate(nowTime, lunchStartTime, dinnerEndTime)) {
            System.out.println("開始營業");
            //午餐
            if (isEffectiveDate(nowTime, lunchStartTime, lunchEndTime)) {
                ad.choiceStrategy(new Lunch());
                ad.choice();
            }
            //晚餐
            if (isEffectiveDate(nowTime, dinnerStartTime, dinnerEndTime)) {
                ad.choiceStrategy(new Dinner());
                ad.choice();
            }
        } else {
            //已打烊
            ad.choiceStrategy(new OutOfBusiness());
            ad.choice();
        }
        //自行設定現在時間(測試打烊)
        nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date + " 23:00:00");
        ad = new CurTime();
        System.out.println("現在時間>" + nowTime);
        if (isEffectiveDate(nowTime, lunchStartTime, dinnerEndTime)) {
            System.out.println("開始營業");
            //午餐
            if (isEffectiveDate(nowTime, lunchStartTime, lunchEndTime)) {
                ad.choiceStrategy(new Lunch());
                ad.choice();
            }
            //晚餐
            if (isEffectiveDate(nowTime, dinnerStartTime, dinnerEndTime)) {
                ad.choiceStrategy(new Dinner());
                ad.choice();
            }
        } else {
            //已打烊
            ad.choiceStrategy(new OutOfBusiness());
            ad.choice();
        }
    }

}