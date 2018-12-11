package black.bracken.kase.key

import black.bracken.kase.SourceContainer

/**
 * @author BlackBracken
 */
class SimpleKey<in C : SourceContainer<S>, S : Any, out V : Any>(
    private val extractor: (C) -> V
) : Key<C, S, V> {

    override fun extract(container: C): V = extractor(container)

}