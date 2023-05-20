package phase1;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("=================================");
		System.out.println("|   WELCOME TO CAMERA RENTAL.IO |");
		System.out.println("=================================");
		System.out.println("                            By SubbaReddy PV");
		System.out.println("PLEASE LOGIN TO CONTINUE -");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Username: ");
		System.out.println("Password: ");
		String p = sc.nextLine();
		// press ENTER to continue
		
		HashMap<Integer,Camera> hashmap= new HashMap<>();

			Camera camera1 = new Camera("Sony","Alpha A7",2500,"AVAILABLE");
			Camera camera2 = new Camera("Canon","EOS 5D",3000,"RENTED");
			Camera camera3 = new Camera("Nikon","D850",3500,"AVAILABLE");
			Camera camera4 = new Camera("GoPro","Hero 9",4000,"RENTED");
			Camera camera5 = new Camera("Chroma","CT",1000,"RENTED");
			Camera camera6 = new Camera("Fujifilm","X-24",4500,"AVAILABLE");
			Camera camera7 = new Camera("Panasonic Lumix","GH5",2500,"AVAILABLE");
			Camera camera8 = new Camera("Leica","Q2",1800,"RENTED");
			Camera camera9 = new Camera("DJI Mavic ","2 Pro",1500,"AVAILABLE");
			Camera camera10 = new Camera("Olympus","OM-D E-M1 Mark III",4200,"AVAILABLE");
			Camera camera11 = new Camera("DJI","Mavic 2 Pro",6500,"AVAILABLE");
			Camera camera12 = new Camera("Sony","Cyber-shot RX100 VII",5500,"RENTED");
			Camera camera13 = new Camera("Olympus","PEN-F",8700,"AVAILABLE");
			Camera camera14 = new Camera("DJI","Osmo Pocket",4300,"AVAILABLE");
			Camera camera15 = new Camera("GoPro","Hero8 Black",5700,"AVAILABLE");
			
			hashmap.put(1, camera1);
			hashmap.put(2, camera2);
			hashmap.put(3, camera3);
			hashmap.put(4, camera4);
			hashmap.put(5, camera5);
			hashmap.put(6, camera6);
			hashmap.put(7, camera7);
			hashmap.put(8, camera8);
			hashmap.put(9, camera9);
			hashmap.put(10, camera10);
			hashmap.put(11, camera11);
			hashmap.put(12, camera12);
			hashmap.put(13, camera13);
			hashmap.put(14, camera14);
			hashmap.put(15, camera15);
			
			
			System.out.println("----------MENU------------");
			System.out.println("1. MY CAMERA");
			System.out.println("2. RENT A CAMERA");
			System.out.println("3. VIEW ALL CAMERAS");
			System.out.println("4. MY WALLET");
			System.out.println("5. EXIT");
	
			
		boolean running = true;
		
		while(running) {
			int choice = sc.nextInt();
			double walletBalance = 10000;
			
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
						System.out.println("Enter the camera ID to remove: ");
						int key  = sc.nextInt();
						op.removeCamera(key);
						break;
						
					case 3:
						op.mycameras();
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
				CameraInventory disp = new CameraInventory(hashmap);
				disp.displayCameras();
				System.out.println("Enter camera ID to rent");
				int cameraId = sc.nextInt();
				disp.rentCamera( cameraId, walletBalance);
				System.out.println("Continue your search");
				System.out.println("----------MENU------------");
    			System.out.println("1. MY CAMERA");
    			System.out.println("2. RENT A CAMERA");
    			System.out.println("3. VIEW ALL CAMERAS");
    			System.out.println("4. MY WALLET");
    			System.out.println("5. EXIT");
				break;
			
			case 3:
				CameraInventory show = new CameraInventory(hashmap);	
				System.out.println("Inventory");
				show.displayCameras();
				System.out.println("Continue further");
				System.out.println("----------MENU------------");
    			System.out.println("1. MY CAMERA");
    			System.out.println("2. RENT A CAMERA");
    			System.out.println("3. VIEW ALL CAMERAS");
    			System.out.println("4. MY WALLET");
    			System.out.println("5. EXIT");
				break;
			case 4:
				System.out.println("YOUR CURRENT WALLET BALANCE IS " +walletBalance);
				System.out.println("Do you want to add balance to your wallet(1.YES/2.NO");
				int opt = sc.nextInt();
				if(opt == 1) {
					System.out.println("Enter the amount to add: ");
					int deposit = sc.nextInt();
					walletBalance += deposit;
					System.out.println("YOUR WALLET BALANCE IS UPDATED SUCCESSFULLY");
					System.out.println("CURRENT WALLET BALANCE IS:" +walletBalance);
				}
				System.out.println("Continue your search");
				System.out.println("----------MENU------------");
    			System.out.println("1. MY CAMERA");
    			System.out.println("2. RENT A CAMERA");
    			System.out.println("3. VIEW ALL CAMERAS");
    			System.out.println("4. MY WALLET");
    			System.out.println("5. EXIT");
				break;
			case 5:
				running = false;
				System.out.println("Thank you, Happy Filming!");
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
    public void setStatus(String Status) {
    	this.Status = Status;
    }


	
}
