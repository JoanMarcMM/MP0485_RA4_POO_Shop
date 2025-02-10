package main;

import java.util.ArrayList;
import model.Product;
import model.Sale;
import model.Amount;
import model.Employee;
import model.Client;
import java.util.Scanner;

public class Shop implements Logable {

    Amount cash = new Amount(100.00);
    private ArrayList<Product> inventory = new ArrayList<Product>();
    private int numberProducts;
    private ArrayList<Sale> sales = new ArrayList<Sale>();

    //Getters
    public double getCash() {
        return cash.getValue();
    }

    public String getCashCurrency() {
        return cash.getValueCurrency();
    }

    //
    final static double TAX_RATE = 1.04;

    public static void main(String[] args) {
        Shop shop = new Shop();

        shop.loadInventory();

        Employee employee = new Employee(123, "test", "test");

        Client client = new Client(456, 50.00, "test");

        ArrayList<Client> clients = new ArrayList<Client>();
        clients.add(client);

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        boolean exit = false;
        boolean loggedin = false;
        do {
            loggedin = shop.login(employee);
        } while (loggedin == false);

        do {
            System.out.println("\n");
            System.out.println("===========================");
            System.out.println("Main menu myShop.com");
            System.out.println("===========================");
            System.out.println("1) Count money on the register.");
            System.out.println("2) Add product.");
            System.out.println("3) Add stock,");
            System.out.println("4) Mark product close to expiration date.");
            System.out.println("5) See stock.");
            System.out.println("6) Sale.");
            System.out.println("7) See sales.");
            System.out.println("8) See nº of sales.");
            System.out.println("9) Delete product from stock.");
            System.out.println("10) Exit.");
            System.out.print("Select an option: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    shop.showCash();
                    break;

                case 2:
                    shop.addProduct();
                    break;

                case 3:
                    shop.addStock();
                    break;

                case 4:
                    shop.setExpired();
                    break;

                case 5:
                    shop.showInventory();
                    break;

                case 6:
                    shop.sale(clients);
                    break;

                case 7:
                    shop.showSales();
                    break;

                case 8:
                    shop.showNumberSales();
                    break;

                case 9:
                    shop.deleteProductInventory();
                    break;

                case 10:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;
            }
        } while (!exit);
    }

    /*
    * log in method
     */
    @Override
    public boolean login(Employee employee) {
        Scanner sc = new Scanner(System.in);

        int user;
        String password;
        boolean loggedin = false;
        boolean valid = false;
        try {
            System.out.println("===========================");
            System.out.println("Log in menu.");
            System.out.println("===========================");
            System.out.print("Employee ID: ");
            user = sc.nextInt();
            System.out.print("Password: ");
            password = sc.nextLine();
            //Adding extra scanner because sc not working properly.
            password = sc.nextLine();

            if (user == employee.getEMPLOYEE_ID() && password.equals(employee.getPASSWORD())) {
                System.out.println("Log in successful.");
                loggedin = true;
            } else {
                System.out.println("Employee not found.");
            }
        } catch (Exception e) {
            System.out.println("Please introduce valid data.");
        }

        return loggedin;
    }

    /**
     * load initial inventory to shop
     */
    public void loadInventory() {
        addProduct(new Product("Apple", 10.00, true, 10));
        addProduct(new Product("Pear", 20.00, true, 20));
        addProduct(new Product("Burger", 30.00, true, 30));
        addProduct(new Product("Strawberry", 5.00, true, 20));
    }

    /**
     * show current total cash
     */
    private void showCash() {
        System.out.println("Money : " + getCashCurrency());
    }

    /**
     * add a new product to inventory getting data from console
     */
    public void addProduct() {
        boolean admitir = true;
        boolean valid = false;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Name: ");
        String name = scanner.nextLine();
        for (Product product : inventory) {
            if (product != null) {
                if (name.equalsIgnoreCase(product.getName())) {
                    System.out.println("Product not admitted, already in the system");
                    admitir = false;
                }
            }
        }
        if (admitir) {
            do {
                try {
                    System.out.print("Wholesale price: ");
                    double wholesalerPrice = scanner.nextDouble();
                    System.out.print("Stock: ");
                    int stock = scanner.nextInt();

                    addProduct(new Product(name, wholesalerPrice, true, stock));
                    valid = true;
                } catch (Exception e) {
                    System.out.println("Please introduce a valid input.");
                }
            } while (valid == false);
        }
    }

    /**
     * add stock for a specific product
     */
    public void addStock() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select the name of the product: ");
        String name = scanner.next();
        Product product = findProduct(name);
        boolean valid = false;

        if (product != null) {
            do {
                try {

                    // ask for stock
                    System.out.print("Select the quantity that will be added: ");
                    int stock = scanner.nextInt();
                    // update stock product
                    product.setStock(product.getStock() + stock);
                    System.out.println("The stock of the product" + name + " has been updated to " + product.getStock());

                } catch (Exception e) {
                    System.out.println("Please introduce a valid input.");
                }
            } while (valid == false);
        } else {
            System.out.println("The product " + name + " has not been found.");
        }
    }

    /**
     * set a product as expired
     */
    private void setExpired() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select the name of the product: ");
        String name = scanner.next();

        Product product = findProduct(name);

        if (product != null) {
            product.expire();
            System.out.println("The price of the product " + name + " has been updated to " + product.getPublicPriceCurrency());

        }
    }

    /**
     * show all inventory
     */
    public void showInventory() {
        System.out.println("Shop stock:");
        for (Product product : inventory) {
            if (product != null) {
                System.out.println("===========================");
                System.out.println("Id: " + product.getId());
                System.out.println("Name: " + product.getName());
                System.out.println("Public price: " + product.getPublicPriceCurrency());
                System.out.println("Wholesale price: " + product.getWholesalerPriceCurrency());
                System.out.println("Stock " + product.getStock());
                System.out.println("===========================");
            }
        }
    }

    /**
     * make a sale of products to a client
     */
    public void sale(ArrayList<Client> clients) {

        //Creo arrayList para guardar los productos de la venta.
        ArrayList<Product> listaProductosSale = new ArrayList<Product>();

        boolean oweMoney = false;

        // ask for client name
        Scanner sc = new Scanner(System.in);

        System.out.println("Processing sale, write the name of the client");
        String nameClient = sc.nextLine();

        Client client = new Client(456, 50.00, nameClient);

        // sale product until input name is not 0
        double totalAmount = 0.0;
        String name = "";

        while (!name.equals("0")) {
            System.out.println("Introduce the name of the product, write 0 to end process:");
            name = sc.nextLine();

            if (name.equals("0")) {
                break;
            }
            Product product = findProduct(name);
            boolean productAvailable = false;

            if (product != null && product.isAvailable()) {
                productAvailable = true;
                totalAmount += product.getPublicPrice();
                product.setStock(product.getStock() - 1);
                listaProductosSale.add(product);
                // if no more stock, set as not available to sale
                if (product.getStock() == 0) {
                    product.setAvailable(false);
                }

                System.out.println("Product added successfully");
            }

            if (!productAvailable) {
                System.out.println("Product not found or out of stock");
            }

        }

        //Creo el objeto sale y lo guardo en sales
        sales.add(new Sale(client, listaProductosSale, totalAmount));

        // show cost total
        totalAmount = totalAmount * TAX_RATE;
        cash.setValue(cash.getValue() + totalAmount);
        System.out.println("Sale made successfully, total: " + totalAmount + "$");

        oweMoney = client.pay(client, totalAmount);

        if (oweMoney == true) {
            System.out.println(client.getName() + " owes: " + (client.getBALANCE().getValue() - totalAmount));
        } else {
            System.out.println(client.getName() + " doesn't own anything! ");
        }

    }

    /**
     * show all sales
     */
    private void showSales() {
        System.out.println("Sale List:");
        for (Sale sale : sales) {
            if (sale != null) {

                System.out.println("===========================");
                System.out.println("Id Sale: " + sales.indexOf(sale));
                System.out.println("Client: " + sale.getClient().getName());
                System.out.println("Products: ");
                for (Product product : sale.getProducts()) {
                    System.out.println(product.getName() + ", Precio: " + product.getPublicPriceCurrency());
                }
                System.out.println("");
                System.out.println("Price: " + sale.getAmountCurrency());
                System.out.println("===========================");
            }
        }
    }

    /**
     * show number of sales
     */
    private void showNumberSales() {

        System.out.println("The total number of sales is: " + Sale.getTotalSales());
    }

    /**
     * Delete product
     */
    private void deleteProductInventory() {
        Scanner sc = new Scanner(System.in);

        String productName;

        System.out.println("Indicate the name of the product you want to delete:");
        productName = sc.nextLine();
        if (findProduct(productName) != null) {
            inventory.remove(findProduct(productName));
            System.out.println("Product deleted.");
        } else {
            System.out.println("Product not found.");
        }
    }

    /**
     * add a product to inventory
     *
     * @param product
     */
    public void addProduct(Product product) {

        inventory.add(product);

    }

    /**
     * check if inventory is full or not
     *
     * @return true if inventory is full
     */
    /**
     * find product by name
     *
     * @param name
     * @return product found by name
     */
    public Product findProduct(String name) {
        for (Product product : inventory) {
            if (name.equalsIgnoreCase(product.getName())) {
                return product;
            }
        }

        return null;
    }

}
