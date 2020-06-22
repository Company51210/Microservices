package altran.rentcloud.rentservice.model;

import altran.rentcloud.model.rent.Rent;

/**
 * Author:Vivek Kumar
 * Date:21-06-2020
 */
public class SimpleResponse implements Response {

    Rent rent;


    public SimpleResponse(Rent rent) {
        this.rent = rent;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }
}
