package com.investigation.investigationsystem.business.suggest.bean;

import java.util.List;

/**
 * Created by zero on 2016/7/10.
 */
public class SuggestInfo {

    private int size;
    private java.util.List<FeedBack> feedbackList;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<FeedBack> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<FeedBack> feedbackList) {
        this.feedbackList = feedbackList;
    }
}
