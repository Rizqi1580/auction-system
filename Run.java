import java.util.Scanner;

public class Run {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        Auction auction = new Auction();
        
        System.out.println("Masukkan nama bidder pertama:");
        String person1Name = scanner.nextLine();
        Person person1 = new Person(person1Name);
        
        System.out.println("Masukkan nama bidder kedua:");
        String person2Name = scanner.nextLine();
        Person person2 = new Person(person2Name);
        
        auction.addPerson(person1);
        auction.addPerson(person2);
      
        System.out.println("Masukkan nama barang yang ingin dilelang:");
        String lotDescription = scanner.nextLine();
        Lot lot1 = new Lot(lotDescription);
        
        auction.addLot(lot1);
        
        System.out.println("Masukkan minimum harga barang:");
        double minimumPrice = scanner.nextDouble();
        
        double highestBid = 0;
        Person highestBidder = null;
        boolean moreBids = true;
        int currentBidder = 1;
        
        while (moreBids) {
            Person currentPerson = (currentBidder == 1) ? person1 : person2;
            System.out.println(currentPerson.getName() + ", Masukkan bid (0 untuk keluar):");
            double bidAmount = scanner.nextDouble();

            if (bidAmount == 0) {
                System.out.println(currentPerson.getName() + " has stopped bidding.");
                moreBids = false;
            } else if (bidAmount > highestBid) {

                highestBid = bidAmount;
                highestBidder = currentPerson;
                System.out.println(currentPerson.getName() + " has the highest bid with " + highestBid);
            } else {
                
                System.out.println("Your bid must be higher than the current highest bid of " + highestBid);
                System.out.println("Do you want to stop bidding or place a higher bid? (enter 0 to stop, or a higher bid):");
                double newBidAmount = scanner.nextDouble();
                
                if (newBidAmount == 0) {
                    System.out.println(currentPerson.getName() + " has stopped bidding.");
                    moreBids = false;
                } else if (newBidAmount > highestBid) {
                    highestBid = newBidAmount;
                    highestBidder = currentPerson;
                    System.out.println(currentPerson.getName() + " has the highest bid with " + highestBid);
                }
            }
            
            if (moreBids) {
                currentBidder = (currentBidder == 1) ? 2 : 1;
            }
        }
        
        if (highestBid >= minimumPrice) {
            System.out.println("The auction is over. The winner is " + highestBidder.getName() +
                               " with a bid of " + highestBid);
        } else {
            System.out.println("The auction is over. No bids met the minimum price of " + minimumPrice);
        }
        
        scanner.close();
    }
}