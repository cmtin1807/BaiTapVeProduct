import ss17.Product;
import ss17.ProductManager;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        ProductManager productManager = new ProductManager();
        Scanner scanner = new Scanner(System.in);
        File file = null;
        file = new File("F://CodeGym//Module2//src//ss17//data.txt");
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
        String line2 = "";
        while ((line2 = bufferedReader2.readLine()) != null) {
            String[] dataProduct = line2.split(",");
            productManager.addProduct(new Product(Integer.parseInt(dataProduct[0]), dataProduct[1], Integer.parseInt(dataProduct[2]), dataProduct[3], dataProduct[4]));
        }
        bufferedReader2.close();
        while (true) {
            file = new File("F://CodeGym//Module2//src//ss17//data.txt");
            System.out.println("Main Menu");
            System.out.println("1. Add Product");
            System.out.println("2. Delete Product");
            System.out.println("3. Display Product");
            System.out.println("4. Update Product");
            System.out.println("0. Exit");
            System.out.println("Enter your choice");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Name Product");
                    String name = scanner.next();
                    System.out.println("Enter Price Product");
                    int price = scanner.nextInt();
                    System.out.println("Enter Company Product");
                    String company = scanner.next();
                    System.out.println("Enter Description Product");
                    String description = scanner.next();
                    int id = productManager.getLastId() + 1;
                    productManager.addProduct(new Product(id, name, price, company, description));
                    FileWriter fileWriter = new FileWriter(file, true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    String data = id + "," + name + "," + price + "," + company + "," + description + "\n";
                    bufferedWriter.write(data);
                    bufferedWriter.close();
                    break;
                case 2:
                    System.out.println("Enter Id Remove Product");
                    int removeId = scanner.nextInt();
                    ArrayList<Product> products = new ArrayList<>();
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    String line = "";
                    while ((line = bufferedReader.readLine()) != null) {
                        String[] dataRemove = line.split(",");
                        boolean haveIdRemove = false;
                        if (dataRemove[0].equals(removeId)) {
                            haveIdRemove = true;
                        } else {
                            products.add(new Product(Integer.parseInt(dataRemove[0]), dataRemove[1], Integer.parseInt(dataRemove[2]), dataRemove[3], dataRemove[4]));
                        }
                        bufferedReader.close();
                        BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file));
                        for (Product product : products) {
                            bufferedWriter2.write(product.toString() + "\n");
                        }
                        bufferedWriter2.close();
                    }
                    break;
                case 3:
                    productManager.printAllProducts();
                    break;
                case 4:
                    System.out.println("Enter Id Update Product");
                    int updateId = scanner.nextInt();
                    ArrayList<Product> productsUpdate = new ArrayList<>();
                    BufferedReader bufferedReaderUpdate = new BufferedReader(new FileReader(file));
                    String line4;
                    boolean haveIdUpdate = false;
                    while ((line4 = bufferedReaderUpdate.readLine()) != null) {
                        String[] dataUpdate = line4.split(",");
                        if (dataUpdate[0].equals(updateId)) {
                            haveIdUpdate = true;
                            System.out.println("Enter Name Update Product");
                            String nameUpdate = scanner.next();
                            System.out.println("Enter Price Update Product");
                            int priceUpdate = scanner.nextInt();
                            System.out.println("Enter Company Update Product");
                            String companyUpdate = scanner.next();
                            System.out.println("Enter Description Update Product");
                            String descriptionUpdate = scanner.next();
                            productsUpdate.add(new Product(updateId, nameUpdate, priceUpdate, companyUpdate, descriptionUpdate));
                        }
                        else {
                            productsUpdate.add(new Product(Integer.parseInt(dataUpdate[0]), dataUpdate[1], Integer.parseInt(dataUpdate[2]), dataUpdate[3], dataUpdate[4]));
                        }

                    }
                    bufferedReaderUpdate.close();
                    BufferedWriter bufferedWriter3 = new BufferedWriter(new FileWriter(file));
                    for (Product product : productsUpdate) {
                        bufferedWriter3.write(product.toString() + "\n");
                    }
                    bufferedWriter3.close();
                    break;
                case 0:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");

            }
        }
    }
}
