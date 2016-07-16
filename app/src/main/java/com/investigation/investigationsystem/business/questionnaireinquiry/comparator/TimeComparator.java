package com.investigation.investigationsystem.business.questionnaireinquiry.comparator;

import com.investigation.investigationsystem.business.questionnaireinquiry.bean.QusertionnaireResults;

import java.util.Comparator;

/**
 * Created by zero on 2016/7/16.
 */
public class TimeComparator implements Comparator {


    @Override
    public int compare(Object lhs, Object rhs) {

        QusertionnaireResults results1 = (QusertionnaireResults) lhs;
        QusertionnaireResults results2 = (QusertionnaireResults) rhs;
        String time1 = results1.getTime();
        String time2 = results2.getTime();



        return 0;
    }



}
