package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Flight;
import repository.FlightRepository;

/**
 * Servlet implementation class AllFlightsJSON
 */
@WebServlet("/api/AllFlightsJSON")
public class AllFlightsJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AllFlightsJSON() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 List<Flight> flights = FlightRepository.getFlightsArrList();

	        response.setContentType("application/json");
	        PrintWriter out = response.getWriter();
	        out.print("[");
	        for (int i = 0; i < flights.size(); i++) {
	            out.print(flights.get(i).toJson());
	            if (i < flights.size() - 1) out.print(",");
	        }
	        out.print("]");
	}

}
