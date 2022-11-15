package IPL_Project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static final int MATCH_ID = 0;
    public static final int INNINGS = 1;
    public static final int BATTING_TEAM = 2;
    public static final int BOWLING_TEAM = 3;
    public static final int OVER = 4;
    public static final int BALL = 5;
    public static final int BATSMAN = 6;
    public static final int NON_STRIKER = 7;
    public static final int BOWLER = 8;
    public static final int IS_SUPER_OVER = 9;
    public static final int WIDE_RUNS = 10;
    public static final int BYE_RUNS = 11;
    public static final int LEG_BYE_RUNS = 12;
    public static final int NO_BALL_RUNS = 13;
    public static final int PENALTY_RUNS = 14;
    public static final int BATSMAN_RUNS = 15;
    public static final int EXTRA_RUNS = 16;
    public static final int TOTAL_RUNS = 17;
    public static final int ID = 0;
    public static final int SEASON = 1;
    public static final int CITY = 2;
    public static final int DATE = 3;
    public static final int TEAM_1 = 4;
    public static final int TEAM_2 = 5;
    public static final int TOSS_WINNER = 6;
    public static final int TOSS_DECISION = 7;
    public static final int RESULT = 8;
    public static final int DL_APPLIED = 9;
    public static final int WINNER = 10;
    public static final int WIN_BY_RUNS = 11;
    public static final int WIN_BY_WICKETS = 12;

    public static ArrayList<Match> mac(String path) {
//    public static void main(String[] args) {

        String split = ",";
        String line = "";
        ArrayList<Match> matchData = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            line = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(split);
                Match match = new Match();
                match.setId(Integer.parseInt(data[ID]));
                match.setSeason(Integer.parseInt(data[SEASON]));
                match.setCity(data[CITY]);
                match.setDate(data[DATE]);
                match.setTeam1(data[TEAM_1]);
                match.setTeam2(data[TEAM_2]);
                match.setTossWinner(data[TOSS_WINNER]);
                match.setTossDecision(data[TOSS_DECISION]);
                match.setResult(data[RESULT]);
                match.setDl_applied(Integer.parseInt(data[DL_APPLIED]));
                match.setWinner(data[WINNER]);
                match.setWin_by_runs(Integer.parseInt(data[WIN_BY_RUNS]));
                match.setWin_by_wickets(Integer.parseInt(data[WIN_BY_WICKETS]));
                matchData.add(match);


            }
//            for (Match a : matchdata){
//                System.out.println(a.getMatchId());
//
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matchData;
    }
    public static ArrayList<Delivery>del(String path) {
        String Split = ",";
        String line = "";
        ArrayList<Delivery> deliverydata = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String data[] = line.split(Split);
//                System.out.println(Arrays.toString(data));
                Delivery delivery = new Delivery();
                delivery.setMatchId(Integer.parseInt(data[MATCH_ID]));
                delivery.setInnings(Integer.parseInt(data[INNINGS]));
                delivery.setBattingTeam(data[BATTING_TEAM]);
                delivery.setBowlingTeam(data[BOWLING_TEAM]);
                delivery.setOver(Integer.parseInt(data[OVER]));
                delivery.setBall(Integer.parseInt(data[BALL]));
                delivery.setBatsman(data[BATSMAN]);
                delivery.setNon_Striker((data[NON_STRIKER]));
                delivery.setBowler(data[BOWLER]);
                delivery.setIssuperover(Integer.parseInt(data[IS_SUPER_OVER]));
                delivery.setWideRuns(Integer.parseInt(data[WIDE_RUNS]));
                delivery.setByeRuns(Integer.parseInt(data[BYE_RUNS]));
                delivery.setLegByeRuns(Integer.parseInt(data[LEG_BYE_RUNS]));
                delivery.setNoballRuns(Integer.parseInt(data[NO_BALL_RUNS]));
                delivery.setPenaltyRuns(Integer.parseInt(data[PENALTY_RUNS]));
                delivery.setBatsmanRuns(Integer.parseInt(data[BATSMAN_RUNS]));
                delivery.setExtraRuns(Integer.parseInt(data[EXTRA_RUNS]));
                delivery.setTotalRuns(Integer.parseInt(data[TOTAL_RUNS]));
                deliverydata.add(delivery);

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return deliverydata;

    }
    public static void main(String[] args) {


        ArrayList<Match> mat = mac("/home/dell/Downloads/matches.csv");
        HashMap<Integer, Integer> matchesPlayedPerYear = perYear(mat);
//        for(Match a : mat)
//        System.out.println(a.getMatchId() + " ," + a.getSeason() + " , " + a.getCity());
//        System.out.println(matchesPlayedPerYear);
        HashMap<String, Integer> matchesWonPerYear = wonPerYear(mat);
//        System.out.println(matchesWonPerYear);
//        Delivery deliver = new Delivery();
        ArrayList<Delivery> deliver = del("/home/dell/Downloads/deliveries.csv");
//        for (Delivery a : deliver) {
//            System.out.println(a.getBowler());
//        }
        HashMap<String, Integer> extra = extraRuns(mat, deliver);
        String Economicbowler = Eb(mat, deliver);


    }
    private static String Eb(ArrayList<Match> mat, ArrayList<Delivery> deliver) {
        HashMap<String, Integer> bowlsCount = new HashMap<>();
        HashMap<String, Integer> bowlruns = new HashMap<>();
        String ecobowler = "";
        for (Match i : mat) {
            if (i.getSeason() == 2015) {


                for (Delivery a : deliver) {
                    if (i.getId() == a.getMatchId()) {
                        if (bowlsCount.containsKey(a.getBowler())) {
                            bowlsCount.put(a.getBowler(), bowlsCount.get(a.getBowler()) + 1);
                        } else {
                            bowlsCount.put(a.getBowler(),1);
                        }
                        if(bowlruns.containsKey(a.getBowler())){
                            bowlruns.put(a.getBowler(),bowlruns.get(a.getBowler()) + a.getTotalRuns());
                        }
                        else{
                            bowlruns.put(a.getBowler(),a.getTotalRuns());
                        }



                    }
                }
            }
        }
        Float firsteco, lasteco = Float.MAX_VALUE;
        for(String bowler : bowlruns.keySet()){
            firsteco = (bowlruns.get(bowler) * 6F / bowlsCount.get(bowler));
            if(firsteco < lasteco){
                lasteco = firsteco;
                ecobowler = bowler;
            }
        }


//        System.out.println(bowlruns);
//       System.out.println(bowlsCount);
        System.out.println(ecobowler + "," + lasteco);
        return ecobowler + "," + lasteco ;
    }
    private static HashMap<String, Integer> extraRuns (ArrayList < Match > mat, ArrayList < Delivery > deliver){
        HashMap<String, Integer> elementCount = new HashMap<>();
        int firstmatchid = 0;
        int lastmatchid = 0;
        for (Match i : mat) {
            if (i.getSeason() == 2016) {
                if (firstmatchid == 0) {
                    firstmatchid = i.getId();
                }
                lastmatchid = i.getId();

            }
        }
        for (Delivery a : deliver) {
            if (a.getMatchId() >= firstmatchid && a.getMatchId() <= lastmatchid) {
//                    System.out.println(a.getMatchId());

//                    System.out.println(a.getExtraRuns());
                if (elementCount.containsKey(a.getBattingTeam())) {

                    elementCount.put(a.getBattingTeam(), elementCount.get(a.getBattingTeam()) + a.getExtraRuns());
                } else {
                    elementCount.put(a.getBattingTeam(), a.getExtraRuns());
                }
            }
        }
//            System.out.println(elementCount);
        return null;
    }


    private static HashMap<String, Integer> wonPerYear (ArrayList < Match > mat) {
        HashMap<String, Integer> WinnerCount = new HashMap<>();
        for (Match i : mat) {
            if (i.getResult() != "no result") {
                if (WinnerCount.containsKey(i.getWinner())) {
                    WinnerCount.put(i.getWinner(), WinnerCount.get(i.getWinner()) + 1);

                } else {
                    WinnerCount.put(i.getWinner(), 1);
                }

            }
        }
        return WinnerCount;
    }


    private static HashMap<Integer, Integer> perYear (ArrayList < Match > mat) {
        HashMap<Integer, Integer> SeasonCount = new HashMap<>();
        for (Match i : mat) {

            if (SeasonCount.containsKey(i.getSeason())) {
                SeasonCount.put(i.getSeason(), SeasonCount.get(i.getSeason()) + 1);
            } else {
                SeasonCount.put(i.getSeason(), 1);
            }

        }
//  System.out.println(elementCountMap);
        return SeasonCount;
    }
}

