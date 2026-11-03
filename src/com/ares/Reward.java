package com.ares;

public class Reward {
    private String rewardType;
    private int pointsRequired;

    public Reward(String rewardType, int pointsRequired) {
        this.rewardType = rewardType;
        this.pointsRequired = pointsRequired;
    }

    public String getRewardType() { return rewardType; }
    public int getPointsRequired() { return pointsRequired; }
}