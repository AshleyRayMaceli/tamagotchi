import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Welcome to Tamagotchi World!");
  }

  @Test
  public void tamagotchiTest() {
    goTo("http://localhost:4567/");
    fill("#name").with("lil guy");
    submit(".btn");
    assertThat(pageSource()).contains("Your cute Tamagotchi!");
  }

  @Test
  public void tamagotchiCurrentSleepLevelTest() {
    goTo("http://localhost:4567/");
    fill("#name").with("lil guy");
    submit(".btn");
    assertThat(pageSource()).contains("Current Sleep Level: 10");
  }

}
