package jian_zhi_offer.p0060_dices_probability;

import java.util.Arrays;

public class DicesProbability {
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int k = 2; k <= n; k++) {
            double[] tmp = new double[5 * k + 1];
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < 6; j++) {
                    tmp[i + j] += dp[i] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }
}
