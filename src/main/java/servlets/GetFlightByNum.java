package servlets;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Flight;
import repository.FlightRepository;

/**
 * Servlet implementation class GetFlightByNum
 */
@WebServlet("/api/GetFlightByNum")
public class GetFlightByNum extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GetFlightByNum() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flightNum = request.getParameter("flightNum");
        List<Flight> flights = FlightRepository.getFlightsArrList();

        response.setContentType("application/json");
        for (Flight f : flights) {
            if (f.getFlightNum().equalsIgnoreCase(flightNum)) {
                response.getWriter().write(f.toJson());
                return;
            }
        }

        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        response.getWriter().write("{\"error\":\"Flight not found\"}");
    }

}
