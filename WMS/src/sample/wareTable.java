package sample;

public class wareTable {
    String SID, MATERIAL, SPACE, COST, STARTDATE, ENDDATE;

    public wareTable(String SID, String MATERIAL, String SPACE, String COST, String STARTDATE, String ENDDATE) {
        this.SID = SID;
        this.MATERIAL = MATERIAL;
        this.SPACE = SPACE;
        this.COST = COST;
        this.STARTDATE = STARTDATE;
        this.ENDDATE = ENDDATE;
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

    public String getSTARTDATE() {
        return STARTDATE;
    }

    public void setSTARTDATE(String STARTDATE) {
        this.STARTDATE = STARTDATE;
    }

    public String getENDDATE() {
        return ENDDATE;
    }

    public void setENDDATE(String ENDDATE) {
        this.ENDDATE = ENDDATE;
    }
}
