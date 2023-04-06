package com.capgemini.tuto.dto;

import java.io.Serializable;

public class StatusResponse implements Serializable {

    private boolean verified;
    private String feedback;
    private int sentCount;

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getSentCount() {
        return sentCount;
    }

    public void setSentCount(int sentCount) {
        this.sentCount = sentCount;
    }

}
