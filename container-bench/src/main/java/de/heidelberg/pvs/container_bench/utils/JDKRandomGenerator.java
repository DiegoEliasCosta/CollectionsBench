package de.heidelberg.pvs.container_bench.utils;

import java.util.Random;

import de.heidelberg.pvs.container_bench.element.Element;

public class JDKRandomGenerator implements RandomGenerator {

	private final int NO_RANGE_FLAG = -1;

	private Random generator;

	@Override
	public void initializeSeed(int seed) {
		this.generator = new Random(seed);
	}

	@Override
	public Integer[] generateIntegersInRange(int size, int range) {
		Integer[] values = new Integer[size];

		// No range specified
		if (range == NO_RANGE_FLAG) {
			for (int i = 0; i < size; i++) {
				values[i] = generator.nextInt();
			}

		} else {
			// Range specified
			for (int i = 0; i < size; i++) {
				values[i] = generator.nextInt(range);
			}
		}
		return values;
	}

	@Override
	public Integer[] generateIntegers(int size) {
		Integer[] values = new Integer[size];
		for (int i = 0; i < size; i++) {
			values[i] = generator.nextInt();
		}
		return generateIntegersInRange(size, NO_RANGE_FLAG);
	}

	@Override
	public Integer generateIntegerInRange(int range) {
		return generator.nextInt(range);
	}

	@Override
	public String[] generateStrings(int size) {
		String[] values = new String[size];
		for (int i = 0; i < size; i++) {
			values[i] = this.generateString();
		}
		return values;
	}

	@Override
	public Integer generateInteger() {
		return generator.nextInt();
	}

	@Override
	public Long[] generateLongsInRange(int size, long range) {
		return generateLongs(size);
	}

	@Override
	public Long[] generateLongs(int size) {

		Long[] longs = new Long[size];

		for (int i = 0; i < size; i++) {
			longs[i] = generator.nextLong();
		}

		return longs;
	}

	@Override
	public Long generateLongInRange(long range) {
		return generateLong();
	}

	@Override
	public Long generateLong() {
		return generator.nextLong();
	}

	@Override
	public Double[] generateDoubles(int size) {
		Double[] doubles = new Double[size];

		for (int i = 0; i < size; i++) {
			doubles[i] = generator.nextDouble();
		}

		return doubles;
	}

	@Override
	public Double generateDouble() {
		return generator.nextDouble();
	}

	@Override
	public Element[] generateElements(int size) {
		Element[] elements = new Element[size];
		for (int i = 0; i < size; i++) {
			elements[i] = this.generateElement();
		}
		return elements;
	}

	@Override
	public Element generateElement() {
		Element element = new Element();
		element.setDoubleField(this.generateDouble());
		element.setIntegerField(this.generateInteger());
		element.setLongField(this.generateLong());
		element.setStringField(this.generateString());
		element.setStringField2(this.generateString());

		return element;
	}

	@Override
	public String generateString() {
		return "" + generator.nextLong();
	}

}
