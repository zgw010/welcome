package org.group.welcome;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Utils {
    public static String getFileName(String ip){
        String[] arr = ip.split("\\.");
        StringBuffer filename_sbf = new StringBuffer();
        for(int i=0;i<arr.length;i++){
            StringBuffer sbf = new StringBuffer();
            sbf.append(arr[i]);
            while(sbf.length()<3){
                sbf.insert(0,"0");
            }
            filename_sbf.append(sbf);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String time = simpleDateFormat.format(new Date());
        Random random = new Random();
        StringBuffer random_sbf = new StringBuffer();
        while (random_sbf.length()<3){
            random_sbf.append(random.nextInt(10));
        }
        return filename_sbf.toString()+time+random_sbf.toString();
    }
}
