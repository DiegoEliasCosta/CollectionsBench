package container.generators;

import java.io.IOException;

public interface IntElementGenerator {
	void init(int poolSize, int seed) throws IOException;

	int generateIndex(int range);

	int[] generateIntArray(int arraySize);
}
