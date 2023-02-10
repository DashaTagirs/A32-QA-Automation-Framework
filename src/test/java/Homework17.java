
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Scanner;
import org.openqa.selenium.Keys;
public class Homework17 extends BaseTest{

    @Test
    public static void CreatePlaylist() {
        loginKoel();
        createNewPlaylist();
        selectNewPlaylist();
        enterPlaylistName();
        verifyPlaylistCreated();
    }

    @Test
    public static void addSongToPlaylist() {
        loginKoel();
        navigateToAllSongs();
        selectSong();
        addToClick();
        selectPlaylist();
        open_m_Playlist();
        verifySongIsAdded();
    }
}