package com.sunyard.xmlparserdemo;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.io.StringReader;

/**
 * @package name：com.sunyard.xmlparserdemo
 * @describe
 * @anthor jokerlover
 * @email:shengj.chen@sunyard.com
 * @time 2020/9/16 4:53 PM
 */
public class ParserByPULL {
    //采用XmlPullParser来解析文件
    public static Person qrResponseBeanList(String xmlData, InputStream inputStream) throws Throwable {
        // List<QrCodeRespBean> qrResponseBeans = null;
        Person person = null;

        //创建XmlPullParser
        XmlPullParser parser = Xml.newPullParser();
        if (xmlData != null) {
            //解析文件输入流
            parser.setInput(new StringReader(xmlData));

        }else {
            parser.setInput(inputStream,"UTF-8");
        }

        //得到当前的解析对象
        int eventType = parser.getEventType();
        //当解析工作还没完成时，调用next（）方法得到下一个解析事件
        while (eventType != XmlPullParser.END_DOCUMENT) {
            switch (eventType) {
                case XmlPullParser.START_DOCUMENT:
                    //解析开始的时候初始化list
                    //qrResponseBeans = new ArrayList<>();

                    break;
                case XmlPullParser.START_TAG:
                    //获得解析器当前指向的元素的名字
                    //当指向元素的名字和id，name，sex这些属性重合时可以返回他们的值
                    String XPPname = parser.getName();

                    if ("person".equals(XPPname)) {
                        //通过解析器获取id的元素值，并设置一个新的Student对象的id
                        person = new Person();
                    }
                    if (person != null) {
                        if ("name".equals(XPPname)) {//交易代码
                            person.setName(parser.nextText());
                        } else if ("age".equals(XPPname)) {//请求渠道类型
                            person.setAge(Integer.parseInt(parser.nextText()));
                        }
                    }
                    break;
                //出发结束元素事件
                case XmlPullParser.END_TAG:

                    if ("Finance".equals(parser.getName())) {
                        // qrResponseBeans.add(qrResponseBean);
                        // qrResponseBean = null;
                    }
                    break;
                default:
                    break;
            }
            eventType = parser.next();
        }
        return person;
    }


}
