# Tests for technical interview of Thomas Murray

Write a test that:
1.	opens https://unsplash.com/
2.	visits every category (i.e. "Wallpapers", "Architecture", "Nature" etc. - the list of the categories is at the top of the page under the line with the search field)
3.	for every category downloads the 20th image and checks that both width and height of that image is greater than 500px

If you find yourself unable to solve a particular aspect of the task in reasonable amount of time (e.g. 2-6 hours for the whole task), you may simplify that particular aspect (download first image instead of 20th, check for some condition with image URL instead of size and so on).

===================================================

1. Get adoptopenjdk-8: https://adoptopenjdk.net/
2. Get maven 3.6.x: https://maven.apache.org/
3. Add above to your path if neccessary.
4. `git clone git@github.com:example/test.git`
5. `mvn clean package`
6. `java -jar target/Test_Thomas_Murray-1.0-SNAPSHOT.jar`
