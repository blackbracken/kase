package black.bracken.kase

import black.bracken.kase.container.SourceContainer
import black.bracken.kase.key.Key

/**
 * A manipulator of [SourceContainer].
 *
 * @author BlackBracken
 */
interface Kase<C : SourceContainer<S>, S : Any> {

    /**
     * Returns a value corresponds the given [key] from [S].
     *
     * @throws NoSuchElementException if a value corresponds the given [key] is not exist.
     */
    operator fun <V : Any> get(key: Key<C, S, V>): V

    /**
     * Sets the given [value] with the given [key] in [S].
     *
     * @throws IllegalStateException if the given [value] could not be set.
     */
    operator fun <V : Any> set(key: Key<C, S, V>, value: V)

    /**
     * Returns a value corresponds the given [key] if it exists otherwise null.
     */
    fun <V : Any> getOrNull(key: Key<C, S, V>): V? = try {
        this[key]
    } catch (exception: NoSuchElementException) {
        null
    }

    /**
     * Returns a value corresponds the given [key] if it exists otherwise a result of [default] invoked.
     */
    fun <V : Any> getOrElse(key: Key<C, S, V>, default: () -> V): V = getOrNull(key) ?: default()

    /**
     * Returns a value corresponds the given [key] if it exists otherwise [defaultValue].
     */
    fun <V : Any> getOrDefault(key: Key<C, S, V>, defaultValue: V): V = getOrNull(key) ?: defaultValue

    /**
     * Returns a value corresponds the given [key] if it exists otherwise a result of [default] invoked and sets it in [S].
     */
    fun <V : Any> getOrPut(key: Key<C, S, V>, default: () -> V): V = getOrNull(key) ?: default().also { this[key] = it }

}