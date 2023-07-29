package com.example.designpatterns.facade

import retrofit2.http.GET

interface BooksApi {
    @GET("books")
    fun listBooks(): List<Book>
}
