package model;

public class Product {
	private int id;
	private String name;
	private Amount publicPrice ;
	private Amount wholesalerPrice;
	private boolean available;
	private int stock;
	private static int totalProducts;

	final static double EXPIRATION_RATE = 0.40;

	public Product(String name, double wholesalerPrice, boolean available, int stock) {
		super();
		this.id = totalProducts + 1;
		this.name = name;
		this.wholesalerPrice = new Amount (wholesalerPrice);
		this.available = available;
		this.stock = stock;
                this.publicPrice= new Amount (wholesalerPrice * 2);
		totalProducts++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public double getPublicPrice() {
        return publicPrice.getValue();
    }
    public String getPublicPriceCurrency() {
        return publicPrice.getValueCurrency();
    }

    public void setPublicPrice(double publicPrice) {
        this.publicPrice.setValue(getWholesalerPrice()*2);
    }

    public double getWholesalerPrice() {
        return wholesalerPrice.getValue();
    }
    
    public String getWholesalerPriceCurrency() {
        return wholesalerPrice.getValueCurrency();
    }

    public void setWholesalerPrice(double wholesalerPrice) {
        this.wholesalerPrice.setValue(wholesalerPrice) ;
    }

	

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public static int getTotalProducts() {
		return totalProducts;
	}

	public static void setTotalProducts(int totalProducts) {
		Product.totalProducts = totalProducts;
	}

	public void expire() {
		
		this.publicPrice.setValue(this.getPublicPrice()-(this.getPublicPrice() * EXPIRATION_RATE));
             
	}
}