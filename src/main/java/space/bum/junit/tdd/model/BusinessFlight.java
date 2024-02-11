package space.bum.junit.tdd.model;

public class BusinessFlight extends Flight {

  public BusinessFlight(String id) {
    super(id);
  }

  @Override
  public boolean addPassenger(Passenger passenger) {
    /**
     * VIP 승객만 추가할 수 있다.
     */
    if (passenger.isVip()) {
      return passengers.add(passenger);
    } else {
      return false;
    }
  }

  @Override
  public boolean removePassenger(Passenger passenger) {
    /**
     * 탑승한 VIP 승객 아무도 제거할 수 없다.
     */
    return false;
  }

}
