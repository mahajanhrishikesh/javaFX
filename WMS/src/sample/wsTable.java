package sample;

public class wsTable {

    String SID, MATERIAL, NAME, SPACE, COST, ADD_DATE, END_DATE;

    public wsTable(String SID, String MATERIAL, String NAME, String SPACE, String COST, String ADD_DATE, String END_DATE) {
        this.SID = SID;
        this.MATERIAL = MATERIAL;
        this.NAME = NAME;
        this.SPACE = SPACE;
        this.COST = COST;
        this.ADD_DATE = ADD_DATE;
        this.END_DATE = END_DATE;
    }

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }

    public String getMATERIAL() {
        return MATERIAL;
    }

    public void setMATERIAL(String MATERIAL) {
        this.MATERIAL = MATERIAL;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getSPACE() {
        return SPACE;
    }

    public void setSPACE(String SPACE) {
        this.SPACE = SPACE;
    }

    public String getCOST() {
        return COST;
    }

    public void setCOST(String COST) {
        this.COST = COST;
    }

    public String getADD_DATE() {
        return ADD_DATE;
    }

    public void setADD_DATE(String ADD_DATE) {
        this.ADD_DATE = ADD_DATE;
    }

    public String getEND_DATE() {
        return END_DATE;
    }

    public void setEND_DATE(String END_DATE) {
        this.END_DATE = END_DATE;
    }
}
