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
    assertThat(pageSource()).contains("Sleep Level:");
  }

  @Test
  public void tamagotchiCurrentSleepLevelTest() {
    goTo("http://localhost:4567/");
    fill("#name").with("lil guy");
    submit(".btn");
    assertThat(pageSource()).contains("Sleep Level: 10");
  }

  @Test
  public void feedButtonTest() {
    goTo("http://localhost:4567/");
    fill("#name").with("lil guy");
    submit(".btn");
    submit("#feed");
    assertThat(pageSource()).contains("Food Level: 11");
  }

  @Test
  public void actionButtonsTest() {
    goTo("http://localhost:4567/");
    fill("#name").with("lil guy");
    submit(".btn");
    submit("#feed");
    submit("#nap");
    submit("#walk");
    submit("#clean");
    assertThat(pageSource()).contains("Food Level: 8");
    assertThat(pageSource()).contains("Sleep Level: 8");
    assertThat(pageSource()).contains("Happiness Level: 8");
    assertThat(pageSource()).contains("Poop Level: 2");
  }


}
