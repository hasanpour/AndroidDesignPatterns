package com.example.designpatterns.facade

import retrofit2.Retrofit

class Client {
    val retrofit = Retrofit.Builder()
        .baseUrl("http://www.myexampleurl.com")
        .addConverterFactory(GsonConverterFactory())
        .build()

    val api = retrofit.create<BooksApi>(BooksApi::class.java)
}