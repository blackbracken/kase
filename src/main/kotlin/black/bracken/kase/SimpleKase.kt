package black.bracken.kase

import black.bracken.kase.container.SourceContainer
import black.bracken.kase.key.Key
import black.bracken.kase.key.WritableKey

/**
 * @author BlackBracken
 */
class SimpleKase<C : SourceContainer<S>, S : Any>(private val container: C) : Kase<C, S> {

    override fun <V : Any> get(key: Key<C, S, V>): V? = key.extract(container)

    override fun <V : Any> set(key: WritableKey<C, S, V>, value: V) = key.insert(container, value)

}