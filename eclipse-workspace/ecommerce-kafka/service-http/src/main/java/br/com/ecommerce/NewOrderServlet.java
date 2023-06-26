package br.com.ecommerce;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ecommerce.dispatcher.KafkaDispatcher;

public class NewOrderServlet extends HttpServlet {

	private final KafkaDispatcher<Order> orderDispatcher = new KafkaDispatcher<>();

	@Override
	public void destroy() {
		super.destroy();
		try {
			orderDispatcher.close();
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
			var orderId = req.getParameter("uuid");
			var amount = new BigDecimal(req.getParameter("amount"));
			var email = req.getParameter("email");

			var order = new Order(orderId, amount, email);

			try (var database = new OrdersDatabase()) {
				if (database.saveNew(order)) {
					orderDispatcher.send("ECOMMERCE_NEW_ORDER", email,
							new CorrelationId(NewOrderServlet.class.getSimpleName()), order);

					System.out.println("New order sent successfully");
					resp.setStatus(HttpServletResponse.SC_OK);
					resp.getWriter().print("New order sent");

				} else {
					System.out.println("Older order sent received");
					resp.setStatus(HttpServletResponse.SC_OK);
					resp.getWriter().print("Older order received");

				}
			}

		} catch (ExecutionException | InterruptedException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};

}
