package black.bracken.kase

import black.bracken.kase.container.SourceContainer
import black.bracken.kase.key.Key
import black.bracken.kase.key.WritableKey

/**
 * A manipulator of [SourceContainer].
 *
 * @author BlackBracken
 */
interface Kase<C : SourceContainer<S>, S : Any> {

    /**
     * Returns a value corresponds the given [key] from [S].
     */
    operator fun <V : Any> get(key: Key<C, S, V>): V?

    /**
     * Sets the given [value] with the given [key] in [S].
     *
     * @throws IllegalStateException if the given [value] could not be set.
     */
    operator fun <V : Any> set(key: WritableKey<C, S, V>, value: V)

    /**
     * Returns a value corresponds the given [key] if it exists otherwise a result of [default] invoked.
     */
    fun <V : Any> getOrElse(key: Key<C, S, V>, default: () -> V): V = get(key) ?: default()

    /**
     * Returns a value corresponds the given [key] if it exists otherwise [defaultValue].
     */
    fun <V : Any> getOrDefault(key: Key<C, S, V>, defaultValue: V): V = get(key) ?: defaultValue

    /**
     * Returns a value corresponds the given [key] if it exists otherwise a result of [default] invoked and sets it in [S].
     */
    fun <V : Any> getOrPut(key: WritableKey<C, S, V>, default: () -> V): V =
        get(key) ?: default().also { this[key] = it }

}