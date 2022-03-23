package de.sonallux.spotify.api.apis.player;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * <h2>Seek To Position request</h2>
 *
 * <h3>Required OAuth scopes</h3>
 * <code>user-modify-playback-state</code>
 *
 * <h3>Response</h3>
 * <p>Command sent</p>
 */
public class SeekToPositionInCurrentlyPlayingTrackRequest {
    private static final TypeReference<Void> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * Seek To Position request
     * @param apiClient <p>The API client</p>
     * @param positionMs <p>The position in milliseconds to seek to. Must be a positive number. Passing in a position that is greater than the length of the track will cause the player to start playing the next song.</p>
     */
    public SeekToPositionInCurrentlyPlayingTrackRequest(ApiClient apiClient, int positionMs) {
        this.apiClient = apiClient;
        this.request = new Request("PUT", "/me/player/seek")
            .addQueryParameter("position_ms", String.valueOf(positionMs))
        ;
    }

    /**
     * @param deviceId <p>The id of the device this command is targeting. If not supplied, the user's currently active device is the target.</p>
     * @return this request
     */
    public SeekToPositionInCurrentlyPlayingTrackRequest deviceId(String deviceId) {
        this.request.addQueryParameter("device_id", String.valueOf(deviceId));
        return this;
    }

    /**
     * Build the request into an executable api call
     * @return an executable api call
     */
    public ApiCall<Void> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
