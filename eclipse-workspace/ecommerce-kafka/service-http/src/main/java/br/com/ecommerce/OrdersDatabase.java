package br.com.ecommerce;

import java.io.Closeable;
import java.io.IOException;
import java.sql.SQLException;

import br.com.database.LocalDatabase;

public class OrdersDatabase implements Closeable{

	private final LocalDatabase database;

	public OrdersDatabase() throws SQLException {
		this.database = new LocalDatabase("orders_database");

		
		// you might want to save all data
		database.creatIfNotExists("create table Orders (" + "uuid varchar(200) primary key)");

	}

	public boolean saveNew(Order order) throws SQLException {
		if(wasProcessed(order)) {
			return false;
		}
		var results = database.update("insert into Oders (uuid) values (?)", order.getOrderId());
		return true;

	}	

	private boolean wasProcessed(Order order) throws SQLException {
		var results = database.query("select uuid from Orders where uuid = ? limit 1", order.getOrderId());
		return results.next();
	}

	@Override
	public void close() throws IOException {
		try {
			database.close();
		} catch (SQLException e) {
			throw new IOException();
		}		
	}		
}
