package model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Flight {

	private String flightNum;
	private LocalDate departureDate;
    private String departureHour;
    private String firstName;
    private String secondName;
    private String surname;
    private double ticketPrice;
    private String airlineName;
	private double cabinLuggageWeight;
	private double extraLuggageWeight;
	
	
	// @AllArgsConstructor just doesn't seem to work for some reason, manually created
	public Flight(String flightNum, LocalDate departureDate, String departureHour,
			String firstName, String secondName, String surname, double ticketPrice,
			String airlineName, double cabinLuggageWeight, double extraLuggageWeight)
	{
		this.flightNum = flightNum;
		this.departureDate = departureDate;
		this.departureHour = departureHour;
		this.firstName = firstName;
		this.secondName = secondName;
		this.surname = surname;
		this.ticketPrice = ticketPrice;
		this.airlineName = airlineName;
		this.cabinLuggageWeight = cabinLuggageWeight;
		this.extraLuggageWeight = extraLuggageWeight;
	}

	public String toJson() {
        return String.format(
            "{" +
                "\"flightNum\":\"%s\"," +
                "\"departureDate\":\"%s\"," +
                "\"departureHour\":\"%s\"," +
                "\"firstName\":\"%s\"," +
                "\"secondName\":\"%s\"," +
                "\"surname\":\"%s\"," +
                "\"ticketPrice\":%.2f," +
                "\"airlineName\":\"%s\"," +
                "\"cabinLuggageWeight\":%.2f," +
                "\"extraLuggageWeight\":%.2f" +
            "}",
            flightNum, departureDate, departureHour,
            firstName, secondName, surname,
            ticketPrice, airlineName,
            cabinLuggageWeight, extraLuggageWeight
        );
    }
}
