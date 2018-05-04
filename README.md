# Collections-Bench

Collections-Bench is a benchmark suite created to evaluate a variety of Java Collection Libraries under a homogeneous set of test cases. 

The Collections-Bench uses the
[OpenJDK jmh microbenchmarking harness](http://openjdk.java.net/projects/code-tools/jmh/)
for performance evaluation of Java collections libraries.

*This documentation is a work in progress, and parts of it may still be under construction.*

## Getting Started

This instructions will get you to build and run Collections-Bench in your local machine.

### Prerequisites

To build and run Collections-Bench you need Java 8.

### Building Collections-Bench

**Build the jar file:** Use `./gradlew shadowJar` to generate the `benchmarks.jar` file
(on windows, use `gradlew.bat shadowJar`).

### Running the complete benchmark

Use `java -jar benchmarks.jar` to run the complete benchmark with the default parameters. The complete benchmark with default parameters takes **3 days** to finish, therefore we came with a naming system to allow partial benchmarks to be run easily.

### Running a specific benchmark

The JMH allows regular expressions when specifying the classes that will be executed during the benchmark. To facilitate, we design the classes name, to contain the configuration about the benchmark such as the library, collection type and data type:

Each class has the following name structure: 

```
[LIBRARY]_[DATATYPE]_[COLLECTIONTYPE]_Test.java
```

For instance, to run the benchmark of standard (JDK) ArrayList containing integers, you can execute the following command:

```
java -jar benchmarks.jar "JDK_Integer_ArrayList_.*"
```

**Specifying the benchmark parameters** The benchmark parameters are defined in the class AbstractBenchmarkTest.java (10 warmups, 30 replications, 1 second each). You can re-define the parameters by using the JMH command line structure. 

For 20 warmup iterations, 30 replications of 5 seconds each.
```
java -jar benchmarks.jar -wi 20 -i 30 -r 5
```

For more information about the parameters, run the help menu: `java -jar benchmarks.jar -h`


## Available Test Scenarios

Currently implemented scenarios. Each scenario is implemented in a distinct method, and can be specified in the benchmark parameters. 

| Scenario	| Description											|
| --------- | -----------------------------------------				|
| add		| Add a random element into the collection. 			|
| populate	| Populate an empty collection with N random elements 	|
| get		| Get a random element from the collection 				|
| iterate	| Traverse the collection								| 
| remove	| Remove a random element from the collection 			|
| copy		| Copy to an empty collection							|  
| contains	| Search a random element in the collection 			|

## Available Collection Libraries
 
We have implemented the benchmark for alternatives of the four most commonly used Java collections, ie,
ArrayList, LinkedList, HashSet and HashMap with implementations of the following libraries:  
 
| Library	| Version	|
| --------- | --------- |
| JDK (SDK8)|       	|
| Fastutil	| 8.1.1 	|
| Guava 	| 24.1-jre	|
| Koloboke	| 0.6.8		|
| HPPC		| 0.7.3		|
| Eclipse	| 9.1.0 	|
| Trove		| 3.0.3		|
 	

# Related Work

Collections-Bench was initially created to be used in the ICPE paper
"*Empirical Study of Usage and Performance of Java Collections*".

Please refer to the paper below if you use Collections-Bench in your academic work.

```
@inproceedings{Costa:2017:ESU:3030207.3030221,
 author = {Costa, Diego and Andrzejak, Artur and Seboek, Janos and Lo, David},
 title = {Empirical Study of Usage and Performance of Java Collections},
 booktitle = {Proceedings of the 8th ACM/SPEC on International Conference on Performance Engineering},
 series = {ICPE '17},
 year = {2017},
 isbn = {978-1-4503-4404-3},
 location = {L'Aquila, Italy},
 pages = {389--400},
 numpages = {12},
 url = {http://doi.acm.org/10.1145/3030207.3030221},
 doi = {10.1145/3030207.3030221},
 acmid = {3030221},
 publisher = {ACM},
 address = {New York, NY, USA},
 keywords = {collections, empirical study, execution time, java, memory, performance},
}
```

