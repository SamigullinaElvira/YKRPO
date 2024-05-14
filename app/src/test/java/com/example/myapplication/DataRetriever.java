package com.example.myapplication;

import com.example.myapplication.objects.PostData;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

public class DataRetriever {
    public static Object retrieveData(String path, Class<?> clazz) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        File file = new File(path);
        PostData[] postData = xmlMapper.readValue(file, PostData[].class);
        for (PostData data : postData) {
            String time = LocalTime.now().getHour() + ":" + LocalTime.now().getMinute();
            data.setTime(time);
        }
        return postData;
    }
}