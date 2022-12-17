package Core.Strategy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Timer {
    public void check() throws ParseException {
        /*
         * 說明：營業時間為11:00:00到22:00:00，午餐時間11:00:00-14:59:59，晚餐時間15:00:00-22:00:00
         * 已打烊時間段：22:00:01-10:59:59
         * */

        //今日日期
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        //現在時間
        String nowTimeStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        //測試時請把本行註解
        Date nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(nowTimeStr);

        //自行設定現在時間(測試用)
        //Date nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date+" 22:00:01");

        //午餐時間設定
        Date lunchStartTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date+" 11:00:00");
        Date lunchEndTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date+" 14:59:59");

        //晚餐時間設定
        Date dinnerStartTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date+" 15:00:00");
        Date dinnerEndTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date+" 22:00:00");

        CurTime ad = new CurTime();
        System.out.println("現在時間>"+nowTimeStr);

        //ad.choiceStrategy(new Dinner());
        //ad.choice();


        if(isEffectiveDate(nowTime,lunchStartTime,dinnerEndTime)) {
            System.out.println("開始營業");
            //午餐
            if(isEffectiveDate(nowTime,lunchStartTime,lunchEndTime)) {
                ad.choiceStrategy(new Lunch());
                ad.choice();
            }
            //晚餐
            if(isEffectiveDate(nowTime,dinnerStartTime,dinnerEndTime)) {
                ad.choiceStrategy(new Dinner());
                ad.choice();
            }
        }
        else {
            //已打烊
            ad.choiceStrategy(new OutOfBusiness());
            ad.choice();
        }


    }


    //判斷現在時機是否在[startTime,endTime]內
    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime() || nowTime.getTime() == endTime.getTime()) {
            return true;
        }
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        }
        else{
            return false;
        }
    }
}
