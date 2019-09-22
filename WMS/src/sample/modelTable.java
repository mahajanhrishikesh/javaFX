package sample;

public class modelTable {
    String WID, PINCODE, WQI, NAME, CAPACITY, REMCAP, COST;

    public modelTable(String WID, String PINCODE, String WQI, String NAME, String CAPACITY, String REMCAP, String COST) {
        this.WID = WID;
        this.PINCODE = PINCODE;
        this.WQI = WQI;
        this.NAME = NAME;
        this.CAPACITY = CAPACITY;
        this.REMCAP = REMCAP;
        this.COST = COST;
    }

    public String getWID() {
        return WID;
    }

    public void setWID(String WID) {
        this.WID = WID;
    }

    public String getPINCODE() {
        return PINCODE;
    }

    public void setPINCODE(String PINCODE) {
        this.PINCODE = PINCODE;
    }

    public String getWQI() {
        return WQI;
    }

    public void setWQI(String WQI) {
        this.WQI = WQI;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getCAPACITY() {
        return CAPACITY;
    }

    public void setCAPACITY(String CAPACITY) {
        this.CAPACITY = CAPACITY;
    }

    public String getREMCAP() {
        return REMCAP;
    }

    public void setREMCAP(String REMCAP) {
        this.REMCAP = REMCAP;
    }

    public String getCOST() {
        return COST;
    }

    public void setCOST(String COST) {
        this.COST = COST;
    }
}
