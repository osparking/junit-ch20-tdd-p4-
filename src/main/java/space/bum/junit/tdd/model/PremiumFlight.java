package space.bum.junit.tdd.model;

public class PremiumFlight extends Flight {

  public PremiumFlight(String id) {
    super(id);
  }

  @Override
  public boolean addPassenger(Passenger passenger) {
    if (passenger.isVip()) {
      return passengers.add(passenger);
    } else {
      return false;
    }
  }

  @Override
  public boolean removePassenger(Passenger passenger) {
    if (passenger.isVip()) {
      return passengers.remove(passenger);
    } else {
      return false;
    }
  }
}
