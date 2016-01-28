package com.lgd.regex;

/**
 * Created by liguodong on 2016/1/28.
 */
public class Main {

    public static String[] logline ={
            "123.163.239.111 analysis.tuanimg.com - [27/Jan/2016:00:00:42  0800] \"GET /oem/img/cake_v.gif?objurl=http://tejia.hao123.com/xiebao&title=鞋包饰品&px=1366*768&pp=871*79&xp=div52-div2-div-a10&area=erji-tejia-nianhuojie&cake=erji-tejia-nianhuojie&ver=1.0&v=hao123-tejia-menu-nianhuojie&cn=1&uv=0&ct=0&pt=32&t=2016-1-27-0-3-13&r=145382416109855&baidu_id=3EBE26AF0DAB554EC5BF54B4430C1F9A&deal_id= HTTP/1.1\" 200 43 \"http://tejia.hao123.com/o/a/nianhuojie\" \"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; 360SE)\" \"-\" 0.000 - .\n",
            "36.251.248.195 analysis.tuanimg.com - [27/Jan/2016:00:01:32  0800] \"GET /oem/img/cake_v.gif?objurl=http://out.zhe800.com/jump?deal_id=2826059&url=http%3A%2F%2Fshop.zhe800.com%2Fproducts%2Fze151124171129000130&jump_source=1&qd_key=uHLMk8bm&u_type=6&u_cid=0&utm_source=hao123cps&qd_wi=test&z_cid=0&title=&px=1440*900&pp=669*41987&xp=div28-div6-div-div2-div648-a2-img&area=floor1&cake=erji-tejia-yurongfu-floor1&ver=1.0&v=hao123-tejia-menu-yurongfu&cn=29&uv=1&ct=31&pt=2329&t=2016-1-27-0-1-28&r=145382102614154&baidu_id=8A7F587F883F27AF25B05460B2EF5015&deal_id=2826059 HTTP/1.1\" 200 43 \"http://tejia.hao123.com/o/a/yurongfu\" \"Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36\" \"-\" 0.000 - . \n",
            "183.64.203.205 analysis.tuanimg.com - [27/Jan/2016:00:02:18  0800] \"GET /oem/img/cake_v.gif?objurl=http://out.zhe800.com/jump?deal_id=1915348&url=http%3A%2F%2Fshop.zhe800.com%2Fproducts%2Fze150925093630000269&jump_source=1&qd_key=uHLMk8bm&u_type=2&u_cid=0&utm_source=hao123cps&qd_wi=test&z_cid=0&title=【优品汇】白巧松塔混装270g&cake=hao123-tejia-search&v=hao123-tejia-search&baiduid=DCE73876CB861F4E6D4AD7A9FD59735B&deal_id=1915348&user_version=0&r=1453824222534 HTTP/1.1\" 200 43 \"http://tejia.hao123.com/search?name=白松塔\" \"Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36\" \"-\" 0.000 - .\n",
            "36.251.248.195 analysis.tuanimg.com - [27/Jan/2016:00:03:04  0800] \"GET /oem/img/cake_v.gif?objurl=http://o.out.zhe800.com/ju/deal/meirisheng_2920233?jump_source=1&qd_key=uHLMk8bm&u_type=2&u_cid=0&utm_source=hao123cps1&qd_wi=test&z_cid=0&title=每日生机苏打饼干540g 原价22元 拍下价9.9元 多数地区包邮&cake=hao123-tejia-indexnew-tnmz&v=hao123-tejia-indexnew-tnmz&baiduid=AD0B8CCB96BDFBC5A7D51AC407C45A89&deal_id=2920233&user_version=0&r=1453824240586 HTTP/1.1\" 200 43 \"http://tejia.hao123.com/?tn=mz\" \"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36\" \"-\" 0.000 - .\n"
    };

    public static String regex = "(deal_id=)([0-9]{0,})";

    public static void main(String[] args) {

        for (int i = 0; i < logline.length; i++) {
            RegexUtils.PatternRegex(logline[i],regex);
        }
    }
}
