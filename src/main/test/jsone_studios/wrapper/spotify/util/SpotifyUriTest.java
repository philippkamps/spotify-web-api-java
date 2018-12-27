package jsone_studios.wrapper.spotify.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SpotifyUriTest
{
    @Test
    public void testParseArtist() throws SpotifyUriException
    {
        SpotifyUri spotifyUri = SpotifyUri.parseUri("spotify:artist:3t5xRXzsuZmMDkQzgOX35S");
        assertTrue(spotifyUri.isArtist());
        assertEquals("3t5xRXzsuZmMDkQzgOX35S", spotifyUri.getArtistId());
        assertEquals("04gDigrS5kc9YWfZHwBETP", SpotifyUri.parseUri("spotify:artist:04gDigrS5kc9YWfZHwBETP").getArtistId());
    }

    @Test
    public void testParseAlbum() throws SpotifyUriException
    {
        SpotifyUri spotifyUri = SpotifyUri.parseUri("spotify:album:6PbItq7wFLcz5pNlvbGH8D");
        assertTrue(spotifyUri.isAlbum());
        assertEquals("6PbItq7wFLcz5pNlvbGH8D", spotifyUri.getAlbumId());
        assertEquals("3S48AGKXMdtFcJPwvtTVmI", SpotifyUri.parseUri("spotify:album:3S48AGKXMdtFcJPwvtTVmI").getAlbumId());
    }

    @Test
    public void testParseTrack() throws SpotifyUriException
    {
        SpotifyUri spotifyUri = SpotifyUri.parseUri("spotify:track:30t2cItUPY7CvZOup7zptn");
        assertTrue(spotifyUri.isTrack());
        assertEquals("30t2cItUPY7CvZOup7zptn", spotifyUri.getTrackId());
        assertEquals("3v2ReIt6xudmz4CYX4OvrY", SpotifyUri.parseUri("spotify:track:3v2ReIt6xudmz4CYX4OvrY").getTrackId());
    }

    @Test
    public void testParseUser() throws SpotifyUriException
    {
        SpotifyUri spotifyUri = SpotifyUri.parseUri("spotify:user:foo123");
        assertTrue(spotifyUri.isUser());
        assertEquals("foo123", spotifyUri.getUserId());
        assertEquals("foo-bar", SpotifyUri.parseUri("spotify:user:foo-bar").getUserId());
    }

    @Test
    public void testParsePlaylist() throws SpotifyUriException
    {
        SpotifyUri spotifyUri = SpotifyUri.parseUri("spotify:user:spotify:playlist:37i9dQZF1DX4npDJDFDYLg");
        assertTrue(spotifyUri.isPlaylist());
        assertEquals("spotify", spotifyUri.getUserId());
        assertEquals("37i9dQZF1DX4npDJDFDYLg", spotifyUri.getPlaylistId());

        spotifyUri = SpotifyUri.parseUri("spotify:user:foo-bar:playlist:a7i1dQZF1DX6npDJDFDYLg");
        assertTrue(spotifyUri.isPlaylist());
        assertEquals("foo-bar", spotifyUri.getUserId());
        assertEquals("a7i1dQZF1DX6npDJDFDYLg", spotifyUri.getPlaylistId());
    }
}