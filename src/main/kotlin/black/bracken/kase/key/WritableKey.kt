package black.bracken.kase.key

import black.bracken.kase.SourceContainer

/**
 * @author BlackBracken
 */
interface WritableKey<C : SourceContainer<S>, S : Any, V : Any> : Key<C, S, V> {

    fun insert(container: C, value: V): Result<V>

}