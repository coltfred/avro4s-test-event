package test

import com.sksamuel.avro4s._
//Some sub types
case class ProjectId(value: Int)

case class OrgId(value: Int)

case class Foo(o: Option[String], more: Long)

//Our base Event type.
sealed trait Event {
  def project: ProjectId
  def org: OrgId
}

case class Event1(project: ProjectId, org: OrgId, other: String, foo: Foo) extends Event
case class Event2(project: ProjectId, org: OrgId, otherFoo: Foo) extends Event
case class Event3(project: ProjectId, org: OrgId, foo: Foo) extends Event
case class Event4(project: ProjectId, org: OrgId, other: String) extends Event
case class Event5(project: ProjectId, org: OrgId, otherStuff: Option[Int]) extends Event
case class Event6(project: ProjectId, org: OrgId) extends Event
case class Event7(project: ProjectId, org: OrgId, other: String, secondProject: ProjectId) extends Event
case class Event8(project: ProjectId, org: OrgId, other: String, something:Option[Long]) extends Event
case class Event9(project: ProjectId, org: OrgId, otherId: Long) extends Event
case class Event10(project: ProjectId, org: OrgId, other: String, foo1: Foo, foo2: Foo, foo3: Foo) extends Event

//A wrapper class around the event.
case class EventWrapper(event: Event)

//Create the implicits to attempt
object EventWrapper {
  implicit val toRecord: ToRecord[EventWrapper] = ToRecord[EventWrapper]
  implicit val fromRecord: FromRecord[EventWrapper] = FromRecord[EventWrapper]
  implicit val toSchema: ToSchema[EventWrapper] = ToSchema[EventWrapper]
}
