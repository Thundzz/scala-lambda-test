package example

import com.amazonaws.services.lambda.runtime.{Context, RequestHandler}
import com.amazonaws.services.lambda.runtime.events.SQSEvent
import scala.jdk.CollectionConverters._

class SuperHandler extends RequestHandler[SQSEvent, String] {
  override def handleRequest(input: SQSEvent, context: Context): String = {
    val value = input.getRecords.asScala.map(_.getBody).mkString
    println(value)
    value
  }
}


