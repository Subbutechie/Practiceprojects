package phase1;
import java.util.*;

public class CameraInventory {
    private HashMap<Integer, Camera> hashmap;
    public int nextCameraId;
    
    public CameraInventory(HashMap<Integer, Camera> hashmap) {
        this.hashmap = hashmap;
        nextCameraId = 1;
    }

    public void addCamera() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the brand of the camera: ");
        String brand = scanner.nextLine();
        System.out.print("Enter the model of the camera: ");
        String model = scanner.nextLine();
        System.out.print("Enter the rent amount of the camera: ");
        double rentAmount = scanner.nextDouble();
        String Status = "AVAILABLE";

        Camera camera = new Camera( brand, model, rentAmount, Status);
        hashmap.put(nextCameraId, camera);
        nextCameraId++;

        System.out.println("Camera added successfully to the list");
        System.out.println("------NEXT-------");
    }
    public void removeCamera(int cameraId) {
        Camera removedCamera = hashmap.remove(cameraId);
        if (removedCamera != null) {
            System.out.println("Camera with ID " + cameraId + " has been removed from the list.");
            System.out.println("-----------------------------------------------------------------");
        } else {
            System.out.println("Camera with ID " + cameraId + " does not exist.");
            System.out.println("-------------------------------------------------");
        }
    }

    public void displayCameras() {
        System.out.println("Camera Inventory:");
        System.out.println("=========================================================================================");
            System.out.printf("%-10s %-15s %-20s %-15s %s%n", "Camera ID", "Brand", "Model", "Rent Amount", "Status");
            System.out.println("=====================================================================================");
            for (HashMap.Entry<Integer, Camera> entry : hashmap.entrySet()) {
                int cameraId = entry.getKey();
                Camera camera = entry.getValue();
                System.out.printf("%-10d %-15s %-20s %-15.2f %s%n",
                        cameraId, camera.getBrand(), camera.getModel(), camera.getRentAmount(), camera.getStatus());
                System.out.println("-----------------------------------------------------------------------------");
            }

     }
        public void mycameras() {
            System.out.println("List of my cameras");
            System.out.println("====================================================================================");
        	System.out.printf("%-10s %-15s %-20s %-15s %s%n", "Camera ID", "Brand", "Model", "Rent Amount", "Status");
        	System.out.println("=====================================================================================");
            for (HashMap.Entry<Integer, Camera> my : hashmap.entrySet()) {
                int cameraId = my.getKey();
                Camera camera = my.getValue();
                if (camera.getStatus().equalsIgnoreCase("rented")) {
                	System.out.printf("%-10d %-15s %-20s %-15.2f %s%n",
                             cameraId, camera.getBrand(), camera.getModel(), camera.getRentAmount(), camera.getStatus());
                	System.out.println("----------------------------------------------------------------------------");
                }
            }
        }

        	
        public void rentCamera(int cameraId, double walletBalance) {
            Camera camera = hashmap.get(cameraId);
            if (camera != null) {
                if (camera.getStatus().equalsIgnoreCase("Available")) {
                    double rentAmount = camera.getRentAmount();
                    if (walletBalance >= rentAmount) {
                        camera.setStatus("Rented");
                        System.out.println("Camera with ID " + cameraId + " has been rented.");
                        walletBalance -= rentAmount;
                        System.out.println("Wallet balance after renting: " + walletBalance);
                    } else {
                        System.out.println("error: Transaction failed due to Insufficient balance. Please Deposit the amount to the wallet.");
                    }
                } else {
                    System.out.println("Camera with ID " + cameraId + " is not available for rent.");
                }
            } else {
                System.out.println("Camera with ID " + cameraId + " does not exist.");
            }
        }

    	
    	
    	
    
}  