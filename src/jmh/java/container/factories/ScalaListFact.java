package container.factories;

import java.util.function.Supplier;

import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.ListBuffer;
import scala.collection.mutable.UnrolledBuffer;
import scala.reflect.ClassTag;

public enum ScalaListFact {
	SCALA_ARRAY(ArrayBuffer::new), //
	SCALA_LIST(ListBuffer::new), //
	SCALA_UNROLL(() -> new UnrolledBuffer<>(ClassTag.Any()));

	public final Supplier<Buffer<?>> maker;

	private ScalaListFact(Supplier<Buffer<?>> maker) {
		this.maker = maker;
	}
}
