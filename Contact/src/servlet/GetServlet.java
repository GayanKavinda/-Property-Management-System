package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contact.service.ContactUslmpl;
import com.contact.model.Inquiry;
import com.contact.service.ContactUslmpl;
import com.contact.service.IContactUs;

/**
 * Servlet implementation class GetServlet
 */
@WebServlet("/GetServlet")
public class GetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

 		String id = request.getParameter("id");			
		IContactUs iContactUs = new ContactUslmpl();
		Inquiry inquiry = iContactUs.getInquiryByID(id);

		request.setAttribute("inquiry", inquiry);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/View/GetInquiry.jsp");
		dispatcher.forward(request, response);
	}

}
