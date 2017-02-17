package de.heidelberg.pvs.container_bench.random;

import de.heidelberg.pvs.container_bench.element.Element;

public class ElementRandomGenerator extends AbstractRandomGenerator<Element> {

	@Override
	public Element generate() {

		Element element = new Element();

		element.setDoubleField(generator.nextDouble());
		element.setLongField(generator.nextLong());
		element.setStringField("" + generator.nextLong());
		element.setStringField2("" + generator.nextLong());
		element.setIntegerField(generator.nextInt());

		return element;
	}

	@Override
	public Element[] generateArray(int arraySize) {
		Element[] elements = new Element[arraySize];
		for (int i = 0; i < elements.length; i++) {
			elements[i] = this.generate();
		}
		return elements;
	}

	@Override
	public Element generateInRange(int range) {
		throw new UnsupportedOperationException(
				"There is no range in Elements. This method should not be called. " 
						+ "Use generate() method instead");
	}

	@Override
	public Element[] generateArrayInRange(int arraySize, int range) {
		throw new UnsupportedOperationException(
				"There is no range in Elements. This method should not be called. " 
						+ "Use generateArray() method instead");
	}

}
