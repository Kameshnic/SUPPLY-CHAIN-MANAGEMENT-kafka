package com.example.streams.generation;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;



public class GenerateTripInfoStreamToKafka {
    public static void main(String[] args) throws InterruptedException, IOException {
        while (true) {

            int recordsCount = RandomDataGenUtility.randomIntBetween(4, 15);
            for (int i = 0; i <= recordsCount; i++) {
                TripInfo tripInfo = new TripInfo();

                // Set values according to the new TripInfo structure
                tripInfo.setProduct(RandomDataGenUtility.randomElement(new String[] {
                        "Echo Dot (4th Gen)", "Fire TV Stick", "Kindle Paperwhite",
                        "AmazonBasics AA Batteries", "Ring Video Doorbell",
                        "Amazon Echo Show 8", "Fire HD 10 Tablet",
                        "AmazonBasics Laptop Sleeve", "Blink Outdoor Camera",
                        "Amazon Fire TV Cube"
                }));
                tripInfo.setsName(RandomDataGenUtility.randomElement(new String[] {"Arun", "Karthik", "Duoee", "Jeva", "Mutasdu", "Praveen", "Rajesh", "Saravanan", "Vasanth", "Ganesh"}));
                tripInfo.setName(RandomDataGenUtility.randomElement(new String[] {"Arun", "Karthik", "Vignesh", "Siva", "Muthu", "Praveen", "Rajesh", "Saravanan", "Vasanth", "Ganesh"}));
                tripInfo.setLoc(RandomDataGenUtility.randomElement(new String[] {
                        "Viman Nagar", "Kothrud (Pune)", "Pune City Hub",
                        "Chennai Airport Hub", "Thiruvanmiyur", "Vandalur", "Kelambakkam"
                }));
                tripInfo.setStatus(RandomDataGenUtility.randomElement(new String[] {
                        "Online Shipment Booked", "Shipment Picked Up", "Shipment Arrived",
                        "Shipment Further Connected", "Delivery Scheduled For Next Working Day",
                        "Shipment Out For Delivery", "Shipment Delivered"
                }));
                tripInfo.setWarehouse(RandomDataGenUtility.randomElement(new String[] {
                        "Pune Warehouse", "Mumbai Warehouse", "Chennai Warehouse", "Bangalore Warehouse"
                }));

                // Create a unique identifier for each record
                tripInfo.setProduct(UUID.randomUUID().toString());

                // Send the updated TripInfo to Kafka
                TestKafkaProducer.sendDataToKafka("test", tripInfo.toString(), tripInfo.getproduct());
            }
            System.out.println(recordsCount + " records Sent to Kafka.");
            Thread.sleep(10000);
        }
    }
}
