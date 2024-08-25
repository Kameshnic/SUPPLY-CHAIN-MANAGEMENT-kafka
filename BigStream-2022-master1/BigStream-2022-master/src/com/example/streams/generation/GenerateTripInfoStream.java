package com.example.streams.generation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

//import com.example.streams.generation.TripInfo.Coordinate;

public class GenerateTripInfoStream {
	public static void main(String[] args) throws InterruptedException, IOException {

		File file = new File("prod-info.json");
		FileWriter fw = new FileWriter(file,true);
		BufferedWriter bw = new BufferedWriter(fw);
		while (true) {

			int recordsCount = new Random().nextInt(15);
			for (int i = 0; i <= recordsCount; i++) {
				TripInfo tripInfo = new TripInfo();
				/*Map<String, String> coords = RandomDataGenUtility.randomLonLat(12, 14, 80, 82);

				Coordinate p1 = new Coordinate();
				p1.setLat(Double.parseDouble(coords.get("J")));
				p1.setLon(Double.parseDouble(coords.get("W")));

				tripInfo.setPickupPoint(p1);

				coords = RandomDataGenUtility.randomLonLat(10, 12, 77, 80);

				Coordinate p2 = new Coordinate();
				p2.setLat(Double.parseDouble(coords.get("J")));
				p2.setLon(Double.parseDouble(coords.get("W")));

				tripInfo.setDropPoint(p2);
				tripInfo.setSearchId(UUID.randomUUID().toString());*/
				String[] names = {"Arun", "Karthik", "Vignesh", "Siva", "Muthu", "Praveen", "Rajesh", "Saravanan", "Vasanth", "Ganesh"};
				tripInfo.setName(RandomDataGenUtility.randomElement(names));

				String[] amazonProducts = {
						"Echo Dot (4th Gen)", "Fire TV Stick", "Kindle Paperwhite",
						"AmazonBasics AA Batteries", "Ring Video Doorbell",
						"Amazon Echo Show 8", "Fire HD 10 Tablet",
						"AmazonBasics Laptop Sleeve", "Blink Outdoor Camera",
						"Amazon Fire TV Cube"
				};
				tripInfo.setProduct(RandomDataGenUtility.randomElement(amazonProducts));
				String[] seller = {"Arun", "Karthik", "Duoee", "Jeva", "Mutasdu", "Praveen", "Rajesh", "Saravanan", "Vasanth", "Ganesh"};
				tripInfo.setsName(RandomDataGenUtility.randomElement(seller));
				String[] locations = {
						"Viman Nagar", "Kothrud (Pune)", "Pune City Hub",
						"Chennai Airport Hub", "Thiruvanmiyur", "Vandalur", "Kelambakkam"
				};
				tripInfo.setLoc(RandomDataGenUtility.randomElement(locations));
				String[] warehouse = {
						"Pune Warehouse", "Mumbai Warehouse", "Chennai Warehouse", "Bangalore Warehouse"
				};
				tripInfo.setWarehouse(RandomDataGenUtility.randomElement(warehouse));
				String[] statuses = {
						"Online Shipment Booked", "Shipment Picked Up", "Shipment Arrived",
						"Shipment Further Connected", "Delivery Scheduled For Next Working Day",
						"Shipment Out For Delivery", "Shipment Delivered"
				};
				tripInfo.setStatus(RandomDataGenUtility.randomElement(statuses));
				/*String[] typeOfVehicle = { "Two-Wheeler", "Auto", "Mini", "Sedan", "SUV" };
				tripInfo.setTypeOfVehicle(RandomDataGenUtility.randomElement(typeOfVehicle));

				//String[] paymentMethod = { "cash", "gpay", "paytm", "phone-pe", "post-paid" };
				tripInfo.setPaymentMethod(RandomDataGenUtility.randomElement(paymentMethod));

				//String[] passengers = { "Ajay", "Bala", "Cyan", "Dinesh", "Ezhil" };
				tripInfo.setPrimaryPassangerName(RandomDataGenUtility.randomElement(passengers));

				tripInfo.setPrimaryPassangerContact(RandomDataGenUtility.randomPhoneno());

				tripInfo.setEstimatedPrice(RandomDataGenUtility.randomBetween(100, 876));*/

				bw.write(tripInfo.toString()+"\n");
				
			}
			
			bw.flush();
			Thread.sleep(1000);
			System.out.println("written "+recordsCount +" to the file.");
		}
		
	}
}
