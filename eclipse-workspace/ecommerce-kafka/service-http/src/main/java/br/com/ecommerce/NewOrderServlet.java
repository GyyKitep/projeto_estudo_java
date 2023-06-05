package br.com.ecommerce;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewOrderServlet extends HttpServlet {

	private final KafkaDispatcher<Order> orderDispatcher = new KafkaDispatcher<>();
	private final KafkaDispatcher<Email> emailDispatcher = new KafkaDispatcher<>();
	
	@Override
	public void destroy() {
		super.destroy();
		try {
			orderDispatcher.close();
			emailDispatcher.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			// we are not caring about any security issues, we are only
			// showing how to use http as a starting point
			var orderId = UUID.randomUUID().toString();
			var amount = new BigDecimal(req.getParameter("amount"));
			var email = req.getParameter("email");

			var order = new Order(orderId, amount, email);

			orderDispatcher.send("ECOMMERCE_NEW_ORDER", email, order);

			var emailCode = new Email("email_subject", "email_body");
			emailDispatcher.send("ECOMMERCE_SEND_EMAIL", email, emailCode);

			System.out.println("New order sent successfully");

			resp.setStatus(HttpServletResponse.SC_OK);
			resp.getWriter().print("New order sent");

		} catch (InterruptedException e) {
			throw new ServletException(e);
		} catch (ExecutionException e) {
			throw new ServletException(e);
		}
	};

}
