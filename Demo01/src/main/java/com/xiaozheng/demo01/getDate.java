package com.xiaozheng.demo01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zyl
 * @description TODO
 * @date 2024/1/9 15:37
 */
public class getDate {
    public static void main(String[] args) {
        List<String> dates = getDates("2024-01-03","2024-01-04");
        dates.stream().forEach(System.out::println);
    }

    public static List<String> getDates(String startDate, String endDate) {
        DateTimeFormatter formatterIn = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatterOut = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate start = LocalDate.parse(startDate, formatterIn);
        LocalDate end = LocalDate.parse(endDate, formatterIn);
        List<String> dates = new ArrayList<>();

        for (LocalDate date = start; !date.isAfter(end); date = date.plusDays(1)) {
            dates.add(date.format(formatterOut));
        }

        return dates;
    }
}
