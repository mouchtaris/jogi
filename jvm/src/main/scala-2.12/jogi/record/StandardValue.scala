package jogi.record

/**
 * A standard value is a value that is provided "by default",
 * as a wrapper for commonly used scala types.
 *
 * @tparam scalaType the underlying scala type.
 */
trait StandardValue[scalaType] extends Value[scalaType]