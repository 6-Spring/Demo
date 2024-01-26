package com.xiaozheng.demo01.utils;

/**
 * @author zyl
 * @description TODO
 * @date 2024/1/24 9:48
 */
public class ZylPageUtil {

    public static void main(String[] args) {
        int[] ints = convertPageParameters(0, 10);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }

        /**
         * Convert front end page parameters to format suitable for backend
         *
         * @param start the start index of data (0-based)
         * @param size the size of each page
         * @return an array of two integers, where the first element is the page number (1-based)
         *         and the second element is the size of each page
         */
        public static int[] convertPageParameters(int start, int size) {
            // Add 1 to the start index to make it into a 1-based page number
            int page = start / size + 1;
            return new int[] { page, size };
        }

}
