package test
import com.sksamuel.avro4s.ToRecord
object Test {
  implicitly[ToRecord[EventWrapper]]
}
