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
Gradle for dependency management and building the project
Internet connection (to fetch data from Wikipedia API)
Steps to build:
1. Build and run the project using Gradle.
2. Apply JSONPath.
3. Run unit test.

Dependencies:
The project uses the following libraries:
com.jayway.jsonpath:json-path:2.6.0 for JSON parsing
