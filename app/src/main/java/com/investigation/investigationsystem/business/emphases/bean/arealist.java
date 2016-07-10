package com.investigation.investigationsystem.business.emphases.bean;

import java.util.List;

/**
 * Created by zero on 2016/7/10.
 */
public class arealist {

        private String areaname;
        private String areaID;
        /**
         * name : 你猜
         * iDNO : 120111199901011234
         * female : 1
         * age : 37
         * nation : 汉
         * address : 天津市南开区
         * address2 : 北京市朝阳区
         * disease : 尘肺
         * tutelageFreq : 每周一次
         * tutelageWay : 住院
         * tutelageContent : 心律
         * doctor : 张生
         * time : 2016/3/2
         */

        private List<Monitoringlist> monitoringlist;

        public String getAreaname() {
            return areaname;
        }

        public void setAreaname(String areaname) {
            this.areaname = areaname;
        }

        public String getAreaID() {
            return areaID;
        }

        public void setAreaID(String areaID) {
            this.areaID = areaID;
        }

        public List<Monitoringlist> getMonitoringlist() {
            return monitoringlist;
        }

        public void setMonitoringlist(List<Monitoringlist> monitoringlist) {
            this.monitoringlist = monitoringlist;
        }

}
