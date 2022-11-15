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

}
