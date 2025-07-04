package org.utl.apiidgs901

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {
    @GET("posts")
    suspend fun getStudents(): List<Student>

    @POST("posts")
    fun addStudent(@Body misDatos : Student): Call<StudentResponse>

    @PUT("posts/{id}")
    fun updateStudent(@Path("id") itemId : Int, @Body misDatos: Student):
            Call<StudentResponse>

    @DELETE("posts/{id}")
    fun deleteStudent(@Path("id") itemId : Int): Call<Void>

    companion object {
        private var apiService : ApiService? = null
        private var url: String = "https://jsonplaceholder.typicode.com/"

        fun getInstance(): ApiService{
            if (apiService == null){
                apiService = Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService::class.java)
            }
            return apiService!!
        }

    }

}