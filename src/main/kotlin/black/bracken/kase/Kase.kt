package black.bracken.kase

import black.bracken.kase.key.Key

/**
 * A manipulator of [SourceContainer].
 *
 * @author BlackBracken
 */
interface Kase<C : SourceContainer<S>, S : Any> {

    operator fun <V : Any> get(key: Key<C, S, V>): V

    operator fun <V : Any> set(key: Key<C, S, V>, value: V)

}