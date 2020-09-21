package com.jzx.crowd;

import com.jzx.crowd.util.CrowdUtil;
import org.junit.Test;

/**
 * @title: CrowdUtil
 * @Author Jzxxxx
 * @Date: 2020/9/19 1:08
 * @Version 1.0
 */
public class CrowdUtilTest {

    @Test
    public void test(){
        String s = "123123";

        String s1 = CrowdUtil.md5(s);

        System.out.println(s1);
    }
}
