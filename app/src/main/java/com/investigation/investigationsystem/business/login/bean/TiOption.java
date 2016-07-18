package com.investigation.investigationsystem.business.login.bean;

import java.io.Serializable;

public class TiOption implements Serializable {
    public String optionContent;
    public String optionNO;

    public TiOption() {
    }

    public TiOption(String optionContent, String optionNO) {
        this.optionContent = optionContent;
        this.optionNO = optionNO;
    }

    public String getOptionContent() {
        return optionContent;
    }

    public void setOptionContent(String optionContent) {
        this.optionContent = optionContent;
    }

    public String getOptionNO() {
        return optionNO;
    }

    public void setOptionNO(String optionNO) {
        this.optionNO = optionNO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TiOption tiOption = (TiOption) o;

        if (optionContent != null ? !optionContent.equals(tiOption.optionContent) : tiOption.optionContent != null)
            return false;
        return optionNO != null ? optionNO.equals(tiOption.optionNO) : tiOption.optionNO == null;

    }

    @Override
    public int hashCode() {
        int result = optionContent != null ? optionContent.hashCode() : 0;
        result = 31 * result + (optionNO != null ? optionNO.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TiOption{" +
                "optionContent='" + optionContent + '\'' +
                ", optionNO='" + optionNO + '\'' +
                '}';
    }
}