# Description
I created a really simple Java program that can create a bunch of fake data and save said data into a csv file, along with its headers. The idea of this program is to provide a (relatively) easy way to populate an empty SQL table with test data, should the need arises.

I used the `Faker` library to generate the dummy data, and the `Apache Commons CSV` library in order to write said data into a csv file.

### Dependencies
* [java-faker](https://github.com/DiUS/java-faker.git)
* [Apache Commons CSV](https://github.com/apache/commons-csv.git)
* [Lombok](https://projectlombok.org/setup/maven)
* [Vavr](https://github.com/vavr-io/vavr)

### Useful resources that I used
* [Introduction to Apache Commons CSV](https://www.baeldung.com/apache-commons-csv)
* [Read / Write CSV files in Java using Apache Commons CSV](https://www.callicoder.com/java-read-write-csv-file-apache-commons-csv/)
* [Vavr User Guide](https://docs.vavr.io/)
* [Retrieving a Class Name in Java](https://www.baeldung.com/java-class-name)
* [Java Ordered Map](https://stackoverflow.com/questions/663374/java-ordered-map)
* [Collect stream of EntrySet to LinkedHashMap](https://stackoverflow.com/questions/52975256/collect-stream-of-entryset-to-linkedhashmap)

