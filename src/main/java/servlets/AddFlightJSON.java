package servlets;

import java.io.IOException;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Flight;
import repository.FlightRepository;

/**
 * Servlet implementation class AddFlightJSON
 */
@WebServlet("/api/AddFlightJSON")
public class AddFlightJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddFlightJSON() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
            Flight flight = new Flight(
                request.getParameter("flightNum"),
                LocalDate.parse(request.getParameter("departureDate")),
                request.getParameter("departureHour"),
                request.getParameter("firstName"),
                request.getParameter("secondName"),
                request.getParameter("surname"),
                Double.parseDouble(request.getParameter("ticketPrice")),
                request.getParameter("airlineName"),
                Double.parseDouble(request.getParameter("cabinLuggageWeight")),
                Double.parseDouble(request.getParameter("extraLuggageWeight"))
            );

            FlightRepository.addFlight(flight);

            response.setContentType("application/json");
            response.getWriter().write("{\"status\":\"Flight added successfully\"}");
        } catch (Exception exc) {
            response.setContentType("application/json");
            response.getWriter().write("{\"error\":\"" + exc.getMessage() + "\"}");
        }
	}

}
