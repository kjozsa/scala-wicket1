/**
 *
 */
package com.fsdev.scw

import ch.lambdaj.function.argument.Argument
import ch.lambdaj.function.argument.ArgumentsFactory
import org.apache.wicket.model.PropertyModel;
import ch.lambdaj.Lambda

object ModelFactory {
  def on[T, S](model: T)(fieldBlock: T => S): PropertyModel[S] = {
    modelFactory(model, fieldBlock(lambda(model)))
  }

  private def lambda[T](x: T): T = {
    Lambda.on(x.getClass)
  }

  private def modelFactory[T](value: Any, proxiedValue: T): PropertyModel[T] = {
    val a = ArgumentsFactory.actualArgument(proxiedValue);
    val invokedPN = a.getInkvokedPropertyName();
    new PropertyModel[T](value, invokedPN);
  }
}