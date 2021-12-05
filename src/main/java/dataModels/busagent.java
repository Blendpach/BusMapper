package dataModels;

public class busagent {

    private int busage_id;
    private String busage_routeid;
    private String busage_triptime;
    private String busage_nostops;
    private String busaeg_averagetimebetstops;
    private String busage_averagespeed;

    public busagent() {

    }

    public busagent(int busage_id, String busage_routeid, String busage_triptime, String busage_nostops,
            String busaeg_averagetimebetstops, String busage_averagespeed) {
        this.busage_id = busage_id;
        this.busage_routeid = busage_routeid;
        this.busage_triptime = busage_triptime;
        this.busage_nostops = busage_nostops;
        this.busaeg_averagetimebetstops = busaeg_averagetimebetstops;
        this.busage_averagespeed = busage_averagespeed;
    }

    public void setBusaeg_averagetimebetstops(String busaeg_averagetimebetstops) {
        this.busaeg_averagetimebetstops = busaeg_averagetimebetstops;
    }

    public void setBusage_averagespeed(String busage_averagespeed) {
        this.busage_averagespeed = busage_averagespeed;
    }

    public void setBusage_id(int busage_id) {
        this.busage_id = busage_id;
    }

    public void setBusage_nostops(String busage_nostops) {
        this.busage_nostops = busage_nostops;
    }

    public void setBusage_routeid(String busage_routeid) {
        this.busage_routeid = busage_routeid;
    }

    public void setBusage_triptime(String busage_triptime) {
        this.busage_triptime = busage_triptime;
    }

    public String getBusaeg_averagetimebetstops() {
        return busaeg_averagetimebetstops;
    }

    public String getBusage_averagespeed() {
        return busage_averagespeed;
    }

    public int getBusage_id() {
        return busage_id;
    }

    public String getBusage_nostops() {
        return busage_nostops;
    }

    public String getBusage_routeid() {
        return busage_routeid;
    }

    public String getBusage_triptime() {
        return busage_triptime;
    }

}
