package container.factories;

import java.util.function.Supplier;

import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.ListBuffer;
import scala.collection.mutable.Seq;
import scala.collection.mutable.UnrolledBuffer;
import scala.reflect.ClassTag;

public enum ScalaListFact {
	SCALA_ARRAY(ArrayBuffer::new), //
	SCALA_LIST(ListBuffer::new), //
	SCALA_UNROLL(() -> new UnrolledBuffer<>(ClassTag.Any()));

	public final Supplier<Seq<?>> maker;

	private ScalaListFact(Supplier<Seq<?>> maker) {
		this.maker = maker;
	}
}
