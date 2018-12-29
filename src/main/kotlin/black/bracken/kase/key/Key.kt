package black.bracken.kase.key

import black.bracken.kase.container.SourceContainer

/**
 * A key to read data from [SourceContainer].
 *
 * @author BlackBracken
 */
interface Key<in C : SourceContainer<S>, S : Any, out V : Any> {

    fun extract(container: C): V?

}