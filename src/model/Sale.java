package model;

import java.util.ArrayList;

public class Sale {
	private Client client;
	private ArrayList <Product> products =new ArrayList <Product>();
	private Amount amount;
        private static int totalSales;

	public Sale(Client client, ArrayList <Product> products, double amount) {
		super();
		this.client = client;
		this.products = products;
		this.amount = new Amount (amount);
                totalSales++;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ArrayList <Product> getProducts() {
		return products;
	}
        
        public String getProduct(int x) {
            String producto;
            if(products.get(x)!=null){
            producto = products.get(x).getName()+";";
            }
            else{
            producto="";
            }
            return producto;
	}

	public void setProducts(ArrayList <Product> products) {
		this.products = products;
	}

    public Amount getAmount() {
        return amount;
    }
    
    public String getAmountCurrency() {
        return amount.getValueCurrency();
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

	

    public static int getTotalSales() {
        return totalSales;
    }
        
        
        
	@Override
	public String toString() {
		return "Sale [client=" + client.getName() + ", products=" + products + ", amount=" + amount.getValueCurrency() + "]";
                
	}

}