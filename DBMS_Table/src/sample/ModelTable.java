package sample;

public class ModelTable {

    String w_id, w_name, plotno, city, capacity;

    public ModelTable(String w_id, String w_name, String plotno, String city, String capacity) {
        this.w_id = w_id;
        this.w_name = w_name;
        this.plotno = plotno;
        this.city = city;
        this.capacity = capacity;
    }

    public String getW_id() {
        return w_id;
    }

    public void setW_id(String w_id) {
        this.w_id = w_id;
    }

    public String getW_name() {
        return w_name;
    }

    public void setW_name(String w_name) {
        this.w_name = w_name;
    }

    public String getPlotno() {
        return plotno;
    }

    public void setPlotno(String plotno) {
        this.plotno = plotno;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
}