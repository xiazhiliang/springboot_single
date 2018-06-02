package com.fly.caipiao.comment;

import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author baidu
 * @date 2018/5/31 下午4:02
 * @description ${TODO}
 **/
public class DateTest extends BaseTest {

    @Test
    public void testDate(){
        LocalDate date = LocalDate.now().plusDays(-1).plus(10,ChronoUnit.DAYS);
        System.err.println(date);
    }
}
