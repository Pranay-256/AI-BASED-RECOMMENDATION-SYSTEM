# AI-BASED-RECOMMENDATION-SYSTEM

*COMPANY*: CODTECH IT SOLUTIONS

*NAME*: Pranay Jha 

*INTERN ID*: CT04DH539

*DOMAIN*: Java Programming 

*DURATION*: 4 WEEKS

*MENTOR*: NEELA SANTOSH

DESCRIPTION:

The ItemAverageRecommender is a Java-based recommendation system built using Apache Mahout, designed to help users identify the most highly rated item from a set of input item IDs based on average user ratings. This project is a straightforward implementation of item-based collaborative filtering, focusing on analyzing past user ratings to recommend the best item among those provided by the user. It reads data from a CSV file named ratings.csv, which contains entries in the form of userID,itemID,rating, and utilizes Mahout’s FileDataModel class to parse and model this data efficiently. The user interacts with the application via the terminal, where they are prompted to input at least two item IDs separated by spaces. The application then iterates through each user in the dataset, checks if they have rated any of the specified items, and collects these ratings into a map structure that links item IDs with a list of their respective ratings. For each item that received ratings, the program calculates the average rating using Java's functional stream API and identifies the item with the highest average rating. The final recommendation is displayed to the user as the item that has the best average rating among the options entered. In cases where no ratings exist for a particular item, the system informs the user accordingly, ensuring transparency. The implementation showcases various core concepts such as file handling, exception management, data modeling using external libraries, and user interaction via console input, making it an ideal beginner project for students exploring AI-based systems or recommendation algorithms. The Mahout library version used here is 0.12.2, selected manually and integrated into the project without using Maven dependencies from the central repository, although a proper pom.xml file is included to compile and run the project using Maven commands like mvn clean compile and mvn exec:java. All the necessary JAR files for Mahout were manually downloaded and added to the project classpath to keep it simple and compatible with non-gradle-based workflows. The sources consulted to build this project include the official Apache Mahout archive, guidance and snippets generated through ChatGPT for step-by-step understanding, a helpful article on Medium titled “Creating a User-Based Recommendation System in Java with Apache Mahout” by Rahul Vaish, and a few YouTube tutorials that explain Mahout basics and collaborative filtering techniques. Overall, this project emphasizes learning through practical coding, showcasing how a basic recommender system works without diving into overly complex algorithms or big data platforms, making it accessible for those new to machine learning or Java development. This implementation can be expanded further by incorporating more sophisticated similarity measures, user-based filtering, or even integrating with a graphical user interface or web application. The clean modular structure of the code, along with meaningful comments and source references, makes this project a great educational tool and a strong addition to a beginner’s portfolio in AI and Java development.

#OUTPUT:

