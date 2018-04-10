package com.lib.controller;

import com.alibaba.fastjson.JSONObject;
import com.lib.base.OrderBy;
import com.lib.model.LibBookborrow;
import com.lib.model.LibBookinfo;
import com.lib.model.vo.LibBookborrowVO;
import com.lib.model.vo.LibBookinfoVO;
import com.lib.service.*;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JONEYAN on 2018/3/22.
 */
@Controller
@RequestMapping("maintain")
public class MainController {
    @Autowired
    private LibReaderService libReaderService;

    @Autowired
    private LibBookinfoService libBookinfoService;
    @Autowired
    private LibBookborrowService libBookborrowService;
    @Autowired
    private LibManagerService libManagerService;

    @RequestMapping("statistics")
    public String getStatistics(HttpServletRequest request,Model model){
        Integer count = libReaderService.countRecentReader();
        //新读者
        model.addAttribute("readercount",count);
        LibBookborrowVO libBookborrowVO = new LibBookborrowVO();
        libBookborrowVO.setStatus(2);
        //借出数量
        int count1 = libBookborrowService.count(libBookborrowVO);
        model.addAttribute("borrowcount",count1);
        //新入图书数量
        Integer count2 = libBookinfoService.countRecentBook(null);
        model.addAttribute("newbookcount",count2);

        //书籍总数
        LibBookinfoVO libBookinfoVO = new LibBookinfoVO();
        libBookinfoVO.setStatus(1);
        int count3 = libBookinfoService.count(libBookinfoVO);
        model.addAttribute("booktotalcount",count3);
        //每月借出书籍数量
        List<Integer> mothlist = libBookborrowService.getEveryMothBorrow();
        Integer totalcount=0;
        ArrayList<MothBean> mothBeenList = new ArrayList<>();
        for (Integer item:mothlist){
            totalcount+=item;
        }
        int i=1;
        for (Integer item:mothlist){

            MothBean mothBean = new MothBean();
            mothBean.setCount(item);
            mothBean.setRadio(item/totalcount);
            mothBean.setFinalradio();

            switch (i){
                case 1: mothBean.setMonth("一月");break;
                case 2: mothBean.setMonth("二月");break;
                case 3: mothBean.setMonth("三月");break;
                case 4: mothBean.setMonth("四月");break;
                case 5: mothBean.setMonth("五月");break;
                case 6: mothBean.setMonth("六月");break;
                case 7: mothBean.setMonth("七月");break;
                case 8: mothBean.setMonth("八月");break;
                case 9: mothBean.setMonth("九月");break;
                case 10: mothBean.setMonth("十月");break;
                case 11: mothBean.setMonth("十一月");break;
                case 12: mothBean.setMonth("十二月");break;
                default:break;
            }
            mothBeenList.add(mothBean);
            i++;
        }
        model.addAttribute("monthlist",mothBeenList);

        //书籍的借书排行
        List<LibBookborrowVO> toplist =  libBookborrowService.getBorrowListTopFive();
        Double total=0.0;
        for (LibBookborrowVO  lib:toplist){
            total+=lib.getTotalBorrow();
        }
        for (LibBookborrowVO  lib:toplist){
            lib.setPecent((lib.getTotalBorrow()/total)*100+"%");
        }
        model.addAttribute("topfivelist",toplist);
        OrderBy orderBy = new OrderBy();
        orderBy.add("intime",false);
        //最近的书籍
        List<LibBookinfoVO> recentBooks = libBookinfoService.getNewFiveTop();
        model.addAttribute("recentbooks",recentBooks);

        List<LibBookinfoVO> bookList = libBookborrowService.getNewFiveTop();
        model.addAttribute("bookTop",bookList);
        JSONObject weather = getWeather();
        model.addAttribute("weather",weather);

        return "index2";
    }

    /**
     * 获取天气方法
     * @return
     */
    public JSONObject getWeather(){

        String param = "key=c8926378e8b04f38903d0c76f89b3c2e&location=杭州&now?";
        StringBuilder sb = new StringBuilder();
        InputStream is=null;
        BufferedReader br=null;
        PrintWriter out =null;
        JSONObject o=null;
        try {
            //接口地址
            String            url        = "https://free-api.heweather.com/s6/weather";
            URL uri        = new URL(url);
            HttpURLConnection connection= (HttpURLConnection) uri.openConnection();
            connection.setRequestMethod("POST");
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(10000);
            connection.setRequestProperty("accept", "*/*");
            //发送参数
            connection.setDoOutput(true);
            out = new PrintWriter(connection.getOutputStream());
            out.print(param);
            out.flush();
            //接收结果
            is = connection.getInputStream();
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String         line;
            //缓冲逐行读取
            while ( (line = br.readLine()) != null ) {
                sb.append(line);
            }
            System.out.println(sb.toString());
            String s = sb.toString();
             o = (JSONObject) JSONObject.parse(s);
            System.out.println(o);
        }catch ( Exception ignored ){}
        finally {
            //关闭流
            try {
                if(is!=null){
                    is.close();
                }
                if(br!=null){
                    br.close();
                }
                if (out!=null){
                    out.close();
                }
            } catch (IOException e2) {}
        }
        return o;
    }

}
