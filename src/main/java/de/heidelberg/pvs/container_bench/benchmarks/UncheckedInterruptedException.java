package de.heidelberg.pvs.container_bench.benchmarks;

/**
 * Unchecked exception for interruption.
 *
 * This serves the purpose of stopping benchmark runs that exceed the timeout.
 * 
 * Checked exception cannot be used nicely with Lambda-style iterations.
 *
 * @author Erich Schubert
 */
public class UncheckedInterruptedException extends RuntimeException {
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 */
	public UncheckedInterruptedException() {
		super();
	}
}
