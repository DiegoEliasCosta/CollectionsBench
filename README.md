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

**Download the dataset** Our benchmarks use an external dataset to draw a more realistic element distribution. Because the file is too large we have it stored in Git Large File Storage (Git LFS). To download the dataset you have to install git lsf with `git lfs install` and then get the dataset through `git lsf pull`. 

### Running the complete benchmark suite

Use `java -jar benchmarks.jar` to run the complete benchmark with the default parameters. The complete benchmark with default parameters takes **weeks** to finish, therefore we came with a naming system to allow partial benchmarks to be run easily.

### Running specific benchmarks

We have the following benchmarks implemented in CollectionsBench:

- wordcount: counts the frequency of words in a pre-tokenized version of Wikipedia articles. Here only `Map` and `Multisets` are evaluated. 
- singleOperations: benchmark composed by a single collection operation. Ideal for a fine grained performance evaluation. Singleoperations benchmark use all available implementations. 
- intsingleoperations: singleoperations benchmark with primitive (int) implementations.
- set: evaluates a six more realistic scenarios using the pre-rokenized Wikipedia article as dataset. 
- intset: equivalent to set benchmark with primitive (int) implementations.
- concurrency: comprised of a handful of concurrent scenarios for performance evaluation of thread-safe implementations. 
- stackoverflow: comprised of 5 most starred stack overflow questions on Java collections performance.

Each benchmark can be specified with a regex formula with the form of `.*benchmarks.[BENCHMARK NAME]`. 
For instance, the wordcount benchmark can be executed through the command

```
java -jar benchmarks.jar .*benchmarks.wordcount.*
```

**Specifying a collection implementation**

Every benchmark contains an `impl` enum, which specifies what implementations are available for evaluation.
One can specify a set of implementations by providing the `impl` parameter as following:

```
java -jar benchmarks.jar -p impl=JDK_ARRAY
```
which will then execute the entire benchmark suite for array implementations of JDK library. 
Benchmarks that do not have JDK_ARRAY as one of the implementations will not be executed.    
Users can also provide a list of implementations, by separating them with a comma `-p impl=JDK_ARRAY,JDK_LINKED`. 

CollectionsBench currently has more than 100 implementations, so we will prepare a external python script for a better usability. 

**Specifying a particular payload type and distribution**

Singleoperation benchmarks (both object and primitive) allow collections to be evaluated on different elements (payload).
We have the followig payloads enabled:

- INTEGER_UNIFORM: Integer elements with random uniform distribution
- INTEGER_DICTIONARY: Integer elements with highly skewed "Zipfian" data distribution 
- STRING_UNIFORM: String elements with random uniform distribution
- STRING_DICTIONARY: String elements with highly skewed "Zipfian" data distribution

Such "Zipfian" data distribution comes from our pre-tokenized words from Wikipedia article and will often represent a more
realistic distribution than a randomly uniform one.


**Specifying the benchmark parameters** The benchmark parameters are pre-defined in the abstract classes of each benchmark. Normally we use 20 warmups, 40 replications with 1 second each. You can re-define the parameters by using the JMH command line structure. 

For 20 warmup iterations, 30 replications of 5 seconds each.
```
java -jar benchmarks.jar -wi 20 -i 30 -r 5
```

For more information about the parameters, run the help menu: `java -jar benchmarks.jar -h`

## Available Collection Libraries
 
We have implemented the benchmark for alternatives of the four most commonly used Java collections, ie,
ArrayList, LinkedList, HashSet and HashMap with implementations of the following libraries:  
 
| Library			| Version	|
| --------- 		| --------- |
| JDK (SDK10)		|       	|
| Fastutil			| 8.2.1 	|
| Guava 			| 26.0-jre	|
| Koloboke			| 1.0.0		|
| HPPC				| 0.7.3		|
| Eclipse			| 9.2.0 	|
| Trove				| 3.1.0		|
| Javolution		| 6.0.0		|
| Mahout			| 0.13.0	|
| CoreNLP			| 3.9.1		|
| Agrona			| 0.9.24	|
| Apache commons	| 4.2		|
| HPPC				| 0.8.1		|

 	

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

