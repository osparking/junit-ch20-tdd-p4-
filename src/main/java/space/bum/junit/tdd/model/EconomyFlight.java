package space.bum.junit.tdd.model;

public class EconomyFlight extends Flight {

  public EconomyFlight(String id) {
    super(id);
  }

  @Override
  public boolean addPassenger(Passenger passenger) {
    if (!passengers.contains(passenger)) {
      return passengers.add(passenger);
    } else {
      return false;
    }
  }

  @Override
  public boolean removePassenger(Passenger passenger) {
    /**
     * VIP 승객은 제거할 수 없다.
     */
    if (passenger.isVip()) {
      return false;
    } else {
      return passengers.remove(passenger);
    }
  }

}
