package application3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities3.Client;
import entities3.Order;
import entities3.OrderItem;
import entities3.Product;
import entities3.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		
		//client register
		System.out.println("ENTER CLIENT DATA: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("E-mail: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YY): ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthDate);
		
		//order data
		System.out.println("ENTER ORDER DATA: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);
		
		//item data
		System.out.println("How many items to this order? ");
		int N = sc.nextInt();
		for(int x = 1; x <= N; x++) {
			System.out.println("ENTER " + x + "# ITEM DATA: ");
			System.out.print("Product name: ");
			sc.nextLine();
			String nameProduct = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			
			Product product = new Product(nameProduct, price);
			
			System.out.print("Quantity: ");
			int qntd = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(qntd, price, product);
			order.addItem(orderItem);
		}
		
		System.out.println("ORDER SUMARY: ");
		System.out.println(order);
		
		sc.close();
	}

}
