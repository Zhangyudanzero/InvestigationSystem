package com.investigation.investigationsystem.business.emphases.bean;

import java.util.List;

/**
 * Created by zero on 2016/7/10.
 */
public class TeamList {

        private String teamname;
        private String teamID;
        /**
         * areaname : 小区
         * areaID : 1e93c7c51c824d3cab14ef2af4621124
         * monitoringlist : [{"name":"你猜","iDNO":"120111199901011234","female":1,"age":37,"nation":"汉","address":"天津市南开区","address2":"北京市朝阳区","disease":"尘肺","tutelageFreq":"每周一次","tutelageWay":"住院","tutelageContent":"心律","doctor":"张生","time":"2016/3/2"},{"name":"你猜","iDNO":"120111199901011234","female":1,"age":37,"nation":"汉","address":"天津市南开区","address2":"北京市朝阳区","disease":"尘肺","tutelageFreq":"每周一次","tutelageWay":"住院","tutelageContent":"心律","doctor":"张生","time":"2016/3/2"}]
         */

        private List<arealist> arealist;

        public String getTeamname() {
            return teamname;
        }

        public void setTeamname(String teamname) {
            this.teamname = teamname;
        }

        public String getTeamID() {
            return teamID;
        }

        public void setTeamID(String teamID) {
            this.teamID = teamID;
        }

        public List<arealist> getArealist() {
            return arealist;
        }

        public void setArealist(List<arealist> arealist) {
            this.arealist = arealist;
        }


    }
