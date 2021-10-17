package com.mark.twoweek.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sun
 * @date 2021-10-16 16:50
 */
public class _2_LC_874 {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Long> obs = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obs.add(calHash(obstacle));
        }
        int x = 0, y = 0;
        int dir = 0; // N = 0, E = 1, S = 2, W = 3
        // 1、方向表示
        // (dir + 1) % 4 右转
        // (dir - 1 + 4) % 4 左转
        // 2、网格中行走题目，技巧：方向数组
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int ans = 0;
        for (int command : commands) {
            if (command == -1) {
                dir = (dir + 1) % 4;
            } else if (command == -2) {
                dir = (dir + 3) % 4;
            } else {
                for (int i = 0; i < command; i++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    if (obs.contains(calHash(new int[]{nx, ny}))) {
                        break;
                    }
                    x = nx;
                    y = ny;
                    ans = Math.max(x * x + y * y, ans);
                }

            }
        }
        return ans;
    }

    private long calHash(int[] obstacle) {
        // 36亿int会溢出，所以需要强转long
        return (long) (obstacle[0] + 30000) * 60001 + obstacle[1] + 30000;
    }

    public static void main(String[] args) {
        new _2_LC_874().robotSim(new int[]{4, -1, 4, -2, 4}, new int[][]{{2, 4}});
    }
}
