package patron

trait CommandDescription[t <: Command] {

  val name: String

  type Repr
  val repr: Repr

  def details(event: t): String

  type Type
  val `type`: Type

}

trait EventDescription[t <: Event] extends CommandDescription[t] {
  final case object Event
  final type Type = Event.type
  final val `type`: Type = Event
}

trait ActionDescription[t <: Action] extends CommandDescription[t] {
  final case object Action
  final type Type = Action.type
  final val `type`: Type = Action
}