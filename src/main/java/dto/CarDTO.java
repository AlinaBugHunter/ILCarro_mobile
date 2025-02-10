package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Builder
@ToString

public class CarDTO {

    private String serialNumber;
    private String manufacture;
    private String model;
    private String year;
    private String fuel;
    private int seats;
    private String carClass;
    private double pricePerDay;
    private String about;
    private String city;
    private double lat;
    private double lng;
    private String image;
    private String owner;
    private List<BookedDTO> bookedPeriods;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarDTO carDTO = (CarDTO) o;
        return seats == carDTO.seats && Double.compare(pricePerDay, carDTO.pricePerDay) == 0
                && Objects.equals(serialNumber, carDTO.serialNumber)
                && Objects.equals(manufacture, carDTO.manufacture)
                && Objects.equals(model, carDTO.model)
                && Objects.equals(year, carDTO.year)
                && Objects.equals(fuel, carDTO.fuel)
                && Objects.equals(carClass, carDTO.carClass)
                && Objects.equals(about, carDTO.about)
                && Objects.equals(city, carDTO.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber, manufacture, model, year, fuel, seats, carClass, pricePerDay, about, city);
    }

}
