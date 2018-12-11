package black.bracken.kase.key

import black.bracken.kase.SourceContainer

/**
 * A key to read data from [SourceContainer].
 *
 * @author BlackBracken
 */
interface Key<C : SourceContainer<S>, S : Any, V : Any> {

    fun extract(container: C): Result<V>

}