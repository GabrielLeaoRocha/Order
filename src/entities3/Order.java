package entities3;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities3.enums.OrderStatus;

public class Order {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus os;
	
	private Client client;
	private List<OrderItem> item = new ArrayList<>();
	
	//contructors
	public Order() {
	}

	public Order(Date moment, OrderStatus os, Client client) {
		this.moment = moment;
		this.os = os;
		this.client = client;
	}

	//get and set
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getOs() {
		return os;
	}

	public void setOs(OrderStatus os) {
		this.os = os;
	}

	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public List<OrderItem> getItem() {
		return item;
	}
	
	//methods
	public void addItem (OrderItem item) {
		this.item.add(item);
	}
	
	public void removeItem (OrderItem item) {
		this.item.add(item);
	}
	
	public double total () {
		double sum = 0.0;
		for(OrderItem o : item) {
			sum += o.subTotal();
		}
		return sum;
	}
	
	//toString
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Order status: ");
		sb.append(os +"\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order Items: \n");
		for(OrderItem o : item) {
			sb.append(o + "\n");
		}
		sb.append("TotalPrice: $");
		sb.append(String.format("%.2f",total()));
		
		return sb.toString();
	}
}
