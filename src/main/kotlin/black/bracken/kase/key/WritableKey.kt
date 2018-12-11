package black.bracken.kase.key

import black.bracken.kase.container.SourceContainer

/**
 * @author BlackBracken
 */
interface WritableKey<in C : SourceContainer<S>, S : Any, V : Any> : Key<C, S, V> {

    fun insert(container: C, value: V)

}