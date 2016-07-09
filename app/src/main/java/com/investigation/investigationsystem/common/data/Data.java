package com.investigation.investigationsystem.common.data;

/**
 * Created by zero on 2016/7/7.
 */
public class Data {

    /**
     * 登录数据
     * 修改密码数据
     * 更新团队信息数据
     */
    public static String loginData = "{\n" +
            "    \"result\": 1,\n" +
            "    \"updateTime\": \"20160422152017123456\",\n" +
            "    \"name\": \"de\",\n" +
            "    \"password\": \"pad\",\n" +
            "    \"userID\": \" e717e1160ceb40c7ada2bf3e9ccaa572\",\n" +
            "    \"teamList\": [\n" +
            "        {\n" +
            "            \"teamName\": \"你猜\",\n" +
            "            \"teamID\": \"e717e1160ceb40c7ada2bf3e9ccaa57e\",\n" +
            "            \"profession\": \"你猜,我不告诉你\",\n" +
            "            \"teamQuestionnaire\": [\n" +
            "                {\n" +
            "                    \"questionnaireID\": \"e717e1160ceb40c7ada2bf3e9ccaa57e\",\n" +
            "                    \"questionnaireTitle\": \"e717e1160ceb40c7ada2bf3e9ccaa572\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"questionnaireID\": \"e717e1160ceb40c7ada2bf3e9ccaa57e\",\n" +
            "                    \"questionnaireTitle\": \"e717e1160ceb40c7ada2bf3e9ccaa572\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"teamArea\": [\n" +
            "                {\n" +
            "                    \"areaName\": \"你猜\",\n" +
            "                    \"areaID\": \"e717e1160ceb40c7ada2bf3e9ccaa57e\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"areaName\": \"你猜\",\n" +
            "                    \"areaID\": \"e717e1160ceb40c7ada2bf3e9ccaa572\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"teamName\": \"你猜\",\n" +
            "            \"teamID\": \"e717e1160ceb40c7ada2bf3e9ccaa57e\",\n" +
            "            \"profession\": \"你猜我不告诉你\",\n" +
            "            \"teamQuestionnaire\": [\n" +
            "                {\n" +
            "                    \"questionnaireID\": \"e717e1160ceb40c7ada2bf3e9ccaa57e\",\n" +
            "                    \"questionnaireTitle\": \"e717e1160ceb40c7ada2bf3e9ccaa572\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"questionnaireID\": \"e717e1160ceb40c7ada2bf3e9ccaa57e\",\n" +
            "                    \"questionnaireTitle\": \"e717e1160ceb40c7ada2bf3e9ccaa572\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"teamArea\": [\n" +
            "                {\n" +
            "                    \"areaName\": \"你猜\",\n" +
            "                    \"areaID\": \"e717e1160ceb40c7ada2bf3e9ccaa57e\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"areaName\": \"你猜\",\n" +
            "                    \"areaID\": \"e717e1160ceb40c7ada2bf3e9ccaa572\"\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";


    /**
     * 提交问卷数据
     */
    public static String answer = "{\n" + "\"size\": 2,\n" +
            "    \"qusertionnaireResultList\": [\n" +
            "        {\n" +
            "            \"qusertionnaireResult\": {\n" +
            "                \"teamID\": \" e717e1160ceb40c7ada2bf3e9ccaa57e \",\n" +
            "                \"areaID\": \"e717e1160ceb40c7ada2bf3e9ccaa57e\",\n" +
            "                \"userID\": \"e717e1160ceb40c7ada2bf3e9ccaa57e\",\n" +
            "                \"questionnaireID\": \"e717e1160ceb40c7ada2bf3e9ccaa57e\",\n" +
            "                \"time\": \"2016-05-01 11:11:12\",\n" +
            "                \"name\": \"小明\",\n" +
            "                \"iDNO\": \"120111199901011234\",\n" +
            "                \"female\": 1,\n" +
            "                \"age\": 85,\n" +
            "                \"nation\": \"汉\",\n" +
            "                \"tel\": \"13538763676\",\n" +
            "                \"address\": \"天津市南开区\",\n" +
            "                \"address2\": \"北京市朝阳区\",\n" +
            "                \"contact\": \"小华\",\n" +
            "                \"contactTel\": \"13854323675\",\n" +
            "                \"relation\": \"兄弟\"\n" +
            "            },\n" +
            "            \"questionnaireResultContent\": [\n" +
            "                {\n" +
            "                    \"questionID\": \" e717e1160ceb40c7ada2bf3e9ccaa57e\",\n" +
            "                    \"resultContent\": [\n" +
            "                        \"asdf5\",\n" +
            "                        \"asdf5\"\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"questionID \": \"7717e1160ceb40c7ada2bf3e9ccaa57e\",\n" +
            "                    \"resultContent\": \"asdf5\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"qusertionnaireResult\": {\n" +
            "                \"teamID\": \" e717e1160ceb40c7ada2bf3e9ccaa57e \",\n" +
            "                \"areaID\": \"e717e1160ceb40c7ada2bf3e9ccaa57e\",\n" +
            "                \"userID\": \"e717e1160ceb40c7ada2bf3e9ccaa57e\",\n" +
            "                \"questionnaireID\": \"e717e1160ceb40c7ada2bf3e9ccaa57e\",\n" +
            "                \"time\": \"2016-05-01 11:11:12\",\n" +
            "                \"name\": \"小明\",\n" +
            "                \"iDNO\": \"120111199901011234\",\n" +
            "                \"female\": 1,\n" +
            "                \"age\": 85,\n" +
            "                \"nation\": \"汉\",\n" +
            "                \"tel\": \"13538763676\",\n" +
            "                \"address\": \"天津市南开区\",\n" +
            "                \"address2\": \"北京市朝阳区\",\n" +
            "                \"contact\": \"小华\",\n" +
            "                \"contactTel\": \"13854323675\",\n" +
            "                \"relation\": \"兄弟\"\n" +
            "            },\n" +
            "            \"questionnaireResultContent\": [\n" +
            "                {\n" +
            "                    \"questionID\": \" e717e1160ceb40c7ada2bf3e9ccaa57e\",\n" +
            "                    \"resultContent\": \"asdf5\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"questionID \": \"7717e1160ceb40c7ada2bf3e9ccaa57e\",\n" +
            "                    \"resultContent\": [\n" +
            "                        \"asdf5\",\n" +
            "                        \"asdf5\"\n" +
            "                    ]\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";


}
