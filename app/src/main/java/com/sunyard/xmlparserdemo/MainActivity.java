package com.sunyard.xmlparserdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.InputStream;
import java.util.List;

import static com.sunyard.xmlparserdemo.XMLContentHandler.readXmlBySAX;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
String xml=" <person id=\"23\">\n" +
        "        <name>春娇</name>\n" +
        "        <age>18</age>\n" +
        "    </person>\n" +
        "    <person id=\"20\">\n" +
        "        <name>志明</name>\n" +
        "        <age>20</age>\n" +
        "    </person>";
       InputStream inputStream = getResources().openRawResource(R.raw.item);
        try {
            //Person person = ParserByPULL.qrResponseBeanList(xml, null);
            List<Person> people = readXmlBySAX(inputStream);

            for (int i = 0; i <people.size() ; i++) {
                Log.e(TAG, "onCreate: "+people.get(i).toString() );
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }
}