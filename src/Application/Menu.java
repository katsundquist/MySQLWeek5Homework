package Application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.FabricDao;
import entity.Fabric;

public class Menu {

	private FabricDao fabricDao = new FabricDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display all fabrics", 
			"Display a fabric",
			"Create fabric entry",
			"Update fabric entry",
			"Delete fabric entry"
			);
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try {
				if(selection.equals("1")) {
					displayFabrics();
					//displays all fabrics
				}else if(selection.equals("2")) {
					displayFabric();
					//displays a particular fabric "R"
				}else if(selection.equals("3")) {
					createFabric();
					//create new fabric entry "C"
				}else if(selection.equals("4")) {
					updateFabric();
					//updates a particular fabric entry "U"
				}else if(selection.equals("5")) {
					deleteFabric();
					//deletes a fabric from DB "D"
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
				
			System.out.println("Press enter to continue.......");
			scanner.nextLine();
		} while (!selection.equals("-1"));
	}
	
	private void printMenu() {
		System.out.println("Select an option or press -1 to exit:\n-----------------------");
		for(int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
			
		}
	}
	
	private void displayFabrics() throws SQLException {
		List<Fabric> fabrics = fabricDao.getFabrics();
		for (Fabric fabric : fabrics) {
			System.out.println(fabric.getFabricId() + ": " + fabric.getFiberContent() + " " + fabric.getFabricType()
			+ " " + fabric.getYardage() +  " yards in " + fabric.getColor());
		}
	}
	
	private void displayFabric() throws SQLException {
		System.out.println("Enter fabric ID: ");
		int id = Integer.parseInt(scanner.nextLine());
		Fabric fabric = fabricDao.getFabricById(id);
		System.out.println(fabric.getFabricId() + ": " + fabric.getFiberContent() + " " + fabric.getFabricType());
	}
	
	private void createFabric() throws SQLException {
		System.out.print("Enter new fabric info: \n");
		System.out.println("Enter fabric type: ");
		String fabricType = scanner.nextLine();
		System.out.println("Enter fiber content: ");
		String fiberContent = scanner.nextLine();
		System.out.println("Enter yardage: ");
		float yardage = Float.parseFloat(scanner.nextLine());
		System.out.println("Enter color: ");
		String color = scanner.nextLine();
		
		fabricDao.createNewFabric(fabricType, fiberContent, yardage, color);
	}
	
	private void updateFabric() throws SQLException {
		System.out.print("Enter fabric ID to update: ");
		int id = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter updated fabric type: ");
		String fabricType = scanner.nextLine();
		System.out.println("Enter updated fiber content: ");
		String fiberContent = scanner.nextLine();
		System.out.println("Enter updated yardage: ");
		float yardage = Float.parseFloat(scanner.nextLine());
		System.out.println("Enter updated color: ");
		String color = scanner.nextLine();
		
		fabricDao.updateFabricById(fabricType, fiberContent, yardage, color, id);
	}
	
	private void deleteFabric() throws SQLException {
		System.out.print("Enter fabric ID to delete: ");
		int id = Integer.parseInt(scanner.nextLine());
		fabricDao.deleteFabricByID(id);
	}
}
