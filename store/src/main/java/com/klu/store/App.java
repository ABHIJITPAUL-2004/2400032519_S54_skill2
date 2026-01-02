package com.klu.store;

import java.util.*;
import com.klu.store.dao.ProductDAO;
import com.klu.store.entity.Product;

public class App {

    public static void main(String[] args) {

        ProductDAO dao = new ProductDAO();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== PRODUCT MENU =====");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. View Product By ID");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("Enter product name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter product description: ");
                    String desc = sc.nextLine();

                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();
                    
                    

                    dao.saveProduct(new Product(name, desc, price, qty));
                    System.out.println("✅ Product added successfully");
                    break;

                case 2:
                    List<Product> products = dao.getProducts();
                    if (products.isEmpty()) {
                        System.out.println("No products available");
                    } else {
                        System.out.println("\nID | NAME | DESC | PRICE | QTY");
                        for (Product p : products) {
                            System.out.println(
                                p.getPid() + " | " +
                                p.getPname() + " | " +
                                p.getDesc() + " | " +
                                p.getPrice() + " | " +
                                p.getQty()
                            );
                        }
                    }
                    break;


                case 3:
                    System.out.print("Enter product ID: ");
                    int id = sc.nextInt();

                    Product p = dao.getByProductId(id);
                    if (p != null) {
                        System.out.println(
                            p.getPid() + " | " +
                            p.getPname() + " | " +
                            p.getDesc() + " | " +
                            p.getPrice() + " | " +
                            p.getQty()
                        );
                    } else {
                        System.out.println("❌ Record Not Found");
                    }
                    break;

                case 4:
                    System.out.print("Enter product ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    Product updateProduct = dao.getByProductId(uid);

                    if (updateProduct != null) {

                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine();

                        System.out.print("Enter new description: ");
                        String newDesc = sc.nextLine();

                        System.out.print("Enter new price: ");
                        double newPrice = sc.nextDouble();

                        System.out.print("Enter new quantity: ");
                        int newQty = sc.nextInt();

                        updateProduct.setPname(newName);
                        updateProduct.setDesc(newDesc);
                        updateProduct.setPrice(newPrice);
                        updateProduct.setQty(newQty);

                        boolean updated = dao.updateProduct(updateProduct);
                        System.out.println(updated ? "✅ Product updated successfully" : "❌ Update failed");

                    } else {
                        System.out.println("❌ Product not found");
                    }
                    break;


                case 5:
                    System.out.print("Enter product ID to delete: ");
                    int did = sc.nextInt();

                    boolean deleted = dao.deleteProduct(did);
                    System.out.println(deleted ? "✅ Product deleted" : "❌ Product not found");
                    break;

                case 6:
                    System.out.println("Exiting application...");
                    showProgressBar();
                    break;

                default:
                    System.out.println("❌ Invalid choice");
            }

        } while (choice != 6);

        sc.close();
    }

    private static void showProgressBar() {
        for (int i = 0; i <= 20; i++) {
            String bar = "█".repeat(i) + " ".repeat(20 - i);
            System.out.print("\r[" + bar + "] " + (i * 5) + "%");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("\nGoodbye");
    }
}
