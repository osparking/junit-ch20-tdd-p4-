package space.bum.junit.tdd;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import space.bum.junit.tdd.model.BusinessFlight;
import space.bum.junit.tdd.model.EconomyFlight;
import space.bum.junit.tdd.model.Flight;
import space.bum.junit.tdd.model.Passenger;
import space.bum.junit.tdd.model.PremiumFlight;

class AirportTest {
  @Nested
  @DisplayName("이코노미 항공편")
  class EconomyFlightTest {
    private Flight economyFlight;

    @BeforeEach
    void setUp() {
      economyFlight = new EconomyFlight("1");
    }

    @Nested
    @DisplayName("보통의 승객")
    class NormPassengerOnEconomyTest {
      @Test
      @DisplayName("보통 승객과 기본 가격 항공편")
      public void testRegularOnEconomy() {
        Passenger passenger = new Passenger("최", false);
        assertAll("일반 승객이 보통 항공편 이용에 관한 검증",
            () -> assertEquals("1", economyFlight.getId()),
            () -> assertEquals(true, economyFlight.addPassenger(passenger)),
            () -> assertEquals(1, economyFlight.getPassengers().size()),
            () -> assertEquals("최",
                economyFlight.getPassengers().get(0).getName()),
            () -> assertEquals(true,
                economyFlight.removePassenger(passenger)),
            () -> assertEquals(0, economyFlight.getPassengers().size()));
      }
    }

    @Nested
    @DisplayName("VIP인 승객")
    class VipPassengerOnEconomyTest {
      @Test
      @DisplayName("보통 승객과 기본 가격 항공편")
      public void testVipOnEconomy() {
        Passenger vip = new Passenger("박", true);
        assertAll("VIP 승객이 보통 항공편 이용에 관한 검증",
            () -> assertEquals("1", economyFlight.getId()),
            () -> assertEquals(true, economyFlight.addPassenger(vip)),
            () -> assertEquals(1, economyFlight.getPassengers().size()),
            () -> assertEquals("박",
                economyFlight.getPassengers().get(0).getName()),
            () -> assertEquals(false, economyFlight.removePassenger(vip)),
            () -> assertEquals(1, economyFlight.getPassengers().size()));
      }
    }
  }

  @Nested
  @DisplayName("비즈니스 항공편")
  class BusinessFlightTest {
    private Flight businessFlight;

    @BeforeEach
    void setUp() {
      businessFlight = new BusinessFlight("2");
    }

    @Nested
    @DisplayName("보통의 승객")
    class NormPassengerOnBusinessTest {

      @Test
      @DisplayName("보통승객이 비즈니스 탑승 시험")
      void normOnBusinessTest() {
        Passenger choi = new Passenger("최", false);
        assertAll("일반 승객은 비즈니 항공편 이용에 관한 검증",
            () -> assertEquals(false, businessFlight.addPassenger(choi)),
            () -> assertEquals(0, businessFlight.getPassengers().size()),
            () -> assertEquals(false, businessFlight.removePassenger(choi)),
            () -> assertEquals(0, businessFlight.getPassengers().size()));
      }
    }

    @Nested
    @DisplayName("VIP인 승객")
    class VipPassengerOnBusinessTest {
      @Test
      @DisplayName("VIP 승객이 비즈니스 탑승 시험")
      void normOnBusinessTest() {
        Passenger park = new Passenger("박", true);
        assertAll("VIP 승객이 비즈니스 항공편 이용에 관한 검증",
            () -> assertEquals(true, businessFlight.addPassenger(park)),
            () -> assertEquals(1, businessFlight.getPassengers().size()),
            () -> assertEquals(false, businessFlight.removePassenger(park)),
            () -> assertEquals(1, businessFlight.getPassengers().size()));
      }
    }
  }
  
  @Nested
  @DisplayName("프리미엄 항공편")
  class PremiumFlightTest {
    private Flight premiumFlight;
    
    @BeforeEach
    void setUp() {
      premiumFlight = new PremiumFlight("3");
    }
    
    @Nested
    @DisplayName("일반 승객")
    class NormPassengerOnBusinessTest {
      
      @Test
      @DisplayName("일반 승객 프리미엄 탑승 시험")
      void normOnBusinessTest() {
        Passenger choi = new Passenger("최", false);
        assertAll("일반 승객 프리미엄 항공편 추가&삭제 불가함 검증",
            () -> assertEquals(false, premiumFlight.addPassenger(choi)),
            () -> assertEquals(0, premiumFlight.getPassengers().size()),
            () -> assertEquals(false, premiumFlight.removePassenger(choi)),
            () -> assertEquals(0, premiumFlight.getPassengers().size()));
      }
    }
    
    @Nested
    @DisplayName("VIP 승객")
    class VipPassengerOnBusinessTest {
      @Test
      @DisplayName("VIP 승객 프리미엄 탑승 시험")
      void normOnBusinessTest() {
        Passenger park = new Passenger("박", true);
        assertAll("VIP 승객 프리미엄 항공편 추가&삭제 가능 검증",
            () -> assertEquals(true, premiumFlight.addPassenger(park)),
            () -> assertEquals(1, premiumFlight.getPassengers().size()),
            () -> assertEquals(false, premiumFlight.removePassenger(park)),
            () -> assertEquals(0, premiumFlight.getPassengers().size()));
      }
    }
  }
}
