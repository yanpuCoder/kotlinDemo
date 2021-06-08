package com.yp.net.bean


/**
 * @author : yanpu
 * @date : 2021/6/2
 * @description:
 */
sealed class ExtData<out L, out R> {

    /** * Represents the left side of [ExtData] class which by convention is a "Success". */
    data class Left<out L>(val a: L) : ExtData<L, Nothing>()

    /** * Represents the right side of [ExtData] class which by convention is a "Failure". */
    data class Right<out R>(val b: R) : ExtData<Nothing, R>()

    /**
     * Returns true if this is a Right, false otherwise.
     * @see Right
     */
    val isRight get() = this is Right<R>

    /**
     * Returns true if this is a Left, false otherwise.
     * @see Left
     */
    val isLeft get() = this is Left<L>

    /**
     * Creates a Left type.
     * @see Left
     */
    fun <L> left(a: L) = ExtData.Left(a)


    /**
     * Creates a Left type.
     * @see Right
     */
    fun <R> right(b: R) = ExtData.Right(b)

    /**
     * Applies fnL if this is a Left or fnR if this is a Right.
     * @see Left
     * @see Right
     */
    fun fold(fnL: (L) -> Any, fnR: (R) -> Any): Any =
        when (this) {
            is Left -> fnL(a)
            is Right -> fnR(b)
        }
}