package com.main;

import com.bean.Director;
import com.bean.IPLTeam;
import com.bean.Movie;
import com.bean.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashMap;
import java.util.HashSet;

public class MovieApplication {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

//        //
//        Director director1 = new Director();
//        director1.setDirectorID(101);
//        director1.setDirectorName("KARAN ZOHAR");
//        HashSet<Movie> movieHashSet = new HashSet<>();
//        movieHashSet.add(new Movie(111,"BLACK PANTHER"));
//        movieHashSet.add(new Movie(191,"BLACK WIDOW"));
//        movieHashSet.add(new Movie(101,"IRONMAN"));
//        director1.setMovieSet(movieHashSet);
//
//        //printing director1
//        System.out.println(director1);
//
//        System.out.println("*************************************");
//        Director director2 = new Director();
//        director1.setDirectorID(102);
//        director1.setDirectorName("SUBHASH ");
//        movieHashSet.clear();
//        movieHashSet.add(new Movie(119,""));
        IPLTeam iplTeam1 = new IPLTeam();
        iplTeam1.setTeamID(1111);
        iplTeam1.setTeamName("CSK");
        iplTeam1.setOwnerName("JKCEMENT");

        HashMap<String, Player> playerHashMap = new HashMap<>();
        playerHashMap.put("WI",new Player(109,"BRAVO",18.0f));
        playerHashMap.put("WI",new Player(117,"DHONI",19.0f));
        playerHashMap.put("WI",new Player(109,"FAF",11.0f));
        iplTeam1.setPlayerMap(playerHashMap);
        session.save(iplTeam1);
        transaction.commit();
        System.out.println("done");

        System.out.println(iplTeam1);



    }
}
