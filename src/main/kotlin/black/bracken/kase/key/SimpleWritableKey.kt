package black.bracken.kase.key

import black.bracken.kase.container.SourceContainer

/**
 * @author BlackBracken
 */
class SimpleWritableKey<C : SourceContainer<S>, S : Any, V : Any>(
    private val extractor: (C) -> V?,
    private val inserter: (C, V) -> Unit
) : WritableKey<C, S, V> {

    override fun extract(container: C): V = extractor(container) ?: throw NoSuchElementException()

    override fun insert(container: C, value: V) = inserter(container, value)

}