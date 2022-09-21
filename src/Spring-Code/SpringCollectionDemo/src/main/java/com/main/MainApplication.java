package com.main;

import com.bean.DID;
import com.bean.Participants;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Config.xml");
//        System.out.println(context.getBean("did"));
        DID did = (DID) context.getBean("did");
        System.out.println("SeasonName : "+did.getSeasons()+"\n" +
                "BrandPartners : "+did.getBrandPartners()+"\n"+
                "Participants: \n");
        Map<Participants,String> map = did.getParticipants();
        for(Map.Entry<Participants,String> item : map.entrySet())
            System.out.println("Participants : "+item.getKey()+" Team-guru : "+item.getValue());
    }
}
