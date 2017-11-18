package net.maiatoday.helloblondie.data

import retrofit2.Call

/**
 * Created by maia on 2017/11/18.
 */
inline fun <T, U> Call<T>.unwrapCall(f: T.() -> U) = execute().body()?.f()