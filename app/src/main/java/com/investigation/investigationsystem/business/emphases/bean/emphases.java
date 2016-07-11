package com.investigation.investigationsystem.business.emphases.bean;

import java.util.List;

/**
 * 重点监测对象
 * <p/>
 * Created by zero on 2016/7/10.
 */
public class emphases {

    /**
     * teamname : x团队
     * teamID : 1e93c7c51c824d3cab14ef2af4621124
     * MonitoringArea : [{"areaname":"小区","areaID":"1e93c7c51c824d3cab14ef2af4621124","monitoringlist":[{"name":"你猜","iDNO":"120111199901011234","female":1,"age":37,"nation":"汉","address":"天津市南开区","address2":"北京市朝阳区","disease":"尘肺","tutelageFreq":"每周一次","tutelageWay":"住院","tutelageContent":"心律","doctor":"张生","time":"2016/3/2"},{"name":"你猜","iDNO":"120111199901011234","female":1,"age":37,"nation":"汉","address":"天津市南开区","address2":"北京市朝阳区","disease":"尘肺","tutelageFreq":"每周一次","tutelageWay":"住院","tutelageContent":"心律","doctor":"张生","time":"2016/3/2"}]}]
     */
    private String result;
    private List<MonitoringTeam> teamlist;

    @Override
    public String toString() {
        return "emphases{" +
                "result='" + result + '\'' +
                ", teamlist=" + teamlist +
                '}';
    }

    public List<MonitoringTeam> getTeamlist() {
        return teamlist;
    }

    public void setTeamlist(List<MonitoringTeam> teamlist) {
        this.teamlist = teamlist;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}