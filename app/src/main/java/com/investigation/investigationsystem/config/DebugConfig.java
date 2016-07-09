package com.investigation.investigationsystem.config;

/**
 * ==========================================
 * <p/>
 * 版    权 ： 北京爱接力科技有限公司
 * <p/>
 * 作    者 ： iwen
 * <p/>
 * 版    本 ： 1.0
 * <p/>
 * 创建日期 ： on 2016/7/9  23:50
 * <p/>
 * 描    述 ：
 * 调试接口路径
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class DebugConfig implements IConfig {
    @Override
    public String getBaseUrl() {
        return "http://192.168.1.101:8080/wenjuan";
    }
}
