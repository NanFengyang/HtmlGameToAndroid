package com.nanfeng.weixintestapplication;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Html解析类
 * Created by yangyoutao on 2016/11/30.
 */

public class HtmlAnalysis {
    private static final String iconTag = "background-image:url(";
    private static final String filePathPrent = "game/";

    public static List<GameBean> analysisMenuList(String htmlStr) {
        List<GameBean> mlist = new ArrayList<>();
        Document document = Jsoup.parse(htmlStr);
        Element gameBody = document.getElementsByClass("gameList").get(0);
        Elements gamelist = gameBody.getElementsByTag("a");
        Log.i("HtmlAnalysis", "gamelist:" + gamelist.size());
        for (int i = 0; i < gamelist.size() - 1; i++) {
            Element element = gamelist.get(i);
            GameBean gameBean = new GameBean();
            String path = element.attr("href");
            Element iconE = element.getElementsByClass("icon").get(0);
            String iconS = iconE.attr("style");
            gameBean.iconpath = filePathPrent + iconS.substring(iconTag.length(), iconS.length() - 2);
            Element name = element.getElementsByTag("p").first();
            gameBean.name = name.text();
            gameBean.filePath = filePathPrent + path;

            mlist.add(gameBean);
            Log.i("HtmlAnalysis", "  gameBean.name :" + gameBean.name + "-- gameBean.filePath:" + gameBean.filePath + "-- gameBean.iconpath:" + gameBean.iconpath);
        }
        return mlist;
    }

}
