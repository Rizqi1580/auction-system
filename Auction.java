/**
 * Write a description of class Auction here.
 *
 * @author Rizqi Ar Rasyid
 * @version 1.0
 */

import java.util.ArrayList;

public class Auction{
    private ArrayList<Lot> lots;
    private ArrayList<Bid> bids;
    private ArrayList<Person> people;

    public Auction() {
        lots = new ArrayList<>();
        bids = new ArrayList<>();
        people = new ArrayList<>();
    }

    public void addLot(Lot lot) {
        lots.add(lot);
    }

    public void addBid(Bid bid) {
        bids.add(bid);
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public ArrayList<Lot> getLots() {
        return lots;
    }

    public ArrayList<Bid> getBids() {
        return bids;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }
}