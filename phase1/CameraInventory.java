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
        System.out.println(Status);

        Camera camera = new Camera( brand, model, rentAmount, Status);
        hashmap.put(nextCameraId, camera);
        nextCameraId++;

        System.out.println("Camera added successfully!");
    }
    public void removeCamera(int cameraId) {
        Camera removedCamera = hashmap.remove(cameraId);
        if (removedCamera != null) {
            System.out.println("Camera with ID " + cameraId + " has been removed.");
        } else {
            System.out.println("Camera with ID " + cameraId + " does not exist.");
        }
    }

    public void displayCameras() {
        System.out.println("Camera Inventory:");
        for (HashMap.Entry<Integer, Camera> entry : hashmap.entrySet()) {
            int cameraId = entry.getKey();
            Camera camera = entry.getValue();
            System.out.println("Camera ID: " + cameraId);
            System.out.println("Brand: " + camera.getBrand());
            System.out.println("Model: " + camera.getModel());
            System.out.println("Rent Amount: " + camera.getRentAmount());
            System.out.println("Status: " + camera.getStatus());
            System.out.println("---------------");
        }
}  }  