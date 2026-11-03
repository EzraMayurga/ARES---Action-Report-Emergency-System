package com.ares;

public class RewardController {

    public void addPointsToUser(User user, int points) {
        user.addPoints(points);
    }

    public boolean claimReward(User user, int rewardIndex) {
        if (rewardIndex < 0 || rewardIndex >= Database.getRewards().size()) {
            return false;
        }

        Reward selected = Database.getRewards().get(rewardIndex);
        if (user.getPoints() >= selected.getPointsRequired()) {
            user.setPoints(user.getPoints() - selected.getPointsRequired());
            return true;
        }
        return false;
    }
}