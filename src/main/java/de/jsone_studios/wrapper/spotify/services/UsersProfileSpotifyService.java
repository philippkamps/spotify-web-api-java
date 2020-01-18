package de.jsone_studios.wrapper.spotify.services;

import de.jsone_studios.wrapper.spotify.models.UserPrivate;
import de.jsone_studios.wrapper.spotify.models.UserPublic;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UsersProfileSpotifyService
{

    /**
     * Get detailed profile information about the current user (including the current user’s username).
     *
     * @return user object (private)
     * @see <a href="https://developer.spotify.com/web-api/get-current-users-profile/">Get Current User's Profile</a>
     */
    @GET("me")
    Call<UserPrivate> getMe();

    /**
     * Get public profile information about a Spotify user.
     *
     * @param userId the user id
     * @return user object (public)
     * @see <a href="https://developer.spotify.com/web-api/get-users-profile/">Get a User's Profile</a>
     */
    @GET("users/{id}")
    Call<UserPublic> getUser(@Path("id") String userId);
}