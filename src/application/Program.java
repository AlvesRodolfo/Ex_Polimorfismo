package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
			Locale.setDefault(Locale.US);
			Scanner sc = new Scanner (System.in);
			SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
			List<Product> list = new ArrayList<>();
			
			System.out.print("ENTER THE NUMBER OF PRODUCTS:  ");
			int n = sc.nextInt();
			
			for (int a = 1; a <= n; a ++) {
				
				System.out.println("Product #" + a + " data: ");
				System.out.print("Common, used or imported (c/u/i)?  ");
				char c = sc.next().charAt(0);
				sc.nextLine();
				System.out.print("Name:  ");
				String name = sc.nextLine();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				
				if (c == 'i') {
					System.out.print("Customs fee:  ");
					double fee = sc.nextDouble();
					
					Product imp = new ImportedProduct(name, price, fee);
					list.add(imp);
					
				}
				
				else if (c == 'u') {
					System.out.print("Manufacture date (dd/MM/yyyy):  ");
					Date data = sdf.parse(sc.next());
					Product used = new UsedProduct(name, price, data);
					list.add(used);
					
				}
				
				else {
					
					Product product = new Product(name, price);
					list.add(product);
				}
			}
			
			System.out.println();
			System.out.println("PRICE TAGS:");
			for (Product p : list) {
				
				System.out.println(p.priceTag());
			}
			
			sc.close();
	}

}
