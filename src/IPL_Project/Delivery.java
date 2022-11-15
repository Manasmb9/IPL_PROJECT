package IPL_Project;

public class Delivery {
    private int matchId;
    private int innings;
    private String  battingTeam;
    private String bowlingTeam;
    private int over;
    private int ball;
    private String batsman;
    private String non_Striker;
    private String bowler;
    private int issuperover;
    private int wideRuns;
    private int byeRuns;
    private int legByeRuns;
    private int noballRuns;
    private int penaltyRuns;
    private int batsmanRuns;
    private int extraRuns;
    private int totalRuns;

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }
    public void setInnings(int innings) {
        this.innings = innings;
    }
    public void setBattingTeam(String battingTeam) {
        this.battingTeam = battingTeam;
    }
    public void setBowlingTeam(String bowlingTeam) {
        this.bowlingTeam = bowlingTeam;
    }
    public void setOver(int over) {
        this.over = over;
    }
    public void setBall(int ball) {
        this.ball = ball;
    }
    public void setBatsman(String batsmanName) {
        this.batsman = batsmanName;
    }
    public void setNon_Striker(String non_Striker){this.non_Striker = non_Striker;}
    public void setBowler(String bowlerName) {
        this.bowler = bowlerName;
    }
    public void setIssuperover(int issuperover){this.issuperover = issuperover;}
    public void setWideRuns(int wideRuns) {
        this.wideRuns = wideRuns;
    }
    public void setByeRuns(int byeRuns) {
        this.byeRuns = byeRuns;
    }
    public void setLegByeRuns(int legByeRuns) {
        this.legByeRuns = legByeRuns;
    }
    public void setNoballRuns(int noballRuns) {
        this.noballRuns = noballRuns;
    }
    public void setPenaltyRuns(int penaltyRuns) {
        this.penaltyRuns = penaltyRuns;
    }
    public void setBatsmanRuns(int batsmanRuns) {
        this.batsmanRuns = batsmanRuns;
    }
    public void setExtraRuns(int extraRuns) {
        this.extraRuns = extraRuns;
    }
    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
    }
    public int getMatchId() {
        return matchId;
    }
    public int getInnings() {
        return innings;
    }
    public String getBattingTeam() {
        return battingTeam;
    }
    public String getBowlingTeam() {
        return bowlingTeam;
    }
    public int getOver() {
        return over;
    }
    public int getBall() {
        return ball;
    }
    public String getBatsman() {
        return batsman;
    }
    public String getNon_Striker(){return non_Striker;}
    public String getBowler() {
        return bowler;
    }
    public int getIssuperover(){return issuperover;}
    public int getWideRuns() {
        return wideRuns;
    }
    public int getByeRuns() {
        return byeRuns;
    }
    public int getLegByeRuns() {
        return legByeRuns;
    }
    public int getNoballRuns() {
        return noballRuns;
    }
    public int getPenaltyRuns() {
        return penaltyRuns;
    }
    public int getBatsmanRuns() {
        return batsmanRuns;
    }
    public int getExtraRuns() {
        return extraRuns;
    }
    public int getTotalRuns() {
        return totalRuns;
    }
}
