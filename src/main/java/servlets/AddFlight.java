package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Flight;
import repository.FlightRepository;

/**
 * Servlet implementation class AddFlight
 */
@WebServlet("/AddFlight")
public class AddFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//private static final List<Flight> flightsArrList = new ArrayList<>();
	
	private FlightRepository flightRepository;
	
    /**
     * Default constructor. 
     */
    public AddFlight() {
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		try {
			
			String flightNum = request.getParameter("flightNum");
	        LocalDate departureDate = LocalDate.parse(request.getParameter("departureDate"));
	        String departureHour = request.getParameter("departureHour");
	        String firstName = request.getParameter("firstName");
	        String secondName = request.getParameter("secondName");
	        String surname = request.getParameter("surname");
	        double ticketPrice = Double.parseDouble(request.getParameter("ticketPrice"));
	        String airlineName = request.getParameter("airlineName");
	        double cabinLuggageWeight = Double.parseDouble(request.getParameter("cabinLuggageWeight"));
	        double extraLuggageWeight = Double.parseDouble(request.getParameter("extraLuggageWeight"));
			
	        Flight flight = new Flight(
	                flightNum, departureDate, departureHour,
	                firstName, secondName, surname, ticketPrice, airlineName,
	                cabinLuggageWeight, extraLuggageWeight
	            );
			
	        FlightRepository.addFlight(flight);
	        
	        String source = "<!DOCTYPE html>" +
	        "<html>" +
				"<head>" +
					"<meta charset = 'UTF-8'>" +
				"</head>" +
				"<body>" +
					"<h1> Добавихте успешно полет!</h1>" +
					"<a href='index.html'> Обратно към Начална страница</a>" +
				"</body>" +
			"</html>";
	        
	        response.getWriter().println(source);
	        
		} catch (Exception exc) {
			
			String errorMsg = "<!DOCTYPE html>" +
			        "<html>" +
					"<head>" +
						"<meta charset = 'UTF-8'>" +
					"</head>" +
					"<body>" +
						"<h1> Грешка при добавянето на полет: " + exc + "</h1>" +
						"<a href='index.html'> Обратно към Начална страница</a>" +
					"</body>" +
				"</html>";
			
			response.getWriter().println(errorMsg);
		}
		
	}

}
