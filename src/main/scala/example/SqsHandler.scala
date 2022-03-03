/*
 * Copyright 2021 Typelevel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package example

import cats.effect.*
import cats.effect.std.Random
import example.SqsHandler.Init
import feral.lambda.*
import feral.lambda.events.{KinesisStreamEvent, SqsEvent}


/**
 * On Scala.js, implement your Lambda as an `object`. This will be the name your JavaScript
 * function is exported as. On JVM, implement your Lambda as a `class`.
 *
 * Every Lambda is triggered by an `Event` for which there must be a circe `Decoder[Event]`. It
 * should then return `Some[Result]` for which there must be a circe `Encoder[Result]`. If your
 * Lambda has no result (as is often the case), use `INothing` and return `None` in the handler.
 *
 * Models for events/results are provided in the `feral.lambda.events` package. There are many
 * more to implement! Please consider contributing to
 * [[https://github.com/typelevel/feral/issues/48 #48]].
 *
 * For a more advanced example, see the `Http4sLambda` next.
 */
object SqsHandler extends IOLambda.Simple[SqsEvent, INothing] {
  /**
   * This is where you implement the logic of your handler.
   *
   * @param event
   * that triggered your lambda
   * @param context
   * provides information about the invocation, function, and execution environment
   * @param init
   * in this example, the skunk session we setup above
   */
  type Init = Int

  def apply(event: SqsEvent, context: Context[IO], init: Init): IO[None.type] =
    IO.println(s"Received event with ${event.records.size} records").as(None)
}

class SqsHandler extends IOLambda.Simple[SqsEvent, INothing] {
  type Init = SqsHandler.Init

  def apply(event: SqsEvent, context: Context[IO], init: Init): IO[None.type] =
    YaBen.handler(event, context, init)
}

object YaBen {
  def handler(event: SqsEvent, context: Context[IO], init: Int): IO[None.type] =
    IO.println(s"Received event with ${event.records.size} records").as(None)
}