package com.example.designpatterns.facade

import okhttp3.ResponseBody
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Converter
import java.io.IOException


class GsonConverterFactory: Converter.Factory() {
    //Customized JSON deserializer
    internal class GsonConverter : Converter<ResponseBody, JSONObject> {
        @Throws(IOException::class)
        override fun convert(responseBody: ResponseBody): JSONObject {
            return try {
                JSONObject(responseBody.string())
            } catch (e: JSONException) {
                throw IOException("Failed to parse JSON", e)
            }
        }

        companion object {
            val INSTANCE = GsonConverter()
        }
    }
}
