import org.apache.mahout.cf.taste.impl.model.file.FileDataModel; // import necessary Mahout classes
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator; // import iterator for user IDs
import org.apache.mahout.cf.taste.model.DataModel; // import DataModel interface

import java.io.*; // import necessary classes for file handling
import java.util.*; // import necessary classes for collections

public class ItemAverageRecommender { // class to recommend items based on average ratings

    public static void main(String[] args) { // main method to execute the recommender
        try {
            // load ratings from CSV
            File ratingsFile = new File("ratings.csv"); // your file path
            DataModel model = new FileDataModel(ratingsFile); // create a DataModel from the file

            // get item IDs from user
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter at least two item IDs: "); // ask user for item IDs
            String[] inputItems = scanner.nextLine().split("\\s+"); // split input into an array of item IDs

            Map<Long, List<Double>> itemRatings = new HashMap<>(); // map to store ratings for each item

            // iterate over all users and their ratings
            LongPrimitiveIterator users = model.getUserIDs();
            while (users.hasNext()) { // iterate through user IDs
                long userID = users.nextLong(); // get user ID
                for (String itemStr : inputItems) { // iterate through input item IDs
                    long itemID = Long.parseLong(itemStr); // parse item ID from string
                    try {
                        // get the rating for the item by the user
                        float rating = model.getPreferenceValue(userID, itemID);
                        if (!Float.isNaN(rating)) { // check if rating is valid
                            itemRatings.putIfAbsent(itemID, new ArrayList<>()); // initialize list if not present
                            itemRatings.get(itemID).add((double) rating); // add rating to the list

                            // print individual rating
                            System.out.printf("User %d has rated Item %d as %.1f%n", userID, itemID, rating);
                        }
                    } catch (Exception ignored) {
                        // No rating found
                    }
                }
            }

            // Calculate averages
            double maxAverage = -1; // variable to track the maximum average rating
            long bestItem = -1; // variable to track the best item ID

            for (String itemStr : inputItems) { // iterate through input item IDs
                long itemID = Long.parseLong(itemStr); // parse item ID from string
                List<Double> ratings = itemRatings.getOrDefault(itemID, new ArrayList<>()); // get ratings for the item
                // check if there are ratings for the item
                if (ratings.isEmpty()) {
                    System.out.printf("Item %d has no ratings.%n", itemID); // skip if no ratings
                    continue;
                }

                double avg = ratings.stream().mapToDouble(Double::doubleValue).average().orElse(0); // calculate average
                                                                                                    // rating
                System.out.printf("Item %d has an average rating of %.2f%n", itemID, avg); // print average rating

                if (avg > maxAverage) { // check if this item has the highest average rating
                    maxAverage = avg; // update maximum average
                    bestItem = itemID; // update best item ID
                }
            }
            // Print the best item recommendation
            if (bestItem != -1) {
                System.out.println("\nRecommended item: " + bestItem);
            } else {
                System.out.println("cannot recommend any item."); // no suitable item found
            }
            // Close the scanner
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace(); // print stack trace for any exceptions
        }
    }
}

// to compile use ".;mahout-core-0.12.2.jar;mahout-math-0.12.2.jar;commons-math3-3.6.1.jar" in terminal
// to run use ".;mahout-core-0.12.2.jar;mahout-math-0.12.2.jar;commons-math3-3.6.1.jar" in terminal
// sources used to make this code:
// "https://archive.apache.org"
// "ChatGPT"
// "https://medium.com/@rahulvaish/creating-a-user-based-recommendation-system-java-apache-mahout-6148f5e4d105"
// "youtube"