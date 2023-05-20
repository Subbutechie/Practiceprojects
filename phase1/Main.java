package phase1;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("=================================");
		System.out.println("|   WELCOME TO CAMERA RENTAL.IO |");
		System.out.println("=================================");
		System.out.println("PLEASE LOGIN TO CONTINUE -");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Username: ");
		String un = sc.nextLine();
		System.out.println("Password: ");
		String p = sc.nextLine();
		HashMap<Integer,Camera> hashmap= new HashMap<>();

			Camera camera1 = new Camera("Sony","Alpha A7",2500,"Available");
			Camera camera2 = new Camera("Canon","EOS 5D",3000,"Available");
			Camera camera3 = new Camera("Nikon","D850",3500,"Available");
			Camera camera4 = new Camera("GoPro","Hero 9",4000,"Rented");
			Camera camera5 = new Camera("Fujifilm","X-24",4500,"Available");
			
			hashmap.put(1, camera1);
			hashmap.put(2, camera2);
			hashmap.put(3, camera3);
			hashmap.put(4, camera4);
			hashmap.put(5, camera5);
			System.out.println("----------MENU------------");
			System.out.println("1. MY CAMERA");
			System.out.println("2. RENT A CAMERA");
			System.out.println("3. VIEW ALL CAMERAS");
			System.out.println("4. MY WALLET");
			System.out.println("5. EXIT");
	
			
		boolean running = true;
		
		while(running) {
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				int submenu =0;
				System.out.println("1. ADD CAMERA");
				System.out.println("2. REMOVE");
				System.out.println("3. VIEW MY CAMERAS");
				System.out.println("4. GO TO PREVIOUS MENU");
				submenu = sc.nextInt();
				CameraInventory op = new CameraInventory(hashmap);
				while(submenu != 4) {
					switch(submenu) {
					case 1: 
						
						op.addCamera();
						break;
					case 2:
						
						System.out.println("Enter the camera ID: ");
						int key  = sc.nextInt();
						op.removeCamera(key);
						break;
					case 3:
						
						op.displayCameras();
						break;
					case 4:
						System.out.println("Going to previous menu");
						break;
					default:
						System.out.println("Invalid choice");
					}
					 System.out.println("1. ADD CAMERA");
		                System.out.println("2. REMOVE");
		                System.out.println("3. VIEW MY CAMERAS");
		                System.out.println("4. GO TO PREVIOUS MENU");
		                submenu = sc.nextInt();
				}
                System.out.println("Going back to PREVIOUS MENU");
                System.out.println("----------MENU------------");
    			System.out.println("1. MY CAMERA");
    			System.out.println("2. RENT A CAMERA");
    			System.out.println("3. VIEW ALL CAMERAS");
    			System.out.println("4. MY WALLET");
    			System.out.println("5. EXIT");
				break;
			case 2:
				
				
			}
		}
				

	}

}
class Camera {
    public String brand;
    public String model;
    public double rentAmount;
    public String Status;

    public Camera(String brand, String model, double rentAmount, String Status) {
        this.brand = brand;
        this.model = model;
        this.rentAmount = rentAmount;
        this.Status = Status;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getRentAmount() {
        return rentAmount;
    }
    public String getStatus() {
    	return Status;
    }
}
