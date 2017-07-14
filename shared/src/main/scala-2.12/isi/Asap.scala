package isi

trait Asap extends scala.concurrent.ExecutionContext {
  def execute(runnable: Runnable): Unit = runnable.run()
  def reportFailure(cause: Throwable): Unit = cause.printStackTrace()
}

//object Asap extends Asap
