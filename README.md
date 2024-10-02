First Project Anthonee and Trace

The Wikipedia Revision Reader is a Java-based application that connects to the Wikipedia API to retrieve and display the most recent revisions of a given Wikipedia article. The application provides the following information:

The username of the editor who made the revision.
The timestamp of when the revision was made. The program can be used to monitor recent changes to Wikipedia pages by querying for article titles.

Features:
Prints up to 15 recent revisions of a specified Wikipedia article.
Displays the username of the editor and the timestamp of the revision.

Authors:
Anthonee Emar (aemar@bsu.edu)
Trace Gibson

Build Instructions:

To build and run the project, follow these steps:

1. Ensure you have Gradle installed on your system for dependency management and building the project.
2. Make sure you have an active internet connection to fetch data from the Wikipedia API.
3. Clone the repository or download the project files.
4. When in the project, Click the GEAR icon on the left side of the minimize and X buttons.
5. Click on Run Anything.
6. Run the following command to build the project:
        ./gradlew build
7. To run the application, execute:
        ./gradlew run
8. Apply JSONPath to parse the JSON data received from the Wikipedia API.

Dependencies:
The project uses the following libraries:
com.jayway.jsonpath:json-path:2.6.0 for JSON parsing
