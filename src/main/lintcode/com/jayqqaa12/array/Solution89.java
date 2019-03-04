package com.jayqqaa12.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 求 gray code
 * <p>
 * 难度 2星
 *
 * @REVIEW
 */
public class Solution89 {

    /**
     * 根据公式来
     * <p>
     * G(i) = i^ (i/2).
     *
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 1 << n; i++) {
            list.add(i ^ i / 2);
        }


        return list;
    }
}
