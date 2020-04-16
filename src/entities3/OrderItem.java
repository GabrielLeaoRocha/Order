package entities3;

public class OrderItem {

	private Integer qntd;
	private Double price;
	
	private Product product;
	
	//contructors
	public OrderItem() {
	}

	public OrderItem(Integer qntd, Double price) {
		this.qntd = qntd;
		this.price = price;
	}
	
	public OrderItem(Integer qntd, Double price, Product product) {
		this.qntd = qntd;
		this.price = price;
		this.product = product;
	}

	//get and set
	public Integer getQntd() {
		return qntd;
	}

	public void setQntd(Integer qntd) {
		this.qntd = qntd;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	//methods
	public double subTotal() {
		return qntd * price;
	}
	
	//toString
	public String toString() {
		return product.getName() 
				+", $"
				+String.format("%.2f", price)
				+", Quantity: "
				+qntd
				+", Subtotal: $"
				+String.format("%.2f", subTotal());
	}
}
