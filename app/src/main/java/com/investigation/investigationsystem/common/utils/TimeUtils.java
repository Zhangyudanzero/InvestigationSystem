package com.investigation.investigationsystem.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zero on 2016/7/20.
 */
public class TimeUtils {

    /**
     * 获取当前时间2016-05-01 11:11:12
     */
    public static String getCurrentTiem(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

}
