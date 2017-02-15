package lightpath.com.ibuy.data.entity;

/**
 * Created by LUIS on 11/02/2017.
 */

public class Favorite {
    String name;
    String cost;

    public Favorite(String name, String cost){
        this.name=name;
        this.cost=cost;
    }

    public String getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setName(String name) {
        this.name = name;
    }
}
