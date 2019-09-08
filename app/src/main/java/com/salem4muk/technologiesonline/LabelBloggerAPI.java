package com.salem4muk.technologiesonline;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public class LabelBloggerAPI {

    public static final String key1 = "AIzaSyAVgAw1TDa-mZzcr18-3FKXAKAXEIyubM0";
    public static final String url1 = "https://www.googleapis.com/blogger/v3/blogs/2419739707488768452/posts/search?q=label:أندرويد";

    public static BloggerAPI.PostService postService = null;

    public static BloggerAPI.PostService getService()
    {
        if(postService == null)
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url1)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            postService = retrofit.create(BloggerAPI.PostService.class);
        }
        return postService;
    }

    public interface PostService {
        @GET
        Call<PostList> getPostList(@Url String url);
    }


}
