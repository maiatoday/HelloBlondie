package net.maiatoday.helloblondie.data

import com.apollographql.apollo.ApolloClient
import net.maiatoday.helloblondie.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object ApolloApi {
    val client = OkHttpClient().newBuilder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            })
            .build()
    var apolloClient = ApolloClient.builder()
        .serverUrl("http://10.0.2.2:3002/graphql")
        .okHttpClient(client)
        .build()
}
