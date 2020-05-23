package com.zy.snow.study.string;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 判断两个字符串中含有几个相同字符
 *
 * @Description: com.zy.snow.study.string
 * @author: Snow
 * @Date: 2020/5/22
 */
@Builder
@Slf4j
public class DetermineStringsSame {

    public static void main(String[] args) {
        DetermineStringsSame obj = DetermineStringsSame.builder().build();
        String arg0 = "abcdefg";
        String arg1 = "gahbxczdy";
        //将字符串转化成数组
        int countArrays = obj.arrays(arg0, arg1);
        log.info("将字符串转化成数组:{}", countArrays);
        //StringApi方法CharAt()
        int countByStringApi = obj.StringApiCharAt(arg0, arg1);
        log.info("StringApi方法CharAt():{}", countByStringApi);
        //HashMap方法getOrDefault()
        int countByHashMap = obj.hashMapByGetOrDefault(arg0, arg1);
        log.info("HashMap方法getOrDefault():{}", countByHashMap);
        //正则表达式
        int countByRegex = obj.regex(arg0, arg1);
        log.info("正则表达式:{}", countByRegex);
        //HashSet的contain()方法
        int countByHashSet = obj.countByHashSet(arg0, arg1);
        log.info("HashSet的contain()方法:{}", countByHashSet);
    }

    //统计次数
    private int count = 0;

    /**
     * 将字符串转化成数组
     *
     * @param args
     * @return
     */
    private int arrays(String... args) {
        //字符串转数组
        char[] aChar = args[0].toCharArray();
        char[] bChar = args[1].toCharArray();
        for (int i = 0; i < aChar.length; i++) {
            for (int j = 0; j < bChar.length; j++) {
                if (aChar[i] == bChar[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * StringApi方法CharAt()
     *
     * @param args
     * @return
     */
    private int StringApiCharAt(String... args) {
        count = 0;
        String a = args[0];
        String b = args[1];
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (b.charAt(j) == a.charAt(i)) {
                    count += 1;
                }
            }
        }
        return count;
    }

    /**
     * HashMap方法getOrDefault()
     *
     * @param args
     * @return
     */
    private int hashMapByGetOrDefault(String... args) {
        //初始化统计次数
        count = 0;
        String a = args[0];
        String b = args[1];
        Map<Character, Integer> map = new HashMap<>();
        for (char c : a.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < b.length(); i++) {
            //如果map中没有相同于a的字符就取默认值0,有则取map的value值1,并count自增
            count += map.getOrDefault(b.charAt(i), 0);
        }

        return count;
    }

    /**
     * 正则表达式
     *
     * @param args
     * @return
     */
    private int regex(String... args) {
        return args[0].replaceAll("[^" + args[1] + "]", "").length();
    }

    /**
     * HashSet的contain()方法
     *
     * @param args
     * @return
     */
    private int countByHashSet(String... args) {
        String a = args[0];
        String b = args[1];
        count = 0;
        Set<Character> set = new HashSet<>();
        for (char c : b.toCharArray()) {
            set.add(c);
        }
        for (char c : a.toCharArray()) {
            if (set.contains(c)) {
                count++;
            }
        }
        return count;
    }
}
