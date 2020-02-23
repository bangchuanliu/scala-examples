package mixin.withs

trait TypeUnsafeDataLoader extends AnyRef with TypeUnsafeData{


  def load() = seq = seq :+ 1

}
